package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.model.Sandwich;
import be.abis.sandwichorder.model.SandwichCompany;

import java.util.ArrayList;

public class CompanyRepository {



    private static ArrayList<SandwichCompany> companies = new ArrayList();

    public CompanyRepository() {

        companies.add(new SandwichCompany("Pinky's", "pinkieadress"));
        companies.add(new SandwichCompany("VLeugels", "Vleugelsadress"));


    }

    public static SandwichCompany findCompany(String name) {;
        for (SandwichCompany c : companies) {
            if (c.getName().equals(name)) {
                return c;
            }
        } return null;
    }
}
