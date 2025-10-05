import model.Student;
import service.StudentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Roll No: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();
                    Student student = new Student(rollNo, name, email, course, marks);
                    manager.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter Roll No to delete: ");
                    manager.deleteStudent(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter Roll No to update: ");
                    int rNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();
                    System.out.print("New Marks: ");
                    double newMarks = sc.nextDouble();
                    manager.updateStudent(rNo, newCourse, newMarks);
                    break;
                case 4:
                    System.out.print("Enter Roll No to search: ");
                    Student s = manager.searchStudent(sc.nextInt());
                    if (s != null) s.displayInfo();
                    else System.out.println("Student not found.");
                    break;
                case 5:
                    manager.viewAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
