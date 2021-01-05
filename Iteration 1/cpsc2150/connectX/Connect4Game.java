package cpsc2150.connectX;

/*
    Paige Clemons (pclemon)
    Lab Section: 5
    Homework 1
    Due: 9/23/18
 */

import java.util.*;
public class Connect4Game {
    public static void main(String [] args){
        //Creates a GameBoard object
        GameBoard board = new GameBoard();
        //Creating a scanner object
        Scanner scanner = new Scanner(System.in);
        //Keeps track of how many turns have been made
        int numOfTurns = 0;
        //Gets what column the player want to put their token into
        int playerChoice = 0;
        //Player's choice to play again
        char playAgain = 'y';
        //Player token
        char player;
        //Booleans to control loops
        boolean win = false;
        boolean tie = false;
        boolean validColumn;

        //Loops while the player wants to play again
        while(playAgain == 'y' || playAgain == 'Y') {
            //Resets everything for a new game
            win = false;
            tie = false;
            numOfTurns = 0;
            board = new GameBoard();
            //Loops while there is not a win and not a tie
            while (win == false && tie == false) {
                //Prints the empty board
                printBoard(board);
                //Printing whose turn it is and return the proper player's token
                player = printTurn(numOfTurns);
                //Getting the column the player wants to place their token
                playerChoice = scanner.nextInt();
                //Checking to insure the column entered is valid
                validColumn = validateColumn(playerChoice);

                //Loops while the column is not vaild
                while(validColumn == false) {
                    //Asks the player for a column
                    player = printTurn(numOfTurns);
                    //Get the column the player wants to place their token
                    playerChoice = scanner.nextInt();
                    //Call validateColumn to check that the column is valid
                    validColumn = validateColumn(playerChoice);
                }

                //Loops while the column the player wishes to place their token is full
                while(board.checkIfFree(playerChoice) == false){
                    //Prints that the column is full
                    System.out.println("Column is full");
                    //Asks the player for a column
                    player = printTurn(numOfTurns);
                    //Get the column the player wants to place their token
                    playerChoice = scanner.nextInt();
                }

                //Increment numOfTurns
                numOfTurns++;
                //Places the token
                board.placeToken(player, playerChoice);
                //Calls checkForWin
                win = board.checkForWin(playerChoice);

                //If win is true
                if(win == true) {
                    //Print the board
                    printBoard(board);
                    //Display who won
                    System.out.println("Player " + player + " won!");
                }

                //Checks if the board is a tie
                tie = board.checkTie();

                //If the board is a tie
                if(tie == true) {
                    //Print the board
                    printBoard(board);
                    //Display that it is a tie
                    System.out.println("It's a tie");
                }
            }

            //Ask to play again
            System.out.println("Would you like to play again? Y/N");
            //Get player's answer
            playAgain = scanner.next().charAt(0);

            //Loops while it is not a valid answer
            while(playAgain != 'y' && playAgain != 'Y' && playAgain != 'n' && playAgain != 'N'){
                //Ask to play again
                System.out.println("Would you like to play again? Y/N");
                //Get player's answer
                playAgain = scanner.next().charAt(0);
            }

        }

    }

    /**
     * @param b the game board that is being played on
     * @pre must create an instance of the GamBoard class
     * @post prints the game board as a string
     */
    private static void printBoard (GameBoard b){
        //Create a string to hold the board
        String boardString;

        //Calling the toString function to make the board a string
        boardString = b.toString();

        //Printing the string representation of the board
        System.out.println(boardString);
    }

    /**
     * @param c the column that the player wishes to place their token
     * @return true if the columns is valid and false if it is invalid
     * @pre the player must choose somewhere to place a token
     * @post false if the column >= 0 and column < 7 and true otherwise
     *       if column < 0 prints a message saying column can't be less than 0
     *       if column > 6 and prints a message saying column can't be greater than 6
     *
     */
    private static boolean validateColumn(int c){
        //Check if the desired column is less than zero
        if(c < 0){
            //If it is then say the column can't be < 0
            System.out.println("Column cannot be less than 0");
            //And return false
            return false;
        }
        //Check if the desired column is the greater than the number of columns
        else if(c >= GameBoard.MAX_COLUMNS){
            //If its then say the column can't be > 6
            System.out.println("Column cannot be greater than 6");
            //And return false
            return false;
        }
        return true;
    }

    /**
     * @param turns the number of turns that have been made
     * @return the player's token that will be placed X or O
     * @pre turns >= 0
     * @post prints a message with whose turn it is either player x if the turns are even or player O if the turns are odd
     *       also returns the player's token once it is decided whose turn it is
     */
    private static char printTurn(int turns){
        //If the turns are even numbers or 0 then it is player X's turn otherwise it is player O's turn
        if(turns == 0){
            //Prints message for player X
            System.out.println("Player X, what column do you want to place your marker in?");
            //Returns X for player X's token
            return 'X';
        }
        else if(turns % 2 != 0){
            //Prints message for player O
            System.out.println("Player O, what column do you want to place your marker in?");
            return 'O';

        }
        //Default case it is Player X turn
        System.out.println("Player X, what column do you want to place your marker in?");
        return 'X';

    }
}
