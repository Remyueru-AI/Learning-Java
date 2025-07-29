package ProjectJava;
import java.util.Scanner;

public class QueryHacking extends BoxCon implements iRetry{

    @Override
    public void display() {
        System.out.print("\nAdventurers Box > 143H@(k3d\nUse Query to hack the box\n>> ");
        input();
    }

    public void input() {
        try {
            Scanner in = new Scanner(System.in);
            qry = in.nextLine();
            connectBox();
            preStatement = con.prepareStatement(qry);
            preStatement.executeUpdate();

            System.out.println("Something change, check the box");
        }
        catch (Exception e) {
            System.out.println("Error: Query Incorrect");
        }
        retry();
    }

    @Override
    public void retry() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > 143H@(k3d\nAnother query hacking? [Y][N]\n>> ");
        again = in.nextLine();
        if (again.equalsIgnoreCase("y")) {
            display();
        }
        else if (again.equalsIgnoreCase("n")) {
            //go to main screen
            AdventurersBox m = new AdventurersBox();
            m.mainDisplay();
        }
        else {
            System.out.println("Error: Choose Y or N");
            retry();
        }
    }

}
