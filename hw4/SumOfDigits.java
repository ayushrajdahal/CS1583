import java.util.Scanner; // imports the scanner

public class SumOfDigits {

    private static int digitSum(int inputNum) {
        int sum = 0; // stores the sum of all the digits

        while (inputNum > 0) {
            int lastDigit = inputNum % 10; // gets the last digit of the number
            sum += lastDigit; // adds to the sum of all the digits for that number
            inputNum = (inputNum - lastDigit) / 10; // removes the last digit of inputNum
        }

        if (sum >= 10) {
            // recursively calls the digitSum function itself until there is a single digit
            // sum
            sum = digitSum(sum);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // creates a scanner object

        int inputNum = scanner.nextInt(); // input numbrt

        System.out.println(digitSum(inputNum)); // calls the digitSum function on inputNum and prints it out

        scanner.close(); // closes scanner object
    }
}
