package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.model.Sandwich;

import java.util.List;

public interface SandwichRepository {
    List<Sandwich> findSandwichesByRestaurant(String name);
    void addSandwichToRepo(Sandwich sandwich);
    void removeSandwichFromRepo(String sandwichName, String sandwichCompany);
}
