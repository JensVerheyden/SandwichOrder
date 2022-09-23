package be.abis.sandwichorder.model;

import be.abis.sandwichorder.repository.SandwichRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuManager {

    Menu menu;


    public void createMenu(String companyName) {
        this.menu = new Menu(companyName, findSandwichesOfCompany(companyName));
    }

    public MenuPreview setMenuOfTheDay() {
        MenuPreview menuPreview = new MenuPreview(this.menu);
        return menuPreview;
    }

    public List<Sandwich> findSandwichesOfCompany(String companyName) {
        ArrayList<Sandwich> sandwichesOfCompany = new ArrayList<>();
        for (Sandwich s : Objects.requireNonNull(SandwichRepository.getSandwichList())) {
            if (s.getSandwichCompany().getName().equals(companyName)) {
                sandwichesOfCompany.add(s);
                System.out.println(s.getName());
            } else {
                System.out.println("nop");
            }
            return sandwichesOfCompany;
        }
        return sandwichesOfCompany;
    }

    public Sandwich findSandwichOfCompany(String company) {
        Sandwich test = null;
        for ( Sandwich s : SandwichRepository.getSandwichList()) {
            if (s.getName().equals(company)) {
                test = s;
            }
        }
        return test;
    }
/*
    public List<Sandwich> findSandwichesOfCompany(String companyName) {
        ArrayList<Sandwich>  sandwichesOfCompany= new ArrayList();
        for (Sandwich s : Objects.requireNonNull(SandwichRepository.findSandwichesByRestaurant(companyName))) {
            sandwichesOfCompany.add(s);
            System.out.println(s.getName());
        }
        return sandwichesOfCompany;
    }*/




    public Sandwich findInMenu(int sandwichNumber) {
        for (Sandwich s : menu.getSandwichList()) {
            if (s.getOrderInMenu()==sandwichNumber) {
                return s;
            }
        }
        return null;
    }

    public void addSandwichToMenu(Sandwich sandwich, Menu menu) {
        menu.getSandwichList().add(sandwich);
    }

    public void removeSandwichFromMenu(Sandwich sandwich, Menu menu) {
    }

}
