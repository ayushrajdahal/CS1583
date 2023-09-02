package hw2.src;

import java.util.Scanner;

public class ClassAverage {
	public static void main(String[] args) {
		int inputNum = 0; // stores input numerical grades
		float sumNum = 0.0f; // stores the sum of numerical grades
		float classAvg = 0.0f; // stores the average numerical grades
		int counter = 0; // counts how many times user has given input
		String grade; // stores the letter grade
		Scanner scanner = new Scanner(System.in); // scanner object

		while (true) {
			if (counter == 0) {
				System.out.print("Please begin typing your scores. Insert a negative number to end the program.\n> "); // message
																														// displayed
																														// on
																														// the
																														// first
																														// loop

			} else {
				System.out.printf("Class average: %.2f (graded %d)\nEnter your next score (-1 to end):\n> ", classAvg,
						counter); // message displayed on later loops
			}

			inputNum = scanner.nextInt(); // takes number input from user

			if (inputNum >= 0) { // only executes this block of code if input is a positive number
				sumNum += (float) inputNum;
				counter += 1;
				classAvg = sumNum / ((float) counter);
			} else {
				break; // breaks out of the loop if negative number is provided
			}

		}

		if (classAvg >= 90) { // grading system
			grade = "A";
		} else if (classAvg >= 80) {
			grade = "B";
		} else if (classAvg >= 70) {
			grade = "C";
		} else if (classAvg >= 50) {
			grade = "D";
		} else {
			grade = "E";
		}

		System.out.printf("Your class average was %.2f (%s) with a total of %d grades entered.", classAvg, grade,
				counter); // final output

		scanner.close(); // closes the scanner object
	}
}