package Day12;

import java.util.Arrays;

public class TheAword {

    public static void main(String[] args) {
        TheAword a = new TheAword();
       // a.execute();
        a.array2D();
    }

    public void execute(){
        //int[] num = new int[3];
        int[] num = {22,30,45,60,86};
        num[1] = 30;
        //System.out.println(num[3]);
        System.out.println("Using Looping: ");
        System.out.print("[ ");
        int i=0;
        while(i<num.length){
            System.out.print(num[i]);
            System.out.print((i!=num.length-1)?", ":"");
            i++;
        }
        System.out.print(" ]\n");
        System.out.println("\nUsing For Each:");
        for(int n:num){
            System.out.print(n);
            System.out.print((n !=num.length-1)?", ":"");
        }
        System.out.println("\nUsing package:");
        System.out.println(Arrays.toString(num));
    }
    public void array2D(){
        //int[][] num = new int[3][3];
        int[][] num = {{1,2,3},{4,5,6},{7,8,9}};
        //System.out.println(num[1][0]);
        for(int[] row: num){

            for(int val: row){
                val = 1;
                System.out.print(val);
            }

            System.out.println("");
        }
        System.out.println("\n");
        for(int row=0;row<num.length;row++){

            for(int col=0;col<num[row].length;col++){
                System.out.print(num[row][col] + " ");
            }

            System.out.println("");
        }
    }
}
/*I HATE THIS CUZ OF CONFUSING METHOD AND STUFF
   Array - variable than can store multiple values of the same data type
   ¹²³⁴⁵⁶⁷⁸⁹⁰
*/