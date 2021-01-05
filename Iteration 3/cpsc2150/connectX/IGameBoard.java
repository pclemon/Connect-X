package cpsc2150.connectX;
/*
    Paige Clemons
    Lab Section: 5
    Homework 3
    10/28/18
 */

/**
 * Initialization ensures: GameBoard is number_of_rows x number_of_columns, number_of_rows is set to
 *                         a number specified by the user, number_of_columns is set to a number specified by the user
 *                         , winning_number_of_tokens is set to a number specified by the user
 * Defines: number_of_rows: Z
 *          number_of_columns: Z
 *          winning_number_of_tokens: Z
 * Constraints: 3 <= number_of_rows <= 100
 *              3 <= number_of_columns <= 100
 *              3 <= winning_number_of_tokens <= 25
 */
public interface IGameBoard {

    /**
     * @param c column in which the player wishes to place a token
     * @return returns true if the column is open and false if it isn't free
     * @pre c >= 0 && c < number_of_columns
     * @post checks if the space that the player wishes to place their token is free
     */
    default public boolean checkIfFree(int c){
        //Keeps track of how many tokens are in the column
        int countTokens = 0;

        //Loops through the given column, c
        for(int i = 0; i < getNumRows(); i++){
            //Check if the space is a token
            if(whatsAtPos(i, c) != ' '){
                //If it is then increment countTokens
                countTokens++;
            }
        }

        //if countTokens equals the max amount of tokens a column can hold return false
        if(countTokens == getNumRows()){
            return false;
        }

        //Otherwise return true
        return true;
    }

    /**
     * @param c the column where the last token was placed
     * @return returns true if there is a win and false if there isn't
     * @pre must call placeToken first
     *      c >= 0 and c < number_of_columns
     * @post returns true if there is a win in any direction and false if there isn't a win
     */
    default public boolean checkForWin(int c){
        //playerToken is the token at the current position
        char playerToken = 'O';
        int row = 0;
        //i is the last row in the array
        int i = getNumRows() - 1;

        //Looping while playerToken is equal to a space and i >= 0
        while(playerToken != ' ' && i >= 0){
            //If i - 1 is less then or equal to zero and i - 1 is less than the number of rows
            if((i - 1 >= 0) && (i - 1 < getNumRows())){
                //Check the position above the current one
                playerToken = whatsAtPos(i - 1, c);
            }
            //If position above the current one is a blank space the row is the current i
            if(playerToken == ' '){
                row = i;
            }
            //Decrementing i
            i--;
        }

        //If i is less than the number of rows in the board then check for wins
        if(row < getNumRows()){
            //Making sure the current position is not a space (only important for new boards)
            if(whatsAtPos(row, c) == ' '){
                return false;
            }
            //If there is a vertical win then return true
            if (checkVertWin(row, c, whatsAtPos(row, c)) == true) {
                return true;
            }
            //If there is a horizontal win then return true
            else if (checkHorizWin(row, c, whatsAtPos(row, c)) == true) {
                return true;
            }
            //If there is a diagonal win then return true
            else if (checkDiagWin(row, c, whatsAtPos(row, c)) == true) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param p the player's token either X or O
     * @param c the column the player wants to place the token
     * @pre c >= 0 and c < number_of_columns
     *      p = 'X' or p = 'O'
     *      must call checkIfFull first and it must return true
     * @post places token p in the bottom most spot in the column that is selected
     */
    public void placeToken(char p, int c);

    /**
     * @param r the row where the last token was placed
     * @param c the column where the last token was placed
     * @param p the player's token that was last placed
     * @return true if there is a win win at the position the last token was placed and false if there is no win
     * @pre must call placeToken first
     *      must not have been a win at a previous turn
     *      r >= 0 and r < number_of_rows
     *      c >= 0 and c < number_of_columns
     * @post if there is the winning_number_of_tokens of the same token, p, horizontally then there is win, true, otherwise false
     */
    default public boolean checkHorizWin (int r, int c, int p){
        //Keeping track of how many consecutive tokens of the same kind there are
        int countTokens = 1;
        //Loop variable
        int i;

        //Checking to the right of the last placed token
        for(i = 0; i < getNumToWin(); i++){
            //Check if the c+i and c+i+1 is inside the bounds of the array
            if(c + i < getNumColumns() && c + i + 1 < getNumColumns()){
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
        if(countTokens == getNumToWin()){
            return true;
        }

        //Checking to the left of the last placed token
        for(i = 0; i < getNumToWin(); i++){
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

        //If countTokens if greater than or equal to the number of tokens needed to win then return true
        if(countTokens >= getNumToWin()){
            return true;
        }

        //If countTokens doesn't equal to the number of tokens needed to win at any point then return false
        return false;
    }

    /**
     * @param r the row where the last token is played
     * @param c the column where the last token is played
     * @param p the player's token that was last placed
     * @return true if there is a win at the last position a token was placed and false if there is no win
     * @pre must call placeToken first
     *      must not have been a win at a previous turn
     *      r >= 0 and r < number_of_rows
     *      c >= 0 and c < number_of_columns
     * @post if there is the winning_number_of_tokens of the same token, p, vertically then there is a win, true, otherwise false
     */
    default public boolean checkVertWin (int r, int c, int p){
        //Keeping track of how many consecutive tokens of the same kind there are
        int countTokens = 0;

        //Loops the column 4 times since you need four tokens in a row to win
        for(int i = 0; i < getNumToWin(); i++){
            //Checks if r + 1 is in the bounds of the array
            if(r + i < getNumRows()){
                //If it is then check if is equal to the player's token that was last placed
                if(whatsAtPos(r + i, c) == p){
                    //If it is then increment countTokens
                    countTokens++;
                }
            }
        }

        //If countTokens is equal to the number of tokens needed to win then return true
        if(countTokens == getNumToWin()){
            return true;
        }

        //If countTokens doesn't equal to the number of tokens needed to win at any point then return false
        return false;
    }

    /**
     * @param r the row where the last token was placed
     * @param c the column where the last token was placed
     * @param p the player's token that was last placed
     * @return true if there is a win at the last position a token was placed and false if there is no win
     * @pre must call placeToken first
     *      must not have been a win at a previous turn
     *      r >= 0 and r < number_of_rows
     *      c >= 0 and c < number_of_columns
     * @post if there is the winning_number_of_tokens of the same token, p, diagonally then there is a win, true, otherwise false
     */
    default public boolean checkDiagWin(int r, int c, int p){
        //Keeping track of how many consecutive tokens of the same kind there are
        int countTokensOne = 1;
        int countTokensTwo = 1;
        //Loop variable
        int i;

        //Checking in the direction of a forward slash
        for(i = 0; i < getNumToWin(); i++){
            //Checking to make sure the rows in column going to the top right of the board is in the bounds of the array
            if(((r - i >= 0) && (c + i < getNumColumns())) && ((r - i - 1 >= 0) && (c + i + 1 < getNumColumns()))){
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
            if(((r + i < getNumRows()) && (c - i >= 0)) && ((r + i + 1 < getNumRows()) && (c - i - 1 >= 0))){
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
        for(i = 0; i < getNumToWin(); i++){
            //Checking to make sure the rows in column going to the bottom left of the board is in the bounds of the array
            if(((r + i < getNumRows()) && (c + i < getNumColumns())) && ((r + i + 1 < getNumRows()) && (c + i + 1 < getNumColumns()))){
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

        //If countTokensOne or countTokensTwo is greater than or equal to the number of tokens needed to win then return true
        if(countTokensOne >= getNumToWin() || countTokensTwo >= getNumToWin()){
            return true;
        }

        //If countTokens doesn't equal to the number of tokens needed to win at any point then return false
        return false;
    }

    /**
     * @param r the row for the spot in the array you want to check
     * @param c the column for the spot in the array you want to check
     * @return returns the character that is in the spot in the array
     * @pre r >= 0 and r < number_of_rows
     *      c >= 0 and c < number_of_columns
     * @post gives the character at the specific r and c location
     */
    public char whatsAtPos(int r, int c);

    /**
     * @return string representation of the gameboard
     * @pre the board != null
     * @post a string representation of the board is created
     */
    public String toString();

    /**
     * @return true if there is a tie and false if there isn't
     * @pre there must not be a win already
     * @post returns true if all columns are full and there has not already been a win returns false otherwise
     */
    default public boolean checkTie(){
        //Counter for how many full columns there are
        int countFullColumns = 0;

        //Looping through all the columns and seeing if they are full
        for(int i = 0; i < getNumColumns(); i++){
            //If checkIfFree returns false the add to the counter
            if(checkIfFree(i) == false){
                countFullColumns++;
            }
        }

        //If the counter equals the number of columns then the board is full
        if(countFullColumns == getNumColumns()){
            return true;
        }
        return false;
    }

    /**
     * @return the number of rows in the GameBoard
     * @pre the number of rows in the GameBoard must be initialized
     * @post getNumRows = number_of_rows
     */
    public int getNumRows();

    /**
     * @return the number of columns in the GameBoard
     * @pre the number of columns in the GameBoard must be initialized
     * @post getNumColumns = number_of_columns
     */
    public int getNumColumns();

    /**
     * @return the number of tokens in a row needed to win
     * @pre the number of tokens needed to win must be initialized
     * @post getNumTokens = winning_number_of_tokens
     */
    public int getNumToWin();
}
