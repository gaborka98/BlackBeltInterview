package com.example.blackbeltspring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Kölcsönzések leírására szolgáló osztály
 *
 * @author Gabor Horvath
 * @version 1.0
 */
@Entity
@Table(name = "RENTAL")
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTAL_ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @Column(name = "DAYS_RENTED")
    private int daysRented;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Transient
    private double amount = 0;
    @Transient
    private int renterPoints = 0;

    /**
     * Kölcsönzés létrehozása megadott adatokkal
     * @param movie Film amit kölcsönöztek
     * @param daysRented kölcsönzés napjainak száma
     *
     * @see Movie
     */
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    /**
     * Kölcsönzés létrehozás megadott adatok nélkül
     */
    public Rental() {
    }

    /**
     * Rendelés értékének kiszámítására szolgáló függvény. Kiszámolja a kölcsönzés árát és a kölcsönzés után járó hűség
     * pontok mennyiségét, majd ezeket eltárolja.
     * Az adatok getterek segítségével kérhetőek le:
     * getAmount();
     * getRenterPoints();
     */
    public void calculateAmount() {
        if (this.movie instanceof RegularMovie) {
            this.amount += 2;
            if (this.daysRented > 2) {
                this.amount += (this.daysRented - 2) * 1.5;
            }
        } else if (this.movie instanceof NewReleaseMovie) {
            this.amount += this.daysRented * 3;
            // add bonus for a two day new release rental
            if (this.daysRented > 1) {
                this.renterPoints++;
            }
        } else if (this.movie instanceof ChildrensMovie) {
            this.amount += 1.5;
            if (this.getDaysRented() > 3) {
                this.amount += (this.getDaysRented() - 3) * 1.5;
            }
        }

        // add frequent renter points
        this.renterPoints++;
    }
}

