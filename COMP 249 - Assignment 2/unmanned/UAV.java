package unmanned;
import aerial.FlyingObjects;

/**
 * A class for creating UAV Objects, inheriting from FlyingObjects
 * @author Sangeethan Thaventhiran
 */
public class UAV extends FlyingObjects{
	
	/**
	 * The UAV's weight
	 */
	protected double Weight;
	
	/**
	 * The default constructor
	 */
	public UAV() {
		this.Weight = 0.00;
		this.Price = 0.00;
	}
	
	/**
	 * The parameterized constructor
	 * @param Weight
	 * @param Price
	 */
	public UAV(double Weight, double Price) {
		this.Weight = Weight;
		this.Price = Price;
	}
	
	/**
	 * The copy constructor
	 * @param uav
	 */
	public UAV(UAV uav) {
		this.Weight = uav.Weight;
		this.Price = uav.Price;
	}
	
//	/**
//	 * Weight Accessor
//	 * @return Weight
//	 */
//	public double getWeight() {
//		return this.Weight;
//	}
//	
//	/**
//	 * Price Accessor
//	 * @return Price
//	 */
//	public double getPrice() {
//		return this.Price;
//	}
	
	/**
	 * Weight Mutator
	 * @param Weight
	 */
	public void setWeight(double Weight) {
		this.Weight = Weight;
	}
	
	/**
	 * Price Mutator
	 * @param Price
	 */
	public void setPrice(double Price) {
		this.Price = Price;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return "This UAV weighs " + this.Weight + " and costs $" + this.Price;
	}
	
	/**
	 * Overridden equals method
	 * @param uav
	 * @return true||false
	 */
	public boolean equals(UAV uav) {
		if(this != null && uav != null) {
			return this.Weight == uav.Weight && this.Price == uav.Price;
		}
		else {
			return false;
		}
		
	}
}
