package com.eshop.Eshop.Controller;

import com.eshop.Eshop.Entity.*;
import com.eshop.Eshop.Repository.*;
import com.eshop.Eshop.Service.ImageService;
import jakarta.websocket.server.PathParam;
import org.aspectj.weaver.ast.Or;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class DemoController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired OrderItemRepository orderItemRepository;

    @GetMapping("/api/categories")
    public Iterable<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/api/category")
    public Category getCategory(@RequestParam Integer id){
        return categoryRepository.findCategoryById(id);
    }

    @PostMapping("/api/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        for(int i = 0; i < product.getImages().size(); i++){
            String url = product.getImages().get(i).getUrl();
            url = url.substring(url.lastIndexOf('\\')+1);
            product.getImages().get(i).setUrl(url);
        }
        imageRepository.saveAll(product.getImages());
        productRepository.save(product);
        return ResponseEntity.ok(productRepository.findProductById(product.getId()));
    }

    @GetMapping("/api/product/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException{
        String imageDir = "C:/Users/Jimmy/Desktop/server";
        Path imagePath = Paths.get(imageDir).resolve(filename);
        Resource imageResource = new UrlResource(imagePath.toUri());
        if (imageResource.exists() && imageResource.isReadable()) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/product")
    public Product getProduct(@RequestParam Integer id){
        return productRepository.findProductById(id);
    }

    @GetMapping("/api/products")
    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/api/customer/add")
    public Customer addCustomer(@RequestBody Customer customer){
        addressRepository.save(customer.getAddress());
        return customerRepository.save(customer);
    }

    @GetMapping("/api/customers")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id){
        return customerRepository.findCustomerById(id);
    }

    @GetMapping("/api/image/")
    public Image getThumbnail(@RequestBody Product product){
        return product.getImages().get(0);
    }

    @GetMapping("/api/product/images")
    public List<Image> getImages(@RequestParam Integer id){
        Product product = productRepository.findProductById(id);
        return product.getImages();
    }

    @PostMapping("/api/order/add")
    public Iterable<OrderItem> addOrder(@RequestBody Order order){
        order.setDate(LocalDate.now());
        order.setStatus("Ej behandlad");
        Order newOrder = orderRepository.save(order);
        for(int i = 0; i < order.getOrderItems().size(); i++){
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(order.getOrderItems().get(i).getProduct());
            orderItem.setPrice(order.getOrderItems().get(i).getPrice());
            orderItem.setQuantity(order.getOrderItems().get(i).getQuantity());
            orderItem.setOrder(newOrder);
            orderItemRepository.save(orderItem);
        }
        return order.getOrderItems();
    }

    @GetMapping("/api/orders")
    public Iterable<Order> getOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/api/order/{id}")
    public Order getOrder(@PathVariable Integer id){
        return orderRepository.findOrderById(id);
    }
}
