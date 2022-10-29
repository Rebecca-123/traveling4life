package com.nighthawk.spring_portfolio.mvc.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/restaurants")  // all requests in file begin with this URI
public class RestaurantsApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private RestaurantsJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Restaurants>> getJokes() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    /* Update Like
     * @PutMapping annotation is used for mapping HTTP PUT requests onto specific handler methods.
     * @PathVariable annotation extracts the templated part {id}, from the URI
     */
    @PutMapping("/five/{id}")
    public ResponseEntity<Restaurants> setLike(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<Restaurants> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Restaurants restaurant = optional.get();  // value from findByID
            restaurant.setFive(restaurant.getFive()+1); // increment value
            repository.save(restaurant);  // save entity
            return new ResponseEntity<>(restaurant, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }

    @PutMapping("/four/{id}")
    public ResponseEntity<Restaurants> setGood(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<Restaurants> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Restaurants restaurant = optional.get();  // value from findByID
            restaurant.setFour(restaurant.getFour()+1); // increment value
            repository.save(restaurant);  // save entity
            return new ResponseEntity<>(restaurant, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }

    @PutMapping("/three/{id}")
    public ResponseEntity<Restaurants> setMid(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<Restaurants> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Restaurants restaurant = optional.get();  // value from findByID
            restaurant.setThree(restaurant.getThree()+1); // increment value
            repository.save(restaurant);  // save entity
            return new ResponseEntity<>(restaurant, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }

    @PutMapping("/two/{id}")
    public ResponseEntity<Restaurants> setBad(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<Restaurants> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Restaurants restaurant = optional.get();  // value from findByID
            restaurant.setTwo(restaurant.getTwo()+1); // increment value
            repository.save(restaurant);  // save entity
            return new ResponseEntity<>(restaurant, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }

    /* Update Jeer
     */
    @PutMapping("/one/{id}")
    public ResponseEntity<Restaurants> setJeer(@PathVariable long id) {
        Optional<Restaurants> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Restaurants restaurant = optional.get();
            restaurant.setOne(restaurant.getOne()+1);
            repository.save(restaurant);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
