public class TrafficLights {
	public static void main(String[] args) {
		String[] Lights = { "Red", "Green", "Yellow" }; // lights to iterate through
		for (int i = 0; i < 3; i++) { // no. of times to loop through the entire list
			for (String j : Lights) { // loop through list items
				System.out.println(j);
			}
		}
	}
}