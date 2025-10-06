package common;
import java.util.*;

public class Course {
    private String title;
    private String description;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private AttendanceRecord attendance = new AttendanceRecord();
    private GradeBook gradeBook = new GradeBook();

    public Course(String title, String description, Teacher teacher) {
        this.title = title;
        this.description = description;
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void markAttendance(Student student, boolean present) {
        attendance.record(student, present);
    }

    public void addGrade(Student student, double grade) {
        gradeBook.assignGrade(student, grade);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printCourseInfo() {
        System.out.println("Курс: " + title);
        System.out.println("Описание: " + description);
        System.out.println("Преподаватель: " + teacher.getName());
        System.out.println("\nСтуденты:");
        for (Student s : students) {
            System.out.println("- " + s.getName()
                + " | Балл: " + gradeBook.getGrade(s)
                + " | Присутствовал: " + attendance.wasPresent(s));
        }
    }
}
