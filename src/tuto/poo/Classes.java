package tuto.poo;

public class Classes {

	public static void main(String[] args) {
		// classes
		SpecialAbility evilLaugh = new SpecialAbility("Evil Laugh", "Produce an Evil laugh");
		System.out.println("Ability: " + evilLaugh.name);

		Monster boogieMan = new Monster("Boogie Man", 2, evilLaugh);
		System.out.println(boogieMan.name + " is scary because of his " + boogieMan.ability.name);

		// legacy
		SuperVilain theJoker = new SuperVilain(127, "The Joker", "Harley Quinn", 3, false);
		theJoker.sayHello();
		System.out.println("He killed " + theJoker.innocentPeopleKilledNumber + " innocent people...");
		SuperNice batman = new SuperNice(76, "Batman", "Robin", 4, false);
		batman.sayHello();
		System.out.println("He saved " + batman.innocentPeopleSaveedNumber + " innocent people...");
		System.out.println("Batman's sidekick is " + batman.sideKick + ".");
		batman.sideKick = "Catwoman";
		System.out.println("Batman's new sidekick is " + batman.sideKick + ".");
	}

	// classes
	static class Monster {
		String name;
		int eyesNumber;
		boolean isScary = true;
		SpecialAbility ability;

		// constructor - isScary has a default value, so it is not mandatory in the
		// constructor
		public Monster(String name, int eyesNumber, SpecialAbility ability) {
			this.name = name;
			this.eyesNumber = eyesNumber;
			this.ability = ability;
		}
	}

	static class SpecialAbility {
		String name;
		String effect;

		// constructor
		public SpecialAbility(String name, String effect) {
			this.name = name;
			this.effect = effect;
		}
	}

	// legacy
	static class SuperHero {
		private final String name;
		public String sideKick;
		public int alliesNumber;
		public boolean hasSuperPower;

		void sayHello() {
			System.out.println("Hello, my name is " + name + " and I am a superhero!");
		}

		SuperHero(String name, String sideKick, int alliesNumber, boolean hasSuperPower) {
			this.name = name;
			this.sideKick = sideKick;
			this.alliesNumber = alliesNumber;
			this.hasSuperPower = hasSuperPower;
		}
	}

	static class SuperVilain extends SuperHero {
		public int innocentPeopleKilledNumber;

		@Override
		void sayHello() {
			super.sayHello();
			System.out.println("I will kill innocent people!");
		}

		SuperVilain(int innocentPeopleKilledNumber, String name, String sideKick, int alliesNumber,
				boolean hasSuperPower) {
			super(name, sideKick, alliesNumber, hasSuperPower);
			this.innocentPeopleKilledNumber = innocentPeopleKilledNumber;
		}

	}

	static class SuperNice extends SuperHero {
		public int innocentPeopleSaveedNumber;

		@Override
		void sayHello() {
			super.sayHello();
			System.out.println("I will save the world from bad guys!");
		}

		SuperNice(int innocentPeopleSaveedNumber, String name, String sideKick, int alliesNumber,
				boolean hasSuperPower) {
			super(name, sideKick, alliesNumber, hasSuperPower);
			this.innocentPeopleSaveedNumber = innocentPeopleSaveedNumber;

		}
	}

	// other example
	public class FigureGeometrique {
		private int posX;
		private int posY;

		public void moveTo(int newPosX, int newPosY) {
			this.posX = newPosX;
			this.posY = newPosY;
		}

		FigureGeometrique(int posX, int posY) {
			this.posX = posX;
			this.posY = posY;
		}
	}

	public class Carre extends FigureGeometrique {
		private long cote;

		public long getCote() {
			return cote;
		}

		public long getPerimetre() {
			return 4 * cote;
		}

		Carre(long cote, int posX, int posY) {
			// call the constructor of the parent class
			super(posX, posY);
			this.cote = cote;
		}
	}

}

// ------------