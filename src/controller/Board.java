package controller;
import chess.Position;
import pieces.*;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Board {
	public int count = 0;
	public boolean blackTurn = true;
	public Squares[][] board;
	public static final int ver = 8;
	public static final int hor = 8;
	
	public Board(){
		board = new Squares[ver][hor];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Squares(new Position(i, j), null);}
		}
        this.loadBoard();
    }
    
    public void loadBoard(){

		char color = 0;

		for(int i = 0; i < ver; i++){
			for(int j = 0; j < hor; j++){
				if(i == 0 || i == 7){
					if(i == 0){
						color = 'b';
					}else{
						color = 'w';
					}
					switch(j){
					case 0: board[i][j].piece = new Rook(color);			
					break;
					case 1: board[i][j].piece = new Knight(color);
					break;
					case 2: board[i][j].piece = new Bishop(color);
					break;
					case 3: board[i][j].piece = new Queen(color);
					break;
					case 4: board[i][j].piece = new King(color);
					break;
					case 5: board[i][j].piece = new Bishop(color);
					break;	
					case 6: board[i][j].piece = new Knight(color);
					break;
					case 7: board[i][j].piece = new Rook(color);
					break;
					default: break;
					}
				}
				else if(i == 1 || i == 6){
					if(i == 1){
						color = 'b';
					}else{
						color = 'w';
					}
					board[i][j].piece = new Pawn(color);
				}
			}
		}
    }

	public void move(Position cell1, Position cell2, String prom){
		Squares start = this.getHorzVert(cell1);
		Squares end = this.getHorzVert(cell2);
		char type = 0;

        Allpieces toMove = start.piece;
		Allpieces toKill = end.piece;
		boolean blocked = this.inPath(cell1, cell2);

		if(start.equals(end)){
			System.out.println();
			System.out.println("Illegal move, try again");
			System.out.println();
			return;
		}
		else if(toMove == null){
			System.out.println("Illegal move, try again");
			return;
		}
		else if(toMove.color == 'b' && blackTurn() == false){
			System.out.println();
			System.out.println("Illegal move, try again");
			System.out.println();
			return;
		}
		else if(toMove.color == 'w' && blackTurn() == true){
			System.out.println();
			System.out.println("Illegal move, try again");
			System.out.println();
			return;
		}
		
		else if(toKill != null){
			type = 'c';
			if(toKill.color == 'b' && blackTurn() == true){
				System.out.println();
				System.out.println("Illegal move, try again");
				System.out.println();
				return;
			}
			if(toKill.color == 'w' && blackTurn() == false){
				System.out.println();
				System.out.println("Illegal move, try again");
				System.out.println();
				return;
			}
		}
		if(checked(start.piece, cell1, cell2)){
			System.out.println();
			System.out.println("King is in Check");
			System.out.println();
		}
		if(toMove.validMove(cell1, cell2, type, blocked)){
			this.move(cell1, cell2);
		}	
	}

    private boolean inPath(Position start, Position end) {
    	if (start.hasSameHorz(end)) {
    		if (start.vert < end.vert) {
				for (int i = start.vert + 1; i < end.vert; i++) {
					if (board[i][start.horz].isEmpty()) {
						return true;
					}
				}
			} else {
				for (int i = start.vert - 1; i > end.vert; i--) {
					if (board[i][start.horz].isEmpty()) {
						return true;
					}
				}
			}
    	} else if (start.hasSameVert(end)) {
			if (start.horz < end.horz) {
				for (int i = start.horz + 1; i < end.horz; i++) {
					if (board[start.vert][i].isEmpty()) {
						return true;
					}
				} 
			} else {
				for (int i = start.horz - 1; i > end.horz; i--) {
					if (board[start.vert][i].isEmpty()) {
						return true;
					}
				} 
			}
		} else if (start.isDiagonal(end)) {
			if (start.isAdjacent(end)) {
				if (!((Squares) this.square(end)).isEmpty()){
					return true;
				} else {

					int changeInHorz;
					int changeInVert;
					int currentVert = start.vert;
					int currentHorz = start.horz;

					if (end.horz > start.horz) {
						changeInHorz = 1;
					} else {
						changeInHorz = -1;
					}
					if (end.vert > start.vert) {
						changeInVert = 1;
					} else {
						changeInVert = -1;
					}

					currentVert += changeInVert;
					currentHorz += changeInHorz;

					while (currentHorz != end.horz && currentVert != end.vert) {
						currentHorz += changeInHorz;
						currentVert += changeInVert;
					}
				}
			}
		}
		return false;
	}
    
	private boolean checked(Allpieces piece, Position begin, Position end){
		int currVert = end.vert;
		int currHorz = end.horz;
		Squares left = this.board[end.vert][end.horz-1];
		Squares right = this.board[end.vert][end.horz+1];
		Squares up = this.board[end.vert+1][end.horz];
		Squares down = this.board[end.vert-1][end.horz];
		Squares rightDiagonal = this.board[end.vert+1][end.horz+1];
		Squares leftDiagonal = this.board[end.vert+1][end.horz-1];
		
		if(piece.type.equals("PAWN")){
			if(rightDiagonal.piece == null){
				return false;
			}
			if(leftDiagonal.piece == null){
				return false;
			}
			if(rightDiagonal.piece.type.equals("KING") && rightDiagonal.piece.isBlack != blackTurn()){
				return true;
			}
			if(leftDiagonal.piece.type.equals("KING") && rightDiagonal.piece.isBlack != blackTurn()){
				return true;
			}
		}
		return false;
	}

	public void move(Position cellOne, Position cellTwo){
		this.board[cellOne.vert][cellOne.horz].piece.move++;
		this.board[cellTwo.vert][cellTwo.horz].piece = this.board[cellOne.vert][cellOne.horz].piece;
		this.board[cellOne.vert][cellOne.horz].piece = null;
		this.count++;
		this.blackTurn = (count % 2 == 0);
	}

	public String toString() {
		String str = "";
		int count = 8;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				str += this.board[i][j].toString() + " ";
			}
			str += (count) + "\n";
			count--;
		}
		str += " a  b  c  d  e  f  g  h\n";
		return str;
	}

	public boolean blackTurn(){
		return !blackTurn;
	}

	private Squares getHorzVert(Position p){
		return board[p.vert][p.horz];
	}
	
	public static boolean isEqual(Object o1, Object o2){
	    return o1 == o2 || (o1 != null && o1.equals(o2));
	}
	
	private Object square(Position p) {
		return board[p.vert][p.horz];
	}

}

