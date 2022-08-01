package com.example.blackbeltspring.model;


/**
 * A felhasználó összes kölcsönzésének összesített adatait tárolja.
 *
 * @author Gabor Horvath
 * @version 1.0
 *
 *
 */
public class RentalDataWrapper {
    public int frequentRenterTotal;
    public double totalAmount;

    /**
     * Az osztály létrehozásáért felelős metódus
     * @param frequentRenterTotal Az összes hűség pont ami jár a felhasználónak a kölcsönzései alapján
     * @param totalAmount Az összeg, amit az összes kölcsönzése után kell fizetnie
     */
    public RentalDataWrapper(int frequentRenterTotal, double totalAmount) {
        this.frequentRenterTotal = frequentRenterTotal;
        this.totalAmount = totalAmount;
    }
}
