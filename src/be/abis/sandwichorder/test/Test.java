package be.abis.sandwichorder.test;

import be.abis.sandwichorder.exception.PersonNotFoundException;
import be.abis.sandwichorder.exception.SandwitchNotFoundException;
import be.abis.sandwichorder.manager.OrderManager;
import be.abis.sandwichorder.model.DayOrder;
import be.abis.sandwichorder.model.Person;
import be.abis.sandwichorder.repository.FileCompanyRepository;
import be.abis.sandwichorder.repository.FileStudentRepository;
import be.abis.sandwichorder.repository.SandwichRepository;

import java.io.File;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        FileStudentRepository fsl = new FileStudentRepository();
        DayOrder dayO = OrderManager.getInstance().createNewDayOrder(LocalDate.of(2022,10,6), FileCompanyRepository.getInstance().findCompany("Vleugels"));

        Person p = dayO.getAllPersons().get(3);


        try {
            p.orderSandwich("Carolina","white", "yes");
        } catch (SandwitchNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(p.getHasOrdered());

        System.out.println(dayO.printOrder());
        p.cancelOrder();
        System.out.println(dayO.printOrder());
    }
}
