package be.abis.sandwichorder.model;

import java.util.ArrayList;

public class Course {

    private String name;
    private Teacher teacher;
    private ArrayList students;
    private String period;

    public Course(String name, Teacher teacher, ArrayList students, String period) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
        this.period = period;
    }




    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList getStudents() {
        return students;
    }

    public String getPeriod() {
        return period;
    }
}
