package be.abis.sandwichorder.model;

import be.abis.sandwichorder.repository.SandwichRepository;

import java.util.List;
import java.util.Objects;

public class Menu {

    String sandwichCompany;
    List<Sandwich> sandwichList;

    public Menu(String sandwichCompany, List<Sandwich> sandwichList) {
        this.sandwichCompany = sandwichCompany;
        this.sandwichList = sandwichList;
    }

    public String getSandwichCompany() {
        return sandwichCompany;
    }

    public List<Sandwich> getSandwichList() {
        return sandwichList;
    }

    public void setSandwichCompany(String sandwichCompany) {
        this.sandwichCompany = sandwichCompany;
    }

    public void setSandwichList(List<Sandwich> sandwichList) {
        this.sandwichList = sandwichList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "sandwichCompany=" + sandwichCompany +
                ", sandwichList=" + sandwichList +
                '}';
    }
}
