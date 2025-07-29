package Day11;
import java.util.Scanner;
public class Activity3 {
    public static void main(String[] args) {
        input();
    }

    public static void commonDiff(int startNumber,int iteration,int commonDiff){
        //holds the string of sum and product
        String sumText = "Sum    : " + startNumber, prodText="Product: " + startNumber;
        //holds the result of the computation
        long sumResult = startNumber, prodResult = startNumber;

        //System.out.println("Initial Number: " +startNumber+ "\nNumber of iteration: " +iteration+ "\nCommon Difference: " +commonDiff+ "\n\n");
        for(int i = 1; i < iteration; i++) {
            //para sa common difference
            startNumber = startNumber + commonDiff;

            //text for both addition and multiplication
            sumText = sumText + " + " + startNumber;
            prodText = prodText + " * " + startNumber;

            //computation
            sumResult = sumResult + startNumber;
            prodResult = prodResult * startNumber;
        }
        System.out.println(sumText + " = " + sumResult + "\n" + prodText + " = " + prodResult);
    }

    public static void input(){
        Scanner in = new Scanner(System.in);
        int s,i,c;
        try{
            System.out.print("Enter Initial Number: ");
            s = in.nextInt();
            System.out.print("Enter Number of Iteration: ");
            i = in.nextInt();
            System.out.print("Enter Common Difference: ");
            c = in.nextInt();
            System.out.println("\n");
            commonDiff(s,i,c);
        }
        catch (Exception e) {
            System.out.println("Please type a number.....");
            input();
        }
        finally {
            in.close();
        }

    }
}
