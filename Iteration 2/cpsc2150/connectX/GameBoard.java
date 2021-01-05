package cpsc2150.connectX;

/*
    Paige Clemons
    Lab Section: 5
    Homework 2
    10/10/18
 */

/**
 * @invariant board != null
 *            3 <= numOfCols <= MAX_COLUMNS
 *            3 <= numOfRows <= MAX_ROWS
 *            3 <= numOfTokens <= 25
 *            MAX_SIZE = 100
 *            MIN_SIZE = 3
 *            MIN_TOKENS = 3
 *            MAX_TOKENS = 25
 * Correspondence number_of_rows = numOfRows
 *                number_of_columns = numOfCols
 *                winning_number_of_tokens = numOfTokens
 */
public class GameBoard implements IGameBoard {

    //2D array for the game
    private char [][] board;
    //The number of columns the user wants the board to have
    private int numOfCols;
    //The number of rows the user wants the board to have
    private int numOfRows;
    //The number of tokens the user wants to have in a row in order for there to be a win
    private int numOfTokens;
    //The maximum number of rows in columns the board can have
    public final static int MAX_SIZE = 100;
    //The minimum number of rows and columns the board can have
    public static final int MIN_SIZE = 3;
    //The minimum number of tokens needed to win
    public static final int MIN_TOKENS = 3;
    //The max number of tokens needed to win
    public static final int MAX_TOKENS = 25;

    /**
     * @param c number of columns for the columns of the playable board
     * @param r number of rows for the rows of the playable board
     * @param t number of tokens needed to win a game
     * @pre board must be defined
     *      c >= 3 and c<= 100
     *      r >= 3 and r <= 100
     *      t >= 3 and t <= 25
     * @post creates a 2D array of size 100x100 and of empty spaces
     */
    public GameBoard(int c, int r, int t){
        //Sets the number of rows to what the user wants
        numOfRows = r;
        //Sets the number of columns to what the user wants
        numOfCols = c;
        //Sets the number of tokens need to win to what the user wants
        numOfTokens = t;

        //Creates a new 2D array of chars with a 100x100 size
        board = new char [MAX_SIZE][MAX_SIZE];
        //Filling the array with empty spaces
        for(int i = 0; i < MAX_SIZE; i++){
            for(int j = 0; j < MAX_SIZE; j++){
                board[i][j] = ' ';
            }
        }
    }

    public void placeToken(char p, int c){
        //Start at the bottom of the desired column
        for(int i = numOfRows - 1; i >= 0; i--){
            //Check if the pos is open
            if(whatsAtPos(i, c) == ' '){
                //if it is open then place the token and return
                board[i][c] = p;
                return;
            }
        }
    }

    public char whatsAtPos(int r, int c){
        //Returns the desired spot in the array
        return board[r][c];
    }

    @Override
    public String toString(){
        //Create a string that will hold the string representation of the board
        String str = "";
        //Controls the spaces before single digit numbers
        int spaceForSingleDigitNumbers = 10;

        //Loops through numbers 0 - numOfCols
        for (int i = 0; i < numOfCols; i++){
            //Adding the column labels to the String
            str += "|";
            //Adding a space in front of the single digit numbers
            if(i < spaceForSingleDigitNumbers){
                str += " ";
            }
            str += i;
        }

        //Adding extra pipe symbol and a new line
        str += "|";
        str += "\n";

        //Loop through the board
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfCols; j++){
                //Insert a pipe symbol and whatever is in that spot in the array into the string
                str +=  "|";
                str += board[i][j];
                str += " ";
                //If j equals the last column then add another pipe
                if(j == numOfCols - 1){
                    str += "|";
                }
            }
            //Insert a new line at the end of a row into the string
            str += "\n";
        }

        //Returns the string representation of the board
        return str;
    }

    public int getNumRows(){
        //Return the number of rows in the board
        return numOfRows;
    }

    public int getNumColumns(){
        //Return the number of columns in the board
        return numOfCols;
    }

    public int getNumToWin(){
        //Return the number of tokens to win
        return numOfTokens;
    }
}
