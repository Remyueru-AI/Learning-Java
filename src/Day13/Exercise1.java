package Day13;
import java.util.Scanner;
public class Exercise1 {
    static String[][] board =  {{"   ","   ","   "},
                                {"   ","   ","   "},
                                {"   ","   ","   "}};

    static int turnCtr = 1;
    static String playerTurn = " O ";
    static int row,col;

    public static void main(String[] args) {
        printBoard();
        makeMove();
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (String[] row : board) {

            System.out.print("|");
            for (String val : row) {
                System.out.print(val + "|");
            }
            System.out.print("\n-------------");
            System.out.println();
        }
    }

    private static void makeMove(){
        Scanner in = new Scanner(System.in);
       try {
         while(turnCtr<10){
             //gaming...
             System.out.print("It is Your turn, PLAYER" +playerTurn+ "\t\t(Turn " +turnCtr+ ")\nEnter row:");
             row = in.nextInt();row--;
             System.out.print("Enter column:");
             col = in.nextInt();col--;
             isSlotTaken(row,col,playerTurn);
             if(isWon(playerTurn)){
                 printBoard();
                 System.out.println("YOU WON PLAYER" +playerTurn+ "in " +turnCtr+ "th turn!\nCONGRATULATIONS!!!");
                 System.exit(0);
             }
             playerTurn = (playerTurn == " O ") ?" X ": " O ";
             printBoard();
             turnCtr++;
         }
           fullBoard();
       }
       catch (Exception e)
       {
           System.out.println("\nThat is not a move! Only the number [1] [2] [3]".toUpperCase());
           printBoard();
           makeMove();
       }
       finally {
           in.close();
       }
    }

    private static void fullBoard(){
        System.out.println("Run out of move, It is a Draw");
        for(int row=0;row<board.length;row++){

            for(int col=0;col<board[row].length;col++){
                board[row][col] = "   ";
            }
        }
        turnCtr =1;
        System.out.println("Board resets!!");
        printBoard();
        makeMove();
        }

    private static void isSlotTaken(int r,int c,String t){
        if (board[r][c].compareToIgnoreCase("   ")!=0) {
            printBoard();
            System.out.println("Occupied already, Try other slots");
            makeMove();
        }
        else  board[r][c] = t;
    }

    private static boolean isWon(String player){
        String s = playerTurn+playerTurn+playerTurn;
        //[row][column]
        for (int i = 0; i < 3; i++) {


        if (((board[i][0] + board[i][1] + board[i][2]).equalsIgnoreCase(s))//horizontal
         || ((board[0][i] + board[1][i] + board[2][i]).equalsIgnoreCase(s))//vertical

         || ((board[0][0] + board[1][1] + board[2][2]).equalsIgnoreCase(s))
         || ((board[2][0] + board[1][1] + board[0][2]).equalsIgnoreCase(s))//diagonal
        )
        {

            return true;
        }

        }
      return false;
    }

}
/*
* check board full - done
* determine the winner - done
* slot taken - done
*/