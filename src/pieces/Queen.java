package pieces;

import chess.Position;
import pieces.Allpieces;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Queen extends Allpieces{

	/**
	 * parameterized constructor of Queen that initializes the type to Queen
	 * @param color color of piece
	 */
	public Queen(char color){
		super(color);
		this.type = "QUEEN";
	}

	/**
	 * getColor no-arg method gets the color of the piece
	 * @return char of color either 'w' or 'b'
	 */
	public char getColor(){
		return color;
	}

	/**
	 * toString method that overrides super class Allpieces' toString method
	 */
	public String toString(){
		return super.toString() + "Q";
	}

	/**
	 *  boolean method validMove that returns true if Queen's move 
	 *  is valid else it returns false
	 */
	public boolean validMove(Position start, Position end, char s, boolean path){

		boolean check = super.validMove(start, end, s, path);

		if (check && path == false) {
			if(start.horz == end.horz){
				return true;
			}else if(start.vert == end.vert){
				return true;
			}else if(start.isDiagonal(end)){
				return true;
			}
		}

		return false;

	}


}