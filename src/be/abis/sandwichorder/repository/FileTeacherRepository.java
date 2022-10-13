package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.exception.PersonNotFoundException;
import be.abis.sandwichorder.model.Teacher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileTeacherRepository implements PersonRepository{


    private List<Teacher> allTeachers = new ArrayList<>();
    private static final String FILELOCATION = "src/be/abis/sandwichorder/resources/teachers.csv";

    public FileTeacherRepository() {this.readFile();}

    public void readFile() {
        if(allTeachers.size() != 0) allTeachers.clear();
        List<String> lines = null;
        try{ lines = Files.readAllLines(Paths.get(FILELOCATION));

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String l : lines){
            Teacher t = convertToTeacherObj(l);
            allTeachers.add(t);
        }
    }

    public Teacher convertToTeacherObj(String attr){
        String[] vals = attr.split( ";");
        if(!vals[0].equals("")){
            Teacher t = new Teacher();
            t.setPersonNr(!vals[0].equals("null")? Integer.valueOf(vals[0]): null);
            t.setFirstName(!vals[1].equals("null")? vals[1]: null);
            t.setLastName(!vals[2].equals("null")? vals[2]: null);
            t.setEmail(!vals[3].equals("null")? vals[3]: null);
            t.setCompany(!vals[4].equals("null")? vals[4]: null);
            t.setCurrentSession(!vals[5].equals("null")? vals[5]: null);
            return t;
        }
        return null;
    }

    public List<Teacher> getTeachers() {
        return allTeachers;
    }


    public Teacher findTeacher(String firstName, String email) throws PersonNotFoundException {
        Teacher foundTeacher = allTeachers.stream()
                .filter(p -> p.getFirstName().equals(firstName) && p.getEmail().equals(email))
                .findFirst().orElseThrow(() -> new PersonNotFoundException("Teacher " + firstName +" not found or email does not match."));
        return foundTeacher;
    }

    public Teacher findTeacherById(int id) throws PersonNotFoundException {
        Teacher foundTeacher = allTeachers.stream()
                .filter(p -> p.getPersonNr() == id)
                .findFirst().orElseThrow(() -> new PersonNotFoundException("Teacher with id " + id + " was not found."));
        return foundTeacher;    }

    //private static Teacher t1 = new Teacher("Floor", "Jansens", "floorjansesn@yahoo.com", "Abis", "Java, UML, JavaScript, HTML/CSS");
    //private static Teacher t2 = new Teacher("Jos", "Van Den Bosch", "jvdbosch@yahoo.com", "Abis", "JavaScript, TypeScript, Angular, React");
    //private static Teacher t3 = new Teacher("Wouter", "Wouters", "wwouters@yahoo.com", "Abis", "UML, JAVA, Cobol");
    //private static Teacher t4 = new Teacher("Tim", "Smets", "tsmets@yahoo.com", "Abis", "R, Python");



}
