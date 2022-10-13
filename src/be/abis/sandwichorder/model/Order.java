package be.abis.sandwichorder.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private Person whoOrdered;
    private Sandwich orderedSandwich;

    public Order(Person whoOrdered, Sandwich orderedSandwich) {
        this.whoOrdered = whoOrdered;
        this.orderedSandwich = orderedSandwich;
    }



    public Person getWhoOrdered() {
        return whoOrdered;
    }

    public void setWhoOrdered(Person whoOrdered) {
        this.whoOrdered = whoOrdered;
    }

    public Sandwich getOrderedSandwich() {
        return orderedSandwich;
    }

    public void setOrderedSandwich(Sandwich orderedSandwich) {
        this.orderedSandwich = orderedSandwich;
    }
}