package app;
import Controller.*;

import java.util.*;

public class Chess {
	
	public static void main(String[] args) throws Exception{
		Controller c = new Controller();
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		while (!c.end){
			System.out.println(c.getBoardString());
			System.out.println(c.blackTurn() ? "Black's turn: " : "White's turn: ");
			String arg = scan.nextLine();
			if(arg.equals("resign")){
				if(c.blackTurn() == true){
					System.out.println("White wins!");
				}
				else{
					System.out.println("Black Wins");
				}
				c.resign();
			}
			boolean draw = false;
			if(arg.contains("draw?")){
				draw = true;
			}
			if(arg.equals("draw")){
				if(draw == true){
					System.out.println("Draw");
					c.end = true;
				}
			}
			if(arg.length() == 5 && !arg.equals("draw?")){
				char horz1 = arg.charAt(0);
				char vert1 = arg.charAt(1);
				char horz2 = arg.charAt(3);
				char vert2 = arg.charAt(4);
			
				
			
				c.move(horz1, vert1, horz2, vert2, null);
			
			}
			
			if(arg.length() == 7){
				char horz1 = arg.charAt(0);
				char vert1 = arg.charAt(1);
				char horz2 = arg.charAt(3);
				char vert2 = arg.charAt(4);
				
				String toPromote = arg.substring(5, 6);
				
				
			
				c.move(horz1, vert1, horz2, vert2, toPromote);
			}
			
		}
		
	}

}



	