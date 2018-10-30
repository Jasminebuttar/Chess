package pieces;

import chess.Position;
import pieces.Allpieces;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Knight extends Allpieces {
	
	public Knight(char color){
		super(color);
		this.type = "KNIGHT";
	}
	
	
	public char getColor(){
		return color;
	}
	
	public String toString(){
		return super.toString() + "I";
	}
	
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