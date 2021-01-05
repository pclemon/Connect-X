package cpsc2150.connectX;

/*
    Paige Clemons (pclemon)
    Lab Section: 5
    Homework 1
    Due: 9/23/18
 */

/**
 * @invariant board != null
 *            MAX_ROWS = 6
 *            MAX_COLUMNS = 7
 *            MAX_TOKENS = 6
 *            WINNING_NUM_OF_TOKENS = 4
 */
public class GameBoard {

    private char [][] board;
    private final static int WINNING_NUM_OF_TOKENS = 4;
    public final static int MAX_ROWS = 6;
    public final static int MAX_COLUMNS = 7;
    public final static int MAX_TOKENS = 6;

    /**
     * @pre board must be defined
     *      MAX_ROWS and MAX_COLUMNS must be initialized
     * @post creates a 2D array of size 6x7 and of empty spaces
     */
    public GameBoard(){
        //Creates a new 2D array of chars with a 6x7 size
        board = new char [MAX_ROWS][MAX_COLUMNS];
        //Filling the array with empty spaces
        for(int i = 0; i < MAX_ROWS; i++){
            for(int j = 0; j < MAX_COLUMNS; j++){
                board[i][j] = ' ';
            }
        }
    }

    /**
     *
     * @param c column in which the player wishes to place a token
     * @return returns true if the column is open and false if it isn't free
     * @pre c >= 0 && c <= 6
     * @post checks if the space that the player wishes to place their token is free
     */
    public boolean checkIfFree(int c){
        //Keeps track of how many tokens are in the column
        int countTokens = 0;

        //Loops through the given column, c
        for(int i = 0; i < MAX_ROWS; i++){
            //Check if the space is a token
            if(board[i][c] != ' '){
                //If it is then increment countTokens
                countTokens++;
            }
        }

        //if countTokens equals the max amount of tokens a column can hold return false
        if(countTokens == MAX_TOKENS){
            return false;
        }

        //Otherwise return true
        return true;
    }

    /**
     * @param c the column where the last token was placed
     * @return returns true if there is a win and false if there isn't
     * @pre must call placeToken first
     *      c >= 0 and c < 7
     * @post returns true if there is a win in any direction and false if there isn't a win
     */
    public boolean checkForWin(int c){
        //playerToken is the token at the current position
        char playerToken = 'O';
        //i is the last row in the array
        int i = MAX_ROWS - 1;

        //Looping while playerToken is equal to a space and i >= 0
        while(playerToken != ' ' && i >= 0){
            //Check the current position
            playerToken = whatsAtPos(i, c);
            //Decrementing i
            i--;
        }


        //Checking that the position of the last token is within the bounds of the array
        if(i + 2 < MAX_ROWS){
            //Making sure the current position is not a space (only important for new boards)
            if(whatsAtPos(i + 2, c) == ' '){
                return false;
            }
            //If there is a vertical win then return true
            if (checkVertWin(i + 2, c, whatsAtPos(i + 2, c)) == true) {
                return true;
            }
            //If there is a horizontal win then return true
            else if (checkHorizWin(i + 2, c, whatsAtPos(i + 2, c)) == true) {
                return true;
            }
            //If there is a diagonal win then return true
            else if (checkDiagWin(i + 2, c, whatsAtPos(i + 2, c)) == true) {
                return true;
            }
        }

        return false;
    }

    /***
     * @param p the player's token either X or O
     * @param c the column the player wants to place the token
     * @pre c >= 0 and c < 7
     *      p = 'X' or p = 'O'
     *      must call checkIfFull first and it must return true
     * @post places token p in the bottom most spot in the column that is selected
     */
    public void placeToken(char p, int c){
        //Start at the bottom of the desired column
        for(int i = MAX_ROWS - 1; i >= 0; i--){
            //Check if the pos is open
            if(whatsAtPos(i, c) == ' '){
                //if it is open then place the token and return
                board[i][c] = p;
                return;
            }
        }
    }

    /**
     * @param r the row where the last token was placed
     * @param c the column where the last token was placed
     * @param p the player's token that was last placed
     * @return true if there is a win win at the position the last token was placed and false if there is no win
     * @pre must call placeToken first
     *      must not have been a win at a previous turn
     *      r >= 0 and r < 6
     *      c >= 0 and c < 7
     * @post if there is 4 tokens of the same token, p, horizontally then there is win, true, otherwise false
     */
    public boolean checkHorizWin (int r, int c, int p){
        //Keeping track of how many consecutive tokens of the same kind there are
        int countTokens = 1;
        //Loop variable
        int i = 0;

        //Checking to the right of the last placed token
        for(i = 0; i < WINNING_NUM_OF_TOKENS; i++){
            //Check if the c+i and c+i+1 is inside the bounds of the array
            if(c + i < MAX_COLUMNS && c + i + 1 < MAX_COLUMNS){
                //Check to see if the two spots are equal to each other
                if(whatsAtPos(r, c + i) == whatsAtPos(r, c + i + 1)){
                    //Check if both spot are equal to the last placed token, p
                    if(whatsAtPos(r, c + i) == p && whatsAtPos(r, c + i + 1) == p) {
                        //Increment countTokens
                        countTokens++;
                    }
                }
            }
        }

        //If countTokens equals 4 then return true
        if(countTokens == WINNING_NUM_OF_TOKENS){
            return true;
        }

        //Checking to the left of the last placed token
        for(i = 0; i < WINNING_NUM_OF_TOKENS; i++){
            //Check if the c-i and c-i-1 is inside the bounds of the array
            if((c - i) >= 0 && (c - i - 1) >= 0){
                //Check to see if the two spots are equal to each other
                if(whatsAtPos(r, c - i) == whatsAtPos(r, c - i -1)){
                    //Check if both spot are equal to the last placed token, p
                    if(whatsAtPos(r, c - i) == p && whatsAtPos(r, c - i - 1) == p) {
                        //Increment countTokens
                        countTokens++;
                    }
                }
            }
        }

        //If countTokens if greater than or equal to 4 then return true
        if(countTokens >= WINNING_NUM_OF_TOKENS){
            return true;
        }

        //If countTokens doesn't equal 4 at any point then return true
        return false;
    }

    /**
     * @param r the row where the last token is played
     * @param c the column where the last token is played
     * @param p the player's token that was last placed
     * @return true if there is a win at the last position a token was placed and false if there is no win
     * @pre must call placeToken first
     *      must not have been a win at a previous turn
     *      r >= 0 and r < 6
     *      c >= 0 and c < 7
     * @post if there is 4 tokens of the same token, p, vertically then there is a win, true, otherwise false
     */
    public boolean checkVertWin (int r, int c, int p){
        //Keeping track of how many consecutive tokens of the same kind there are
        int countTokens = 0;

        //Loops the column 4 times since you need four tokens in a row to win
        for(int i = 0; i < WINNING_NUM_OF_TOKENS; i++){
            //Checks if r + 1 is in the bounds of the array
            if(r + i < MAX_ROWS){
                //If it is then check if is equal to the player's token that was last placed
                if(board[r + i][c] == p){
                    //If it is then increment countTokens
                    countTokens++;
                }
            }
        }

        //If countTokens is equal to four then return true
        if(countTokens == WINNING_NUM_OF_TOKENS){
            return true;
        }

        return false;
    }

    /**
     * @param r the row where the last token was placed
     * @param c the column where the last token was placed
     * @param p the player's token that was last placed
     * @return true if there is a win at the last position a token was placed and false if there is no win
     * @pre must call placeToken first
     *      must not have been a win at a previous turn
     *      r >= 0 and r < 6
     *      c >= 0 and c < 7
     * @post if there is 4 tokens of the same token, p, diagonally then there is a win, true, otherwise false
     */
    public boolean checkDiagWin(int r, int c, int p){
        //Keeping track of how many consecutive tokens of the same kind there are
        int countTokensOne = 1;
        int countTokensTwo = 1;
        //Loop variable
        int i;

        //Checking in the direction of a forward slash
        for(i = 0; i < WINNING_NUM_OF_TOKENS; i++){
            //Checking to make sure the rows in column going to the top right of the board is in the bounds of the array
            if(((r - i >= 0) && (c + i < MAX_COLUMNS)) && ((r - i - 1 >= 0) && (c + i + 1 < MAX_COLUMNS))){
                //Checking that the two spots are equal to each other
                if(whatsAtPos(r - i, c + i) == whatsAtPos(r - i - 1, c + i + 1)){
                    //Check if both spot are equal to the last placed token, p
                    if(whatsAtPos(r - i, c + i) == p && whatsAtPos(r - i - 1, c + i + 1) == p){
                        //Incrementing countTokensOne
                        countTokensOne++;
                    }
                }
            }
            //Checking to make sure the rows in column going to the bottom right of the board is in the bounds of the array
            if(((r + i < MAX_ROWS) && (c - i >= 0)) && ((r + i + 1 < MAX_ROWS) && (c - i - 1 >= 0))){
                //Checking that the two spots are equal to each other
                if(whatsAtPos(r + i, c - i) == whatsAtPos(r + i + 1, c - i - 1)){
                    //Check if both spot are equal to the last placed token, p
                    if(whatsAtPos(r + i, c - i) == p && whatsAtPos(r + i + 1, c - i - 1) == p){
                        //Incrementing countTokensOne
                        countTokensOne++;
                    }
                }
            }
        }

        //Checking the direction of a backslash
        for(i = 0; i < WINNING_NUM_OF_TOKENS; i++){
            //Checking to make sure the rows in column going to the bottom left of the board is in the bounds of the array
            if(((r + i < MAX_ROWS) && (c + i < MAX_COLUMNS)) && ((r + i + 1 < MAX_ROWS) && (c + i + 1 < MAX_COLUMNS))){
                //Checking that the two spots are equal to each other
                if(whatsAtPos(r + i, c + i) == whatsAtPos(r + i + 1, c + i + 1)){
                    //Check if both spot are equal to the last placed token, p
                    if(whatsAtPos(r + i, c + i) == p && whatsAtPos(r + i + 1, c + i + 1) == p){
                        //Incrementing countTokensTwo
                        countTokensTwo++;
                    }
                }
            }
            //Checking to make sure the rows in column going to the top left of the board is in the bounds of the array
            if(((r - i >= 0 ) && (c - i >= 0)) && ((r - i - 1 >= 0) && (c - i - 1 >= 0))){
                //Checking that the two spots are equal to each other
                if(whatsAtPos(r - i, c - i) == whatsAtPos(r - i - 1, c - i - 1)){
                    //Check if both spot are equal to the last placed token, p
                    if(whatsAtPos(r - i, c - i) == p && whatsAtPos(r - i - 1, c - i - 1) == p){
                        //Incrementing countTokensTwo
                        countTokensTwo++;
                    }
                }
            }
        }

        //If countTokensOne or countTokensTwo is greater than or equal to 4 then return true
        if(countTokensOne >= WINNING_NUM_OF_TOKENS || countTokensTwo >= WINNING_NUM_OF_TOKENS){
            return true;
        }

        return false;
    }

    /**
     * @param r the row for the spot in the array you want to check
     * @param c the column for the spot in the array you want to check
     * @return returns the character that is in the spot in the array
     * @pre r >= 0 and r < 6
     *      c >= 0 and c < 7
     * @post gives the character at the specific r and c location
     */
    public char whatsAtPos(int r, int c){
        //Returns the desired spot in the array
        return board[r][c];
    }

    /**
     * @return string representation of the gameboard
     * @pre the board != null
     * @post a string representation of the board is created
     */
    @Override
    public String toString(){
        //Create a string that will hold the string representation of the board
        String str = "";

        //Loops through numbers 0-6 to add the column labels
        for (int i = 0; i < MAX_COLUMNS; i++){
            //Adding the column labels to the String
            str += "|";
            str += i;
        }

	//Adding extra pipe symbol and a new line
        str += "|";
        str += "\n";

        //Loop through the board
        for(int i = 0; i < MAX_ROWS; i++){
            for(int j = 0; j < MAX_COLUMNS; j++){
                //Insert a pipe symbol and whatever is in that spot in the array into the string
                str +=  "|";
                str += board[i][j];
                //If j equals the last column then add another pipe
                if(j == MAX_ROWS){
                    str += "|";
                }
            }
            //Insert a new line at the end of a row into the string
            str += "\n";
        }

        //Returns the string representation of the board
        return str;
    }

    /**
     * @return true if there is a tie and false if there isn't
     * @pre there must not be a win already
     * @post returns true if all columns are full and there has not already been a win returns false otherwise
     */
    public boolean checkTie(){
        //Counter for how many full columns there are
        int countFullColumns = 0;

        //Looping through all the columns and seeing if they are full
        for(int i = 0; i < MAX_COLUMNS; i++){
            //If checkIfFree returns false the add to the counter
            if(checkIfFree(i) == false){
                countFullColumns++;
            }
        }

        //If the counter equals the number of columns then the board is full
        if(countFullColumns == MAX_COLUMNS){
            return true;
        }
        return false;
    }
}
