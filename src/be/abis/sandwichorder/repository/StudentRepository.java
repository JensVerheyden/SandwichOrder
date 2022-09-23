package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.model.Student;

public class StudentRepository {

    private static Student s1 = new Student("Mary", "Jones", "maryjones@gmail.com", "FTL");
    private static Student s2 = new Student("Jim", "McFlee", "jimmcflee@gmail.com", "FTL");
    private static Student s3 = new Student("Helen", "Sting", "helensting@gmail.com", "FTL");
    private static Student s4 = new Student("Larry", "Lane", "larrylane@gmail.com", "FTL");


    private static Student s5 = new Student("Mike", "Randall", "mikerandall@gmail.com", "IBM");
    private static Student s6 = new Student("Steve", "Sigmundson", "stevesigmundson@yahoo.com", "IBM");
    private static Student s7 = new Student("Aaron", "Simmons", "aaronsimmons@hotmail.com", "IBM");
    private static Student s8 = new Student("Lance", "Armstrong", "lancearmstrong@yahoo.com", "IBM");

    private static Student s9 = new Student("Leroy", "Jenkins", "leroyjenkins@talk.com", "Melon");
    private static Student s10 = new Student("Andrea", "Serotti", "andreaserotti@yahoo.it", "Melon");
    private static Student s11 = new Student("Indra", "Evensen", "indraevensen@hotmail.com", "Melon");
    private static Student s12 = new Student("Mikael", "Akerfield", "makerfield@yahoo.com", "Melon");
    private static Student s13 = new Student("Frodo", "Baggins", "frodobaggins@theshire.mi", "Melon");


    public static Student[] students = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13};

    public static Student findByFirstName(String firstName){
        for(Student s:students){
            if (s.getFirstName().equals(firstName)) {
                return s;
            }
        }
        return null;
    }

}
