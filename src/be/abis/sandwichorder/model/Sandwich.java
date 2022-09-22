package be.abis.sandwichorder.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Sandwich {

    private String name;
    private String breadType;
    private ArrayList<String> ingredients;
    private double price;
    private boolean vegetables;
    private boolean butter;
    private SandwichCompany sandwichCompany;
    private String comment;
    private boolean special;
    private String category;


    public Sandwich(String name, String breadType, ArrayList<String> ingredients, double price, boolean vegetables, boolean butter, SandwichCompany sandwichCompany, String comment, boolean special, String category) {
        this.name = name;
        this.breadType = breadType;
        this.ingredients = ingredients;
        this.price = price;
        this.vegetables = vegetables;
        this.butter = butter;
        this.sandwichCompany = sandwichCompany;
        this.comment = comment;
        this.special = special;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVegetables() {
        return vegetables;
    }

    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }

    public boolean isButter() {
        return butter;
    }

    public void setButter(boolean butter) {
        this.butter = butter;
    }

    public SandwichCompany getSandwichCompany() {
        return sandwichCompany;
    }

    public void setSandwichCompany(SandwichCompany sandwichCompany) {
        this.sandwichCompany = sandwichCompany;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
