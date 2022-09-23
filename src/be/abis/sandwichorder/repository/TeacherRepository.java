package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.model.Student;
import be.abis.sandwichorder.model.Teacher;

public class TeacherRepository {

    private static Teacher t1 = new Teacher("Floor", "Jansens", "floorjansesn@yahoo.com", "Abis", "Java, UML, JavaScript, HTML/CSS");
    private static Teacher t2 = new Teacher("Jos", "Van Den Bosch", "jvdbosch@yahoo.com", "Abis", "JavaScript, TypeScript, Angular, React");
    private static Teacher t3 = new Teacher("Wouter", "Wouters", "wwouters@yahoo.com", "Abis", "UML, JAVA, Cobol");
    private static Teacher t4 = new Teacher("Tim", "Smets", "tsmets@yahoo.com", "Abis", "R, Python");

    public static Teacher[] teachers = {t1,t2,t3,t4};

    public static Teacher findByFirstName(String firstName){
        for(Teacher t:teachers){
            if (t.getFirstName().equals(firstName)) {
                return t;
            }
        }
        return null;
    }

}
