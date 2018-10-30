package Controller;

import app.Position;
import Controller.Board;

public class Controller {
	
	private Board board;
	
	public boolean end;
	
	public Controller(){
		this.board = new Board();
	}
	
	public void resign(){
		end = true;
	}
	
	public void move(char horz1, char vert1, char horz2, char vert2, String promote) throws Exception{
		Position x;
		Position y;
		
		if(promote != null){
			if(promote != "R" || promote != "B" || promote != "Q" || promote != "N"){
				System.out.println("Invalid promotion");
			}
		}
		x = new Position(horz1, vert1);
		y = new Position(horz2, vert2);
		
		if(x != null && y != null){
			board.move(x, y, promote);
		}
	}
	
	public String getBoardString(){
		return this.board.toString();
	}
	
	public boolean blackTurn(){
		return board.blackTurn();
		
	}

}