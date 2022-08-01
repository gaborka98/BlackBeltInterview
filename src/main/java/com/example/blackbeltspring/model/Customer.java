package com.example.blackbeltspring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

/**
 * Egy vásárló leírására használt osztály
 * @author Gabor Horvath
 * @version 1.0
 */
@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, targetEntity = Rental.class)
    private List<Rental> rentals = new ArrayList<>();

    /**
     * Vásárló létrehozása adott névvel
     * @param name a felhasználó neve
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * Vásárló létrehozása előre megadott adatok nélkül
     */
    public Customer() {}

    /**
     * Hozzá adjuk a felhasználó "kosarához" a kölcsönzést
     * @param arg kölcsönzés osztály
     */
    public void addRental(Rental arg) {
        this.rentals.add(arg);
    }

    /**
     * A vásárló "kosarának" összegét számolja ki. Az összes rendelését megvizsgálja és kiszámolja a kölcsönzés díját,
     * illetve, hogy mennyi törzsvásárlói pontot ad
     * @return RentalDataWrapper - összesített adatok
     * @see RentalDataWrapper
     */

    public RentalDataWrapper statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = this.rentals.iterator();
        while (rentals.hasNext()) {
            Rental each = (Rental) rentals.next();

            each.calculateAmount();

            totalAmount += each.getAmount();
            frequentRenterPoints += each.getRenterPoints();
        }

        return new RentalDataWrapper(frequentRenterPoints, totalAmount);
    }
}
