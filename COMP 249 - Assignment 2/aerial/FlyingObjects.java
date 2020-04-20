package aerial;

public class FlyingObjects {
	
	/**
	 * The price for all Flying Objects
	 */
	protected double Price;
	
	/**
	 * The default constructor
	 */
	public FlyingObjects() {
		this.Price = 0;
	}
	
	/**
	 * The parameterized constructor
	 * @param Price
	 */
	public FlyingObjects(double Price) {
		this.Price = Price;
	}
	
	/**
	 * The copy constructor
	 * @param flyingobject
	 */
	public FlyingObjects(FlyingObjects flyingobject) {
		this.Price = flyingobject.Price;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return "This is a flying object, not any of the other classes, the price of this is $" + this.Price;
	}
	
	/**
	 * Overridden equals method
	 * @param flyingobjects
	 * @return true||false
	 */
	public boolean equals(FlyingObjects flyingobjects) {
		if(this != null && flyingobjects != null) {
			return this.Price == flyingobjects.Price;
		}
		else {
			return false;
		}
	}
}
