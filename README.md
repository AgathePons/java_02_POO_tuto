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

