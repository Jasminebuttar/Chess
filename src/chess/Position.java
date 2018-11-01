package chess;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Position {
	
	/**
	 * declaring variable for the location of the piece
	 */
	public int horz;
	public int vert;
	
	/**
	 * Parameterized constructors for Position
	 * @param h horizontal coordinate
	 * @param v vertical coordinate
	 */
	public Position(int h, int v)
	{
		this.horz = h;
		this.vert = v;
	}
	/**
	 * 
	 * @param h horizontal coordinate
	 * @param v vertical coordinate
	 * @throws Exception when  hNum or vNum goes out of bounds
	 */
	public Position(char h, char v) throws Exception
	{
		/**
		 * assigning int values to hNum and vNum by calling getHorz(h) and getVert(v) methods
		 */
		int hNum = getHorz(h);
		int vNum = getVert(v);
		
		/**
		 * if hNum or vNum goes out of bounds(bound: 0<=x<=7), printing Invalid
		 */
		if(hNum > 7 || hNum < 0)
		 System.out.println("Invalid File");
		if(vNum > 7 || vNum < 0)
		 System.out.println("Invalid Rank");
		
		/**
		 * assigning the values of hNum and vNum to the horz and vert fields or current object
		 */
		this.horz = hNum;
		this.vert = vNum;
	}
	
	/**
	 * method getHorz which takes a character from a through 
	 * returns the corresponding int value 0 through 7
	 * @param h scan and get horizontal coordinate
	 * @return int value for h
	 */
	
	public int getHorz(char h)
	{
		switch(h){
		 case 'a': return 0;
		 case 'b': return 1;
		 case 'c': return 2;
		 case 'd': return 3;
    	 case 'e': return 4;
		 case 'f': return 5;
		 case 'g': return 6;
		 case 'h': return 7;
		}
	 return -1;	
	}
		
	/**
	 * method getVert which takes a character from 8 through 1 
	 * in reverse returns the corresponding int value 0 through 7
	 * @param v scan and get vertical coordinate
	 * @return int value for v
	 */
	public int getVert(char v)
	{
	    int num  = Character.getNumericValue(v);
		switch(num){
			case 8: return 0;
			case 7: return 1;
			case 6: return 2;
			case 5: return 3;
			case 4: return 4;
			case 3: return 5;
			case 2: return 6;
			case 1: return 7;
		 
		}
	 return -1;
	}
	
	/**
	 * method hasSameHorz takes parameter p of type Position 
	 * and checks horizontal value of new and old position is equal or not
	 * @param p position of passed arg p(horz and vert)
	 * @return boolean value stating whether p's horz value is equal to the current object's horz value 
	 */
	public boolean hasSameHorz(Position p) 
	{
		if (this.horz == p.horz){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * method hasSameVert takes parameter p of type Position 
	 * and checks vertical value of new and old position is equal or not
	 * @param p position of passed arg p(horz and vert)
	 * @return boolean value stating whether p's vert value is equal to the current object's vert value
	 */
	public boolean hasSameVert(Position p) 
	{
		if (this.vert == p.vert){
			return true;
		}
		else{
			return false;
		}
	}
		
	/*public int getSlope(Position p){
		int vert1 = this.vert + 1;
		int horz1 = this.horz + 1;
        int vert2 = p.vert + 1;
		int horz2 = p.horz + 1;
        int d = horz1 - horz2;
        
		if(d != 0){
		  return (vert1 - vert2) / d;
		}
		else{
          return 0;
		}
	}*/
		
	/**
	 * isDiagonal checks if the new position is diagonally adjacent to the old position or not
	 * @param p position of passed arg p(horz and vert)
	 * @return boolean value stating whether p is diagonally adjacent to the current position or not
	 */
	public boolean isDiagonal(Position p){
		if (this.equals(p)) {
		  return false;
		}
		else
		{
			int vert1 = this.vert + 1;
			int horz1 = this.horz + 1;
	        int vert2 = p.vert + 1;
			int horz2 = p.horz + 1;
	        int d = horz1 - horz2;
	        int slope=0;
			if(d != 0){
	          slope =  (vert1 - vert2) / d;
			}
			if (slope == 1 || slope == -1){
				return true;
			}
			else{
				return false;
			}
		}
	}

	
	/**
	 * isAdjacent checks if the new position is adjacent to the old position or not
	 * @param p p position of passed arg p(horz and vert)
	 * @return boolean value stating whether p is  adjacent to the current position or not
	 */
    public boolean isAdjacent(Position p) {
		if((this.vert == p.vert)&&(this.horz <= p.horz + 1 && this.horz >= p.horz - 1)){
				return true;
		}
		
		else if((this.horz == p.horz)&&(this.vert <= p.vert + 1 && this.vert >= p.vert - 1)){
				return true;
		}
		
		return false;
	}
 }