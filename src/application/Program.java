package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.BoardExceptions;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner reader = new Scanner(System.in);
		try {
			ChessMatch chessMatch = new ChessMatch();
			while (true) {
				try {
					UI.clearScreen();
					UI.printBoard(chessMatch.getPieces());
					System.out.print("Source: ");
					ChessPosition source = UI.readChessPosition(reader);
					
					boolean[][] possibleMoves = chessMatch.possibleMoves(source);
					UI.clearScreen();
					UI.printBoard(chessMatch.getPieces(), possibleMoves);
					
					System.out.println();
					System.out.print("Target: ");
					ChessPosition target = UI.readChessPosition(reader);
					
					ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				}
				catch (ChessException e) {
					System.out.println(e.getMessage());
					reader.nextLine();
				}
				catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					reader.nextLine();
				}
			}
		} catch (BoardExceptions e) {
			System.out.println(e.getMessage());
		}
		reader.close();
	}
}
