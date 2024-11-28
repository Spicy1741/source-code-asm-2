public class StudentStack {
    private Node top;

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public StudentStack() {
        this.top = null;
    }

    // Push a student onto the stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    // Pop a student from the stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        Student poppedStudent = top.student;
        top = top.next;
        return poppedStudent;
    }

    // Peek at the top student without removing
    public Student top() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return top.student;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Look through the entire stack (for display purposes)
    public void look() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}
