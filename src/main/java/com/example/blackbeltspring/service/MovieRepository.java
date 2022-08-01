package com.example.blackbeltspring.service;

import com.example.blackbeltspring.model.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 * A Movie tábla lekérésére szolgáló interface
 *
 * @author Gabor Horvath
 * @version 1.0
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
