package be.abis.sandwichorder.model;

import java.util.ArrayList;

public class DayOrder {

    private String date;
    private SandwichCompany sandwichCompany;
    private ArrayList<Student> studentGroups;
    private ArrayList<Order> orderList = new ArrayList<Order>();


    public DayOrder(String date, SandwichCompany sandwichCompany, ArrayList<Student> studentGroups) {
        this.date = date;
        this.sandwichCompany = sandwichCompany;
        this.studentGroups = studentGroups;
    }

    public void addOrder(Order order){

    }

    public void removeOrder(Order order){

    }

    public void checkIfOrdered(Student student){

    }

    public void viewOrderOfSession(String sessionName){
        //studentGroups
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SandwichCompany getSandwichCompany() {
        return sandwichCompany;
    }

    public void setSandwichCompany(SandwichCompany sandwichCompany) {
        this.sandwichCompany = sandwichCompany;
    }

    public ArrayList<Student> getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(ArrayList<Student> studentGroups) {
        this.studentGroups = studentGroups;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}
