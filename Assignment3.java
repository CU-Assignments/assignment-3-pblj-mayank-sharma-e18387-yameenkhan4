// NAME - MOHD YAMEEN KHAN , UID - 22BCS14561:
// problem 1 Square Root Calculation.

import java.util.Scanner;

class Assignment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        
        try {
            double num = scanner.nextDouble();
            if (num < 0) {
                throw new IllegalArgumentException("Error: Cannot calculate the square root of a negative number");
            }
            System.out.println("Square Root: " + Math.sqrt(num));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// problem 2 ATM Withdrawal System 

import java.util.Scanner;

class Assignment3 {
    private static final int PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();
            if (enteredPin != PIN) {
                throw new SecurityException("Error: Invalid PIN");
            }

            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            if (amount > balance) {
                throw new IllegalArgumentException("Error: Insufficient balance. Current Balance: " + balance);
            }

            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Final Balance: " + balance);
            scanner.close();
        }
    }
}
 
// Problem 3 : University Enrollment System :

import java.util.HashMap;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Assignment3 {
    private static final int COURSE_CAPACITY = 2;
    private static int enrolledStudents = 0;
    private static HashMap<String, Boolean> completedCourses = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulating completed courses
        completedCourses.put("Core Java", false);

        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();

            System.out.print("Prerequisite: ");
            String prerequisite = scanner.nextLine();

            if (!completedCourses.getOrDefault(prerequisite, false)) {
                throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete " + prerequisite + " before enrolling in " + course);
            }

            if (enrolledStudents >= COURSE_CAPACITY) {
                throw new CourseFullException("Error: CourseFullException - The course is full");
            }

            enrolledStudents++;
            System.out.println("Enrollment successful in " + course);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
