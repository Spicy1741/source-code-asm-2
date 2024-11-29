import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Reverse Stack");
            System.out.println("5. Display Maximum Marks");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.deleteStudent();
                    break;
                case 3:
                    manager.displayAllStudents();
                    break;
                case 4:
                    manager.reverseStack();
                    break;
                case 5:
                    manager.displayMaxMarks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class ErrorHandlingTest {
    public static void main(String[] args) {
        StudentStack stack = new StudentStack();

        // Test Case 1: Pop on empty stack
        System.out.println("Testing pop on an empty stack:");
        stack.pop();

        // Test Case 2: Push null
        System.out.println("\nTesting push with a null student:");
        stack.push(null);

        // Test Case 3: Reverse empty stack
        System.out.println("\nTesting reverseStack on an empty stack:");
        stack.reverseStack();

        // Test Case 4: Find maximum marks
        System.out.println("\nTesting findMaxMarks with valid data:");
        stack.push(new Student("S001", "nghia", 19, 8.0)); // Added age parameter
        stack.push(new Student("S002", "thiep", 19, 9.0));
        stack.push(new Student("S003", "tuan anh", 19, 8.0));
        System.out.println("Maximum Marks: " + stack.findMaxMarks());

        // Test Case 5: Valid operations sequence
        System.out.println("\nTesting valid operations:");
        System.out.println("Before reversal:");
        stack.displayStudents();
        stack.reverseStack();
        System.out.println("After reversal:");
        stack.displayStudents();
    }
}




