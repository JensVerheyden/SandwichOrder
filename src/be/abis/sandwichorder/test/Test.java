package be.abis.sandwichorder.test;

import be.abis.sandwichorder.model.MenuManager;
import be.abis.sandwichorder.model.Sandwich;
import be.abis.sandwichorder.repository.FileCompanyRepository;
import be.abis.sandwichorder.repository.FileSandwichRepository;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        FileCompanyRepository fileCompanyRepository = new FileCompanyRepository();
        System.out.println(fileCompanyRepository.getCompanies().size());
        System.out.println(fileCompanyRepository.findCompany("Pinky's").getName());

        FileSandwichRepository fileSandwichRepository = FileSandwichRepository.getInstance();
        System.out.println(fileSandwichRepository.getSandwichList().size());
        System.out.println(fileSandwichRepository.findSandwichesByRestaurant("Pinky's"));

        MenuManager menuManager = MenuManager.getInstance();
        System.out.println(menuManager.findSandwichesOfCompany("Pinky's"));

        menuManager.createMenu("Pinky's");
        System.out.println(menuManager.getMenu().getSandwichList().size());

        System.out.println(menuManager.findInMenu(3).getName());
        Sandwich cheese = new Sandwich("30", "5" , fileCompanyRepository.findCompany("Pinky's"), "Cheese", "Vlees",
                "5.00", "cheese");

        menuManager.addSandwich(cheese);
        for (Sandwich sandwich : menuManager.getMenu().getSandwichList()) {
            System.out.print(sandwich.getName() + " ");
        }

        System.out.println();
        menuManager.removeSandwich("Cheese", "Pinky's");

        for (Sandwich sandwich : menuManager.getMenu().getSandwichList()) {
            System.out.print(sandwich.getName() + " ");
        }

    }
}
