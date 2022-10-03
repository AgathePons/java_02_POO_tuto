package tuto.poo;

public class arrays {

	public static void main(String[] args) {
		// arrays
		String[] myArray = new String[5];
		myArray[0] = "first element (index 0)";
		myArray[3] = "fourth element (index 3)";
		for (String element : myArray) {
			System.out.println(element);
		}
	}

}
