package com.eshop.Eshop;

import com.eshop.Eshop.Entity.Category;
import com.eshop.Eshop.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EshopApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;

	@Autowired
	public EshopApplication(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category = new Category();
		category.setName("Underkläder");
		categoryRepository.save(category);
	}
}
