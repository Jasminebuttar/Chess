package controller;

import chess.Position;
import controller.Board;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Controller {
	
	private Board board;
	
	public boolean end;
	
	/**
	 * no argument constructor
	 */
	public Controller(){
		this.board = new Board();
	}
	
	/**
	 * void method resign() which assigns "true" value to boolean variable end
	 */
	public void resign(){
		end = true;
	}
	
	/**
	 * move the piece or promote to Queen, Knight, Rook, or Bishop
	 * @param horz1 horizontal coordinate of source position
	 * @param vert1 vertical coordinate of source position
	 * @param horz2 horizontal coordinate of destination position
	 * @param vert2 vertical coordinate of destination position
	 * @param promote promotion of the current piece whatever specified
	 * @throws Exception promote could be null, Q, N, B, R and if something else print invalid promotion
	 */
	public void move(char horz1, char vert1, char horz2, char vert2, String promote) throws Exception{
		
		/**
		 * if promote is not null, Queen, Knight, Rook, or Bishop, print "Invalid promotion"
		 */
		if((promote != null)&&(promote != "Q" || promote != "N" || promote != "R" || promote != "B")){
				System.out.println("Invalid promotion");
		}
		
		Position x = new Position(horz1, vert1);//source position(move from)
		Position y = new Position(horz2, vert2);//destination position(move to)
		
		/**
		 * if source or destination position is not null, calling move from Board class via board instance
		 */
		if(x != null && y != null){
			board.move(x, y, promote);
		}
	}
	
	public String getBoardString(){
		return this.board.toString();
	}
	
	/**
	 * boolean return method blackTurn() which returns true if it is black's turn and returns false if it is white's turn	
	 * @return boolean value stating whether it is black's turn or not
	 */
	public boolean blackTurn(){
		return board.blackTurn();
		
	}

}