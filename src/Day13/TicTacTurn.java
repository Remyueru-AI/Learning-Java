package Day13;
import Day20.Organism;

import java.util.Scanner;
import java.lang.Math;

public class TicTacTurn {
    String[] board =  {" ¹ "," ² "," ³ ", " ⁴ "," ⁵ "," ⁶ "," ⁷ "," ⁸ "," ⁹ "};
    char[] ctr = {'⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹'};
    int[] turnPoint = {0,0}, pay = {0, 1, 2, 3, 4,};
    String playerTurn = " O";
    int turnCtr = 1,newBoard =1;
    boolean inGame = true;


    TicTacTurn(){
    showBoard();
    getMove();
    }

    private void showBoard(){
        System.out.println("\n\n\t\t\t Tic_Tac_Turn[" +turnCtr+
                "]\n[+]void:"+pay[0]+" \t |"+board[6]+"|"+board[7]+"|"+board[8]+
                "|\n[-]cull:"+pay[1]+" \t ]---+---+---["+
                "\n[*]loot:"+pay[2]+" \t |"+board[3]+"|"+board[4]+"|"+board[5]+
                "|\tTurn PoinT\n[/]seal:"+pay[3]+" \t ]---+---+---[\t| O : ["+turnPoint[0]+"]"+
                "\n[0]coin:"+pay[4]+" \t |"+board[0]+"|"+board[1]+"|"+board[2]+
                "|\t| X : ["+turnPoint[1]+"]"+
                "\n\t\t\t ^-v-^-v-^-v-^\t\"--------\"");
        String m = inGame ? "Player"+playerTurn+", " : "PLAYER"+playerTurn+"! ";
        System.out.print(m);
    }

    private void getMove() {
        try {
            Scanner in = new Scanner(System.in);
            while(inGame){

                System.out.print("Select a Tile to play: ");
                int move = in.nextInt();//tp usage should be included here later
                --move;
                //spendingTP
                isSlotTaken(move,board[move]);//this might be somewhere else
                isCtrFaded(board,ctr);
                isWon(board,playerTurn);
                if (!inGame){break;}
                isFull(board,ctr);


                turnCtr++;//turn and player change
                playerTurn = (playerTurn.equalsIgnoreCase(" O")) ? " X" : " O";
                tpScaling(turnPoint,newBoard);
                showBoard();
            }
        }
        catch (Exception e) {
            showBoard();
            System.out.print("that is an invalid move\n");
            getMove();
        }
    }

    private void isSlotTaken(int index,String value){
        if(value.contains("X")||value.contains("O")){
            showBoard();
            System.out.print("the tile is Already taken\n");
            getMove();
        }
        else  board[index]= playerTurn + ctr[6];//ctr 1st turn should be 4
    }

    private void isWon(String[] b, String player) {
        //wil check the board in 2d array if one of the player wins
        String s = String.valueOf(player.charAt(1)) + player.charAt(1) + player.charAt(1);
        String[][] con2D = {{b[0],b[1],b[2]},{b[3],b[4],b[5]},{b[6],b[7],b[8]}};

        for (int i = 0; i < 3; i++){

            if ((//horizontal
            (String.valueOf(con2D[i][0].charAt(1)) + con2D[i][1].charAt(1) + con2D[i][2].charAt(1)).equalsIgnoreCase(s)
            ) || (//vertical
            (String.valueOf(con2D[0][i].charAt(1)) + con2D[1][i].charAt(1) + con2D[2][i].charAt(1)).equalsIgnoreCase(s)
            ) || (
            (String.valueOf(con2D[0][0].charAt(1)) + con2D[1][1].charAt(1) + con2D[2][2].charAt(1)).equalsIgnoreCase(s)
            ) || (//diagonals
            (String.valueOf(con2D[2][0].charAt(1)) + con2D[1][1].charAt(1) + con2D[0][2].charAt(1)).equalsIgnoreCase(s)))
            {
                inGame = false;//flag to stop the game
                showBoard();
                System.out.println("YOU WIN ON "+turnCtr+"TH TURN!! CONGRATULATION!!!");
                break;
            }
        }
    }

    private void isCtrFaded(String[] b,char[] c) {
        /*
        Argument needed: the board and the character marks as condition

        What it does:
            - It searches each tile of their counter mark
            - If it was equal value, perform a decrement
            - If the new value is not zero, attach it to the tile
            - Else reset the tile
            */
        for (int j = 0; j < b.length ; j++)
        {
            char v = b[j].charAt(2);//it will get each counter in the tile as char v
            // b[j] is the value
            for (int i = 0; i < c.length ; i++) {
                //checking each character mark

                if (v == c[i]) {
                    //if v is the same as the character mark, then v will be the ctr mark -1
                    v = c[--i];
                }
            }

            if (v!=c[0]) {
                //if v is NOT zero, ch will turn the tile to char[] and replace the previous mark
                char[] ch = b[j].toCharArray();
                ch[2]=v;
                b[j]= String.valueOf(ch);

            }else
                //else the tile will be character mark +1
                b[j] = " "+c[j+1]+" ";
        }
    }

    private void isFull(String[] brd, char[] ctr) {
        int emptyTiles = brd.length;

        for (int i = 0; i < brd.length; i++) {
            char boardVal = brd[i].charAt(1);

            if (boardVal!=ctr[i+1]) {--emptyTiles;}

            if (emptyTiles == 0) {
                showBoard();
                for (int j = 0; j < brd.length; j++) {
                    brd[j] = " " + ctr[j + 1] + " ";
                }
                System.out.print("You resets the Tiles");
                ++newBoard;
            }
        }
    }

    private void tpScaling(int[] tp, int nB){
        tp[0] = (int) (tp[0] + Math.pow(nB,2));
        tp[1] = (int) (tp[1] + Math.pow(nB,2));
    }

    public static void main(String[] args) {
        TicTacTurn turn = new TicTacTurn();
    }

}

/*
make numpad tictactoe


function isSlotTaken - done
         isWon       - done
         isCtrFading - done
         spendingTp  -
         isFull      - done
         save        -

To do
make the o and x last only in 4 turns
using this ¹²³⁴⁵⁶⁷⁸⁹⁰

have a turn counter
    - players will have turn point each turn
    - in their turn players can spend tp for buffs or debuffs

            spend turn counter
            [+] void - the player mark will not be reduced this turn(+1)
            [-] cull  - the foe tiles will have a -1
            [*] loot - get the half of foe tp
            [/] seal  - restrict an empty tile for next turn
            [0] coin  - T the tile will be at ctr 9, F no move

 Tic-Tac-Turn!
        |   |   | X⁰|
        |---+---+---|
        |   |   |   |
        |---+---+---|
        |   |   |   |
        ^-----------^
*/
