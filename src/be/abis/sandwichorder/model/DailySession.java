package be.abis.sandwichorder.model;

public class DailySession {

    private String courseName;
    private String date;
    private Student[] students;
    private Teacher teacher;

    public DailySession(String courseName, String date, Student[] students, Teacher teacher) {
        this.courseName = courseName;
        this.date = date;
        this.students = students;
        this.teacher = teacher;
        setStudentSession(courseName);
    }

    public void setStudentSession(String courseName){
        for(Student s:students){
            s.setCurrentSession(courseName);
        }
    };

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
