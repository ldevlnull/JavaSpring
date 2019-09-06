package com.alexcompany;

import com.alexcompany.service.StorageService;
import com.alexcompany.serviceImplement.storage.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringpaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringpaginationApplication.class, args);
	}

	CommandLineRunner init(StorageService storageService){
		return (args -> {
			storageService.deleteAll();
			storageService.init();
		});
	}
}
