package com.nighthawk.spring_portfolio.mvc.restaurants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class RestaurantsInit {
    
    // Inject repositories
    @Autowired RestaurantsJpaRepository repository;
    
    @Bean
    CommandLineRunner run() {  // The run() method will be executed after the application starts
        return args -> {
            // Fail safe data validations

            // starting restaurants
            final String[] restaurantsArray = {
                "In-N-Out Burger",
                "Chick-Fil-A",
                "Wendy's",
                "Burger King",
                "Jack in the Box",
                "Burger Lounge"
            };

            // make sure Restaurant database is populated with starting restaurants
            for (String res : restaurantsArray) {
                List<Restaurants> test = repository.findByRestrIgnoreCase(res);  // JPA lookup
                if (test.size() == 0)
                    repository.save(new Restaurants(null, res, 0, 0)); // JPA save
            }
            
        };
    }
}

