package pieces;

import chess.Position;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class King extends Allpieces{
	
	public King(char color){
		super(color);
		this.type = "KING";
	}
	
	public char getColor(){
		return color;
	}
	
	public String toString(){
		return super.toString() + "K";
	}
	/**
	 * This method defines valid move for the king piece
	 */
	public boolean validMove(Position start, Position end, char s, boolean path){
		boolean validityCheck = super.validMove(start, end, s, path);
		
		if(validityCheck && path == false){
			if(start.isAdjacent(end)){
				return true;
			}
			if(start.isDiagonal(end)){
				return true;
			}
			
		}
		return false;
	}
}

