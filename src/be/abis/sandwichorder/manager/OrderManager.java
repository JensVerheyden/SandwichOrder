package be.abis.sandwichorder.manager;

import be.abis.sandwichorder.model.*;

import javax.swing.plaf.BorderUIResource;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderManager {

    private static OrderManager instance;
    private OrderManager(){}

    public static OrderManager getInstance() {
        if (instance == null) instance = new OrderManager();
        return instance;
    }


    public void printTicket() {}

    public void createNewDailyOrder(LocalDate date){


    }

    public void saveOrder(){}

    public void retrieveOrder(){}

    public void deleteOrder(){}
}
