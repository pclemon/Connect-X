package cpsc2150.connectX;
/*
    Paige Clemons
    Lab Section: 5
    Homework 4
    11/17/18
 */
import java.util.*;

/**
 * @invariant board != null
 *            MIN_SIZE <= numOfCols <= MAX_SIZE
 *            MIN_SIZE <= numOfRows <= MAX_SIZE
 *            MIN_SIZE <= numOfTokens <= MAX_SIZE
 * Correspondence number_of_rows = numOfRows
 *                number_of_columns = numOfCols
 *                winning_number_of_tokens = numOfTokens
 */public class GameBoardMem implements IGameBoard {
    //Map to represent the game board
    private Map <Integer, List<Character>> board;
    //The number of columns the user wants the game board to have
    private int numOfCols;
    //The number of rows the user wants the game board to have
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
     *      t >= MIN_SIZE and t <= MAX_SIZE
     * @post creates a map with the number of keys = c
     */
    GameBoardMem(int c, int r, int t){
        //Sets the number of rows to what the user wants
        numOfRows = r;
        //Sets the number of columns to what the user wants
        numOfCols = c;
        //Sets the number of tokens need to win to what the user wants
        numOfTokens = t;

        //Making a HashMap
        board = new HashMap<>();

        //Putting 100 keys in the map and declaring the list
        for(int i = 0; i < numOfCols; i++){
            List<Character> columns = new ArrayList<>();
            board.put(i, columns);
        }
    }

    public void placeToken(char p, int c){
        //Variable for the list that is at the column, c
        List<Character> tempCol;
        //Variable for the size of the column, c
        int listSize;

        //Setting tempCol to the desired column, c
        tempCol = board.get(c);

        //Getting the size of the column, c
        listSize = tempCol.size();

        //Then add the player token, p, at the top of the column, c
        tempCol.add(listSize, p);

        //Then copy tempCol into the map using the key, c
        board.put(c, tempCol);
    }

    public char whatsAtPos(int r, int c){
        //Variable for the list that is at the column, c
        List<Character> tempCol;
        //The number we want to get from the board
        int val;
        //Final value to get from the board/ place in the list
        int desired = -1;
        //Variable for an empty space meaning no token is placed
        char empty = ' ';

        //Setting tempCol to the desired column, c
        tempCol = board.get(c);

        //Finding the we want to get from the board
        val = (numOfRows - 1) - r;

        //Looping to find that val
        for(int i = tempCol.size() - 1; i >= 0; i--){
            //If i == val then the spot in the list exists so set desired equal to val
            if(i == val){
                desired = val;
            }
        }

        //Then if val is not equal to -1 return the character that is that is in the spot in the list
        if(desired != -1){
            return tempCol.get(desired);
        }

        //If the value is not a valid spot in the list then the space is empty so return a blank space
        return empty;
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

        //Adding the board to the string str
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfCols; j++){
                //Adding a pipe to the string
                str += "|";
                //If the position in the board is not empty then add the character in the position then a space
                if(whatsAtPos(i, j) != ' ') {
                    str += whatsAtPos(i, j);
                    str += " ";
                }
                //Otherwise add two spaces
                else {
                    str += "  ";
                }
            }

            //Add an extra pipe and a newline to the string, str
            str += "|";
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

