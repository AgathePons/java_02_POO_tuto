package tuto.poo;

import java.util.Arrays;

public class arrays {

	public static void main(String[] args) {
		// arrays
		String[] myStringsArray = new String[5];
		myStringsArray[0] = "first element (index 0)";
		myStringsArray[3] = "fourth element (index 3)";
		for (String element : myStringsArray) {
			System.out.println(element);
		}

		int[] myNumbersArray = new int[4];
		for (int element : myNumbersArray) {
			System.out.println(element);
		}

		String weekDays[] = new String[] { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday",
				"sunday" };
		System.out.println(Arrays.toString(weekDays));

		int[] anArray = { 00, 10, 20, 30, 40, 50, };
		System.out.println(Arrays.toString(anArray));

		// bi-dimensional arrays
		String[][] levelsArray = { { "Level 1", "Level 2", "Level 3", "level 4", "level 5" },
				{ "Easy", "Medium", "Hard" }, };
		for (String[] array : levelsArray) {
			System.out.println(Arrays.toString(array));
		}
		System.out.println(Arrays.deepToString(levelsArray));

	}

}
