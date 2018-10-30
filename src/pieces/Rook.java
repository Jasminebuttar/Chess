package pieces;
import chess.Position;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Rook extends Allpieces{
	
	public Rook(char color){
		super(color);
		this.type = "ROOK";
	}
	
	
	public char getColor(){
		return color;
	}
	
	public String toString(){
		return super.toString() + "R";
	}
	
	public boolean validMove(Position start, Position end, char s, boolean path){
		boolean check = super.validMove(start, end, s, path);
		
		if(check && path == false){
			if(start.vert == end.vert){
				return true;
			}else if(start.horz == end.horz){
				return true;
			}	
		}
		return false;
	}
}

