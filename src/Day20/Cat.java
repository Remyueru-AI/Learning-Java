package Day20;

import javax.xml.transform.Source;

public class Cat extends Animal{
    int lives = 9;

    void speak(){
        System.out.println("The cat goes *meow*");
    }

    @Override
    void showLives() {
        System.out.println("Cat life: " + lives);
    }
}
/*
              Organism
        _________|_________
       |                   |
     Plant              Animal
                     ______|_______
                    |              |
                   Dog         -> Cat
This is a subclass/child of Animal and Grandparent to Organism but not related to plant and dog
*/