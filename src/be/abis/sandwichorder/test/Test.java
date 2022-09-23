package be.abis.sandwichorder.test;

import be.abis.sandwichorder.model.MenuManager;
import be.abis.sandwichorder.model.MenuPreview;
import be.abis.sandwichorder.model.Sandwich;
import be.abis.sandwichorder.model.SandwichCompany;
import be.abis.sandwichorder.repository.CompanyRepository;
import be.abis.sandwichorder.repository.SandwichRepository;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        MenuManager menuManager = new MenuManager();
        System.out.println(SandwichRepository.findSandwichesByRestaurant("Pinky's"));


        menuManager.createMenu("Vleugels");
        MenuPreview menuPreview = menuManager.setMenuOfTheDay();

        System.out.println(menuManager.findSandwichesOfCompany("Vleugels"));
        System.out.println(menuManager.findSandwichesOfCompany("Vleugels"));

        System.out.println(menuManager.findSandwichOfCompany("Vleugels"));

        System.out.println(SandwichRepository.getSandwichList());

        menuPreview.printMenu();

        ///repository van static naar normale class zetten en dan alle methods aanpasse en overbodige methods verwijderen

    }
}
