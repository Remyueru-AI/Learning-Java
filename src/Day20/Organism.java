package Day20;

public abstract class Organism {
    boolean isAlive;

    Organism(){
        isAlive = true;
    }

}
/*
           -> Organism
        _________|_________
       |                   |
     Plant              Animal
                     ______|_______
                    |              |
                   Dog            Cat
This is the base class having both Animal and Plant as child
*/