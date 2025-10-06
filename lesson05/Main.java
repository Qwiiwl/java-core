
import common.*;
import quiz.*;
import utils.InputHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputHelper helper = new InputHelper(sc);

        System.out.println("=== LESSON 05 ===");
        System.out.println("1. Course Management System");
        System.out.println("2. Online Quiz System");
        System.out.print("Выберите модуль: ");
        int choice = helper.readInt();

        if (choice == 1) {
            runCourseSystem(helper);
        } else if (choice == 2) {
            runQuizSystem(helper);
        } else {
            System.out.println("Неверный выбор.");
        }
    }

    // ===== COURSE MANAGEMENT =====
    private static void runCourseSystem(InputHelper helper) {
        System.out.println("\n=== COURSE MANAGEMENT SYSTEM ===");

        System.out.print("Введите имя преподавателя: ");
        String teacherName = helper.readLine();
        System.out.print("Введите предмет преподавателя: ");
        String subject = helper.readLine();
        Teacher teacher = new Teacher(teacherName, subject);

        System.out.print("Введите название курса: ");
        String courseTitle = helper.readLine();
        System.out.print("Введите описание курса: ");
        String courseDesc = helper.readLine();

        Course course = new Course(courseTitle, courseDesc, teacher);

        System.out.print("Введите количество студентов: ");
        int count = helper.readInt();
        for (int i = 0; i < count; i++) {
            System.out.print("Имя студента #" + (i + 1) + ": ");
            Student s = new Student(helper.readLine());
            course.addStudent(s);
        }

        // Attendance
        System.out.println("\n=== Отметим посещаемость ===");
        for (Student s : course.getStudents()) {
            System.out.print("Присутствовал ли " + s.getName() + " (y/n)? ");
            String ans = helper.readLine().toLowerCase();
            course.markAttendance(s, ans.equals("y"));
        }

        // Grades
        System.out.println("\n=== Ввод оценок ===");
        for (Student s : course.getStudents()) {
            System.out.print("Введите балл для " + s.getName() + ": ");
            double grade = helper.readDouble();
            course.addGrade(s, grade);
        }

        System.out.println("\n--- Информация о курсе ---");
        course.printCourseInfo();
    }

    // ===== QUIZ SYSTEM =====
    private static void runQuizSystem(InputHelper helper) {
        System.out.println("\n=== ONLINE QUIZ SYSTEM ===");

        System.out.print("Введите название квиза: ");
        Quiz quiz = new Quiz(helper.readLine());

        System.out.print("Введите количество вопросов: ");
        int qCount = helper.readInt();
        for (int i = 0; i < qCount; i++) {
            System.out.print("\nТекст вопроса #" + (i + 1) + ": ");
            String text = helper.readLine();
            System.out.print("Правильный ответ: ");
            String ans = helper.readLine();
            quiz.addQuestion(new Question(text, ans));
        }

        System.out.print("\nВведите количество команд: ");
        int tCount = helper.readInt();
        for (int i = 0; i < tCount; i++) {
            System.out.print("Название команды #" + (i + 1) + ": ");
            Team team = new Team(helper.readLine());
            quiz.addTeam(team);
        }

        QuizManager manager = new QuizManager(quiz, helper);
        manager.start();
    }
}
