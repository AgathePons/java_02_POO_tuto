package tuto.poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class referenceValueTests {

	public static void main(String[] args) {
		// ----- first example ----- //
		class Animal {
			String name = "cat";
		}

		Animal myFirstAnimal = new Animal();
		// System.out.println(myFirstAnimal.name); -> cat

		Animal mySecondAnimal = myFirstAnimal;
		// System.out.println(mySecondAnimal.name); -> cat

		mySecondAnimal.name = "dog";
		System.out.println(myFirstAnimal.name); // -> dog
		System.out.println(mySecondAnimal.name); // -> dog

		// ----- second example ----- //
		List<Integer> suite = new ArrayList<>(Arrays.asList(1, 2, 3));
		System.out.println("suite:" + suite.toString()); // -> [1, 2, 3]
		List<Integer> otherSuite = addFour(suite);
		System.out.println("otherSuite:" + otherSuite.toString()); // -> [1, 2, 3, 4]
		System.out.println("suite:" + suite.toString()); // -> [1, 2, 3, 4]

		// ----- third example ----- //
		/**
		 * Integer variables are references to an object, but Integer (and String, and
		 * other primitive boxes) are immutable
		 * (https://www.geeksforgeeks.org/primitive-wrapper-classes-are-immutable-in-java/)
		 * So, in this example, there is no side effect on sizeA, which is still 3 after
		 * executiing the enlargeElementInteger twice.
		 */
		Integer sizeA = 3;
		Integer sizeB = enlargeElementInteger(sizeA);
		Integer sizeC = enlargeElementInteger(sizeA) + 10;
		System.out.println("sizeC: " + sizeA + " - sizeD: " + sizeB + " - sizeE: " + sizeC);

	}

	static List<Integer> addFour(List<Integer> original) {
		original.add(4);
		return original;
	}

	static Integer enlargeElementInteger(Integer size) {
		size += 2;
		return size;
	}

}
