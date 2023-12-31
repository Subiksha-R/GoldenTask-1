import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentID;
    private String name;
    private double totalFees;
    private double feesPaid;

    public Student(String studentID, String name, double totalFees) {
        this.studentID = studentID;
        this.name = name;
        this.totalFees = totalFees;
        this.feesPaid = 0;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void makePayment(double amount) {
        feesPaid += amount;
    }

    public double getRemainingFees() {
        return totalFees - feesPaid;
    }
}

class FeeManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void recordPayment(String studentID, double amount) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                student.makePayment(amount);
                System.out.println("Payment recorded successfully.");
                return;
            }
        }
        System.out.println("Student not found with the given ID.");
    }

    public void displayStudentInfo(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                System.out.println("Student ID: " + student.getStudentID());
                System.out.println("Name: " + student.getName());
                System.out.println("Total Fees: $" + student.getTotalFees());
                System.out.println("Fees Paid: $" + student.getFeesPaid());
                System.out.println("Remaining Fees: $" + student.getRemainingFees());
                return;
            }
        }
        System.out.println("Student not found with the given ID.");
    }
}

public class FeesManagement {
    public static void main(String[] args) {
        FeeManagementSystem feeSystem = new FeeManagementSystem();
        Student student1 = new Student("101", "Subi", 82000);
        Student student2 = new Student("102", "Ram", 75600);
        Student student3 = new Student("103", "Susan", 65000);
        
        feeSystem.addStudent(student1);
        feeSystem.addStudent(student2);
        feeSystem.addStudent(student3);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nFees Management System Menu:");
            System.out.println("1. Record Payment");
            System.out.println("2. Display Student Info");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentID = sc.next();
                    System.out.print("Enter Payment Amount: $");
                    double amount = sc.nextDouble();
                    feeSystem.recordPayment(studentID, amount);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.next();
                    feeSystem.displayStudentInfo(studentID);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        sc.close();
    }
}