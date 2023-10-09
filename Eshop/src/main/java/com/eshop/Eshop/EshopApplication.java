package com.eshop.Eshop;

import com.eshop.Eshop.Entity.*;
import com.eshop.Eshop.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class EshopApplication implements CommandLineRunner {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final CustomerRepository customerRepository;
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	private final UserRepository userRepository;
	@Autowired
	public EshopApplication(CategoryRepository categoryRepository, ProductRepository productRepository, CustomerRepository customerRepository, OrderRepository orderRepository, OrderRepository orderRepository1, OrderItemRepository orderItemRepository, UserRepository userRepository){
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category newCategory = new Category();
		newCategory.setCategoryName("Dam");
		newCategory.setCategoryDescription("Detta är en kategori för kvinnor");
		categoryRepository.save(newCategory);
		Category category = new Category();
		category.setCategoryName("Herr");
		category.setCategoryDescription("Detta är en kategori för herrar");
		categoryRepository.save(category);
		Product product = new Product();
		product.setDescription("Detta är en snygg tröja");
		product.setPrice(10);
		product.setInventory_amount(10);
		product.setName("Tröja");
		product.setCategory(category);
		Product product1 = productRepository.save(product);
		Customer customer = new Customer();
		customer.setEmail("few@gre.se");
		customer.setFirstName("Bajs");
		customer.setLastName("Korv");
		customer.setPhone("00000");
		Customer newCustomer = customerRepository.save(customer);
		Order order = new Order();
		order.setCustomer(newCustomer);
		order.setDate(LocalDate.now());
		order.setStatus("Ej behandlad");
		Order newOrder= orderRepository.save(order);
		OrderItem orderItem = new OrderItem(newOrder, product1);
		orderItemRepository.save(orderItem);
		User user = new User();
		user.setName("Admin");
		user.setPassword("Bajskorv");
		userRepository.save(user);
	}
}
