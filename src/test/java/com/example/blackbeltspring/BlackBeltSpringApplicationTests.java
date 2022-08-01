package com.example.blackbeltspring;

import com.example.blackbeltspring.model.*;
import com.example.blackbeltspring.service.CustomerRepository;
import com.example.blackbeltspring.service.MovieRepository;
import com.example.blackbeltspring.service.RentalRepository;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.DEFAULT)
class BlackBeltSpringApplicationTests {
    @Autowired
    RentalRepository rentalRepo;
    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    MovieRepository movieRepo;

    @Test
    public void saveCustomer() {
        Customer customer = new Customer("Test Customer");
        assertThat(customerRepo.save(customer)).isInstanceOf(Customer.class);
    }

    @Test
    public void saveMovie() {
        NewReleaseMovie nwMovie = new NewReleaseMovie("Test movie");
        assertThat(movieRepo.save(nwMovie)).isInstanceOf(NewReleaseMovie.class);
    }

    @Test
    public void FindRentalById() {
        Movie nwMovie = null;
        Customer customer = null;
        Optional<Movie> dbMovie = movieRepo.findById(0L);
        Optional<Customer> dbCustomer = customerRepo.findById(0L);
        if (dbMovie.isPresent()) {
            nwMovie = dbMovie.get();
        }
        if (dbCustomer.isPresent()) {
            customer = dbCustomer.get();
        }


        Rental rental = new Rental(nwMovie,5);
        rental.setCustomer(customer);

        Rental saved = rentalRepo.save(rental);
        assertThat(rentalRepo.findById(saved.getId())).isInstanceOf(Optional.class);
    }

}
