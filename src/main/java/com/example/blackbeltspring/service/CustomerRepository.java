package com.example.blackbeltspring.service;

import com.example.blackbeltspring.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * A Customer tábla lekérésére szolgáló interface
 *
 * @author Gabor Horvath
 * @version 1.0
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
