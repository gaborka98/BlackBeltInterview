package com.example.blackbeltspring;

import com.example.blackbeltspring.model.Rental;
import com.example.blackbeltspring.service.RentalRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class RentalTests {
    @Autowired
    RentalRepository rentalRepository;

    @Test
    public void RentalCalculateTest() {
        Optional<Rental> res = rentalRepository.findById(2L);
        if (res.isPresent()) {
            Rental rent = res.get();
            System.out.println(rent.getCustomer().statement());
        }
    }
}
