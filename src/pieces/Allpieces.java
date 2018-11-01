package pieces;

import java.util.ArrayList;
import chess.Position;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public abstract class Allpieces 
{
    public char color;
	public String type;
	public int move;
	public boolean isBlack;

	/**
	 * initializing members of the constructor: color to passed arg cl 
	 * and default values to type and move
	 * @param cl color of piece
	 */
	public Allpieces(char cl){
		this.color = cl;
	    this.type = null;
		this.move = 0;	
	}
	
	
	/**
	 * toString method returning string that contains 
	 * character of color 'w' or 'b'
	 */
	public String toString(){
		return this.color + "";
	}
	public ArrayList<Position> deepestMoves(Position startAdd) {
		return null;
	}

	
	public boolean validMove(Position start, Position end, char s, boolean path){
		float distance = (float) Math.sqrt(Math.pow(end.horz - start.horz, 2) + Math.pow(end.vert - start.vert,2));
		if(distance <= 7)
			return true;
		else
			return false;
	}
	
	
}

