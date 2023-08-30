import java.util.ArrayList;
import java.util.Scanner;

public class PrintStuff {
	public static void main(String[] args) {
		Scanner scannerObj = new Scanner(System.in);

		System.out.println("How many strings to print?");
		int strCount = scannerObj.nextInt();

		System.out.println("How many times to print?");
		int loopCount = scannerObj.nextInt();

		scannerObj.nextLine(); // to erase the /n that .nextInt() leaves out

		ArrayList<String> stringList = new ArrayList<String>(); // array that'll store strings given by the user

		for (int i = 0; i < strCount; i++) {
			System.out.printf("Enter the String no. %d of %d: ", i + 1, strCount);
			stringList.add(scannerObj.nextLine());
		}
		// String[] Lights = { "Red", "Yellow", "Green" };
		for (int i = 0; i < loopCount; i++) {
			for (String j : stringList) {
				System.out.println(j);
			}
		}
		scannerObj.close();
	}
}