package be.abis.sandwichorder.model;

import java.time.LocalDate;
import java.util.List;

public class Session {

    private String courseName;
    private Teacher teacher;
    private List<Student> students;
    private LocalDate date;

    public Session(String courseName, Teacher teacher, List<Student> students, LocalDate date) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = students;
        this.date = date;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
