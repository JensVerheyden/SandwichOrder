package be.abis.sandwichorder.model;

public class Session {

    private String courseName;
    private Teacher teacher;
    private Student[] students;
    private String[] dates;

    public Session(String courseName, Teacher teacher, Student[] students, String[] dates) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = students;
        this.dates = dates;
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

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String[] getDates() {
        return dates;
    }

    public void setDates(String[] dates) {
        this.dates = dates;
    }
}
