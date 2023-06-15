
import java.util.Scanner;

import studentmanagementsystem.*;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to store student data: ");
        String fileName = scanner.nextLine();

        StudentManagementSystem system = new StudentManagementSystem(fileName);

        while (true) {
            System.out.println("\n----- Student Management System -----");
            System.out.println("1. Add a student");
            System.out.println("2. Display all students");
            System.out.println("3. Update a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    Student student = new Student(name, rollNumber, age, course);
                    system.addStudent(student);
                    break;
                case 2:
                    system.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter roll number of the student to update: ");
                    int updateRollNumber = scanner.nextInt();
                    scanner.nextLine();
                    system.updateStudent(updateRollNumber);
                    break;
                case 4:
                    System.out.print("Enter roll number of the student to delete: ");
                    int deleteRollNumber = scanner.nextInt();
                    scanner.nextLine();
                    system.deleteStudent(deleteRollNumber);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
