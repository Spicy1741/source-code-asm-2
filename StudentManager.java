import java.util.Scanner;

public class StudentManager {
    private StudentStack stack = new StudentStack();

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '0' at any point to return to the menu.");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        if (id.equals("0")) return;

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        if (name.equals("0")) return;

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        if (age == 0) return;

        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();
        if (marks < 0 || marks > 10) {
            System.out.println("Invalid marks. Enter a value between 0 and 10.");
            return;
        }

        Student student = new Student(id, name, age, marks);
        stack.push(student);
        System.out.println("Student added to the stack.");
    }

    public void deleteStudent() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. No student to delete.");
            return;
        }

        System.out.println("Are you sure you want to delete the top student? (Enter '0' to cancel, 1 to proceed): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0) return;

        Student removedStudent = stack.pop();
        if (removedStudent != null) {
            System.out.println("Removed Student: " + removedStudent);
        }
    }

    public void updateStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '0' at any point to return to the menu.");
        System.out.print("Enter ID of Student to Update (alphanumeric): ");
        String id = scanner.nextLine();
        if (id.equals("0")) return;

        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!stack.isEmpty()) {
            Student current = stack.pop();
            if (current.getId().equals(id)) {
                System.out.println("Current Details: " + current);

                System.out.print("Enter New Name: ");
                String newName = scanner.nextLine();
                if (newName.equals("0")) {
                    tempStack.push(current);
                    break;
                }

                System.out.print("Enter New Age: ");
                int newAge = scanner.nextInt();
                if (newAge == 0) {
                    tempStack.push(current);
                    break;
                }

                System.out.print("Enter New Marks: ");
                double newMarks = scanner.nextDouble();
                if (newMarks < 0 || newMarks > 10) {
                    System.out.println("Invalid marks. Update canceled.");
                    tempStack.push(current);
                    break;
                }

                current.setName(newName);
                current.setAge(newAge);
                current.setMarks(newMarks);
                found = true;
            }
            tempStack.push(current);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student details updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void sortStudentsByMarks() {
        if (stack.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }

        int size = 0;
        StudentStack tempStack = new StudentStack();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
            size++;
        }

        Student[] studentArray = new Student[size];
        for (int i = 0; i < size; i++) {
            studentArray[i] = tempStack.pop();
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (studentArray[j].getMarks() > studentArray[j + 1].getMarks()) {
                    Student temp = studentArray[j];
                    studentArray[j] = studentArray[j + 1];
                    studentArray[j + 1] = temp;
                }
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            stack.push(studentArray[i]);
        }

        System.out.println("Students sorted by marks.");
    }

    public void rankStudents() {
        if (stack.isEmpty()) {
            System.out.println("No students to rank.");
            return;
        }

        System.out.println("Student Rankings:");
        StudentStack tempStack = new StudentStack();

        while (!stack.isEmpty()) {
            Student student = stack.pop();
            System.out.println(student + ", Rank: " + getRank(student.getMarks()));
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    private String getRank(double marks) {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    public void displayAllStudents() {
        System.out.println("All Students:");
        stack.look();
    }

    public void searchStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '0' at any point to return to the menu.");
        System.out.print("Enter Student ID to Search (alphanumeric): ");
        String id = scanner.nextLine();
        if (id.equals("0")) return;

        StudentStack tempStack = new StudentStack();
        boolean found = false;

        // Iterate through the stack and search for the student by ID
        while (!stack.isEmpty()) {
            Student current = stack.pop();
            if (current.getId().equals(id)) { // Compare as String
                System.out.println("Found Student: " + current);
                found = true;
            }
            tempStack.push(current); // Push each student to tempStack
        }

        // Restore the stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
