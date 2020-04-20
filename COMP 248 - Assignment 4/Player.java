
public class Player {
		String name;
		int level;
		int x,y;
		int energy;
		
		public Player() {
			this.name="";
			this.level=0;
			this.x=0;
			this.y=0;
			this.energy=10;
		}
		
		public Player(String name) {
			this.name=name;
		}
		
		public Player(int level, int x, int y) {
			this.level=level;
			this.x=x;
			this.y=y;
		}
		
		public Player(Player B) {
			name=B.name;
			level=B.level;
			x=B.x;
			y=B.y;
			energy=B.energy;
		}
		
		public String getName() {
			return name;
		}
		
		public int getLevel() {
			return level;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public int getEnergy() {
			return energy;
		}
		
		public void setName(String Name) {
			this.name=Name;
		}
		
		public void setLevel(int Level) {
			this.level=Level;
		}
		
		public void setX(int X) {
			this.x=X;
		}
		
		public void setY(int Y) {
			this.y=Y;
		}
		
		public void setEnergy(int Energy) {
			this.energy=Energy;
		}
		
		public void moveTo(Player B) {
			
			int tempLevel=this.level;
			int tempX=this.x;
			int tempY=this.y;
			
			this.level=B.level;
			this.x=B.x;
			this.y=B.y;
			
			B.level=tempLevel;
			B.x=tempX;
			B.y=tempY;
			
		}
		
		public boolean won(Board B) {
			if(this.level==(B.level-1) && this.x==(B.size-1) && this.y==(B.size-1)) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean equals(Player B) {
			if(this.level==B.level && this.x==B.x && this.energy==B.y) {
				return true;
			}else {
				return false;
			}
		}
		
		public String toString() {
			return name +" is on level " + level + " at location ("+ x +"," + y +") and has "+ energy +" units of energy.";
		}
}
