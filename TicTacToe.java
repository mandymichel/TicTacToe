import static java.lang.System.out;

import java.util.Scanner;

public class TicTacToe {
	static char PLACEHOLDER = '.';
	static char marker = 'X';
	static int xWins = 0;
	static int oWins = 0;
	static int draws = 0;
	static Scanner keyboard = new Scanner(System.in);

	public static void drawBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				out.print(board[i][j] + "|");
			}
			out.println();
		}
	}

	public static char[][] createEmptyBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = PLACEHOLDER;
				out.print(board[i][j] + "|");
			}
			out.println();
		}
		out.println();
		return board;
	}

	public static boolean isWin(char[][] board) {
		return true;
	}

	public static boolean isFull(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == PLACEHOLDER) {
					return false;
				}
			}
		}
		out.println("The board is full!");
		return true;
	}

	public static boolean isHorizontalWin(char[][] board) {
		boolean isOver = false;

		if ((board[0][0] == marker) && (board[0][1] == marker) && (board[0][2] == marker)) {
			out.println(marker + " is the winner!");
			if (marker == 'X') {
				xWins++;
			} else {
				oWins++;
			}
			isOver = true;
			return isOver;
		}

		if ((board[1][0] == marker) && (board[1][1] == marker) && (board[1][2] == marker)) {
			out.println(marker + " is the winner!");
			if (marker == 'X') {
				xWins++;
			} else {
				oWins++;
			}
			isOver = true;
			return isOver;
		}

		if ((board[2][0] == marker) && (board[2][1] == marker) && (board[2][2] == marker)) {
			out.println(marker + " is the winner!");
			if (marker == 'X') {
				xWins++;
			} else {
				oWins++;
			}
			isOver = true;
			return isOver;
		}

		return isOver;
	}

	public static boolean isVerticalWin(char[][] board) {
		boolean isOver = false;

		if ((board[0][0] == marker) && (board[1][0] == marker) && (board[2][0] == marker)) {
			out.println(marker + " is the winner!");
			if (marker == 'X') {
				xWins++;
			} else {
				oWins++;
			}
			isOver = true;
			return isOver;
		}

		if ((board[0][1] == marker) && (board[1][1] == marker) && (board[2][1] == marker)) {
			out.println(marker + " is the winner!");
			if (marker == 'X') {
				xWins++;
			} else {
				oWins++;
			}
			isOver = true;
			return isOver;
		}

		if ((board[0][2] == marker) && (board[1][2] == marker) && (board[2][2] == marker)) {
			out.println(marker + " is the winner!");
			if (marker == 'X') {
				xWins++;
			} else {
				oWins++;
			}
			isOver = true;
			return isOver;
		}
		return isOver;
	}

	public static boolean isDiagonalWin(char[][] board) {
		boolean isOver = false;

		if ((board[0][0] == marker) && (board[1][1] == marker) && (board[2][2] == marker)) {
			out.println(marker + " is the winner!");
			if (marker == 'X') {
				xWins++;
			} else {
				oWins++;
			}
			isOver = true;
			return isOver;
		}

		if ((board[0][2] == marker) && (board[1][1] == marker) && (board[2][0] == marker)) {
			out.println(marker + " is the winner!");
			if (marker == 'X') {
				xWins++;
			} else {
				oWins++;
			}
			isOver = true;
			return isOver;
		}
		return isOver;
	}

	public static void printWelcome() {
		out.println("Welcome to Tic Tac Toe!");
		out.println("To play, enter a number for which box to play in.");
		out.println("1 2 3");
		out.println("4 5 6");
		out.println("7 8 9");
		out.println("You'll need a buddy to play with.  Ready to begin?  Here we go.");
		out.println("X goes first. Enter a number.");
	}

	public static boolean wantsToPlayAgain() {
		return true;
	}

	public static void placeToken(int gridchoice, char[][] board, boolean isXTurn) {
		if (isXTurn) {
			marker = 'X';
		} else {
			marker = 'O';
		}
		int row = (gridchoice - 1) / 3;
		int col = (gridchoice - 1) % 3;

		if (board[row][col] != PLACEHOLDER) {
			out.println("That space has already been taken. Choose another space.");
			gridchoice = keyboard.nextInt();
			row = (gridchoice - 1) / 3;
			col = (gridchoice - 1) % 3;
		}
		board[row][col] = marker;
		drawBoard(board);
	}

	public static void getPositionAndPlaceToken(char[][] board, boolean isXTurn) {
		int gridchoice = 0;

		placeToken(gridchoice, board, isXTurn);
	}

	public static void game() {

		boolean doesXStart = true;
		boolean isXTurn = doesXStart;
		boolean isOver = false;
		String wantsToPlayAgain = "yes";
		int gridchoice = 0;
		char[][] board = new char[3][3];

		do {
			// initialize for the beginning of a new game.
			printWelcome();
			boolean gameStillGoing = true;
			createEmptyBoard(board);
			// play the game until it's complete. single-game loop.
			do {
				do {
					gridchoice = keyboard.nextInt();
				} while ((gridchoice > 9) || (gridchoice < 0));
				if (gridchoice == 0) {
					gameStillGoing = false;
					break;
				}
				placeToken(gridchoice, board, isXTurn);
				isOver = isDiagonalWin(board) || isHorizontalWin(board) || isVerticalWin(board);
				if (isOver) {
					gameStillGoing = false;
				}
				if (isFull(board)) {
					draws++;
					gameStillGoing = false;
				}
				if (!isOver) {
					if (isXTurn) {
						isXTurn = false;
						out.println("O's turn!");
					} else {
						isXTurn = true;
						out.println("X's turn!");
					}
				}
			} while (gameStillGoing);
			System.out.println("Score: X=" + xWins + ", O=" + oWins + ", Draws=" + draws);
			out.println("Do you want to play again? ");
			wantsToPlayAgain = keyboard.next();
		} while (wantsToPlayAgain.equals("yes") || wantsToPlayAgain.equals("y"));

		// They're done playing. Method will return and program will finish.
	}

	public static void main(String[] args) {
		game();
		System.out.println("Goodbye!");
	}

}
