package pieces;

import chess.Position;
import pieces.Allpieces;
/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Pawn extends Allpieces {

	/**
	 * parameterized constructor of Queen that initializes the type to Pawn
	 * @param color color of piece
	 */
	public Pawn(char color){
		super(color);
		this.type = "PAWN";
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
		return super.toString() + "P";
	}
	
	/**
	 * boolean method validMove that returns true if Pawn's move 
	 * is valid else it returns false
	 */
	public boolean validMove(Position start, Position end, char s, boolean path){
		
		boolean check = super.validMove(start, end, s, path);

		
		if(check){
			if(s == 'c' && (start.vert - 1 == end.vert || start.vert + 1 == end.vert)){
					if(this.color == 'w'){
						if ((start.horz - 1 == end.horz)||(start.horz + 1 == end.horz)){
							return true;
						}
						else{
							return false;
						}
					}	
					if(this.color == 'b'){
							if ((start.horz - 1 == end.horz)||(start.horz + 1 == end.horz)){
							return true;
							}
							else{
								return false;
							}
					}
				}
		}
		
		if(this.move == 0){
			if(start.horz == end.horz){
				if(this.color == 'w'){
						if (start.vert - 1 == end.vert || start.vert - 2 == end.vert){			
							return true;
						}
						else{
							return false;
						}	
				}
				if(this.color == 'b'){
					if (start.vert + 1 == end.vert || start.vert + 2 == end.vert){
						return true;
					}
					else{
						return false;
					}
				}
				
			}
		}
		else{
			if(this.color == 'w'){
				if (start.vert - 1 == end.vert){
					return true;
				}
				else{
					return false;
				}
			}
			if(this.color == 'b'){
				if (start.vert + 1 == end.vert){
					return true;
				}
				else{
					return false;
				}
			}
		}
		
		return false;
	}	

}