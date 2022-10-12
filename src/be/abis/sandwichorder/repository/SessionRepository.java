package be.abis.sandwichorder.repository;

import be.abis.sandwichorder.exception.PersonNotFoundException;
import be.abis.sandwichorder.model.Session;
import be.abis.sandwichorder.model.Student;
import be.abis.sandwichorder.model.Teacher;

import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SessionRepository {

    FileStudentRepository fsr = new FileStudentRepository();
    FileTeacherRepository ftr = new FileTeacherRepository();
    private List<Student> st1 = new ArrayList<>();
    private List<Student> st2 = new ArrayList<>();
    private List<Student> st3 = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    private List<Session> sessions= new ArrayList<>();


    public SessionRepository() {

        try {
            st1.add(fsr.findStudentById(2));
            st1.add(fsr.findStudentById(6));
            st1.add(fsr.findStudentById(13));

            st2.add(fsr.findStudentById(5));
            st2.add(fsr.findStudentById(9));
            st2.add(fsr.findStudentById(7));
            st2.add(fsr.findStudentById(10));
            st2.add(fsr.findStudentById(3));

            st3.add(fsr.findStudentById(4));
            st3.add(fsr.findStudentById(11));
            st3.add(fsr.findStudentById(12));

            teachers.add(ftr.findTeacherById(1));
            teachers.add(ftr.findTeacherById(2));
            teachers.add(ftr.findTeacherById(3));
        } catch (PersonNotFoundException e) {
            System.out.println(e);
        }


        sessions.add(new Session("Java basics", teachers.get(0), st1, LocalDate.of(2022,10,3)));
        sessions.add(new Session("Java basics", teachers.get(0), st1, LocalDate.of(2022,10,4)));
        sessions.add(new Session("Java basics", teachers.get(0), st1, LocalDate.of(2022,10,5)));
        sessions.add(new Session("Java basics", teachers.get(0), st1, LocalDate.of(2022,10,6)));
        sessions.add(new Session("Java basics", teachers.get(0), st1, LocalDate.of(2022,10,7)));

        sessions.add(new Session("Python for friends", teachers.get(1), st2, LocalDate.of(2022, 10, 5)));
        sessions.add(new Session("Python for friends", teachers.get(1), st2, LocalDate.of(2022, 10, 6)));
        sessions.add(new Session("Python for friends", teachers.get(1), st2, LocalDate.of(2022, 10, 7)));
        sessions.add(new Session("Python for friends", teachers.get(1), st2, LocalDate.of(2022, 10, 10)));
        sessions.add(new Session("Python for friends", teachers.get(1), st2, LocalDate.of(2022, 10, 11)));

        sessions.add(new Session("Front end", teachers.get(2), st3, LocalDate.of(2022,10,6)));
        sessions.add(new Session("Front end", teachers.get(2), st3, LocalDate.of(2022,10,7)));
        sessions.add(new Session("Front end", teachers.get(2), st3, LocalDate.of(2022,10,10)));


    }



    public List<Session> findByDate(LocalDate date){
        return sessions.stream()
                .filter(s -> s.getDate() == date)
                .collect(Collectors.toList());
    }

    public void addSession(Session s) {sessions.add(s);}
}
