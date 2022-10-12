package be.abis.sandwichorder.model;

public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String company;
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
    }

    public Person(){}


    public void orderSandwich(Sandwich sandwich){

    }


    //getters and setters


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
}
