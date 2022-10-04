# POO with Java

## /!\ Tips before all

Because Java is very wordy and variables' types cannot be changed, with an IDE, it is very simple to get the
type of a variable.
But in any event, here are some ways to find variables types.

To find the **primitive type** of a variable:

```java
int myNumber = 2;
System.out.println(((Object) myNumber).getClass().getName());
// -> java.lang.Integer
boolean myBool = true;
System.out.println(((Object) myBool).getClass().getSimpleName());
// -> Boolean
```

The idea is to cast the primitive type into an `Object` type, so we can access the `.getClass()` and
`getName()` methods. 

To find the **complex type** of a variable:

```java
List<String> myList = new ArrayList<String>();
myList.add("test");
System.out.println(myList.getClass().getName());
// -> java.util.ArrayList
System.out.println(myList.get(0).getClass().getName());
// -> java.lang.String
```

The special case for **arrays**.  
Because arrays are special, the `.getClass().getName()` behavior is different.  
It will return `[` for 1D array, `[[` for a 2D array and so on. Followed by a letter which is a code
representing the type.

```java
boolean             Z
byte                B
char                C
class or interface  Lclassname;
double              D
float               F
int                 I
long                J
short               S
```

For example:

```java
int[] anArray = { 00, 10, 20, 30, 40, 50, };
System.out.println(anArray.getClass().getName());
// -> class [I
String weekDays[] = new String[] { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday" };
System.out.println("weekDays is type:" + weekDays.getClass().getName());
// -> [Ljava.lang.String;
```
 


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

An **array** is a **container object** that holds a **fixed number of values** of a **single type**.  
The length of an array is established when the array is created. After creation, its length is fixed.
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

**/!\ Attention**, to be able tu use the `Arrays` methods from the class Arrays, we must import the class
using `import java.util.Arrays;` (Eclipse handles it automatically when saving).

### Ordered list

Ordered lists are editable, their content and number of elements can be changed.

It is possible to:

- Access an element by its index
- Add an element at the end of the list
- Add an element to a specific index
- Delete an element at a specific index

**/!\ Attention**, It is possible to change / add / remove values, but not the type!

There are many classes which use lists, but the most used is `ArrayList`. To be able to use it, we have to use
the interface `List`.

**/!\ Attention**, like `Arrays`, `List` and `ArrayList` must be imported.

---------------------------
