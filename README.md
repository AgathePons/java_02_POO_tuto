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
 
----------------------------------------------

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

----------------------------------------------

## Array

An **array** is a **container object** that holds a **fixed number of values** of a **single type**.  
The length of an array is established when the array is created. After creation, its length is fixed.  
Arrays in Java are not used a lot, we prefere `ArrayList`.
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
using `import java.util.Arrays;` (Eclipse can handle it automatically when saving).

## Ordered collection - List

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

To declare an `ArrayList`:

- Declare a variable whose the type is the interface `List`. That means we can assign any object to this
variable, including the class `ArrayList`.
- Initialize the cariable with the key word `new` to create a new instance of the `ArrayList` class.

```java
List<String> myStringsList = new ArrayList<String>();
List<Integer> myIntegersList = newArrayList<Integer>();
```

The first element between chevrons is the **type parameter** for the list, which limits the object type that 
can be stocked in the list.  
If no type paramter is specified, we can stock any object, but when we want to get an element of the list, we
will have to make a type conversion (a **cast**) to use it. It is higly recommended to specify the
**type parameter**.

Because a list can stock only objects, even if we want to stock a primitive type like integer, we must use the
**object version** of the primitive types (`Integer`, `Float`, `Boolean`...).  
(these object versions are very useful because they have many methods, see the doc, for example the doc for
[Integer](https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html))

Then, we can add values using the `.add()` method.

```java
myIntegersList.add(5);
```

This assignment create a instance of the `Integer` class and push it in the list.

> The **boxing** in Java is an auto-conversion between a primitive type and its corresponding class when an
object is required, like it is with the `ArrayList`.  
Read more on **[autoboxing](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html)**.

The most used methods of `ArrayList` are:

- `.add()`: Add a new element at the end of the list, or insert a new element at the given index
(`.add(2, "my element")`) moving the current element and the following at the index + 1 position.
- `.set()`: Replace an element at the given index (`.set(2, "my other element"`).
- `.remove()`: Remove an element at the given index, moving all the following at the index - 1 position.
- `.size()`: Returns the size of the list (like `.length` for arrays).
- `.get()`: Returns the element at the given index.

To print out a list (or a set), we can use the `toString()` method on it.

## Non ordered collection - Set

A set is a non ordered collection of unique elements.

Like lists, Java provides many classes for sets. The most used is `HashSet`.

```java
Set<String> ingredients = new HashSet<String>();
```

We declare the variable with the **interface** `Set`, then we initialize a new instance with the **class**
`HashSet`.

Because a set is not ordered, there is no simple way to access a specific element.  
See the [Java doc for Set](https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html) for more
infos.

We can use the methods `.add()`, `.remove()`, `.size()` of `HashSet`. Unlike `ArrayList`, we cannot give an
index to the `remove()`method, we have to specify the unique value we want to remove:

```java
ingredients.add("salt");
ingredients.add("pepper");
ingredients.remove("salt");
```

## Map

A **map** is an Java object that maps **keys** to **value**. Keys are unique, and each key can map one value.

Like lists and sets, Java provides many classes for maps. The most used is `HashMap`.

To declare a map, we must specify the **key type** followed by the **value type** when we declare the variable
and when we create the new class instance:

```java
Map<String, Integer> myInventoryMap = new HashMap<String, Integer>();
```

We can use `put(key, value)` to insert or modify an entry in a map, `remove(key)` to remove an entry by its
key, and `get(key)` to get the value of an entry by its key.

For example:

```java
myInventoryMap.put("health potion", 6); // add entry
myInventoryMap.put("mana potion", 4); // add entry
myInventoryMap.put("boar leather", 32); // add entry
myInventoryMap.remove("mana potion", 4); // remove entry
myInventoryMap.put("boar leather", 75); // modify entry
System.out.println("in my inventory, I have " + myInventoryMap.get("mana potion") + " mana potions");
```

To avoid mistakes or mispelling a key, a trick is to constant variables as keys:

```java
Map<String, String> batmanMap = new HashMap<String, String>();

final String K_NAME = "name";
final String K_HERO_NAME = "hero name";
final String K_SIDEKICK = "side-kick";

batmanMap.put(K_NAME, "Bruce Wayne");
batmanMap.put(K_HERO_NAME, "Batman");
batmanMap.put(K_SIDEKICK, "Robin");
```

To loop on a map, we do not have index, but we can loop on entries:

```java
for (Map.Entry<String, Integer> item : myInventoryMap.entrySet()) {
    System.out.println(item.getKey() + ": " + item.getValue());
}
```

See the complete doc for [Java map](https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html).

----------------------------------------------

## Parameters of a function

When a function / method is declared, it is possible to define **parameters**. The type of each paramter must
be specified:

```java
public static void inMyPocket(String element, int number) {
    System.out.println("In my pocker, I have " + number + " " + element);
}
```

Then, when we call the method, we give it **arguments**:

```java
inMyPocket("chewing-gum", 2);
inMyPocket("broken necklace", 1);
```

## Function return

If we want our function returns something, we have to define the type of return, instead of `void`.

```java
public static int sumOfTwoIntegers(int numberA, int numberB) {
    int result = numberA + numberB;
    return result;
}
```

In the example above, we defined the return as an integer.

## Value type or reference type

The different variable types (`integer`, `String`, `class`...) are categorized by **value** type or
**reference** type.

### Value type

For a value type, if we declare a variable `myValue` with an other variable `myFirstValue` as value, the value
of `myFirstValue` is duplicated and stored as value of `myValue`. Then if we modify the value of
`myFirstValue`, because the 2 values are independent, `myValue` is not modified.

```java
int myFirstValue = 2; // -> 2
int myValue = myFirstValue; // -> 2

myFirstValue = 5; // -> 5

System.out.println(myValue); // -> 2
```

### Reference type : pointers

When we create a variable and assign it a class instance as value, the object is created, but the variable
itself contains a **reference to this object** (the memory space where it is stocked). Then, if we created a
new variable which takes our first variable as value, our 2 variables contain a
**reference to the same object**.

```java
class Animal {
    String name = "cat";
}

Animal myFirstAnimal = new Animal(); // -> cat (point to this instance of Animal)
Animal mySecondAnimal = myFirstAnimal; // -> cat (point to the same instance of Animal)
```

So now, if we modifiy the value of the name of one variable, it will affect the other variable:

```java
mySecondAnimal.name = "dog"; // -> the instance is modified
System.out.println(myFirstAnimal.name); // -> dog, because it points on the same instance than mySecondAnimal
```

If we want our 2 variables each point to their own value, we have to create a new instance of our Animal class
for our second variable:

```java
Animal myFirstAnimal = new Animal(); // -> cat (point to this instance of Animal)
Animal mySecondAnimal = new Animal(); // -> cat (point to this instance of Animal)
```

Reference type (or pointer type) can save memory, but it can have dangerous side effects if it is not handled
properly.

### WARNING: side effects!!!

**We must be carreful if we pass reference type as function parameters** because all the modifications made will
have side effects on the original instance of object.

When calling a method, the given arguments are always value type. For primitive types, it is the value of the
argument which is reproduced in the methode paramter.  
So the modifications on the method paramter have no side effect on the argument.

```java
int sizeElementA = 5;
int sizeElementB = enlargeElement(sizeOfElement);
// this method add 2 to the integer given in argument
```

Because we work with `int`, this is value type, so there is no side effect on sizeElementA.

**WARNING**: Rework this last section because the tests hav not worked as expected...

Now, if we do the same with `Integer` instead of `int`:

```java
Integer sizeElementA = 5;
Integer sizeElementB = enlargeElement(sizeOfElement);
// this method add 2 to the integer given in argument
```

Because we work with `Integer`, this is a reference type, 


----------------------------------------------
