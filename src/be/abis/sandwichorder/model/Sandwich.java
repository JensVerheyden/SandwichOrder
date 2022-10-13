package be.abis.sandwichorder.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private String ID;
    //private String orderInMenu;
    private SandwichCompany sandwichCompany;
    private String name;
    private String category;
    private String price;
    private String ingredientList;
    private String breadType;
    private boolean vegetables;
    private String comment = "";

    public Sandwich() {
    }

    public Sandwich(String ID, SandwichCompany sandwichCompany, String name, String category, String price, String ingredientList) {
        this.ID = ID;
        this.sandwichCompany = sandwichCompany;
        this.name = name;
        this.category = category;
        this.price = price;
        this.ingredientList = ingredientList;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    /*
    public String getOrderInMenu() {
        return orderInMenu;
    }

    public void setOrderInMenu(String orderInMenu) {
        this.orderInMenu = orderInMenu;
    }

     */

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
