import java.lang.Math;
import java.util.*;

public class RandomGuesser {

	// return the log base 2 of ain integer as a double
	private static double log2Func(int inputNum) {

		return Math.log(inputNum) / Math.log(2);

	}

	// randomly picks a number between two integers (non-inclusive)
	private static int randomPicker(int a, int b) {

		Random rand = new Random();
		a++;
		return rand.nextInt(b - a) + a;

	}

	// gives EXCELLENT, GOOD, FAILED, and LUCKY acc to the requirement.
	private static void guessGrading(int max_boundary, int min_boundary, int number_tries, boolean guessed) {
		double log2value = log2Func(max_boundary - min_boundary);

		String message;

		if (!guessed) {
			message = "FAILED";
		} else if ((max_boundary - min_boundary > 1) && (number_tries == 1)) {
			message = "LUCKY";
		} else if (number_tries <= log2value) {
			message = "EXCELLENT";
		} else {
			message = "GOOD";
		}

		System.out.println("Your grade is " + message);
		System.exit(0);

	}

	// main method
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Max Boundary:");
		int max_boundary = scanner.nextInt();
		System.out.println("Min Boundary:");
		int min_boundary = scanner.nextInt();
		System.out.println("Max No. of Guesses:");
		int max_guesses = scanner.nextInt();

		int temp;
		List<Integer> prev_guesses = new ArrayList<>();

		// to make sure max is max and min is min

		if (max_boundary < min_boundary) {
			temp = max_boundary;
			max_boundary = min_boundary;
			min_boundary = temp;
		}

		// throw an error if there are <=1 integers in between

		if (max_boundary - min_boundary <= 1) {
			System.out.println("ERROR: The two integers should have at least one integer in between");
			System.exit(0);
		}

		// throw an error if inputted max no. of guesses < 1
		if (max_guesses < 1) {
			System.out.println("ERROR: Max no. of guesses shouldn't be less than 1");
			System.exit(0);
		}

		int generated_number = randomPicker(min_boundary, max_boundary);

		for (int i = 0; i < max_guesses; i++) {
			System.out.println("Guess a number:");
			int anumber = scanner.nextInt();

			if (prev_guesses.contains(anumber)) {
				System.out.println("DUPLICATE GUESS");
				i--;
			} else if (anumber == generated_number) {
				System.out.println("CORRECT");
				guessGrading(max_boundary, min_boundary, i + 1, true);
			} else if (anumber < generated_number) {
				System.out.println("HIGHER");
				prev_guesses.add(anumber);
			} else {
				System.out.println("LOWER");
				prev_guesses.add(anumber);
			}
		}
		guessGrading(max_boundary, min_boundary, max_guesses, false);
		scanner.close();
	}
}