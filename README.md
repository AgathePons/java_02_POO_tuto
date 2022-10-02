# POO with Java

## Java classes

Classes are **complex type** in Java.


Classes begins with an upper case letter. They can have **class attributes** and **fields**.

It is possible to use classes in classes.

To create a **class instance**, a **constructor** is needed. The constructor is a function, and it takes the
class name.

```java
static class Monster {
    String name;
    int eyesNumber;
    boolean isScary = true;
    SpecialAbility ability;
    
    // constructor - isScary has a default value, so it is not mandatory in the constructor
    public Monster(String name, int eyesNumber, boolean isScary, SpecialAbility ability) {
        this.name = name;
        this.eyesNumber = eyesNumber;
        this.isScary = isScary;
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
```

Then, it is possible to create class instances, which is an **object**:

```java
SpecialAbility evilLaugh = new SpecialAbility("Evil Laugh", "Produce an Evil laugh");
System.out.println("Ability: " + evilLaugh.name);

Monster boogieMan = new Monster("Boogie Man", 2, evilLaugh);
System.out.println(boogieMan.name + " is scary because of his " + boogieMan.ability.name);
```

## Legacy class

A class can inherit an other class with the key word `extends`.

```java
static class SuperHero {
    void hello() {
        System.out.println("Hello, I am a superhero!");
    }
}

static class SuperVilain extends SuperHero {}

static class SuperNice extends SuperHero {}
```

In this example, `SuperVilain` and `SuperNice` have acces to the `SuperHero` method `hello()`.

```java
SuperVilain theJoker = new SuperVilain();
theJoker.hello();
SuperNice batman = new SuperNice();
batman.hello();
```

A child class can inherit only one parent class, but the parent class can be the child class of another class.

An object from a **legacy class** is an object of the first class. In the example, `theJoker` and `batman` are 
both `SuperHero`.

To initialize the inherited attributes, we have to use the keyword `super`:

```java
public class FigureGeometrique {
    private int posX;
    private int posY;

    public void moveTo(int newPosX, int newPosY) {
        this.posX = newPosX;
        this.posY = newPosY;
    }
    // constructor
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
```

## Polymorphism


---------------------------
