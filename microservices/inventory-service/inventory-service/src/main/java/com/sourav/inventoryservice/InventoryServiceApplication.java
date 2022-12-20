package com.sourav.inventoryservice;

import com.sourav.inventoryservice.models.Inventory;
import com.sourav.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory1 = new Inventory();
			inventory1.setQuantity(100);
			inventory1.setSkuCode("iPhone13");

			Inventory inventory2 = new Inventory();
			inventory1.setQuantity(0);
			inventory1.setSkuCode("iPhone14");

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}

}
