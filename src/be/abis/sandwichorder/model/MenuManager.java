package be.abis.sandwichorder.model;

import be.abis.sandwichorder.repository.FileSandwichRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuManager {

    private static MenuManager instance;
    Menu menu;
    FileSandwichRepository fileSandwichRepository = FileSandwichRepository.getInstance();

    public MenuManager() throws IOException {
    }

    public static MenuManager getInstance() throws IOException {
        if (instance == null) { instance = new MenuManager();}
        return instance;
    }

    public void createMenu(String companyName) {
        this.menu = new Menu(companyName, findSandwichesOfCompany(companyName));
    }

    public MenuPreview setMenuOfTheDay() {
        return new MenuPreview(this.menu);
    }


    public List<Sandwich> findSandwichesOfCompany(String companyName) {
        List<Sandwich> sandwichesOfCompany = new ArrayList<>();
        for (Sandwich s : Objects.requireNonNull(fileSandwichRepository.findSandwichesByRestaurant(companyName))) {
            if (s.getSandwichCompany().getName().equals(companyName)) {
                sandwichesOfCompany.add(s);
            }
        }
        return sandwichesOfCompany;
    }

    public Sandwich findInMenu(int sandwichNumber) {
        String sandwichNumberToString = Integer.toString(sandwichNumber);
        Sandwich foundSandwich = null;
        for (Sandwich s : menu.getSandwichList()) {
            if (s.getOrderInMenu().equals(sandwichNumberToString)) {
                foundSandwich =  s;
            }
        }
        return foundSandwich;
    }

    public void addSandwich(Sandwich sandwich) {
        fileSandwichRepository.addSandwichToRepo(sandwich);
        menu = new Menu(menu.getSandwichCompany(), findSandwichesOfCompany(menu.getSandwichCompany()));
    }

    public void removeSandwich(String sandwichName, String sandwichCompany) {
        fileSandwichRepository.removeSandwichFromRepo(sandwichName, sandwichCompany);
        menu = new Menu(menu.getSandwichCompany(), findSandwichesOfCompany(menu.getSandwichCompany()));

    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
