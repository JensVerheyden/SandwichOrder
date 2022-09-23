package be.abis.sandwichorder.model;

public class Student extends Person {

    private String currentSession = "";


    public Student(String firstName, String lastName, String email, String company) {
        super(firstName, lastName, email, company);
    }


    public String getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(String currentSession) {
        this.currentSession = currentSession;
    }
}
