package com.example.blackbeltspring.service;

import com.example.blackbeltspring.model.Rental;
import org.springframework.data.repository.CrudRepository;

/**
 * A Rental tábla lekérésére szolgáló interface
 *
 * @author Gabor Horvath
 * @version 1.0
 */
public interface RentalRepository extends CrudRepository<Rental, Long> {
}
