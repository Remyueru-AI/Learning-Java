package ProjectJava;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class TossItem extends ViewItem implements iRetry{

    Item myItem;
    int tossItem;

    @Override
    public void display() {
        System.out.print("\nAdventurers Box > Toss Item > Bag");
        viewBag();
        input();
    }

    @Override
    public void input() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("\nAdventurers Box > Toss Item\t\t[0] Back\nEnter item name: ");
            String s = in.nextLine();
            if (s.equals("0")) {
                ab.mainDisplay();
            } else {
                ObjectMapper om = new ObjectMapper();
                items = om.readValue(bagJson, new TypeReference<>() {});
                for (Item i : items){
                    if (i.getName().equalsIgnoreCase(s)) {
                        myItem = new Item(i.getId(),i.getName(), i.getAmount());
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
            System.out.print("\nAdventurers Box > Toss Item > " + myItem.getName() +
                    "\nEnter amount, you have " + myItem.getAmount() + " in bag\n>> ");
            tossItem = in.nextInt();
            if (tossItem > this.myItem.getAmount()) {
                System.out.println("The bag contains less...");
                askAmount();
            }
            else if (tossItem == 0) {
                System.out.println("Please enter amount.");
                askAmount();
            }
            else confirmToss();
        }
        catch (Exception e) {
            System.out.println("Please enter a number");
            askAmount();
        }
    }

    public void confirmToss() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > Toss Item > Confirm\nThrow " + tossItem + " " + myItem.getName() + "? [Y][N]\n>> ");
        again = in.nextLine();
        if (again.equalsIgnoreCase("y")) {
            PutItem pi = new PutItem();
            pi.getItemFromBag(tossItem, myItem.getId(), myItem.getName());
            viewBag();
            System.out.println("You threw x" + tossItem + " " + myItem.getName() + " away..");
            retry();

        } else if (again.equalsIgnoreCase("n")) {
            retry();
        } else {
            System.out.println("Error: Choose Y or N");
            confirmToss();
        }
    }

    @Override
    public void retry() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nAdventurers Box > Toss Item\nBack to main? [Y][N]\n>> ");
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
