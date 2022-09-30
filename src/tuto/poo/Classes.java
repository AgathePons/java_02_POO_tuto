package tuto.poo;

public class Classes {

	public static void main(String[] args) {

		SpecialAbility evilLaugh = new SpecialAbility("Evil Laugh", "Produce an Evil laugh");
		System.out.println("Ability: " + evilLaugh.name);

		Monster boogieMan = new Monster("Boogie Man", 2, evilLaugh);
		System.out.println(boogieMan.name + " is scary because of his " + boogieMan.ability.name);
	}

	static class Monster {
		String name;
		int eyesNumber;
		boolean isScary = true;
		SpecialAbility ability;

		// constructor - isScary has a default value, so it is not mandatory in the constructor
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

}
