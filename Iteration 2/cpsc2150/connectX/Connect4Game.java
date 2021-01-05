package cpsc2150.connectX;

/*
    Paige Clemons
    Lab Section: 5
    Homework 2
    10/10/18
 */

import java.util.*;
public class Connect4Game {
    public static void main(String [] args){
        //Creates a IGameBoard object
        IGameBoard board;
        //Values for creating the GameBoard object
        int rows;
        int columns;
        int tokens;
        //Creating a scanner object
        Scanner scanner = new Scanner(System.in);
        //Keeps track of how many turns have been made
        int numOfTurns;
        //Gets what column the player want to put their token into
        int playerChoice;
        //Player's choice to play again
        char playAgain = 'y';
        //Player token
        char player;
        //Booleans to control loops
        boolean win;
        boolean tie;
        boolean validColumn;
        boolean validNum;

        //Loops while the player wants to play again
        while(playAgain == 'y' || playAgain == 'Y') {
            //Resets everything for a new game
            win = false;
            tie = false;
            numOfTurns = 0;

            //Ask for how many rows the user would like
            System.out.println("How many rows should be on the board?");
            //Get the number of rows from the user
            rows = scanner.nextInt();
            //Calls validateNumRows to see if the number of rows is valid
            validNum = validateNumRows(rows);

            //Keeps asking for rows if the number is not valid
            while(validNum == false){
                System.out.println("How many rows should be on the board?");
                rows = scanner.nextInt();
                validNum = validateNumRows(rows);
            }

            //Ask for how many columns the user would like
            System.out.println("How many columns should be on the board?");
            //Get the number of columns from the user
            columns = scanner.nextInt();
            //Calls validateNumCols to see if the number of columns is valid
            validNum = validateNumCols(columns);

            //Keeps asking for columns if the number is not valid
            while(validNum == false){
                //Ask for how many columns the user would like
                System.out.println("How many columns should be on the board?");
                //Get the number of columns from the user
                columns = scanner.nextInt();
                //Calls validateNumCols to see if the number of columns is valid
                validNum = validateNumCols(columns);
            }

            //Ask for how many tokens needed to win the user would like
            System.out.println("How many in a row to win?");
            //Get the number of tokens need to win from the user
            tokens = scanner.nextInt();
            //Calls validateNumTokens to see if the needed tokens to win is valid
            validNum = validateNumTokens(tokens);

            //Keeps asking for a number of tokens if the number is not valid
            while(validNum == false){
                //Ask for how many tokens needed to win the user would like
                System.out.println("How many in a row to win?");
                //Get the number of tokens need to win from the user
                tokens = scanner.nextInt();
                //Calls validateNumTokens to see if the needed tokens to win is valid
                validNum = validateNumTokens(tokens);
            }

            board = new GameBoard(columns, rows, tokens);

            //Loops while there is not a win and not a tie
            while (win == false && tie == false) {
                //Prints the empty board
                printBoard(board);
                //Printing whose turn it is and return the proper player's token
                player = printTurn(numOfTurns);
                //Getting the column the player wants to place their token
                playerChoice = scanner.nextInt();
                //Checking to insure the column entered is valid
                validColumn = validateColumn(playerChoice, board);

                //Loops while the column is not valid or the column is not free
                while(validColumn == false || board.checkIfFree(playerChoice) == false) {
                    //Prints the column is full if it is full if it is a valid number
                    if(validColumn == true) {
                        if (board.checkIfFree(playerChoice) == false) {
                            //Prints that the column is full
                            System.out.println("Column is full");
                        }
                    }
                    //Asks the player for a column
                    player = printTurn(numOfTurns);
                    //Get the column the player wants to place their token
                    playerChoice = scanner.nextInt();
                    //Call validateColumn to check that the column is valid
                    validColumn = validateColumn(playerChoice, board);
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
    private static void printBoard (IGameBoard b){
        //Create a string to hold the board
        String boardString;

        //Calling the toString function to make the board a string
        boardString = b.toString();

        //Printing the string representation of the board
        System.out.println(boardString);
    }

    /**
     * @param c the column that the player wishes to place their token
     * @param b the GameBoard being played
     * @return true if the columns is valid and false if it is invalid
     * @pre the player must choose somewhere to place a token
     * @post false if the column >= 0 and column < columns and true otherwise
     *       if column < 0 prints a message saying column can't be less than 0
     *       if column > coulumns - 1 and prints a message saying column can't be greater than than columns - 1
     *
     */
    private static boolean validateColumn(int c, IGameBoard b){
        //Check if the desired column is less than zero
        if(c < 0){
            //If it is then say the column can't be < 0
            System.out.println("Column cannot be less than 0");
            //And return false
            return false;
        }
        //Check if the desired column is the greater than the number of columns
        else if(c >= b.getNumColumns()){
            //If its then say the column can't be > than the columns the board has
            System.out.println("Column cannot be greater than " + (b.getNumColumns() - 1));
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

    /**
     * @param r rows that the board should have
     * @return returns true of the number of rows that the board should have is valid and false otherwise
     * @pre r > 0
     * @post validateNumRows = true if r < 3 and r > 100 otherwise false
     */
    private static boolean validateNumRows(int r){
        //If the rows is less than 3 then print a message that the board needs at least 3 rows and return false
        if(r < GameBoard.MIN_SIZE){
            System.out.println("Must have at least 3 rows.");
            return false;
        }
        //If the rows is greater than 100 then print a message that the board can have at most 100 rows and return false
        else if(r > GameBoard.MAX_SIZE){
            System.out.println("Can have at most 100 rows");
            return false;
        }

        //Otherwise the number of rows is valid return true
        return true;
    }

    /**
     * @param c columns that the board should have
     * @return returns true of the number of columns that the board should have is valid and false otherwise
     * @pre c > 0
     * @post validateNumCols = true if c < 3 and c > 100 otherwise false
     */
    private static boolean validateNumCols(int c){
        //If the columns is less than 3 then print a message that the board needs at least 3 columns and return false
        if(c < GameBoard.MIN_SIZE){
            System.out.println("Must have at least 3 columns.");
            return false;
        }
        //If the columns is greater than 100 then print a message that the board can have at most 100 columns and return false
        else if(c > GameBoard.MAX_SIZE){
            System.out.println("Can have at most 100 columns");
            return false;
        }

        //Otherwise the number of columns is valid return true
        return true;
    }

    /**
     * @param t the number of tokens needed in a row to win the game
     * @return returns true of the number of tokens in a row need to win is valid and false otherwise
     * @pre t > 0
     * @post validateNumTokens = true if t < 3 and t > 25 otherwise false
     */
    private static boolean validateNumTokens(int t){
        //If the number of tokens needed to win is less than 3 then print a message that the number of tokens needed to win is at least 3 and return false
        if(t < GameBoard.MIN_TOKENS){
            System.out.println("Must have at least 3 in a row to win.");
            return false;
        }
        //If the number of tokens needed to win is greater than 25 then print a message that the number of tokens needed to win is at most 25 and return false
        else if(t > GameBoard.MAX_TOKENS){
            System.out.println("Can have at most 25 in a row to win");
            return false;
        }

        //Otherwise the number of tokens is valid return true
        return true;
    }
}
