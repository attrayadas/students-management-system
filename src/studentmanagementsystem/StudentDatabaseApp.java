package studentmanagementsystem;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {

		// To get the number of students we have to add
		System.out.print("Enter number of new students to enroll: ");
		Scanner sc = new Scanner(System.in);
		int numOfStudents = sc.nextInt();
		Student[] students = new Student[numOfStudents];

		// Create n number of new students
		for (int n = 0; n < numOfStudents; n++) {
			students[n] = new Student();
		}

		for (int n = 0; n < numOfStudents; n++) {
			System.out.println(students[n]);
		}

	}

}
