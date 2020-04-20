public class Dice {
	
	int die1, die2;
	
	public Dice() {
		die1 = 0;
		die2 = 0;
	}
	
	public int getDie1() {
		return this.die1;
	}
	
	public int getDie2() {
		return this.die2;
	}
	
	public int rollDice() {
		die1 = (int)(Math.random()*6+1);
		die2 = (int)(Math.random()*6+1);
		
		int sum = die1 + die2;
		return sum;
	}
	
	public boolean isDouble() {
		if(die1==die2) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Die 1: " + die1 + " & Die 2: "+die2;
	}
}
