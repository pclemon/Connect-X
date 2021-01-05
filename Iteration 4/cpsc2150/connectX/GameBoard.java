package cpsc2150.connectX;

/*
    Paige Clemons
    Lab Section: 5
    Homework 4
    11/17/18
 */

/**
 * @invariant board != null
 *            MIN_SIZE <= numOfCols <= MAX_COLUMNS
 *            MAN_SIZE <= numOfRows <= MAX_ROWS
 *            MIN_TOKENS <= numOfTokens <= MAX_TOKENS
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


    /**
     * @param c number of columns for the columns of the playable board
     * @param r number of rows for the rows of the playable board
     * @param t number of tokens needed to win a game
     * @pre board must be defined
     *      c >= MIN_SIZE and c <= MAX_SIZE
     *      r >= MIN_SIZE and r <= MAX_SIZE
     *      t >= MIN_SIZE and t <= MAXSIZE
     * @post creates a 2D array of size MAX_SIZExMAX_SIZE and of empty spaces
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
        final int SPACE_FOR_SINGLE_DIGIT_NUMBERS = 10;

        //Loops through numbers 0 - numOfCols
        for (int i = 0; i < numOfCols; i++){
            //Adding the column labels to the String
            str += "|";
            //Adding a space in front of the single digit numbers
            if(i < SPACE_FOR_SINGLE_DIGIT_NUMBERS){
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
