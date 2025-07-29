/*
Today I learned that user defined packaged is another class
and need to declare as object depending on the conditions below

static - easy access
     Call           Use          Object
      S              S             F
      S             NS             F
      NS             S             T
      NS            NS             F if within the same class, T in other classes
 */

package Day4;
//I could run different package if its imported

//could use import SampleClass.* if you need to import all classes in the package
//this one is user defined

//this one is built in package from jdk

public class AccessMod {
    public static void main(String[] args) {

        //Day4Sample userDefine = new Day4Sample();
        //this function is in different packaged/folder
        //userDefine.tryHello();
        //System.out.println(userDefine.doublenum(8));
    }

}

/*
Access modifier - specify who can access a  particular class/members or properties
    4 types of modifiers
        * public - anywhere within the project
        * private - within the class only
        * protected - within the same package and other packages
                    using inheritance
        * default - no keyword needed
                    within the same package only

package - compilation of related classes
    2 types of packages
        * built in packages - provided by java
                            - ready to use classes
        * user defined packages - created by you

class - contains everything

main method - starting point of execution

methods/functions - contains set of instruction

static - easy access
     Call           Use          Object
      S              S             F
      S             NS             F
      NS             S             T
      NS            NS             F if within the same class, T in other classes

void - no return type

method name - verb/ action word

code block - set of instructions
*/
