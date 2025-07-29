package ProjectJava;

import java.util.Scanner;

public class MakeItem extends BoxCon implements iRetry{

    @Override
    public void display() {
        input();
        retry();
    }

    @Override
    public void input() {
        String name;
        int amount;
        Scanner s = new Scanner(System.in);
        Scanner i = new Scanner(System.in);
        try {
            System.out.println("\nAdventurers Box > Make Item");
            System.out.print("Enter Name: ");
            name = s.nextLine();
            //check if name exist

            System.out.print("Enter Amount: ");
            amount = i.nextInt();
            confirmMake(name, amount);
        } catch (Exception e) {
            System.out.println("Error: Something went wrong");
            retry();
        }
    }

    public void confirmMake(String name,int amount) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > Make Item > Confirm\nMake " + amount + "x of " + name + "? [Y][N]\n>> ");
        again = in.nextLine();
        if (again.equalsIgnoreCase("y")) {
            insert2Box(name, amount);

        } else if (again.equalsIgnoreCase("n")) {
           retry();
        } else {
            System.out.println("Error: Choose Y or N");
            confirmMake(name, amount);
        }
    }

    public void insert2Box(String name,int amount) {
        System.out.println("Processing....");
        qry = "select * from boxTb where itemName like '" + name + "'";

        try {
            connectBox();
            statement = con.createStatement();
            resultSet = statement.executeQuery(qry);

            if (!resultSet.isBeforeFirst()) {
                qry = "insert into boxTb values (?,?,?)";
                connectBox();
                preStatement = con.prepareStatement(qry);
                preStatement.setInt(1, 0);//id temp
                preStatement.setString(2, name);
                preStatement.setInt(3, amount);
            }
            else {
                qry = "UPDATE boxTb SET amount = amount + " + amount + " WHERE itemName = '" + name +"'";
                connectBox();
                preStatement = con.prepareStatement(qry);
            }
            preStatement.executeUpdate();
            System.out.println("The item is in the box\n");
            retry();
        }
        catch (Exception e) {
            System.out.println("Something went wrong" + e);
        }
    }

    @Override
    public void retry() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > Make Item\nAnother Item? [Y][N]\n>> ");
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
