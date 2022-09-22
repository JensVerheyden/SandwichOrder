package be.abis.sandwichorder.test;

import be.abis.sandwichorder.model.Sandwich;
import be.abis.sandwichorder.model.SandwichCompany;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        SandwichCompany pinky = new SandwichCompany("pinky", "testmenu", "testadress");
        ArrayList<String> smosIngredients = new ArrayList<>();
        smosIngredients.add("Cheese");
        smosIngredients.add("Ham");
        ArrayList<String> smosVegetables = new ArrayList<>();
        smosVegetables.add("Salad");
        smosVegetables.add("Tomato");
        smosVegetables.add("Carrots");
        ArrayList<String> smosBaseLayer = new ArrayList<>();
        smosBaseLayer.add("Mayo");

        Sandwich smos = new Sandwich("smos", "white",smosIngredients, 4.00, smosVegetables, smosBaseLayer
                , pinky, "test", false, "vlees");
    }
}
