package Day6;

public class Operators {
    static int x, y, z;
    public static void main(String[] args) {

        //Remove comment to test

        //unarySample();
        //binarySample();
        //arithmeticSample();
        //shiftSample();
        //relationalSample();
        //logicalSample();
        //ternarySample();
    }

    public static void unarySample(){
        //run and see the difference
        x = 45;
        y = x++; //y=45, x=46
        z = ++x; //z=47, x 47
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    public static void binarySample(){
        x=2; y=5; z= 3;
        //have 2 argument, use () to make it less confusing
        System.out.println(x + (y * z));
    }

    public static void arithmeticSample(){
        //classic MDAS with %
        x = 100; y=15;
        System.out.println("The output will become string "+ x + y);
        //beware of concatenation and addition, always put () if operation is performed AFTER concatenation
        System.out.println(x - y);//
        System.out.println(x * y);//
        System.out.println(x / y);//
        System.out.println(x % y);//
    }

    public static void shiftSample() {
        x = 45; // I CBA, just search shift operator or something.
        System.out.println(x << 3); // 360
    }

    public static void relationalSample(){
        x = 50; y = 50;
        //this will have a boolean answer, its only true and false
        System.out.println(x<=y); //
    }

    public static void logicalSample(){
        x = 15;
        y = 20;
        z = 5;
        //                    T       F         T
        System.out.println( x<y && z++>x++ & y++>z); // false
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    public static void ternarySample(){
        x = 5;
        //this is a one liner if-else statement
        y = (x <= 3) ?x :++x;
        /*
        equivalent above
        if(x <= 3){
        sout(x)
        }else{
        sout(++x)
        }
        */
        System.out.println(y);
    }
}


/*
Operators - special symbols that is used to perform a particular operation
    unary - incrementation, decrementation, negate
          - ++, --, -

    arithmetic - mathematical operations
               - +,-,*,/,%

    shift - moves the bit of a value
          - <<, >>

    relational - checking of equality and comparison of two values
               - ==, !=,   <,>,<=,>=

        And/Or
    bitwise - &,|
            - check all the condition before coming up with an output
    logical - &&,||
        and - checks next condition only if current condition is true
         or - checks next condition only if current condition is false

       &,&&                   |,||
    T and T = T             T or T = T
    T and F = F             T or F = T
    F and T = F             F or T = T
    F and F = F             F or F = F

    ternary - one line code for an if else statement
            - ()?:
*/