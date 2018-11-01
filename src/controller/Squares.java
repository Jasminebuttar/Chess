package controller;

import chess.Position;
import pieces.Allpieces;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Squares {
	
	public Position current;
	public Allpieces piece;
	
	public boolean isEmpty(){
		return this.piece == null;
	}
	/**
	 * 
	 * @param curr is current position of the piece
	 * @param piece defines the nature of the piece
	 */
	public Squares(Position curr, Allpieces piece){
		this.current = curr;
		this.piece = piece;
	}
	/**
	 * This method lays out white and black squares on the chess board
	 */
	public String toString(){
		if (this.piece == null) {
			if ((this.current.horz % 2 == 0 && this.current.vert % 2 == 0) || (this.current.horz % 2 != 0 && this.current.vert % 2 != 0)) {
				return "  ";
			} else {
				return "##";
			}
		} else {
			return this.piece.toString();
		}
	}
}

