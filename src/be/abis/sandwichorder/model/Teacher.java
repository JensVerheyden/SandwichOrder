package be.abis.sandwichorder.model;

public class Teacher extends Person{

    private String currentCourseName;

    public Teacher(String personNr, String firstName, String lastName, String email, String company, String currentCourseName) {
        super(personNr,firstName, lastName, email, company);
        this.currentCourseName = currentCourseName;
    }

    public Teacher(){};


    public void viewOrderOfToday(){
        System.out.println();
    }



    public String getCurrentCourseName() {
        return currentCourseName;
    }

    public void setCurrentCourseName(String course) {
        this.currentCourseName = currentCourseName;
    }
}
