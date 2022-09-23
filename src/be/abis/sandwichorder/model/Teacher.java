package be.abis.sandwichorder.model;

public class Teacher extends Person{

    private Course course;

    public Teacher(String firstName, String lastName, String email, String company, Course course) {
        super(firstName, lastName, email, company);
        this.course = course;
    }



    /*
    public Order viewCurrentOrder(){

    }
    */


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
