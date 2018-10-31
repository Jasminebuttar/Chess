package chess;

/**
 * @author Jasmine Buttar
 * @author Zalak Shingala
 *
 */
public class Position {
		
	public int horz;
	public int vert;
	
	public Position(int h, int v)
	{
		this.horz = h;
		this.vert = v;
	}
		
	public Position(char h, char v) throws Exception
	{
		int hNum = getHorz(h);
		int vNum = getVert(v);
			
		if(hNum > 7 || hNum < 0)
		 System.out.println("Invalid File");
			
		if(vNum > 7 || v < 0)
		 System.out.println("Invalid Rank");
			
		this.horz = hNum;
		this.vert = vNum;
	}
		
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
		
	public int getVert(char v)
	{
	    int num  = Character.getNumericValue(v);
		switch(num){
		 case 1: return 7;
		 case 2: return 6;
		 case 3: return 5;
		 case 4: return 4;
		 case 5: return 3;
		 case 6: return 2;
		 case 7: return 1;
		 case 8: return 0;
		}
	 return -1;
	}
	
	public boolean hasSameHorz(Position p) 
	{
		if (this.horz == p.horz)
			return true;
		else
			return false;
	}

	public boolean hasSameVert(Position p) 
	{
		if (this.vert == p.vert)
			return true;
		else
			return false;
	}
		
	public int getSlope(Position p){
		int vert1 = this.vert + 1;
		int horz1 = this.horz + 1;
        int vert2 = p.vert + 1;
		int horz2 = p.horz + 1;
        int denominator = horz1 - horz2;
        
		if(denominator != 0)
		  return (vert1 - vert2) / denominator;
		else
          return 0;
		}
		
	public boolean isDiagonal(Position p){
		if (this.equals(p)) 
		  return false;
		else
		{
		  int slope = this.getSlope(p);
			if (slope == 1 || slope == -1)
				return true;
			else
				return false;
		}
	}

    public boolean isAdjacent(Position p) {
		if(this.vert == p.vert){
			if(this.horz <= p.horz + 1 && this.horz >= p.horz - 1){
				return true;
		    }
		}else if(this.horz == p.horz){
			if (this.vert <= p.vert + 1 && this.vert >= p.vert - 1){
				return true;
			}
		}
		return false;
	}
 }
		
	



