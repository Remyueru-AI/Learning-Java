package ProjectJava;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class PutItem extends ViewItem implements iRetry{
    int putToBox;
    Item myItem;

    @Override
    public void display() {
        System.out.print("\nAdventurers Box > Put Item");
        viewBag();
        input();
    }


    @Override
    public void input() {

        try {
            Scanner in = new Scanner(System.in);
            System.out.print("\nAdventurers Box > Put Item\t\t[0] Back\nEnter item name: ");
            String s = in.nextLine();
            if (s.equals("0")) {
                ab.mainDisplay();
            } else {
                qry = "select * from boxTb where itemName like '" + s + "'";
                //search item from json
                ObjectMapper om = new ObjectMapper();
                items = om.readValue(bagJson, new TypeReference<>() {});
                for (Item i : items){
                    if (i.getName().equalsIgnoreCase(s)) {
                        this.myItem = new Item(i.getId(),i.getName(), i.getAmount());
                        askAmount();
                        break;
                    }

                }
                System.out.printf("You don't have %s in the bag..\n",s);
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
            System.out.print("\nAdventurers Box > Get Item > " + this.myItem.getName() +
                    "\nEnter amount, you have " + this.myItem.getAmount() + " in bag\n>> ");
            putToBox = in.nextInt();
            if (putToBox > this.myItem.getAmount()) {
                System.out.println("The bag contains less...");
                askAmount();
            }
            else if (putToBox == 0) {
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
        System.out.print("\nAdventurers Box > Put Item > Confirm\nPut " + putToBox + " " + this.myItem.getName() + "? [Y][N]\n>> ");
        again = in.nextLine();
        if (again.equalsIgnoreCase("y")) {

            putItemToBox(putToBox, this.myItem.getId());
            getItemFromBag(putToBox, this.myItem.getId(), this.myItem.getName());

            System.out.print("\nAdventurers Box > Put Item > Box\n");
            qry = "select * from boxTb where amount !=0;";
            viewBox();
            System.out.println("You put x" + putToBox + " " + this.myItem.getName() + " to the box..");
            retry();

        } else if (again.equalsIgnoreCase("n")) {
            retry();
        } else {
            System.out.println("Error: Choose Y or N");
            confirmGet();
        }
    }

    public void putItemToBox(int put, int id) {

        try {
            qry = "UPDATE boxTb SET amount = amount + " + put + " WHERE itemId = " + id;
            connectBox();
            preStatement = con.prepareStatement(qry);
            preStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Something went wrong" + e);
            display();
        }
    }

    public void getItemFromBag(int get, int id, String name) {
        try {
            ObjectMapper om = new ObjectMapper();
            items = om.readValue(bagJson, new TypeReference<>() {});
            Item pcs = new Item(id, name, get);

            for (Item i : items) {
                if (i.getId() == pcs.getId()) {
                    get = i.getAmount() - get;
                    pcs.setAmount(get);
                    items.remove(i);
                    break;
                }
            }

            items.add(pcs);
            jsonUpdate(items);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void retry() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > Put Item\nBack to main? [Y][N]\n>> ");
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
