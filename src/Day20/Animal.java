package Day20;

public abstract class Animal extends Organism {

    abstract void showLives();
    void eat(){
        System.out.println("This animal is eating");
    }

}
/*
              Organism
        _________|_________
       |                   |
     Plant            -> Animal
                     ______|_______
                    |              |
                   Dog            Cat
This class is both Parent(Dog and Cat) and a child(Organism)
*/