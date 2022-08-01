package com.example.blackbeltspring.controller;

import com.example.blackbeltspring.model.Rental;
import com.example.blackbeltspring.model.RentalDataWrapper;
import com.example.blackbeltspring.service.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * A Rental osztállyal kapcsolatos oldalak kiszolgálása történik ebben a classban
 * @author Gabor Horvath
 * @version 1.0
 */

@Controller
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    RentalRepository rentalRepository;

    /**
     * Ez a függvény felelős a paraméterben kapott Rental id-hoz kapcsolódó Rental lekéréséért és az adatok
     * megjelenítéséért html oldalon
     *
     * @param id Az url paraméterben kapott Rental azonosítója
     * @param model A megfelelő adatok felvételéhez szükséges
     * @return String - Thymleaf álltal kigenerált html String
     */
    @GetMapping("/{id}")
    public String getRentalDetail(@PathVariable("id") Long id, Model model) {
        if (id == null) {
            System.out.println("Missing");
            return "Missing rental ID";
        }

        Optional<Rental> res = rentalRepository.findById(id);
        if (res.isPresent()) {
            Rental rent = res.get();
            System.out.println("find!!!!!");
            RentalDataWrapper datawrapper = rent.getCustomer().statement();
            model.addAttribute("rent", rent);
            model.addAttribute("customer", rent.getCustomer().getName());
            model.addAttribute("totals", datawrapper);
            model.addAttribute("point", datawrapper.frequentRenterTotal);
            return "index";
        }
        System.out.println("NOT FOUND");
        return "Rental not found";
    }
}
