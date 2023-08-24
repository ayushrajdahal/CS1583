import java.util.Scanner;

public class Greeting {
	public static void main(String[] args) {
		Scanner scannerObject = new Scanner(System.in); // creates a scanner object

		System.out.println("What is your name?"); // input message for name
		String firstName = scannerObject.nextLine(); // takes a name input

		System.out.println("What salutation would you like me to use?"); // input message for salutation
		String salutation = scannerObject.nextLine(); // takes a salutation input

		System.out.println("Hello " + salutation + " " + firstName + ", it is nice to meet you! Goodbye!"); // prints out the greeting

		scannerObject.close();
	}
}