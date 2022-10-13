package be.abis.sandwichorder.manager;

import be.abis.sandwichorder.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderManager {

    private static OrderManager instance;
    private OrderManager(){}

    public static OrderManager getInstance() {
        if (instance == null) instance = new OrderManager();
        return instance;
    }


    public void printTicket() {}

    public DayOrder createNewDayOrder(LocalDate date, SandwichCompany sandwichCompany){
        List<Session> sessions = SessionManager.getTodaysSessions(date);
        System.out.println(sessions.size());
        List<Person> allPeople = sessions.stream()
                .map(Session::getStudents).flatMap(List::stream).collect(Collectors.toList());
        for(Session s:sessions){
            allPeople.add(s.getTeacher());
        }

        MenuManager mm = MenuManager.getInstance();
        Menu dayMenu = mm.setMenuOfTheDay(sandwichCompany);



        DayOrder dayOrder = new DayOrder(date, dayMenu, allPeople );
        for(Person p:allPeople){
            p.setDayOrder(dayOrder);
            p.setHasOrdered(false);
        }

        return dayOrder;
    }

    public void saveOrder(){}

    public void retrieveOrder(){}

    public void deleteOrder(){}
}
