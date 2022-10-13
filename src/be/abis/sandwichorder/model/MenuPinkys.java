package be.abis.sandwichorder.model;

import be.abis.sandwichorder.repository.FileSandwichRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MenuPinkys extends Menu {

    private static MenuPinkys instance;



    private MenuPinkys() {
        this.sandwichCompany = "Pinky's";
        this.sandwichList = FileSandwichRepository.getInstance().findSandwichesByRestaurant(sandwichCompany).stream()
                .sorted(Comparator.comparing(Sandwich::getCategory).thenComparing(Sandwich::getName))
                .toList();
    }

    public static MenuPinkys getInstance (){
        if(instance == null) { instance = new MenuPinkys();}
        return instance;
    }
}
