package ProjectJava;
import java.util.Scanner;

public class AdventurersBox {

    public void mainDisplay() {
        System.out.println("""
               \n.__________________[0]Exit.
               |       Adventurers       |
               |___________Box___________|
               |\t [1] View Item        |
               |\t [2] Put Item         |
               |\t [3] Get Item         |
               |\t [4] Make Item        |
               |\t [5] Toss Item        |
               '-------------------------'""");

        boxInput();
    }

    public void boxInput() {

        System.out.print(">> ");
        try {
            Scanner in = new Scanner(System.in);
            int i = in.nextInt();

            switch (i) {
                case 1 -> {
                    ViewItem vi = new ViewItem();
                    vi.display();
                }
                case 2 -> {
                    PutItem pi = new PutItem();
                    pi.display();
                }
                case 3 -> {
                    GetItem gi = new GetItem();
                    gi.display();
                }
                case 4 -> {
                    MakeItem mi = new MakeItem();
                    mi.display();
                }
                case 5 -> {
                    TossItem ti = new TossItem();
                    ti.display();
                }
                case 0 -> {
                    System.out.println("You exit the Adventure box.");
                    System.exit(0);
                }
                case 143 -> {
                    QueryHacking qh = new QueryHacking();
                    qh.display();
                }
                default -> {
                    System.out.println("\nError: Number not detected");
                    mainDisplay();
                }
            }

        } catch (Exception e) {
            System.out.println("\nError: Please use the corresponding number");
            mainDisplay();
        }

    }

    public static void main(String[] args) {
        AdventurersBox a = new AdventurersBox();
        a.mainDisplay();

    }

}
/*


                 Adventurers Box Class Structure

                            BoxCon*
       +----------------------+-------------------+
       |                      |                   |
    MakeItem^              ViewItem^        QueryHacking^
                   +----------+----------+
                   |          |          |
                PutItem^   GetItem^   TossItem^


      Abstract: [*]

    Interfaces: [^]
        - iRetry(display,input,retry)


*/