package Controller;

import Pieces.Allpieces;
import app.Position;

public class Squares {
	
	public Position current;
	public Allpieces piece;
	
	public boolean isEmpty(){
		return this.piece == null;
	}
	
	public Squares(Position curr, Allpieces piece){
		this.current = curr;
		this.piece = piece;
	}
	
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

