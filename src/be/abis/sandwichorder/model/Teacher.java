package be.abis.sandwichorder.model;

import java.text.Format;

public class Teacher extends Person{



    public Teacher(String personNr, String firstName, String lastName, String email, String company, String currentCourseName) {
        super(personNr,firstName, lastName, email, company);
    }

    public Teacher(){};


    public void viewOrderOfToday(){
        System.out.println(this.getCurrentSession() + "\n");
        System.out.println("---------------------\n");
        this.getDayOrder().getAllPersons().stream()
                .filter(p->p.getCurrentSession().equals(this.getCurrentSession()))
                .forEach(p -> System.out.printf("%-20s %20s%n",p.getFirstName() + " "+ p.getLastName(), p.getHasOrdered()));
    }


}
