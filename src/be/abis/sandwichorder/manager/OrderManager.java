package be.abis.sandwichorder.manager;

import be.abis.sandwichorder.model.*;

import java.util.ArrayList;

public class OrderManager {


    public void printTicket() {}

    public void createOrder(String date){

        ArrayList<Student> studentsOfDay = new ArrayList<Student>();

        ArrayList<DailySession> dailySessions = SessionManager.createDailySessions(date);
        for (DailySession d:dailySessions){
            for(Student s:d.getStudents()) studentsOfDay.add(s);
        }

        SandwichCompany sandwichCompany = MenuManager.getMenuOfTheDay().company();

        DayOrder dayOrder = new DayOrder(date, sandwichCompany, studentsOfDay );
        // find how to actually use the just created dayOrder
        // the manager calls createNewOrder()
        // which they should assign to a var
    }

    public void saveOrder(){}

    public void retrieveOrder(){}

    public void deleteOrder(){}
}
