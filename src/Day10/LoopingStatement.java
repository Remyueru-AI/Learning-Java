package Day10;

public class LoopingStatement {
    public static void main(String[] args) {
        triangle();
        pyramid();
    }
    public static void triangle(){
        System.out.println("For loop inside a for loop:");
        //one outer and inner loop
        for(int i=5;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(" x ");
            }
            System.out.println("  ");
        }
    }
    public static void pyramid(){
        int pyramid=0,rows =5;
        System.out.println("Two inner loop and 1 outer loop:");
        for (int firstLoop = 1; firstLoop <= rows; ++firstLoop) {
            //Two inside loop in 1 outer loop
            for (int space = 1; space <= rows - firstLoop; ++space) {
                System.out.print("   ");
                //giving space
            }
           for(pyramid = 0; pyramid!=(2*firstLoop)-1; ++pyramid){
               System.out.print(" " +pyramid+ " ");
               //pyramid not equal to the first loop multiplied by 2 and minus 1
           }
            System.out.println();
        }
    }
    }
/*
      Control Flow Looping Statements
      - Re execute a code block as long as the condition is met

          Components of a loop
          -Initialization: Indicates where to start the loop
          -Condition: Tells weather it should stop or continue
          -Code block: it will run FIRST before the process
          -Process: incrementing or decrementing the count

          Types of loop
          for(starting;condition;process){
             code block;
          }

          while(condition){
            code block;

            process(could be anywhere)
          }

          Do while - Will run at least once.
          do{
          code block;
          }
          while(condition);
*/
