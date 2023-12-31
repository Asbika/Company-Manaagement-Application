package com.example.GestionEntreprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EnableJpaRepositories("com.example.GestionEntreprise.repository")
@EntityScan(basePackages = "com.example.GestionEntreprise.model")
public class GestionEntrepriseApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestionEntrepriseApplication.class, args);
    }
}
