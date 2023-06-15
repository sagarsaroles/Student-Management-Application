package studentmanagementsystem;
import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    private List<Student> students;
    private String fileName;

    public StudentManagementSystem(String fileName) {
        students = new ArrayList<>();
        this.fileName = fileName;
        loadStudentsFromFile();
    }

    private void loadStudentsFromFile() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String name = data[0];
                int rollNumber = Integer.parseInt(data[1]);
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                students.add(new Student(name, rollNumber, age, course));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Student data file not found. Creating a new file...");
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student List:");
            for (Student student : students) {
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Age: " + student.getAge());
                System.out.println("Course: " + student.getCourse());
                System.out.println("--------------------------");
            }
        }
    }

    public void updateStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new age: ");
                int age = scanner.nextInt();
                System.out.print("Enter new course: ");
                scanner.nextLine();
                String course = scanner.nextLine();
                student = new Student(name, rollNumber, age, course);
                saveStudentsToFile();
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found with roll number: " + rollNumber);
    }

    public void deleteStudent(int rollNumber) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber() == rollNumber) {
                iterator.remove();
                saveStudentsToFile();
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found with roll number: " + rollNumber);
    }

    private void saveStudentsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                writer.println(student.getName()+","+student.getRollNumber()+","+student.getAge()+","+student.getCourse());
            }
        } catch (IOException e) {
            System.out.println("Error occurred while saving student data.");
        }
    }
}
