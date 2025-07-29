package ProjectJava;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class ViewItem extends BoxCon implements iRetry {
    Item myItem;
    ArrayList<Item> items;

    @Override
    public void display() {
        System.out.println("""
                \nAdventurers Box > View Item
                \t.__________[0]Back.
                \t|  [1] Box        |
                \t|  [2] Bag        |
                \t'-----------------'""");
        System.out.print(">> ");
        qry = "select * from boxTb where amount !=0;";
        input();
    }

    @Override
    public void input() {

        try {
            Scanner in = new Scanner(System.in);
            int i = in.nextInt();

            switch (i) {
                case 0 -> {
                    AdventurersBox ab = new AdventurersBox();
                    ab.mainDisplay();
                }
                case 1 -> {
                    System.out.println("\nAdventurers Box > View Item > Box");
                    viewBox();
                    retry();
                }
                case 2 -> {
                    System.out.print("\nAdventurers Box > View Item > Bag");
                    viewBag();
                    backMain();
                }
                default -> {
                    System.out.println("\nError: Number not detected");
                    display();
                }
            }

        } catch (Exception e) {
            System.out.println("\nError: Please use the corresponding number");
            display();
        }
    }

    @Override
    public void retry() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > View Item > Box\nSearch item? [Y][N]\n>> ");
        again = in.nextLine();
        if (again.equalsIgnoreCase("y")) {
            searchBox();
        } else if (again.equalsIgnoreCase("n")) {
            display();
        } else {
            System.out.println("Error: Choose Y or N");
            retry();
        }
    }

    public void viewBox() {
        try {
            connectBox();

            statement = con.createStatement();
            resultSet = statement.executeQuery(qry);

            if (!resultSet.isBeforeFirst()) {
                System.out.println("""
                        +----------------+
                        |  NO ITEM FOUND |
                        +----------------+""");
                myItem = new Item();
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("+--------------------+\n|\t%-10s\t| %-2d |\n",
                            resultSet.getString("itemName"), resultSet.getInt("amount"));
                    if (resultSet.isFirst()) {
                        myItem = new Item(
                                resultSet.getInt("itemId"),
                                resultSet.getString("itemName"),
                                resultSet.getInt("amount"));
                    }
                }
                System.out.println("+--------------------+");
            }

        } catch (Exception e) {
            System.out.println("Error: Box not found" + e);
            display();
        }
    }

    public void searchBox() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > View Item > Box > Search\nItem name: ");
        String s = in.nextLine();
        qry = "select * from boxTb where amount !=0 and itemName like '%" + s + "%'";
        System.out.println("\nAdventurers Box > View Item > Box > Search");
        viewBox();
        retry();
    }

    public void viewBag() {
        try {
            ObjectMapper om = new ObjectMapper();
            items = om.readValue(bagJson, new TypeReference<ArrayList<Item>>(){});
            jsonUpdate(items);
            System.out.println(" [" + items.size() + "/5]\n/------------+------\\");
            for(Item i : items) {
                System.out.printf("|  %-10s|\t%-2d\t|\n",i.getName(), i.getAmount());
            }
            System.out.println("\\------------+------/");

        }
        catch (Exception e) {
            System.out.println("Something went wrong" + e);
            display();
        }
    }

    public void jsonUpdate(ArrayList<Item> items) {
        try {
            ObjectMapper om = new ObjectMapper();
            items.removeIf(i -> i.getAmount() == 0);
            om.writeValue(new File(jPath), items);
        } catch (Exception e) {
            System.out.println(e);
            ab.mainDisplay();
        }
    }

    public void backMain() {
        Scanner in = new Scanner(System.in);
        System.out.print("Back to main? [Y][N]\n>> ");
        again = in.nextLine();
        if (again.equalsIgnoreCase("y")) {
            AdventurersBox ab = new AdventurersBox();
            ab.mainDisplay();
        } else if (again.equalsIgnoreCase("n")) {
            display();
        } else {
            System.out.println("Error: Choose Y or N");
            backMain();
        }
    }

}
