import java.util.Scanner;

public class StudentManager {
    private StudentStack stack = new StudentStack();

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, age, marks);
        stack.push(student);
    }

    public void deleteStudent() {
        Student removedStudent = stack.pop();
        if (removedStudent != null) {
            System.out.println("Deleted Student: " + removedStudent);
        }
    }

    public void displayAllStudents() {
        stack.displayStudents(); // Fixed method call
    }

    public void reverseStack() {
        stack.reverseStack();
    }

    public void displayMaxMarks() {
        double maxMarks = stack.findMaxMarks();
        if (maxMarks != -1) {
            System.out.println("Maximum Marks in Stack: " + maxMarks);
        }
    }
}
