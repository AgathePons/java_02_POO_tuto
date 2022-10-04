package tuto.poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		myList.add("Bloubliblou");
		myList.add("Youpi Tralala");
		myList.add("test2");
		myList.add(0, "test3");
		myList.remove(1);

		System.out.println(myList.toString());
		System.out.println(myList.getClass().getName());
		System.out.println(myList.get(0).getClass().getName());
		System.out.println("test is in the set: " + myList.contains("test"));

		System.out.println("//------ SETS -----------------------------------//");
		// sets
		Set<String> ingredients = new HashSet<String>();
		ingredients.add("salt");
		ingredients.add("pepper");
		ingredients.add("tomato");
		ingredients.add("chicken");
		System.out.println(ingredients.toString());
		ingredients.remove("salt");
		System.out.println(ingredients.toString());

		for (String ingredient : ingredients) {
			System.out.println(ingredient);
		}

		System.out.println("pepper is in the set: " + ingredients.contains("pepper"));

		System.out.println("//------------------------------------------------//");

	}

}
