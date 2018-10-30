package Pieces;

import Pieces.Allpieces;
import app.Position;

public class Queen extends Allpieces{

	public Queen(char color){
		super(color);
		this.type = "QUEEN";
	}


	public char getColor(){
		return color;
	}

	public String toString(){
		return super.toString() + "Q";
	}

	public boolean validMove(Position start, Position end, char s, boolean path){

		boolean check = super.validMove(start, end, s, path);

		if (check && path == false) {
			if(start.horz == end.horz){
				return true;
			}else if(start.vert == end.vert){
				return true;
			}else if(start.isDiagonalTo(end)){
				return true;
			}
		}

		return false;

	}


}