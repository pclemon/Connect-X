# Paige Clemons (pclemon)
# Lab Section 5
# Homework 4
# Due: 11/18/18

default:cpsc2150/connectX/
	javac cpsc2150/connectX/Connect4Game.java cpsc2150/connectX/GameBoard.java cpsc2150/connectX/IGameBoard.java cpsc2150/connectX/GameBoardMem.java
run:cpsc2150/connectX/
	java cpsc2150.connectX.Connect4Game cpsc2150.connectX.GameBoard cpsc2150.connectX.IGameBoard cpsc2150.connectX.GameBoard.java
test: cpsc2150/connectX/
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/connectX/Connect4Game.java cpsc2150/connectX/GameBoard.java cpsc2150/connectX/IGameBoard.java cpsc2150/connectX/GameBoardMem.java cpsc2150/connectX/TestIGameBoard.java
runtest: cpsc2150/connectX/Connect4Game.class cpsc2150/connectX/GameBoard.class cpsc2150/connectX/IGameBoard.class cpsc2150/connectX/GameBoardMem.class cpsc2150/connectX/TestIGameBoard.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.connectX.TestIGameBoard
clean:
	rm -f cpsc2150/connectX/*.class
