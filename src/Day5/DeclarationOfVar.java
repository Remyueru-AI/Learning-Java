// today kinda easy, data types
package Day5;

import java.sql.SQLOutput;

public class DeclarationOfVar {
    //non-primitive always a null by default
    static String staticVarSample;

    //primitive have a default value(bool is false by default)
    static boolean falseByDefault;

    //instance is outside the method but inside the class
    String instanceVarSample;


    public static void main(String[] args) {
        //non-primitive starts in capital letter, these 3 below are local to main
        String s = "";

        //primitive are all small letter and highlight
        int i = 1;

        //variable could be anything iirc
        var f = "";

        //I call the DeclarationOfVar and name it c as a new object of itself, now I could use method and attributes on that class
        DeclarationOfVar c = new DeclarationOfVar();
        c.initialize();

        //A little bit for a string method
        System.out.println(c.instanceVarSample.toUpperCase());
        System.out.println(c.instanceVarSample.length());

    }



    public void initialize(){
        String localVarSample = "this is a local variable inside initialize method";
        System.out.println(localVarSample +"\n"+ staticVarSample + " <- these is a static example");
        staticVarSample = "but now, I put something to it";
        System.out.println(staticVarSample + "\n" + instanceVarSample + " <- this is the instance sample, both static and instance could be null");
        instanceVarSample = "now I edit it as well inside the method";
        System.out.println(instanceVarSample);
    }
}

/*
Variables - container for a value
          - data type variable = value;
    3 types of variables
        * local - can be found and use inside a method only
        * static - can be found inside a class but outside any methods
                 - can be used anywhere depends on the modifier
        * instance - can be found inside a class but outside any methods
                   - can be used anywhere depends on the modifier and object
                   - no static keyword

data type - specifies what type of data is to be stored in a variable
    2 types
        * primitive - most common data types
                    - boolean, byte, short, int, long, float, double, char
        * non-primitive - user defined data types
                        - can perform special functions
*/
