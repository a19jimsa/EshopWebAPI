package com.eshop.Eshop.Controller;

import com.eshop.Eshop.Entity.*;
import com.eshop.Eshop.Repository.CategoryRepository;
import com.eshop.Eshop.Repository.CustomerRepository;
import com.eshop.Eshop.Repository.ImageRepository;
import com.eshop.Eshop.Repository.ProductRepository;
import com.eshop.Eshop.Service.ImageService;
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

    @GetMapping("/api/categories")
    public Iterable<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/api/category")
    public Category getCategory(@RequestParam Integer id){
        return categoryRepository.findCategoryById(id);
    }

    @PostMapping("/api/add")
    public void addProduct(@RequestBody RequestData requestData){
        Product product = requestData.getProduct();
        Image image = requestData.getImage();
        imageRepository.save(image);
        product.getImages().add(image);
        productRepository.save(product);
    }

    @GetMapping("/api/product/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException{
        String imageDir = "C:/Users/Ninte/Desktop/Bajs";
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

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last){
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id){
        return customerRepository.findCustomerById(id);
    }

    @GetMapping("/api/images/{id}")
    public Image getThumbnail(@PathVariable Integer id){return imageRepository.findImageById(id);}
}
