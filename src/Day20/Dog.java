package Day20;

public class Dog extends Animal{
    int lives = 1;

    void speak(){
        System.out.println("The dog goes *woof*");
    }

    @Override
    void showLives() {
        System.out.println("Dog life: " + lives);
    }
}
/*
              Organism
        _________|_________
       |                   |
     Plant              Animal
                     ______|_______
                    |              |
                -> Dog            Cat
This is a subclass/child of Animal and Grandparent to Organism but not related to plant and cat
*/