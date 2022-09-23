package be.abis.sandwichorder.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private int ID;
    private int orderInMenu;
    private SandwichCompany sandwichCompany;
    private String name;
    private String category;
    private double price;
    private String ingredientList;
    private String breadType;
    private boolean vegetables;
    private boolean butter;
    private String comment;


    public Sandwich(int ID, int orderInMenu, SandwichCompany sandwichCompany, String name, String category, double price, String ingredientList) {
        this.ID = ID;
        this.orderInMenu = orderInMenu;
        this.sandwichCompany = sandwichCompany;
        this.name = name;
        this.category = category;
        this.price = price;
        this.ingredientList = ingredientList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOrderInMenu() {
        return orderInMenu;
    }

    public void setOrderInMenu(int orderInMenu) {
        this.orderInMenu = orderInMenu;
    }

    public SandwichCompany getSandwichCompany() {
        return sandwichCompany;
    }

    public void setSandwichCompany(SandwichCompany sandwichCompany) {
        this.sandwichCompany = sandwichCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(String ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
