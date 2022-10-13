package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.exception.PersonNotFoundException;
import be.abis.sandwichorder.model.Person;
import be.abis.sandwichorder.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileStudentRepository implements PersonRepository {

    private List<Student> allStudents  = new ArrayList<>();
    private static final String FILELOCATION = "src/be/abis/sandwichorder/resources/students.csv";

    public FileStudentRepository() {
        this.readFile();
    }

    public void readFile() {
        if(allStudents.size() != 0) allStudents.clear();
        List<String> lines = null;
        try{
            lines = Files.readAllLines(Paths.get(FILELOCATION));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : lines){
            Student s = convertToStudentObj(line);
            allStudents.add(s);
        }
    }

    public static Student convertToStudentObj(String attr){
        String[] vals = attr.split(";");
        if(!vals[0].equals("")){
            Student s = new Student();
            s.setPersonNr(!vals[0].equals("null") ? Integer.valueOf(vals[0]) : null);
            s.setFirstName(!vals[1].equals("null")? vals[1] : null );
            s.setLastName(!vals[2].equals("null") ? vals[2] : null);
            s.setEmail(!vals[3].equals( "null") ? vals[3] : null);
            s.setCompany(!vals[4].equals("null") ? vals[4] : null);
            return s;
        }
        return null;
    }

    public List<Student> getStudents() {
        return allStudents;
    }


    public Student findStudent(String firstName, String email) throws PersonNotFoundException {
        Student foundStudent = allStudents.stream()
                .filter(p -> p.getFirstName().equals(firstName) && p.getEmail().equals(email))
                .findFirst().orElseThrow(() -> new PersonNotFoundException("Student " + firstName +" not found or email does not match."));
        return foundStudent;
    }


    public Student findStudentById(int id) throws PersonNotFoundException{
        Student foundStudent = allStudents.stream()
                .filter(p -> p.getPersonNr() == id)
                .findFirst().orElseThrow(() -> new PersonNotFoundException("Student with id " + id + " was not found."));
        return foundStudent;
    }
}
