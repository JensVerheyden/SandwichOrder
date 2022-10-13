package be.abis.sandwichorder.model;

import be.abis.sandwichorder.repository.FileSandwichRepository;

import java.util.Comparator;

public class MenuVleugels extends Menu{

    private static MenuVleugels instance;

    private MenuVleugels() {
        this.sandwichCompany = "Vleugels";
        this.sandwichList = FileSandwichRepository.getInstance().findSandwichesByRestaurant(sandwichCompany).stream()
                .sorted(Comparator.comparing(Sandwich::getCategory).thenComparing(Sandwich::getName))
                .toList();
    }

    public static MenuVleugels getInstance (){
        if(instance == null) { instance = new MenuVleugels();}
        return instance;
    }
}
