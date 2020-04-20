
public class Board {
	
	int[][][] board;
	final int MIN_LEVEL = 3;
	final int MIN_SIZE = 3;
	int level;
	int size;
	
	public Board() {
		level=3;
		size=3;
		
		board = createBoard(this.level, this.size);
		
	}
	
	public Board(int L, int S) {
		this.level = L;
		this.size = S;
		
		board = createBoard(this.level, this.size);
	}
	
	private int[][][] createBoard(int L, int S) {
		int X, Y, Z = 0;
		int[][][] Board = new int[L][S][S];
		
		for(Z=0; Z<L;Z++) {
			
			for(Y=0; Y<S;Y++) {	

				 for(X = 0; X < S ; X++) {
					 
						if(X==0 && Y==0) {
							X++;
						}

					 if((X+Y+Z)%3==0) {
						 Board[Z][X][Y]=-3;
					 }else if((X+Y+Z)%5==0) {
						 Board[Z][X][Y]=-2;
					 }else if((X+Y+Z)%7==0) {
						 Board[Z][X][Y]=2;
					 }else {
						 Board[Z][X][Y]=0;
					 }
					 
				}
				 

			}
			
		}	

	return Board;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getEnergyAdj(int L, int X, int Y) {
		return board[L][X][Y];
	}
	
	public String toString() {
	
		for (int a = 0; a <  getLevel(); a++){
			
			System.out.println("Level "+a);
			System.out.println("----------");
	          for (int b = 0; b < getSize(); b++){
	            System.out.print("\t");
	        	  for (int c = 0; c <  getSize(); c++){
	            	  System.out.print( board[a][b][c]+"\t");
	            	  if(c==( getSize()-1)) {
	            		  System.out.print("\n");
	            	  }

	              }
	        	  if(b==( getSize()-1)) {
	        		  System.out.println("");
	        		  System.out.println("");

	        		  
	        	  }
	            }

	    }
		
		return " " ;


	}
	
}
	
	

