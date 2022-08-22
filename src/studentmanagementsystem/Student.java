package studentmanagementsystem;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private String courses = "";
	private double tuitionBalance = 0;
	private static double costOfCourse = 200;
	private static int id = 1000;

	// Constructor: prompts user to enter student's name and year
	public Student() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter student's first name: ");
		this.firstName = sc.nextLine();

		System.out.print("Enter student's last name: ");
		this.lastName = sc.nextLine();

		System.out.print("	1 - Beginner\n	2 - Intermediate\n	3 - Advanced\n	4 - Expert\nEnter student's level: ");
		try {
			this.gradeYear = sc.nextInt();
			setStudentId();
			this.enroll();
		} catch (Exception e) {
			System.out.println("Invalid Entry");
		}
	}

	// Generate an ID: grade level+id
	private void setStudentId() {
		id = id + 1;
		this.studentId = gradeYear + "" + id;
	}

	// Enroll in courses
	public void enroll() {
		do {
			System.out.print("Enter course name to enroll(Q to quit): ");
			Scanner sc = new Scanner(System.in);
			String course = sc.nextLine();
			if (!course.equals("Q")) {
				courses = courses + course + ", ";
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {
				break;
			}
		} while (true);
		this.payTuition();
	}

	// View Balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}

	// Pay Tuition
	public void payTuition() {
		this.viewBalance();
		System.out.print("Enter the amount you want to pay : $");
		Scanner in = new Scanner(System.in);
		double payment = in.nextDouble();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("-------------------------------------------");
		System.out.println("** Thank you for your payment of $" + payment + " **");
		this.viewBalance();
		System.out.println("-------------------------------------------");
	}

	// Show summary
	@Override
	public String toString() {
		return "Summary [Name=" + firstName + " " + lastName + "; Grade Level=" + gradeYear + "; Student Id="
				+ studentId + "; Courses Enrolled= {" + courses + "}; Pending Balance=" + tuitionBalance + "]";
	}

}