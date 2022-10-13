package be.abis.sandwichorder.manager;

import be.abis.sandwichorder.model.*;
import be.abis.sandwichorder.repository.FileSandwichRepository;

import java.util.List;

public class MenuManager {

    private static MenuManager instance;
    FileSandwichRepository fileSandwichRepository = FileSandwichRepository.getInstance();

    public MenuManager() {
    }

    public static MenuManager getInstance()  {
        if (instance == null) { instance = new MenuManager();}
        return instance;
    }

    public void createMenu(String companyName) {

        //this.menu = new Menu(companName, findSandwichesOfCompany(companyName));
    }

    public Menu setMenuOfTheDay(SandwichCompany company) {

        return switch (company.getName()) {
            case "Pinky's" -> MenuPinkys.getInstance();
            case "Vleugels" -> MenuVleugels.getInstance();
            default -> null;
        };
    }


    public List<Sandwich> findSandwichesOfCompany(String companyName) {
        return fileSandwichRepository.findSandwichesByRestaurant(companyName);
    }


    public void addSandwich(Sandwich sandwich) {
        fileSandwichRepository.addSandwichToRepo(sandwich);
        switch (sandwich.getSandwichCompany().getName()){
            case "Pinky's":
                MenuPinkys.getInstance().addSandwichToMenu(sandwich);
            case "Vleugels":
                MenuVleugels.getInstance().addSandwichToMenu(sandwich);
        }
    }


    public void removeSandwich(Sandwich sandwich) {
        fileSandwichRepository.removeSandwichFromRepo(sandwich);
        switch (sandwich.getSandwichCompany().getName()){
            case "Pinky's":
                MenuPinkys.getInstance().removeSandwichFromMenu(sandwich);
            case "Vleugels":
                MenuVleugels.getInstance().removeSandwichFromMenu(sandwich);
        }
    }


}
