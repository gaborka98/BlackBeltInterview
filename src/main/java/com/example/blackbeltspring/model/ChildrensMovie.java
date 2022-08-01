package com.example.blackbeltspring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * Ez az osztály a Gyerek filmek leképezésére van. Szülő osztálya a Movie.
 * @see Movie
 *
 * @author Gabor Horvath
 * @version 1.0
 */
@Entity
@Getter
@Setter
@ToString
public class ChildrensMovie extends Movie{
    /**
     * A gyerek filmek példányosítására használható constructor
     * @param title Az adott film cime
     */
    public ChildrensMovie(String title) {
        super(title, Movie.CHILDRENS);
    }

    /**
     * A gyerek filmek default paraméterek nélküli constructora
     */
    public ChildrensMovie() {}
}
