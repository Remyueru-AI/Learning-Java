package Day20;

public class oopInheritance {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Plant plant = new Plant();
        System.out.println(dog.isAlive); // isAlive is Organism property
        System.out.println(plant.isAlive);
        dog.showLives();
    }
}
/*
              Organism
        _________|_________
       |                   |
     Plant              Animal
                     ______|_______
                    |              |
                   Dog            Cat

Inheritance - a concept where a class can acquire properties and functions of another class
    5 types of inheritance
        * Single - one parent inherited by a child
        (Animal > Cat)

        * Multi-Level - chain of inheritance
        (Organism > Animal > Cat)

        * Hierarchical - a parent can be inherited by multiple child
        (Dog < Animal > Cat) and (Plant < Organism > Animal)

        * Multiple - a child can inherit from multiple parents

        * Hybrid - combination of two or more types of inheritance

    P              c              keyword          inheritance
  class          class            extends             True
interface      interface          extends             True
interface        class           implements           True
  class        interface             -                False

constructor - special type of method derived from its class

Keyword
extends - can be used to same type of file class to class and interface to interface
implements - a way for interface to be a parent to a class

super - refers to the parent class, calls parent constructor to initialize attributes
*/