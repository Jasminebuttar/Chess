package chess;

import java.util.*;

import controller.*;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Chess {
	
	public static void main(String[] args){
	
		
		Controller c = new Controller();
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		/**
		 * loop until a player resigns or wins or there is a draw
		 */
		while (!c.end){
			System.out.println(c.getBoardString());
			
			/**
			 * if black's turn print "Black's turn", else print "White's turn"
			 */
			System.out.println(c.blackTurn() ? "Black's turn: " : "White's turn: ");
			String arg = scan.nextLine();
			
			/**
			 * if a player resigns, other player automatically wins the game
			 */
			if(arg.equals("resign")){
				if(c.blackTurn() == true){
					System.out.println("White wins!");
				}
				else{
					System.out.println("Black Wins!");
				}
				c.resign();
			}
			boolean draw = false;
			if(arg.contains("draw?")){
				draw = true;
			}
			
			/**
			 * if argument is "draw", then end game
			 */
			if(arg.equals("draw")){
				if(draw == true){
					System.out.println("Draw");
					c.end = true;
				}
			}
			/**
			 * example input: e2 e4 <-- length = 5
			 */
			if(arg.length() == 5 && !arg.equals("draw?")){
				char horz1 = arg.charAt(0);
				char vert1 = arg.charAt(1);
				char horz2 = arg.charAt(3);
				char vert2 = arg.charAt(4);
				
				/**
				 * calling move from Controller class through instance c
				 */
				try {
					c.move(horz1, vert1, horz2, vert2, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
			
			/**
			 * example input for promoting: e2 e4 Q
			 */
			if(arg.length() == 7){
				char horz1 = arg.charAt(0);
				char vert1 = arg.charAt(1);
				char horz2 = arg.charAt(3);
				char vert2 = arg.charAt(4);
				
				String toPromote = arg.substring(5, 6);
				
				/**
				 * calling move from Controller class through instance c
				 */
				try {
					c.move(horz1, vert1, horz2, vert2, toPromote);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}



	

	