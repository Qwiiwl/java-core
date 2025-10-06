package common;
import java.util.HashMap;
import java.util.Map;

public class GradeBook {
    private Map<Student, Double> grades = new HashMap<>();

    public void assignGrade(Student student, double grade) {
        grades.put(student, grade);
        student.setGrade(grade);
    }

    public double getGrade(Student student) {
        return grades.getOrDefault(student, 0.0);
    }
}

