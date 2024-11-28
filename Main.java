import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Rank Students");
            System.out.println("8. Exit");
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
                    manager.updateStudent();
                    break;
                case 4:
                    manager.searchStudent();
                    break;
                case 5:
                    manager.displayAllStudents();
                    break;
                case 6:
                    manager.sortStudentsByMarks();
                    break;
                case 7:
                    manager.rankStudents();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
