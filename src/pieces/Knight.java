package pieces;

import chess.Position;
import pieces.Allpieces;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Knight extends Allpieces {
	/**
	 * parameterized constructor Knight which initializes the type of the piece to Knight
	 * @param color color of piece
	 */
	public Knight(char color){
		super(color);
		this.type = "KNIGHT";
	}
	
	/**
	 * getColor no-arg method that gets the color of the piece
	 * @return char stating the piece color whether it 
	 * is 'b' = black or 'w' = white
	 */
	public char getColor(){
		return color;
	}
	
	/**
	 * toString method that overrides super class Allpieces' toString method
	 */
	public String toString(){
		return super.toString() + "N";
	}
	
	/**
	 * boolean method validMove that returns true if Knight's move 
	 * is valid else it returns false
	 */
	public boolean validMove(Position start, Position end, char s, boolean path){
		
		boolean check = super.validMove(start, end, s, path);

		if (check) {
			if (((start.vert + 2 == end.vert || start.vert - 2 == end.vert)&&
			   (start.horz + 1 == end.horz || start.horz - 1 == end.horz))||
			   ((start.horz + 2 == end.horz || start.horz - 2 == end.horz)&&
			   (start.vert + 1 == end.vert || start.vert - 1 == end.vert))){
					return true;
				} 
		}

		return false;

	}

}