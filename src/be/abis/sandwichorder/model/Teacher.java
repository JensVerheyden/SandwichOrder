package be.abis.sandwichorder.model;

public class Teacher extends Person{

    private String course;

    public Teacher(String firstName, String lastName, String email, String company, String course) {
        super(firstName, lastName, email, company);
        this.course = course;
    }




    public void viewOrderOfToday(){
        System.out.println();
    }



    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
