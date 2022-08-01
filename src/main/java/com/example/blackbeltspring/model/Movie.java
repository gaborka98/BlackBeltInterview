package com.example.blackbeltspring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Filmek leírására használt osztály. Ebből származik a ChildrensMovie, RegularMovie, NewReleaseMovie osztály
 * @author Gabor Horvath
 * @version 1.0
 *
 * @see ChildrensMovie
 * @see RegularMovie
 * @see NewReleaseMovie
 */
@Entity
@Table(name = "Movie")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@ToString
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", nullable = false)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE_CODE")
    private int priceCode;

    /**
     * Film létrehozása megadott adatok alapján
     * @param title A film címe
     * @param priceCode A film ár kódja
     */
    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    /**
     * Film létrehozása előre megadott adatok nélkül
     */
    public Movie() {}

}
