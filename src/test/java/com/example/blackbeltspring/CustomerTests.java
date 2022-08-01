package com.example.blackbeltspring;

import com.example.blackbeltspring.model.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class CustomerTests {

    @Test
    public void calcEmptyList() {
        Customer customer = new Customer("Test Customer");
        RentalDataWrapper total =  customer.statement();

        assertEquals(total.totalAmount, 0);
        assertEquals(total.frequentRenterTotal, 0);
    }

    @Test
    public void calcRegularLessThan2Days() {
        RegularMovie regularMovie = new RegularMovie("regual1");
        Customer customer = new Customer("Test Customer");
        Rental rental1 = new Rental(regularMovie,2);
        customer.addRental(rental1);

        RentalDataWrapper total =  customer.statement();

        assertEquals(total.totalAmount, 2);
        assertEquals(total.frequentRenterTotal, 1);
    }

    @Test
    public void calcRegularMoreThan2Days() {
        RegularMovie regularMovie = new RegularMovie("regual1");
        Customer customer = new Customer("Test Customer");
        Rental rental1 = new Rental(regularMovie,3);
        customer.addRental(rental1);

        RentalDataWrapper total =  customer.statement();

        assertEquals(total.totalAmount, 3.5);
        assertEquals(total.frequentRenterTotal, 1);
    }

    @Test
    public void calcNewReleaseSimple() {
        NewReleaseMovie nwMovie = new NewReleaseMovie("regual1");
        Customer customer = new Customer("Test Customer");
        Rental rental1 = new Rental(nwMovie,1);
        customer.addRental(rental1);

        RentalDataWrapper total =  customer.statement();

        assertEquals(total.totalAmount, 3);
        assertEquals(total.frequentRenterTotal, 1);
    }

    @Test
    public void calcNewReleaseWithBonusPoint() {
        NewReleaseMovie nwMovie = new NewReleaseMovie("regual1");
        Customer customer = new Customer("Test Customer");
        Rental rental1 = new Rental(nwMovie,5);
        customer.addRental(rental1);

        RentalDataWrapper total =  customer.statement();

        assertEquals(total.totalAmount, 15);
        assertEquals(total.frequentRenterTotal, 2);
    }

    @Test
    public void calcChildrenLessThan3Days() {
        ChildrensMovie childrensMovie = new ChildrensMovie("regual1");
        Customer customer = new Customer("Test Customer");
        Rental rental1 = new Rental(childrensMovie,2);
        customer.addRental(rental1);

        RentalDataWrapper total =  customer.statement();

        assertEquals(total.totalAmount, 1.5);
        assertEquals(total.frequentRenterTotal, 1);
    }

    @Test
    public void calcChildrenMoreThan3Days() {
        ChildrensMovie childrensMovie = new ChildrensMovie("regual1");
        Customer customer = new Customer("Test Customer");
        Rental rental1 = new Rental(childrensMovie,6);
        customer.addRental(rental1);

        RentalDataWrapper total =  customer.statement();

        assertEquals(total.totalAmount, 6);
        assertEquals(total.frequentRenterTotal, 1);
    }

    @Test
    public void calcWithAllType() {
        ChildrensMovie childrensMovie = new ChildrensMovie("regual1");
        NewReleaseMovie nwMovie = new NewReleaseMovie("regual1");
        RegularMovie regularMovie = new RegularMovie("regual1");

        Customer customer = new Customer("Test Customer");
        Rental rental1 = new Rental(childrensMovie,2);
        Rental rental2 = new Rental(nwMovie,5);
        Rental rental3 = new Rental(regularMovie,3);
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        RentalDataWrapper total =  customer.statement();

        assertEquals(total.totalAmount, 20);
        assertEquals(total.frequentRenterTotal, 4);
    }
}
