package Day20;

public class Plant extends Organism{

    void photosynthesize(){
        System.out.println("The plant absorbs sunlight");
    }

}
/*
              Organism
        _________|_________
       |                   |
  -> Plant              Animal
                     ______|_______
                    |              |
                   Dog            Cat
Child of Organism but unrelated to Animal class
*/