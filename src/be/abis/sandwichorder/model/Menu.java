package be.abis.sandwichorder.model;

import be.abis.sandwichorder.exception.SandwitchNotFoundException;

import java.util.List;

public abstract class Menu {

    String sandwichCompany;
    List<Sandwich> sandwichList;

    public Menu() {

    }

    public Sandwich findSandwich(String name) throws SandwitchNotFoundException {
        return sandwichList.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst().orElseThrow(() -> new SandwitchNotFoundException("Sandwich not found"));
    }

    public void addSandwichToMenu(Sandwich sandwich) {
        sandwichList.add(sandwich);
    }

    public void removeSandwichFromMenu(Sandwich sandwich) {
        sandwichList.remove(sandwich);
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
        StringBuilder str = new StringBuilder();
        str.append(this.getSandwichCompany()).append("\n")
                .append("-------------------------------");
        for (Sandwich s : this.getSandwichList()) {
            str.append(String.format( "%-20s| %-20s| %-20s \n",
                    s.getName(), (s.getIngredientList()!=null)?s.getIngredientList():"" , s.getPrice()));
        }
        return str.toString();
    }
}
