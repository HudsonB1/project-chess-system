package application;

import java.util.Scanner;

import boardgame.BoardExceptions;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		try {
			ChessMatch chessMatch = new ChessMatch();
			while (true) {
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(reader);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(reader);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
		} catch (BoardExceptions e) {
			System.out.println(e.getMessage());
		}
		reader.close();
	}
}
