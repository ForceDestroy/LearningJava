package planes;
import aerial.FlyingObjects;

/**
 * A class for creating Airplane Objects, inheriting from FlyingObjects
 * @author Sangeethan Thaventhiran
 */
public class Airplane extends FlyingObjects{
	
	/**
	 * The airplane's brand name
	 */
	protected String Brand;
	
	/**
	 * The airplane's horse power
	 */
	protected int HorsePower;
	
	/**
	 * The default constructor
	 */
	public Airplane() {
		this.Brand = null;
		this.Price = 0.00;
		this.HorsePower = 0;
	}
	
	/**
	 * The parameterized constructor
	 * @param Brand
	 * @param Price
	 * @param HorsePower
	 */
	public Airplane(String Brand, double Price, int HorsePower) {
		this.Brand = Brand;
		this.Price = Price;
		this.HorsePower = HorsePower;
	}
	
	/**
	 * The copy constructor
	 * @param airplane
	 */
	public Airplane(Airplane airplane) {
		this.Brand = airplane.Brand;
		this.Price = airplane.Price;
		this.HorsePower = airplane.HorsePower;
	}
	
//	/**
//	 * Brand Accessor
//	 * @return Brand
//	 */
//	public String getBrand() {
//		return this.Brand;
//	}
//	
//	/**
//	 * Price Accessor
//	 * @return Price
//	 */
//	public double getPrice() {
//		return this.Price;
//	}
//	
//	/**
//	 * Horse Power Accessor
//	 * @return HorsePower
//	 */
//	public int getHorsePower() {
//		return this.HorsePower;
//	}
	
	/**
	 * Brand Mutator
	 * @param Brand
	 */
	public void setBrand(String Brand) {
		this.Brand = Brand;
	}
	
	/**
	 * Price Mutator
	 * @param Price
	 */
	public void setPrice(double Price) {
		this.Price = Price;
	}
	
	/**
	 * Horse Power Mutator
	 * @param HorsePower
	 */
	public void setHorsePower(int HorsePower) {
		this.HorsePower = HorsePower;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return "This airplane is made by " + this.Brand + ", it has a horse power of " + this.HorsePower + " and costs $" + this.Price;
	}
	
	/**
	 * Overridden equals method
	 * @param airplane
	 * @return true||false
	 */
	public boolean equals(Airplane airplane) {
		if(this != null && airplane != null) {
			return this.Brand == airplane.Brand && this.Price == airplane.Price && this.HorsePower == airplane.HorsePower;
		}
		else {
			return false;
		}
	}
}
