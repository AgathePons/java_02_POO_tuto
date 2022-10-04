package tuto.poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arrays {

	public static void main(String[] args) {
		System.out.println("//------ ARRAYS -----------------------------------//");
		// arrays
		String[] myStringsArray = new String[5];
		myStringsArray[0] = "first element (index 0)";
		myStringsArray[3] = "fourth element (index 3)";
		for (String element : myStringsArray) {
			System.out.println(element);
		}

		int[] myNumbersArray = new int[3];
		for (int element : myNumbersArray) {
			System.out.println(element);
		}

		String weekDays[] = new String[] { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday",
				"sunday" };
		System.out.println(Arrays.toString(weekDays));
		System.out.println("weekDays is type:" + weekDays.getClass().getName());

		int[] anArray = { 00, 10, 20, 30, 40, 50, };
		System.out.println(Arrays.toString(anArray));
		System.out.println("anArray is type:" + anArray.getClass());

		// bi-dimensional arrays
		String[][] levelsArray = { { "Level 1", "Level 2", "Level 3", "level 4", "level 5" },
				{ "Easy", "Medium", "Hard" }, };
		for (String[] array : levelsArray) {
			System.out.println(Arrays.toString(array));
		}
		System.out.println(Arrays.deepToString(levelsArray));

		System.out.println("//------ LISTS -----------------------------------//");
		// lists
		List<String> myList = new ArrayList<String>();
		myList.add("test");
		System.out.println(myList.getClass().getName());
		System.out.println(myList.get(0).getClass().getName());

		boolean number = true;
		System.out.println(((Object) number).getClass().getSimpleName());

		System.out.println("//------------------------------------------------//");

	}

}
