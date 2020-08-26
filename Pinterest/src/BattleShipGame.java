/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

//class Solution {
//    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("Hello, World!");
//        strings.add("Welcome to CoderPad.");
//        strings.add("This pad is running Java " + Runtime.version().feature());
//
//        for (String string : strings) {
//            System.out.println(string);
//        }
//    }
//}


/*
Your previous Plain Text content is preserved below:

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://coderpad.io/settings

Enjoy your interview!


Battleship Problem
Battleship is a two player, pen and paper guessing game. Each player is given their own separate 10x10 grid that represents a birds eye view of the battlefield. At the beginning of the game, the players will mark their ships on their grid. The location of player 1's ships are concealed from player 2 and vice versa. Players take turns calling "shots" at the other player's ships. The objective of the game is to destroy the other player's ships.

Walk through the design, and then implement the game of battleship using a programming language of your choice. You will have around 45 minutes.

Your game should output something similar to the following logs, where lines with the > character represents input provided by the players:

At the beginning of the game, Players provide (x, y) coordinates and orientation of the ship
Player 1's turn to position ship of size 2:
> 3, 2, vertical
Player 1's turn to position ship of size 4:
> 5, 4, horizontal
Player 2's turn to position ship of size 2:
> 4, 4, vertical
Player 2's turn to position ship of size 4:
> 0, 0, vertical

Gameplay
Player 1's turn to fire:
> 8, 9
Miss
Player 2's turn to fire:
> 4, 5
Miss
Player 1's turn to fire:
> 4, 4
Hit
Player 2's turn to fire:
> 6, 4
Hit
Player 1's turn to fire:
> 4, 5
Hit - Ship destroyed

End game (output truncated for brevity)
Player 1's turn to fire:
> 0, 0
Hit - Ship destroyed
Player 2 has no more ships. Player 1 wins!
2 x 1, 3 x 1, 2 x 1

grid - matrix
ships -
player - grid,ships[]
game -

 board : ship = 1, water = 0, hit ship = 2
 */

class Player {
    int[][] board;
    List<int[]> shipCoordinates;
    int shipCount;
    //ship placed - 1

    Player(int dimension, List<int[]> shipCoordinates) {
        board = new int[dimension][dimension];
        this.shipCoordinates = shipCoordinates;
        shipCount = shipCoordinates.size();
        gameIdnitializer();
    }

    // 3,2 , 2, -1 - down  // 1 - right
    private void gameIdnitializer() {
        for (int[] coordinate : shipCoordinates) {
            //validate the input
            int row = coordinate[0];
            int col = coordinate[1];
            int size = coordinate[2];
            int direction = coordinate[3];
            if (direction == -1) { // make constant for direction
                for (int r = row; r < row + size; r++) {
                    //validate current coordinate
                    board[r][col] = 1;
                }
            } else {
                for (int c = col; c < col + size; c++) {
                    board[row][c] = 1;
                }
            }
        }
    }

    //false - miss // true - hit
    public boolean fireBoard(int x, int y) throws Exception {

        if (board[x][y] == 1) {
            board[x][y] = 2; //ship hit
            shipCount--;
            if (shipCount == 0) {
                throw new Exception("End the game");
            }
            return true;
        }
        return false;
    }


}

/*
Player 1's turn to fire:
> 8, 9
Miss
Player 2's turn to fire:
> 4, 5
Miss
*/
public class BattleShipGame {
    public static void main(String[] args) throws Exception {
        List<int[]> shipCoordinatesForPlayer1 = new ArrayList<>();
        List<int[]> shipCoordinatesForPlayer2 = new ArrayList<>();
        shipCoordinatesForPlayer1.add(new int[]{3, 2, 2, -1});
        shipCoordinatesForPlayer1.add(new int[]{5, 4, 4, 1});
        shipCoordinatesForPlayer2.add(new int[]{4, 4, 2, -1});
        shipCoordinatesForPlayer2.add(new int[]{0, 0, 4, -1});
        Player player1 = new Player(10, shipCoordinatesForPlayer1);
        Player player2 = new Player(10, shipCoordinatesForPlayer2);

        String[] operations = {"1 1 0", "2 4 5", "1 4 4", "2 6 4", "1 4 5","1 0 0","2 5 5"};
        for (String obj : operations) {
            String[] myObj = obj.split(" ");
            int playerNumber = Integer.parseInt(myObj[0]);  // Read user input
            int x = Integer.parseInt(myObj[1]);  // Read user input
            int y = Integer.parseInt(myObj[2]);  // Read user input
            //Scanner ip, x y
            if (playerNumber == 1) {
                if (player2.fireBoard(x, y)) {
                    System.out.println("ship was hit");
                } else {
                    System.out.println("misssed it!!!");
                }
            } else {
                if (player1.fireBoard(x, y)) {
                    System.out.println("ship was hit");
                } else {
                    System.out.println("misssed it!!!");
                }
            }


        }


    }
}
/*
Player 1's turn to position ship of size 2:
> 3, 2, vertical
Player 1's turn to position ship of size 4:
> 5, 4, horizontal
Player 2's turn to position ship of size 2:
> 4, 4, vertical
Player 2's turn to position ship of size 4:
> 0, 0, vertical

Gameplay
Player 1's turn to fire:
> 8, 9
Miss
Player 2's turn to fire:
> 4, 5
Miss
Player 1's turn to fire:
> 4, 4
Hit
Player 2's turn to fire:
> 6, 4
Hit
Player 1's turn to fire:
> 4, 5
Hit - Ship destroyed
 */

