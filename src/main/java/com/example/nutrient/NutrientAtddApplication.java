package com.example.nutrient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NutrientAtddApplication  {

    public static void main(String[] args) {
        SpringApplication.run(NutrientAtddApplication.class, args);
    }

}
