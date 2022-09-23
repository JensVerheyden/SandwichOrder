package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.model.Session;
import be.abis.sandwichorder.model.Student;

public class SessionRepository {

    private static Student[] students1 = {StudentRepository.findByFirstName(""),
            StudentRepository.findByFirstName("Jim"),
            StudentRepository.findByFirstName("Steve"),
            StudentRepository.findByFirstName("Frodo")
    };

    private static Student[] students2 = {StudentRepository.findByFirstName(""),
            StudentRepository.findByFirstName("Mike"),
            StudentRepository.findByFirstName("Leroy"),
            StudentRepository.findByFirstName("Aaron"),
            StudentRepository.findByFirstName("Andrea"),
            StudentRepository.findByFirstName("Helen")
    };

    private static Student[] students3 = {StudentRepository.findByFirstName(""),
            StudentRepository.findByFirstName("Larry"),
            StudentRepository.findByFirstName("Indra"),
            StudentRepository.findByFirstName("Mikael")
    };

    private static Student[] students4 = {StudentRepository.findByFirstName(""),
            StudentRepository.findByFirstName("Mary"),
            StudentRepository.findByFirstName("Indra"),
            StudentRepository.findByFirstName("Steve"),
            StudentRepository.findByFirstName("Helen"),
            StudentRepository.findByFirstName("Larry"),
            StudentRepository.findByFirstName("Frodo"),
            StudentRepository.findByFirstName("Mike")
    };

    private static String[] dates1 = {"17 march", "18 march", "19 march"};
    private static String[] dates4 = {"1 april", "2 april", "3 april"};
    private static String[] dates5 = {"28 february", "29 february", "1 march", "4 march", "5 march", "6 march", "15 march", "16 march", "17 march"};
    private static String[] dates2 = {"15 march", "16 march", "17 march", "18 march", "19 march"};
    private static String[] dates3 = {"17 march", "18 march", "19 march", "22 march", "23 march", "24 march"};


    private static Session se1 = new Session("Java basics", TeacherRepository.findByFirstName("Floor"), students1, dates1 );
    private static Session se2 = new Session("Python for friends", TeacherRepository.findByFirstName("Tim"), students4, dates3);
    private static Session se3 = new Session("Front end", TeacherRepository.findByFirstName("Jos"), students2, dates5);
    private static Session se4 = new Session ("Java advanced", TeacherRepository.findByFirstName("Wouter"), students3, dates2);

    public static Session[] sessions = {se1,se2,se3,se4};

    public static Session findByDate(String date){
        for(Session se:sessions){
            String[] allDates = se.getDates();
            for (String d:allDates) {
                if (d.equals(date)) return se;
            }
        }
        return null;
    }
}
