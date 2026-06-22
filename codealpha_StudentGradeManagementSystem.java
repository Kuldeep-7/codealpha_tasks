import java.util.*;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

public class codealpha_StudentGradeManagementSystem{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Show Statistics");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();

                    students.add(new Student(name, grade));

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    displayStudents(students);
                    break;

                case 3:
                    showStatistics(students);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void displayStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("----- Student Records -----");
        System.out.println("Name   Grade");

        for (Student student : students) {
            System.out.println(student.getName() +"   "+ student.getGrade());
        }
    }

    public static void showStatistics(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).getGrade();
        double lowest = students.get(0).getGrade();

        for (Student student : students) {
            double grade = student.getGrade();

            total = total + grade;

            if (grade > highest) {
                highest = grade;
            }

            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = total / students.size();

        System.out.println("===== Summary Report =====");
        System.out.println("Total Students : " + students.size());
        System.out.println("Average Score  : " + average);
        System.out.println("Highest Score  : " + highest);
        System.out.println("Lowest Score   : " + lowest);
    }
}