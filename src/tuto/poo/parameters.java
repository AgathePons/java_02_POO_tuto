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

		// type value
		String nameFirst = "Jean-Michèle";
		String nameSecond = nameFirst;

		nameFirst = "Micheline";

		displayName(nameFirst);
		displayName(nameSecond);

		// type reference
		Person personFirst = new Person("Kevin");
		Person personSecond = personFirst;

		personFirst.name = "Kyllian";

		displayName(personFirst.name);
		displayName(personSecond.name);

		class Animal {
			String name = "cat";
		}

		Animal myFirstAnimal = new Animal();
		System.out.println(myFirstAnimal.name);

		Animal mySecondAnimal = myFirstAnimal;
		System.out.println(mySecondAnimal.name);

		mySecondAnimal.name = "dog";
		System.out.println(myFirstAnimal.name);
		System.out.println(mySecondAnimal.name);

		// other example
		Car myCar = new Car();
		System.out.println(myCar.color); // -> red
		paint(myCar, "green");
		System.out.println(myCar.color); // -> green

		Car myOtherCar = new Car();
		System.out.println(myOtherCar.color); // -> red

		// last example
		int sizeA = 5;
		int sizeB = enlargeElementInt(sizeA);
		System.out.println("sizeA: " + sizeA + " - sizeB: " + sizeB);

		Integer sizeC = 3;
		Integer sizeD = enlargeElementInteger(sizeC);
		Integer sizeE = enlargeElementInteger(sizeC) + 10;
		System.out.println("sizeC: " + sizeC + " - sizeD: " + sizeD + " - sizeE: " + sizeE);

		class SizeInteger {
			Integer value = 3;
		}
		SizeInteger sizeF = new SizeInteger();
		SizeInteger sizeG = new SizeInteger();

		sizeF.value = 5;
		sizeG.value = 10;
		SizeInteger sizeH = new SizeInteger();

		System.out.println("sizeF: " + sizeF.value);
		System.out.println("sizeG: " + sizeG.value);
		System.out.println("sizeH: " + sizeH.value);

		SizeIntegerClass element = new SizeIntegerClass();
		int sizeI = element.value;
		int sizeJ = enlargeElementIntObj(element);
		System.out.println("sizeI: " + sizeI + " - sizeJ: " + sizeJ);

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

	// type value / type reference
	public static void displayName(String name) {
		System.out.println("name >> " + name);
	}

	static class Person {
		String name;

		// constructor
		Person(String name) {
			this.name = name;
		}
	}

	// other example
	static class Car {
		String color = "red";
	}

	public static void paint(Car car, String color) {
		car.color = color;
	}

	// last example
	public static int enlargeElementInt(int size) {
		size += 2;
		return size;
	}

	public static Integer enlargeElementInteger(Integer size) {
		size += new Integer(2);
		return size;
	}

	public static class SizeIntegerClass {
		int value = 3;
	}

	public static int enlargeElementIntObj(SizeIntegerClass obj) {
		obj.value += 2;
		return obj.value;
	}

}
