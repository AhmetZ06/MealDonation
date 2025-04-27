package com.mezunlar.mealdonation.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.mezunlar.mealdonation"})
@EntityScan(basePackages = {"com.mezunlar.mealdonation"})
@EnableJpaRepositories(basePackages = {"com.mezunlar.mealdonation"})
@SpringBootApplication
public class MealDonationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MealDonationApplication.class, args);
    }

}
