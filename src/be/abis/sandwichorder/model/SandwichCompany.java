package be.abis.sandwichorder.model;

import java.util.ArrayList;

public class SandwichCompany {

    private String name;
    private ArrayList<Sandwich> menu;
    private String address;

    public SandwichCompany(String name, ArrayList<Sandwich> menu, String address) {
        this.name = name;
        this.menu = menu;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Sandwich> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Sandwich> menu) {
        this.menu = menu;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
