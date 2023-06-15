package studentmanagementsystem;

public class Student {

    private String name;
    private int rollNumber;
    private int age;
    private String course;

    public Student(String name, int rollNumber, int age, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }
}
