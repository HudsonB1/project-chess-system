package application;

import boardgame.BoardExceptions;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		try {
			ChessMatch chessMatch = new ChessMatch();
			UI.printBoard(chessMatch.getPieces());
		} catch (BoardExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
