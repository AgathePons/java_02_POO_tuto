package tuto.poo;

public class parameters {

	public static void main(String[] args) {

		// give arguments to the function
		displayPerimeter(4, 6);
		displayPerimeter(12, 15);

		inMyPocket("chewing-gum", 2);
		inMyPocket("broken necklace", 1);

		final int numberOfItemA = 10;
		final int numberOfItemB = 7;

		System.out.println("I have " + sumOfTwoIntegers(numberOfItemA, numberOfItemB) + " items.");

	}

	// define parameters for the method displayPerimeter
	public static void displayPerimeter(int length, int width) {
		int perimeter = 2 * (length + width);
		System.out.println(perimeter);
	}

	// define parameters of different types
	public static void inMyPocket(String element, int number) {
		if (number == 0 || number == 1) {
			System.out.println("In my pocker, I have " + number + " " + element);
		} else {
			System.out.println("In my pocker, I have " + number + " " + element + "s");
		}

	}

	// return
	public static int sumOfTwoIntegers(int numberA, int numberB) {
		int result = numberA + numberB;
		return result;
	}

}
