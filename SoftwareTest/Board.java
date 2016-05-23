package SoftwareTest;

public class Board{
	
	private String[][] board;
	private boolean winner;
	
	public Board(){
		board = new String[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = " ";
			}
		}
		winner = false;
	}
	
	public void setMark(String mark, int x, int y) throws Exception {
		if(x >=0 && x <= 2 && y >=0 && y <= 2){
			board[x][y] = mark;
			System.out.println("Markierung wurde gesetzt");
		}
		else {
			throw new Exception("ungültige Markierung");
		}
	}
	
	public boolean hasWinner(){
		if((board[0][0].equalsIgnoreCase("X") && board[0][1].equalsIgnoreCase("X") && board[0][2].equalsIgnoreCase("X")) ||//erste Reihe
		   (board[1][0].equalsIgnoreCase("X") && board[1][1].equalsIgnoreCase("X") && board[1][2].equalsIgnoreCase("X")) ||//zweite Reihe
		   (board[2][0].equalsIgnoreCase("X") && board[2][1].equalsIgnoreCase("X") && board[2][2].equalsIgnoreCase("X")) ||//dritte Reihe
		   (board[0][0].equalsIgnoreCase("X") && board[1][1].equalsIgnoreCase("X") && board[2][2].equalsIgnoreCase("X")) ||//Diagonal links rechts
		   (board[2][0].equalsIgnoreCase("X") && board[1][1].equalsIgnoreCase("X") && board[0][2].equalsIgnoreCase("X")) ||//Diagonal rechts links 
		   (board[0][0].equalsIgnoreCase("X") && board[1][0].equalsIgnoreCase("X") && board[2][0].equalsIgnoreCase("X")) ||//erste Spalte
		   (board[0][1].equalsIgnoreCase("X") && board[1][1].equalsIgnoreCase("X") && board[2][1].equalsIgnoreCase("X")) ||//zweite Spalte
		   (board[0][2].equalsIgnoreCase("X") && board[1][2].equalsIgnoreCase("X") && board[2][2].equalsIgnoreCase("X"))   //dritte Spalte
		){
			winner = true;
		}
		else if((board[0][0].equalsIgnoreCase("O") && board[0][1].equalsIgnoreCase("O") && board[0][2].equalsIgnoreCase("O")) ||//erste Reihe
				(board[1][0].equalsIgnoreCase("O") && board[1][1].equalsIgnoreCase("O") && board[1][2].equalsIgnoreCase("O")) ||//zweite Reihe
				(board[2][0].equalsIgnoreCase("O") && board[2][1].equalsIgnoreCase("O") && board[2][2].equalsIgnoreCase("O")) ||//dritte Reihe
				(board[0][0].equalsIgnoreCase("O") && board[1][1].equalsIgnoreCase("O") && board[2][2].equalsIgnoreCase("O")) ||//Diagonal links rechts
				(board[2][0].equalsIgnoreCase("O") && board[1][1].equalsIgnoreCase("O") && board[0][2].equalsIgnoreCase("O")) ||//Diagonal rechts links 
				(board[0][0].equalsIgnoreCase("O") && board[1][0].equalsIgnoreCase("O") && board[2][0].equalsIgnoreCase("O")) ||//erste Spalte
				(board[0][1].equalsIgnoreCase("O") && board[1][1].equalsIgnoreCase("O") && board[2][1].equalsIgnoreCase("O")) ||//zweite Spalte
				(board[0][2].equalsIgnoreCase("O") && board[1][2].equalsIgnoreCase("O") && board[2][2].equalsIgnoreCase("O"))   //dritte Spalte
		){
			winner = true;
		}
		return winner;
	}
}