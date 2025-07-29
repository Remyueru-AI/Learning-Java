package ProjectJava;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class GetItem extends ViewItem implements iRetry {
    int gotFromBox;

    @Override
    public void display() {
        System.out.println("\nAdventurers Box > Get Item");
        qry = "select * from boxTb where amount !=0;";
        viewBox();
        input();
    }

    @Override
    public void input() {

        try {
            Scanner in = new Scanner(System.in);
            System.out.print("\nAdventurers Box > Get Item\t\t[0] Back\nEnter item name: ");
            String s = in.nextLine();
            if (s.equals("0")) {
                ab.mainDisplay();
            } else {
                qry = "select * from boxTb where amount !=0 and itemName like '" + s + "'";
                viewBox();

                if (myItem.getName() != null) {
                    askAmount();
                }
                retry();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong..");
            input();
        }

    }

    public void askAmount() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("\nAdventurers Box > Get Item > " + myItem.getName() +
                    "\nEnter amount, you have " + myItem.getAmount() + " in storage\n>> ");
            gotFromBox = in.nextInt();
            if (gotFromBox > myItem.getAmount()) {
                System.out.println("The box contains less...");
                askAmount();
            }
            else if (gotFromBox == 0) {
                System.out.println("Please enter amount.");
                askAmount();
            }
            else confirmGet();

        }
        catch (Exception e) {
            System.out.println("Please enter a number");
            askAmount();
        }
    }

    public void confirmGet() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > Get Item > Confirm\nGet " + gotFromBox + " " + myItem.getName() + "? [Y][N]\n>> ");
        again = in.nextLine();
        if (again.equalsIgnoreCase("y")) {

            putItemToBag(gotFromBox, myItem.getId(), myItem.getName());
            getItemFromBox(gotFromBox, myItem.getAmount(), myItem.getId());

            System.out.print("\nAdventurers Box > Get Item > Bag");
            viewBag();
            System.out.println("You got x" + gotFromBox + " " + myItem.getName() + " from the box..");

        } else if (again.equalsIgnoreCase("n")) {
           retry();
        } else {
            System.out.println("Error: Choose Y or N");
            confirmGet();
        }
    }

    public void getItemFromBox(int get, int amount, int id) {
        amount = amount - get;
        try {
            qry = "UPDATE boxTb SET amount = " + amount + " WHERE itemId = " + id;
            connectBox();
            preStatement = con.prepareStatement(qry);
            preStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Something went wrong" + e);
            display();
        }
    }

    public void putItemToBag(int put, int id, String name) {

        try {
            ObjectMapper om = new ObjectMapper();
            items = om.readValue(bagJson, new TypeReference<>() {});
            Item pcs = new Item(id, name, put);
            boolean isNewItem = true;

            for (Item i : items) {
                if (i.getId() == pcs.getId()) {
                    put = put + i.getAmount();
                    pcs.setAmount(put);
                    items.remove(i);
                    items.add(pcs);
                    jsonUpdate(items);
                    isNewItem = false;
                    break;
                }
            }

            if (isNewItem) {
                if (items.size() < 5) {
                    items.add(pcs);
                    jsonUpdate(items);
                }
                else {
                    System.out.println("The bag is already full..");
                    retry();
                }
            }


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    @Override
    public void retry() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > Get Item\nBack to main? [Y][N]\n>> ");
        again = in.nextLine();
        if (again.equalsIgnoreCase("y")) {
            ab.mainDisplay();
        } else if (again.equalsIgnoreCase("n")) {
            display();
        } else {
            System.out.println("Error: Choose Y or N");
            retry();
        }
    }
}
