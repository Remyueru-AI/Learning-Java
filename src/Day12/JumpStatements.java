package Day12;

public class JumpStatements {

    public static void main(String[] args) {
        jumpSample();
        System.out.println( returnSample("bOb"));

    }

    public static void jumpSample(){
        System.out.println("Loop that counts from one to ten\nNormal loop:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i+" ");
        }

        System.out.println("\nWith Continue:");
        for (int i = 1; i <= 10; i++) {
            if(i==5){
                continue;//the iteration will be skipped here
            }
            System.out.print(i+" ");
        }

        System.out.println("(5 is missing)\nWith Break");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i+" ");//BE AWARE of the position where the code block sits
            System.out.print((i== 5)?"(ended at 5)":"");
            if(i==5){
                break;//the iteration will be ended here
            }
        }

    }

    public static String returnSample(String name){
        String S = "Hello " +name+ ", this is a sample return statement";
        //it will return a sentence in uppercases
        return "\n\nWith Return:\n" +S.toUpperCase();
    }
}
/*
Control Flow Jump Statements
    - Jump to a specific point in the program, interrupting the normal sequential execution
    Continue - Skips iteration for looping statements
    Break - Terminates the looping statements, mostly seen on switch statements

    Return - Used in a non-void method to return a value
*/