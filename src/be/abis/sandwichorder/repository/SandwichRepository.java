package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.model.Sandwich;


import java.util.ArrayList;
import java.util.List;

public class SandwichRepository {

    private ArrayList<Sandwich> sandwichList = new ArrayList();

    public SandwichRepository() {
        sandwichList.add(new Sandwich(30, 1 ,CompanyRepository.findCompany("Pinky's"), "Hesp", "Vlees",
                 5.00, "Ham" ));
        sandwichList.add(new Sandwich(31, 2 ,CompanyRepository.findCompany("Pinky's"), "Brie", "Kaas",
                 5.00, "Brie" ));
        sandwichList.add(new Sandwich(33, 3 ,CompanyRepository.findCompany("Pinky's"), "Tonijnsla", "Vis",
                 5.00, "Tonijnsla" ));
        sandwichList.add(new Sandwich(34, 4 ,CompanyRepository.findCompany("Pinky's"), "Smos", "Specialiteiten",
                 5.00, "Club met kaas en hesp" ));
        sandwichList.add(new Sandwich(35, 4 ,CompanyRepository.findCompany("Vleugels"), "Hummus", "Vegan",
                5.00, "Humus" ));
        System.out.println(sandwichList.size());

    }

    public List<Sandwich> findSandwichesByRestaurant(String name) {
        ArrayList<Sandwich> sandwichListByCompany = new ArrayList<>();
        for (Sandwich s : sandwichList) {
            if (s.getSandwichCompany().getName().equals(name)) {
                sandwichListByCompany.add(s);
            }
        } System.out.println("huh"); return sandwichListByCompany;

    }

    public  ArrayList<Sandwich> getSandwichList() {
        return sandwichList;
    }

    public static void setSandwichList(ArrayList<Sandwich> sandwichList) {
        SandwichRepository.sandwichList = sandwichList;
    }

    //R
}
