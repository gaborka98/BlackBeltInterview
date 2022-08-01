package com.example.blackbeltspring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * Ez az osztály a újonnan megjelent filmek leképezésére van. Szülő osztálya a Movie.
 * @see Movie
 *
 * @author Gabor Horvath
 * @version 1.0
 */
@Entity
@Getter
@Setter
@ToString
public class NewReleaseMovie  extends Movie{
    /**
     * Új megjelenésű film létrehozása megadott címmel
     * @param title A film címe
     */
    public NewReleaseMovie(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    /**
     * új megjelenésű film létrehozása adatok nélkül
     */
    public NewReleaseMovie() {

    }
}
