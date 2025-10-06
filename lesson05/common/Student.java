package common;

public class Student extends Person {
    private double grade;

    public Student(String name) {
        super(name);
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public void introduce() {
        System.out.println("Я студент " + name);
    }
}
