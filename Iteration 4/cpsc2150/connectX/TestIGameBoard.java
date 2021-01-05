package cpsc2150.connectX;

/*
    Paige Clemons
    Lab Section: 5
    Homework 4
    11/17/18
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestIGameBoard {
    /* Testing the constructor */

    //Test #1
    @Test
    public void testConstructor_row3_column3_token3(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(3,3,3);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [3][3];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Expected variables for rows, columns, and the number of tokens needed to win
        int expectedRows = 3;
        int expectedColumns = 3;
        int expectedTokens = 3;

        //Actual variables for rows, columns, and the number of tokens needed to win
        int actualRows = actualGB.getNumRows();
        int actualColumns = actualGB.getNumColumns();
        int actualTokens = actualGB.getNumToWin();

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(3,3,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking the values and the boards
        assertEquals(expectedRows, actualRows);
        assertEquals(expectedColumns, actualColumns);
        assertEquals(expectedTokens, actualTokens);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #2
    @Test
    public void testConstructor_row100_column100_token25(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(100,100,25);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [100][100];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Expected variables for rows, columns, and the number of tokens needed to win
        int expectedRows = 100;
        int expectedColumns = 100;
        int expectedTokens = 25;

        //Actual variables for rows, columns, and the number of tokens needed to win
        int actualRows = actualGB.getNumRows();
        int actualColumns = actualGB.getNumColumns();
        int actualTokens = actualGB.getNumToWin();

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(100,100,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking the values and the boards
        assertEquals(expectedRows, actualRows);
        assertEquals(expectedColumns, actualColumns);
        assertEquals(expectedTokens, actualTokens);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #3
    @Test
    public void testConstructor_row6_column7_token4(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Expected variables for rows, columns, and the number of tokens needed to win
        int expectedRows = 6;
        int expectedColumns = 7;
        int expectedTokens = 4;

        //Actual variables for rows, columns, and the number of tokens needed to win
        int actualRows = actualGB.getNumRows();
        int actualColumns = actualGB.getNumColumns();
        int actualTokens = actualGB.getNumToWin();

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking the values and the boards
        assertEquals(expectedRows, actualRows);
        assertEquals(expectedColumns, actualColumns);
        assertEquals(expectedTokens, actualTokens);
        assertEquals(expectedGBString, actualGBString);
    }

    /* Testing checkIfFree */

    //Test #1
    @Test
    public void testCheckIfFree_full_column(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens in the first column
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[4][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[2][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[1][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[0][0] = 'O';

        //Calling checkIfFree(0)
        boolean actual = actualGB.checkIfFree(0);

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkIfFree and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #2
    @Test
    public void testCheckIfFree_half_full_column(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens in the first column
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[4][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';

        //Calling checkIfFree(0)
        boolean actual = actualGB.checkIfFree(0);

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkIfFree and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #3
    @Test
    public void testCheckIfFree_empty_column(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Calling checkIfFree(0)
        boolean actual = actualGB.checkIfFree(0);

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkIfFree and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    /* Testing checkHorizWin */

    //Test #1
    @Test
    public void testCheckHorizWin_check_right(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',1);
        expectedGB[5][1] = 'X';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        //Last placed token
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';

        //Calling checkHorizWin(5, 0, 'X')
        boolean actual = actualGB.checkHorizWin(5,0,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkHorizWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #2
    @Test
    public void testCheckHorizWin_check_left(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('X',1);
        expectedGB[5][1] = 'X';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        //Last placed token
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';

        //Calling checkHorizWin(5, 3, 'X')
        boolean actual = actualGB.checkHorizWin(5,3,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkHorizWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #3
    @Test
    public void testCheckHorizWin_check_middle(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        //Last placed token
        actualGB.placeToken('X',1);
        expectedGB[5][1] = 'X';

        //Calling checkHorizWin(5, 1, 'X')
        boolean actual = actualGB.checkHorizWin(5,1,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkHorizWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #4
    @Test
    public void testCheckHorizWin_check_middle_more_tokens_than_needed(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('X',1);
        expectedGB[5][1] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        actualGB.placeToken('X',4);
        expectedGB[5][4] = 'X';
        //Last placed token
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';

        //Calling checkHorizWin(5, 2, 'X')
        boolean actual = actualGB.checkHorizWin(5,2,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkHorizWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #5
    @Test
    public void testCheckHorizWin_no_win(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[5][1] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        actualGB.placeToken('X',4);
        expectedGB[5][4] = 'X';
        //Last placed token
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';

        //Calling checkHorizWin(5, 2, 'X')
        boolean actual = actualGB.checkHorizWin(5,2,'X'); //false

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkHorizWin and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    /* Testing checkVertWin */

    //Test #1
    @Test
    public void testCheckVertWin_four_in_a_row_from_bottom(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('X',0);
        expectedGB[4][0] = 'X';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';
        //Last placed token
        actualGB.placeToken('X',0);
        expectedGB[2][0] = 'X';

        //Calling checkVertWin(2, 0, 'X')
        boolean actual = actualGB.checkVertWin(2,0,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #2
    @Test
    public void testCheckVertWin_four_in_a_row_from_next_to_bottom(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('O',0);
        expectedGB[5][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[4][0] = 'X';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';
        actualGB.placeToken('X',0);
        expectedGB[2][0] = 'X';
        //Last placed token
        actualGB.placeToken('X',0);
        expectedGB[1][0] = 'X';

        //Calling checkVertWin(1, 0, 'X')
        boolean actual = actualGB.checkVertWin(1,0,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #3
    @Test
    public void testCheckVertWin_close_to_win(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('X',0);
        expectedGB[4][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[3][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[2][0] = 'X';
        //Last placed token
        actualGB.placeToken('X',0);
        expectedGB[1][0] = 'X';

        //Calling checkVertWin(1, 0, 'X')
        boolean actual = actualGB.checkVertWin(1,0,'X'); //false

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #4
    @Test
    public void testCheckVertWin_obvious_loss(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[4][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[2][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[1][0] = 'X';
        //Last placed token
        actualGB.placeToken('O',0);
        expectedGB[0][0] = 'O';

        //Calling checkVertWin(0, 0, 'X')
        boolean actual = actualGB.checkVertWin(0,0,'O'); //false

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #5
    @Test
    public void testCheckVertWin_close_to_win_three_in_a_row(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('X',0);
        expectedGB[4][0] = 'X';
        //Last placed token
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';

        //Calling checkVertWin(3, 0, 'X')
        boolean actual = actualGB.checkVertWin(3,0,'X'); //false

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    /* Testing checkDiagWin */

    //Test #1
    @Test
    public void testCheckDiagWin_four_in_a_row_top_right(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[4][4] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[5][5] = 'O';
        actualGB.placeToken('O',5);
        expectedGB[4][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[3][5] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[5][6] = 'O';
        actualGB.placeToken('O',6);
        expectedGB[4][6] = 'O';
        actualGB.placeToken('O',6);
        expectedGB[3][6] = 'O';
        //Last placed token
        actualGB.placeToken('X',6);
        expectedGB[2][6] = 'X';

        //Calling checkDiagWin(2, 6, 'X')
        boolean actual = actualGB.checkDiagWin(2,6,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #2
    @Test
    public void testCheckDiagWin_four_in_a_row_top_left(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',6);
        expectedGB[5][6] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[5][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[4][5] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('O',4);
        expectedGB[4][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[3][4] = 'X';
        actualGB.placeToken('O',3);
        expectedGB[5][3] = 'O';
        actualGB.placeToken('O',3);
        expectedGB[4][3] = 'O';
        actualGB.placeToken('O',3);
        expectedGB[3][3] = 'O';
        //Last placed token
        actualGB.placeToken('X',3);
        expectedGB[2][3] = 'X';

        //Calling checkDiagWin(2, 3, 'X')
        boolean actual = actualGB.checkDiagWin(2,3,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #3
    @Test
    public void testCheckDiagWin_four_in_a_row_bottom_right(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('O',5);
        expectedGB[5][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[4][5] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('O',4);
        expectedGB[4][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[3][4] = 'X';
        actualGB.placeToken('O',3);
        expectedGB[5][3] = 'O';
        actualGB.placeToken('O',3);
        expectedGB[4][3] = 'O';
        actualGB.placeToken('O',3);
        expectedGB[3][3] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[2][3] = 'X';
        //Last placed token
        actualGB.placeToken('X',6);
        expectedGB[5][6] = 'X';

        //Calling checkDiagWin(5, 6, 'X')
        boolean actual = actualGB.checkDiagWin(5,6,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #4
    @Test
    public void testCheckDiagWin_four_in_a_row_bottom_left(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[4][4] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[5][5] = 'O';
        actualGB.placeToken('O',5);
        expectedGB[4][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[3][5] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[5][6] = 'O';
        actualGB.placeToken('O',6);
        expectedGB[4][6] = 'O';
        actualGB.placeToken('O',6);
        expectedGB[3][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[2][6] = 'X';
        //Last placed token
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';

        //Calling checkDiagWin(5, 3, 'X')
        boolean actual = actualGB.checkDiagWin(5,3,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }


    //Test #5
    @Test
    public void testCheckDiagWin_four_in_a_row_middle(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('O',5);
        expectedGB[5][5] = 'O';
        actualGB.placeToken('O',5);
        expectedGB[4][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[3][5] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[5][6] = 'O';
        actualGB.placeToken('O',6);
        expectedGB[4][6] = 'O';
        actualGB.placeToken('O',6);
        expectedGB[3][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[2][6] = 'X';
        //Last placed token
        actualGB.placeToken('X',4);
        expectedGB[4][4] = 'X';

        //Calling checkDiagWin(4, 4, 'X')
        boolean actual = actualGB.checkDiagWin(4,4,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #6
    @Test
    public void testCheckDiagWin_middle_more_tokens_than_needed(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('O',6);
        expectedGB[5][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[4][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[3][6] = 'O';
        actualGB.placeToken('O',6);
        expectedGB[2][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[1][6] = 'X';
        actualGB.placeToken('X',5);
        expectedGB[5][5] = 'X';
        actualGB.placeToken('X',5);
        expectedGB[4][5] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[3][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[2][5] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('O',4);
        expectedGB[4][4] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[4][3] = 'X';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        //Last placed token
        actualGB.placeToken('X',4);
        expectedGB[3][4] = 'X';

        //Calling checkDiagWin(3, 4, 'X')
        boolean actual = actualGB.checkDiagWin(3,4,'X'); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #7
    @Test
    public void testCheckDiagWin_close_to_a_win(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('O',6);
        expectedGB[5][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[4][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[3][6] = 'O';
        actualGB.placeToken('O',6);
        expectedGB[2][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[1][6] = 'X';
        actualGB.placeToken('X',5);
        expectedGB[5][5] = 'X';
        actualGB.placeToken('X',5);
        expectedGB[4][5] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[3][5] = 'O';
        actualGB.placeToken('O',5);
        expectedGB[2][5] = 'O';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('O',4);
        expectedGB[4][4] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[4][3] = 'X';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        //Last placed token
        actualGB.placeToken('X',4);
        expectedGB[3][4] = 'X';

        //Calling checkDiagWin(3, 4, 'X')
        boolean actual = actualGB.checkDiagWin(3,4,'X'); //false

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test 8
    @Test
    public void testCheckDiagWin_obvious_no_win(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('O',1);
        expectedGB[5][1] = 'O';
        actualGB.placeToken('O',1);
        expectedGB[4][1] = 'O';
        actualGB.placeToken('O',1);
        expectedGB[3][1] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[2][1] = 'X';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[4][2] = 'O';
        actualGB.placeToken('O',3);
        expectedGB[5][3] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[4][3] = 'X';
        //Last placed token
        actualGB.placeToken('X',2);
        expectedGB[3][2] = 'X';

        //Calling checkDiagWin(3, 2, 'X')
        boolean actual = actualGB.checkDiagWin(3,2,'X'); //false

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checkVertWin and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    /* Testing checkTie */

    //Test #1
    @Test
    public void testCheckTie_completely_full_board(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[4][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[2][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[1][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[0][0] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[5][1] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[4][1] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[3][1] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[2][1] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[1][1] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[0][1] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[4][2] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[3][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[2][2] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[1][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[0][2] = 'O';
        actualGB.placeToken('O',3);
        expectedGB[5][3] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[4][3] = 'X';
        actualGB.placeToken('O',3);
        expectedGB[3][3] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[2][3] = 'X';
        actualGB.placeToken('O',3);
        expectedGB[1][3] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[0][3] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[4][4] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[3][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[2][4] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[1][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[0][4] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[5][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[4][5] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[3][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[2][5] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[1][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[0][5] = 'X';
        actualGB.placeToken('X',6);
        expectedGB[5][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[4][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[3][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[2][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[1][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[0][6] = 'O';

        //Calling checkTie()
        boolean actual = actualGB.checkTie(); //true

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checktie and the board
        assertTrue(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #2
    @Test
    public void testCheckTie_one_token_shy_of_a_completely_full_board(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[4][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[2][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[1][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[0][0] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[5][1] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[4][1] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[3][1] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[2][1] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[1][1] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[0][1] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[4][2] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[3][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[2][2] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[1][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[0][2] = 'O';
        actualGB.placeToken('O',3);
        expectedGB[5][3] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[4][3] = 'X';
        actualGB.placeToken('O',3);
        expectedGB[3][3] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[2][3] = 'X';
        actualGB.placeToken('O',3);
        expectedGB[1][3] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[0][3] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[4][4] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[3][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[2][4] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[1][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[0][4] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[5][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[4][5] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[3][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[2][5] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[1][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[0][5] = 'X';
        actualGB.placeToken('X',6);
        expectedGB[5][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[4][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[3][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[2][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[1][6] = 'X';


        //Calling checkTie()
        boolean actual = actualGB.checkTie(); //false

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checktie and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #3
    @Test
    public void testCheckTie_one_whole_column_empty(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing tokens
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[4][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[2][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[1][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[0][0] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[5][1] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[4][1] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[3][1] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[2][1] = 'O';
        actualGB.placeToken('X',1);
        expectedGB[1][1] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[0][1] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[4][2] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[3][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[2][2] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[1][2] = 'X';
        actualGB.placeToken('O',2);
        expectedGB[0][2] = 'O';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[4][4] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[3][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[2][4] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[1][4] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[0][4] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[5][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[4][5] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[3][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[2][5] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[1][5] = 'O';
        actualGB.placeToken('X',5);
        expectedGB[0][5] = 'X';
        actualGB.placeToken('X',6);
        expectedGB[5][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[4][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[3][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[2][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[1][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[0][6] = 'O';

        //Calling checkTie()
        boolean actual = actualGB.checkTie(); //false

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checktie and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #4
    @Test
    public void testCheckTie_completely_empty_board(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Calling checkTie()
        boolean actual = actualGB.checkTie(); //false

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking checktie and the board
        assertFalse(actual);
        assertEquals(expectedGBString, actualGBString);
    }


    /* Testing whatsAtPos */

    //Test #1
    @Test
    public void testWhatsAtPos_bottom_left_with_token(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';

        //Calling whatsAtPos(5, 0)
        char actual = actualGB.whatsAtPos(5,0);
        char expected = 'X';
        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking whatsAtPos and the board
        assertEquals(expected, actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #2
    @Test
    public void testWhatsAtPos_bottom_left_empty(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Calling whatsAtPos(5, 0)
        char actual = actualGB.whatsAtPos(5,0);
        char expected = ' ';
        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking whatsAtPos and the board
        assertEquals(expected, actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #3
    @Test
    public void testWhatsAtPos_top_left_with_token(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[4][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[2][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[1][0] = 'X';
        //Last token placed
        actualGB.placeToken('A',0);
        expectedGB[0][0] = 'A';

        //Calling whatsAtPos(0, 0)
        char actual = actualGB.whatsAtPos(0,0);
        char expected = 'A';
        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking whatsAtPos and the board
        assertEquals(expected, actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #4
    @Test
    public void testWhatsAtPos_top_left_no_token(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[4][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[3][0] = 'X';
        actualGB.placeToken('O',0);
        expectedGB[2][0] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[1][0] = 'X';

        //Calling whatsAtPos(0, 0)
        char actual = actualGB.whatsAtPos(0,0);
        char expected = ' ';
        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking whatsAtPos and the board
        assertEquals(expected, actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #5
    @Test
    public void testWhatsAtPos_bottom_right_with_token(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',6);
        expectedGB[5][6] = 'X';

        //Calling whatsAtPos(5, 6)
        char actual = actualGB.whatsAtPos(5,6);
        char expected = 'X';
        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking whatsAtPos and the board
        assertEquals(expected, actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #6
    @Test
    public void testWhatsAtPos_bottom_right_no_token(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Calling whatsAtPos(5, 6)
        char actual = actualGB.whatsAtPos(5,6);
        char expected = ' ';
        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking whatsAtPos and the board
        assertEquals(expected, actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #7
    @Test
    public void testWhatsAtPos_top_right_with_token(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',6);
        expectedGB[5][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[4][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[3][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[2][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[1][6] = 'X';
        //Last token placed
        actualGB.placeToken('A',6);
        expectedGB[0][6] = 'A';

        //Calling whatsAtPos(0, 6)
        char actual = actualGB.whatsAtPos(0,6);
        char expected = 'A';
        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking whatsAtPos and the board
        assertEquals(expected, actual);
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #8
    @Test
    public void testWhatsAtPos_top_right_no_token(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',6);
        expectedGB[5][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[4][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[3][6] = 'X';
        actualGB.placeToken('O',6);
        expectedGB[2][6] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[1][6] = 'X';

        //Calling whatsAtPos(0, 6)
        char actual = actualGB.whatsAtPos(0,6);
        char expected = ' ';
        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking whatsAtPos and the board
        assertEquals(expected, actual);
        assertEquals(expectedGBString, actualGBString);
    }

    /* Testing placeToken */

    //Test #1
    @Test
    public void testPlaceToken_one_token_on_empty_board(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking the board
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #2
    @Test
    public void testPlaceToken_filling_half_of_a_column(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[4][3] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[3][3] = 'X';

        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking the board
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #3
    @Test
    public void testPlaceToken_completely_filling_a_column(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[4][3] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[3][3] = 'X';
        actualGB.placeToken('O',3);
        expectedGB[2][3] = 'O';
        actualGB.placeToken('X',3);
        expectedGB[1][3] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[0][3] = 'X';


        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking the board
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #4
    @Test
    public void testPlaceToken_placing_tokens_in_different_columns(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',3);
        expectedGB[5][3] = 'X';
        actualGB.placeToken('X',3);
        expectedGB[4][3] = 'X';
        actualGB.placeToken('O',4);
        expectedGB[5][4] = 'O';
        actualGB.placeToken('O',6);
        expectedGB[5][6] = 'O';
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';



        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking the board
        assertEquals(expectedGBString, actualGBString);
    }

    //Test #5
    @Test
    public void testPlaceToken_completely_filling_a_row(){
        //Creating a IGameBoard object using the factory method
        IGameBoard actualGB = factory(7,6,4);
        //Creating an expected game board using a 2D array
        char [][] expectedGB = new char [6][7];
        //Filling the expectedGB 2D array with empty spaces
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                expectedGB[i][j] = ' ';
            }
        }

        //Placing token
        actualGB.placeToken('X',0);
        expectedGB[5][0] = 'X';
        actualGB.placeToken('O',1);
        expectedGB[5][1] = 'O';
        actualGB.placeToken('X',2);
        expectedGB[5][2] = 'X';
        actualGB.placeToken('O',3);
        expectedGB[5][3] = 'O';
        actualGB.placeToken('X',4);
        expectedGB[5][4] = 'X';
        actualGB.placeToken('O',5);
        expectedGB[5][5] = 'O';
        actualGB.placeToken('X',6);
        expectedGB[5][6] = 'X';



        //Converting the expectedGB array to a string
        String expectedGBString = convertToString(6,7,expectedGB);
        //Converting the actualGB object to a string
        String actualGBString = actualGB.toString();

        //Checking the board
        assertEquals(expectedGBString, actualGBString);
    }

    //Factory method
    private IGameBoard factory(int c, int r, int t){
        return new GameBoard(c, r, t);
    }
    //Method to convert the expected game board to a string
    private String convertToString(int r, int c, char [][] board){
        //Create a string that will hold the string representation of the board
        String str = "";
        //Controls the spaces before single digit numbers
        final int SPACE_FOR_SINGLE_DIGIT_NUMBERS = 10;

        //Loops through numbers 0 - c
        for (int i = 0; i < c; i++){
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
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                //Insert a pipe symbol and whatever is in that spot in the array into the string
                str +=  "|";
                str += board[i][j];
                str += " ";
                //If j equals the last column then add another pipe
                if(j == c - 1){
                    str += "|";
                }
            }
            //Insert a new line at the end of a row into the string
            str += "\n";
        }

        //Returns the string representation of the board
        return str;
    }
}
