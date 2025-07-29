package Day9;
import java.util.Scanner;
public class Activity2 {
    public static void main(String[] args) {
        userInput();
        //tryAgain();
    }

    public static String findZodiac(String month, int date){
        String sign = "";
       if(month.compareToIgnoreCase("march")==0){
            if (date < 21)
                sign = "♓ Pisces (Fish)";
            else
                sign = "♈ Aries (Ram)";
        }
       else if (month.compareToIgnoreCase("april")==0){
            if (date < 20)
                sign = "♈ Aries (Ram)";
            else
                sign = "♉ Taurus (Bull)";
        }
       else if (month.compareToIgnoreCase("may")==0){
            if (date < 21)
                sign = "♉ Taurus (Bull)";
            else
                sign = "♊ Gemini (Twins)";
        }
       else if (month.compareToIgnoreCase("june")==0){
            if (date < 21)
                sign = "♊ Gemini (Twins)";
            else
                sign = "♋ Cancer (Crab)";
        }
       else if (month.compareToIgnoreCase("july")==0){
            if (date < 23)
                sign = "♋ Cancer (Crab)";
            else
                sign = "♌ Leo (Lion)";
        }
       else if (month.compareToIgnoreCase("august")==0){
            if (date < 23)
                sign = "♌ Leo (Lion)";
            else
                sign = "♍ Virgo (Virgin)";
        }
       else if (month.compareToIgnoreCase("september")==0){
            if (date < 23)
                sign = "♍ Virgo (Virgin)";
            else
                sign = "♎ Libra (Balance)";
        }
       else if (month.compareToIgnoreCase("october")==0){
            if (date < 23)
                sign = "♎ Libra (Balance)";
            else
                sign = "♏ Scorpius (Scorpion)";
        }
       else if (month.compareToIgnoreCase("november")==0){
            if (date < 22)
                sign = "♏ Scorpius (Scorpion)";
            else
                sign = "♐ Sagittarius (Archer)";
        }
       else if (month.compareToIgnoreCase("december")==0){

            if (date < 22)
                sign = "♐ Sagittarius (Archer)";
            else
                sign ="♑ Capricornus (Goat)";
        }
       else if (month.compareToIgnoreCase("january")==0){
            if (date < 20)
                sign = "♑ Capricornus (Goat)";
            else
                sign = "♒ Aquarius (Water Bearer)";
        }
       else if (month.compareToIgnoreCase("february")==0){
            if (date < 19)
                sign = "♒ Aquarius (Water Bearer)";
            else
                sign = "♓ Pisces (Fish)";
        }
        else
           return "The program haven't found a match";

        return "\nBirth date: " +month+ " " +date+ "\nZodiac sign: " + sign ;
    }

    public static void userInput(){
        Scanner in = new Scanner(System.in);
        try {
            String m; int d;
            System.out.print("Enter month: ");
            m = in.nextLine();
            System.out.print("Enter date: ");
            d = in.nextInt();
            System.out.println(findZodiac(m,d));

        } catch (Exception a) {
            System.out.println("Need a number correspond to your birthday.\n\n");
            tryAgain();
        }
        finally {
            in.close();
        }
    }

    public static void tryAgain(){
        String answer ="";
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to try again? Y/n");
        answer = in.nextLine();
        if (answer.compareToIgnoreCase("y")==0){
            userInput();
        }
        else if (answer.compareToIgnoreCase("n")==0) {

        }
        else {
            System.out.println("\nNeed [Y]es or [N]o");
            tryAgain();
        }
        in.close();
    }
}
/*
♈ Aries (Ram): March 21–April 19
♉ Taurus (Bull): April 20–May 20
♊ Gemini (Twins): May 21–June 21
♋ Cancer (Crab): June 22–July 22
♌ Leo (Lion): July 23–August 22
♍ Virgo (Virgin): August 23–September 22
♎ Libra (Balance): September 23–October 23
♏ Scorpius (Scorpion): October 24–November 21
♐ Sagittarius (Archer): November 22–December 21
♑ Capricornus (Goat): December 22–January 19
♒ Aquarius (Water Bearer): January 20–February 18
♓ Pisces (Fish): February 19–March 20
*/