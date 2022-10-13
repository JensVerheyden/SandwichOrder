package be.abis.sandwichorder.model;

import be.abis.sandwichorder.manager.SessionManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DayOrder {

    private LocalDate date;
    private Menu dayMenu;
    private List<Person> allPersons;
    private List<Order> orderList = new ArrayList<>();


    public DayOrder(LocalDate date, Menu dayMenu, List<Person> allPersons) {
        this.date = date;
        this.dayMenu = dayMenu;
        this.allPersons = allPersons;
    }

    public void addOrder(Order order){
        orderList.add(order);
        order.getWhoOrdered().setHasOrdered(true);
    }

    public void removeOrder(Person p){
        orderList.remove(findOrderByPerson(p));
        p.setHasOrdered(false);
    }

    public String printOrder(){
        StringBuilder sb = new StringBuilder();
        sb.append(date).append("     ").append(dayMenu.sandwichCompany);
        Map<String,List<Order>> sortedOrders = orderList.stream()
                        .filter(o ->o.getOrderedSandwich().getName() != null)
                .collect(Collectors.groupingBy(o->o.getWhoOrdered().getCurrentSession()));
       sortedOrders.forEach((k,v) -> {
           sb.append("------------------------------------------\n");
           sb.append(k);
           v.forEach(p -> sb.append(String.format("%-20s%20s", p.getWhoOrdered().getFirstName(),
                   p.getOrderedSandwich().getName() + " " + p.getOrderedSandwich().getBreadType() + " veggies:" +
                           p.getOrderedSandwich().isVegetables())));
       });
           return sb.toString();
       }

    public Order findOrderByPerson(Person p){
        return orderList.stream()
                .filter(o -> o.getWhoOrdered().getEmail().equals(p.getEmail()))
                .findFirst().get();
    }


    public void printMenu(){
        System.out.println(dayMenu);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Menu getDayMenu() {
        return dayMenu;
    }

    public void setDayMenu(Menu dayMenu) {
        this.dayMenu = dayMenu;
    }

    public List<Person> getAllPersons() {
        return allPersons;
    }

    public void setAllPersons(List<Person> allPersons) {
        this.allPersons = allPersons;
    }


    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
