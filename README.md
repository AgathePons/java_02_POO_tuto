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

It is possible to **override** or **overwrite** a class method inherited from a parent class.
The method name is the same, and it is inherited from the same parent class, but according to the child class 
that extends the parent class, the method can have different behaviors.

```java
static class SuperHero {
    private final String name;
    void sayHello() {
        System.out.println("Hello, my name is " + name + " and I am a superhero!");
    }
    // constructor
    SuperHero(String name) {
        this.name = name;
    }
}
```

Here, the method `sayHello()` prints "Hello, my name is [name of the hero] and I am a superhero!".

```java
static class SuperVilain extends SuperHero {
    @Override
    void sayHello() {
        super.sayHello();
        System.out.println("I will kill innocent people!");
    }
    // constructor    
    SuperVilain(String name) {
        super(name, sideKick, alliesNumber, hasSuperPower);
    }
}

static class SuperNice extends SuperHero {
    @Override
    void sayHello() {
        super.sayHello();
        System.out.println("I will save innocent people!");
    }
    // constructor    
    SuperNice(String name) {
        super(name, sideKick, alliesNumber, hasSuperPower);
    }
}
```

Both `SuperVilain` and `SuperNice` have access to the `sayHello()` method, but it has different behaviors 
according to the child class calling it.

The notation `@override` is here to inform that this method is inherited, and overriden.

It is possible to access the parent original method with the keyword `super`. In the example above, we use 
`super.sayHello();` to access the original method, and a new instruction is added to overload the method.

**/!\** In multiple legacies case, it is only possible to access the direct parent class implementation. If we 
 create a sub-class `SuperNiceWithSuperPower` that extends `SuperNice`, `super` allows to access the
 `SuperNice` implementation but not the `SuperHero` implementation.
 
## Annotation type

 Annotation is a special type beginning by `@` that is used to specify the behavior of of a class, method, 
 attribute, variable... Annotations give informations to the compiler for the execution of the program's code.
 
 In Java, the most used annotation is `@Override` in complement of the **polymorphism** to point that the 
method is a redefinition of a method from the parent class. If the annotation is on a method, the compiler
will check if the method signature is identical to the method signature of the parent class.

## Array

To declare an array:

```java
int[] arrayOfNumbers = new int[5];
String[] arrayOfStrings;
arrayOfStrings = new String[3];
```

The arrays are declared, but they have no values, by default, the strings array contains `null` elements, and 
the integers array contains `0` elements.

To access an element of the array, we use the index value:

```java
arrayOfStrings[0] = "first element (index 0)";
System.out.println(arrayOfStrings[0]);
```

It is possible to create an array with values, and an array can be declared with the bracket pair on the name
of the variable:

```java
String weekDays[] = new String[]{"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
System.out.println(Arrays.toString(weekDays));
```

And with a shorter syntax:

```java
int[] anArray = { 00, 10, 20, 30, 40, 50, };
```

In Java, **arrays length is fixed**, and only the existing values can be changed.  
**It is not possible to insert or remove elements**.

### Multidimensional array

It is possible to declare bi-dimensional array:

```java
String[][] myBidimensionalArray = new String[4][2];
// or
String[][] levelsArray = {
    { "Level 1", "Level 2", "Level 3", "level 4", "level 5" },
    { "Easy", "Medium", "Hard" },
};
for (String[] array : levelsArray) {
    System.out.println(Arrays.toString(array));
}
```

It is like an array of array in JS.

**Tips:** There are many ways to print 2D arrays (make a loop in a loop, use `Arrays.toString()` in a loop...) 
but it is possible to use the `Arrays.deepToString()` method (sorted in one line).

---------------------------
