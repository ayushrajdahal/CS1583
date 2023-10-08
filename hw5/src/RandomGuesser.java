import java.util.*;

public class RandomGuesser {

	// Calculate log base 2 of inputNum
	private static double log2(int inputNum) {
		return Math.log(inputNum) / Math.log(2);
	}

	// Generate a random number between min_boundary and max_boundary
	private static int randomPicker(int min_boundary, int max_boundary) {
		Random rand = new Random();
		return rand.nextInt(max_boundary - min_boundary - 1) + min_boundary + 1;
	}

	// Determine the grade of the guesser based on the number of tries and whether
	// or not they guessed correctly
	private static void guessGrading(int max_boundary, int min_boundary, int number_tries, boolean guessed) {
		double log2value = log2(max_boundary - min_boundary);
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

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Max Boundary:");
		int max_boundary = scanner.nextInt();
		System.out.print("Min Boundary:");
		int min_boundary = scanner.nextInt();
		System.out.print("Max No. of Guesses:");
		int max_guesses = scanner.nextInt();

		List<Integer> prev_guesses = new ArrayList<>();

		// Check if the boundaries are valid
		int temp;
		temp = max_boundary;
		max_boundary = Math.max(min_boundary, max_boundary);
		min_boundary = Math.min(min_boundary, temp);

		// Check if the range is valid
		if (max_boundary - min_boundary <= 1) {
			System.out.println("ERROR: The two integers should have at least one integer in between");
			System.out.println(max_boundary + " - " + min_boundary + " = " + (max_boundary - min_boundary));
			System.exit(0);
		}

		// Check if the number of guesses is valid
		if (max_guesses < 1) {
			System.out.println("ERROR: Max no. of guesses shouldn't be less than 1");
			System.exit(0);
		}

		// Generate a random number within the range
		int generated_number = randomPicker(min_boundary, max_boundary);

		// Loop through the guesses
		for (int i = 0; i < max_guesses; i++) {
			System.out.print("Guess a number:");
			int anumber = scanner.nextInt();

			// Check for duplicate guesses
			if (prev_guesses.contains(anumber)) {
				System.out.println("DUPLICATE GUESS");
				i--;
			} else if (anumber == generated_number) {
				// The user guessed the number correctly
				System.out.println("CORRECT");
				guessGrading(max_boundary, min_boundary, i + 1, true);
			} else if (anumber < generated_number) {
				// The user guessed too low
				System.out.println("HIGHER");
				prev_guesses.add(anumber);
			} else {
				// The user guessed too high
				System.out.println("LOWER");
				prev_guesses.add(anumber);
			}
		}

		// The user failed to guess the number
		System.out.println("Sorry, the right answer was " + generated_number + ".");
		guessGrading(max_boundary, min_boundary, max_guesses, false);

		scanner.close();
	}
}
