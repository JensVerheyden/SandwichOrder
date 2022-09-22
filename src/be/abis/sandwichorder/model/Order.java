package be.abis.sandwichorder.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private String date;
    private SandwichCompany company;
    private ArrayList<Sandwich> sandwiches;

    public Order() {
    }

    public Order( SandwichCompany company, String date) {
        this.date = date;
        this.company = company;
        sandwiches = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void removeSandwich(Sandwich sandwich) {
        sandwiches.remove(sandwich);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SandwichCompany getCompany() {
        return company;
    }

    public void setCompany(SandwichCompany company) {
        this.company = company;
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(ArrayList<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }
}
