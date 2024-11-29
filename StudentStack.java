class StudentStack {
    private Node top; // Top of the stack
    private int size; // To keep track of the number of elements

    // Constructor
    public StudentStack() {
        top = null; // Stack is initially empty
        size = 0;   // Initial size is 0
    }

    // Inner Node class
    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            if (student == null) {
                throw new IllegalArgumentException("Student cannot be null");
            }
            this.student = student;
            this.next = null;
        }
    }

    // Push a student onto the stack
    public void push(Student student) {
        try {
            Node newNode = new Node(student);
            newNode.next = top; // Point new node to the previous top
            top = newNode;      // Update top to be the new node
            size++;
            System.out.println("Inserted: " + student);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }

    // Pop a student from the stack
    public Student pop() {
        try {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow! No students to remove.");
            }
            Student poppedStudent = top.student; // Get the student from the top node
            top = top.next;                      // Move top to the next node
            size--;
            return poppedStudent;
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
            return null;
        }
    }

    // Peek at the top student without removing
    public Student peek() {
        try {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty!");
            }
            return top.student; // Return the student at the top node
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
            return null;
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null; // Stack is empty if top is null
    }

    // Get the size of the stack
    public int size() {
        return size; // Return the current size of the stack
    }

    // Display all students in the stack
    public void displayStudents() {
        try {
            if (isEmpty()) {
                throw new IllegalStateException("No students in the stack.");
            }

            System.out.println("Students in Stack:");
            Node current = top;  // Start from the top node
            while (current != null) {
                System.out.println(current.student);
                current = current.next; // Move to the next node
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }

    // Find the maximum marks in the stack without modifying it
    public double findMaxMarks() {
        try {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty. Cannot find maximum marks.");
            }

            Node current = top;
            double maxMarks = current.student.getMarks(); // Start with the top student's marks
            while (current != null) {
                if (current.student.getMarks() > maxMarks) {
                    maxMarks = current.student.getMarks();
                }
                current = current.next; // Move to the next node
            }
            return maxMarks;
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
            return -1;
        }
    }

    // Reverse the stack
    public void reverseStack() {
        try {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty. Nothing to reverse.");
            }

            Node prev = null;
            Node current = top;
            Node next;

            while (current != null) {
                next = current.next;   // Store next node
                current.next = prev;   // Reverse the current node's pointer
                prev = current;        // Move prev to current
                current = next;        // Move current to next
            }

            top = prev; // Update top to the new top of the reversed stack
            System.out.println("Stack has been reversed.");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }
}
