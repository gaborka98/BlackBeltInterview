package com.example.blackbeltspring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * Ez az osztály a szabványos filmek leképezésére van. Szülő osztálya a Movie.
 * @see Movie
 *
 * @author Gabor Horvath
 * @version 1.0
 */
@Entity
@Getter
@Setter
@ToString
public class RegularMovie  extends Movie{
    /**
     * Szabványos film létrehozása megadott címmel
     * @param title A film címe
     */
    public RegularMovie(String title) {
        super(title, Movie.REGULAR);
    }

    /**
     * Szabványos film létrehozása megadott adatok nélkül
     */
    public RegularMovie() {}
}
