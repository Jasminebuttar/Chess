package pieces;
import chess.Position;
import pieces.Allpieces;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Bishop extends Allpieces{
	
	public Bishop(char color){
		super(color);
		this.type = "BISHOP";
	}
		
    public char getColor(){
		return color;
	}
		
    public String toString(){
		return super.toString() + "B";
	}
		
	public boolean validMove(Position start, Position end, char s, boolean path){
		boolean check = super.validMove(start, end, s, path);
			
		if(check && path == false){
			if(start.isDiagonal(end)){
				return true;
			}
		}
		return false;
	}
}


