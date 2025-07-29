package Day7;

import java.util.Random;

public class Activity1 {
/*
1. Declaration of Variables:

    Declare and initialize the following variables with any values of your choice:
	num1 (int)
	num2 (int)
	num3 (double)
	isJavaFun (boolean)
	str1 (String)
	*/
    int num1 = 16;
    int num2 = 8;
    double num3 = 123.4;
    boolean isJavaFun = true;
    String str1 = "Today's activity";
    static Activity1 a = new Activity1();

    public static void printNumber1And2(){

        System.out.println("num1: " + a.num1);
        System.out.println("num2: " + a.num2);
        System.out.println("num3: " + a.num3);
        System.out.println("isJavaFun: " + a.isJavaFun);
        System.out.println("str1: " + a.str1);
        System.out.println("--------------------------------");
/*
2. Arithmetic Operations:

    Calculate and store the results of the following arithmetic operations in separate variables:
	Sum of num1 and num2: sum
	Difference between num1 and num2: difference
	Product of num1 and num2: product
	Quotient of num1 divided by num2 (as a double): quotient
	*/
        int sum,difference,product; double quotient;
        sum = a.num1 + a.num2;
        difference = a.num1 - a.num2;
        product = a.num1 * a.num2;
        quotient = a.num1 / a.num2;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient " + quotient);
    }

    public static void printNumber3(){
/*
3. Logical Operations:

    Use logical operators to perform the following:
	Determine if both num1 and num2 are even numbers and store the result in bothEven.
	Determine if either num1 or num2 is greater than 10 and store the result in eitherGreaterThan10.
	Determine if isJavaFun is true and store the result in javaIsFun.
	*/
        boolean bothEven = (a.num1 % 2 == 0 && a.num2 % 2 == 0);
        boolean eitherGreaterThan10 = (a.num1 > 10 || a.num2 > 10);
        boolean isJavaFun = a.isJavaFun == true;

        System.out.println("Both num1 and num2 are even: " + bothEven);
        System.out.println("Either num1 and num2 is greater than 10: " + eitherGreaterThan10);
        System.out.println("Java is fun: " + isJavaFun);
    }

    public static  void printNumber4(){
/*
4. String Concatenation:

    Concatenate str1 with the text " is amazing!" and store the result in a variable named strResult.
    */
    String strResult = a.str1 + " is amazing!";
    System.out.println("strResult: " + strResult);
    }

    public static void optionalChallenge(){
     //Coin Toss using random class
       Random toss = new Random();
       String tossResult = (toss.nextBoolean()) ? "Heads" : "Tails";
       System.out.println("--------------------------------");
       System.out.println("Coin toss(Optional Challenge)\nResult of coin toss is: "+ tossResult);
    }

    public static void main(String[] args) {
/*
5. Print Results:

    Display the results of all the calculations and comparisons along with appropriate messages using
    System.out.println().
    */
        printNumber1And2();
        printNumber3();
        printNumber4();
        optionalChallenge();
    }
}
