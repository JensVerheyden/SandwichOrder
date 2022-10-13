package be.abis.sandwichorder.model;

import be.abis.sandwichorder.exception.SandwitchNotFoundException;

public class Person {

    private String currentSession;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private Boolean hasOrdered;
    private DayOrder dayOrder;
    private int counter = 0;
    private int personNr;

    public Person(String personNr, String firstName, String lastName, String email, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        if (personNr == null) {
            this.personNr = ++counter;
        } else {
            this.personNr = Integer.parseInt(personNr);
            counter = Math.max(counter, this.personNr);
        }
        this.hasOrdered = false;
    }

    public Person(){}

    public void noSandwich(){
        dayOrder.addOrder(new Order(this,new Sandwich()));
    }

    public void orderSandwich(String sandwichName, String breadType, String vegetables) throws SandwitchNotFoundException {
        Sandwich currentSandwich = dayOrder.getDayMenu().findSandwich(sandwichName);
        currentSandwich.setBreadType(breadType);
        currentSandwich.setVegetables((vegetables.equals("yes")));
        Order order = new Order(this, currentSandwich);
        dayOrder.addOrder(order);
    }

    public void orderSandwich(String sandwichName, String breadType, String vegetables, String comment) throws SandwitchNotFoundException {
        Sandwich currentSandwich = dayOrder.getDayMenu().findSandwich(sandwichName);
        currentSandwich.setBreadType(breadType);
        currentSandwich.setVegetables((vegetables.equals("yes")));
        currentSandwich.setComment(comment);
        Order order = new Order(this, currentSandwich);
        dayOrder.addOrder(order);
    }

    public void cancelOrder(){
        dayOrder.removeOrder(this);
    }

    public void checkMenu(){
        dayOrder.printMenu();
    }
    //getters and setters


    public DayOrder getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(DayOrder dayOrder) {
        this.dayOrder = dayOrder;
    }

    public void setHasOrdered(Boolean hasOrdered) {
        this.hasOrdered = hasOrdered;
    }

    public Boolean getHasOrdered() {
        return hasOrdered;
    }

    public int getPersonNr() {
        return personNr;
    }

    public void setPersonNr(int personNr) {
        this.personNr = personNr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(String currentSession) {
        this.currentSession = currentSession;
    }
}
