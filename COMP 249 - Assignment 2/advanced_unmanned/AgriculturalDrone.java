package advanced_unmanned;
import unmanned.UAV;

/**
 * A class for creating Agricultural Drone Objects, inheriting from UAV
 * @author Sangeethan Thaventhiran
 */
public class AgriculturalDrone extends UAV{
	
	/**
	 * The Drone's brand
	 */
	private String Brand;
	
	/**
	 * The Drone's carrying capacity
	 */
	private int CarryCapacity;
	
	
	/**
	 * The default constructor
	 */
	public AgriculturalDrone() {
		super();
		this.Brand = null;
		this.CarryCapacity = 0;
	}
	
	/**
	 * The parameterized constructor
	 * @param Weight
	 * @param Price
	 * @param Brand
	 * @param CarryCapacity
	 */
	public AgriculturalDrone(double Weight, double Price, String Brand, int CarryCapacity) {
		super(Weight, Price);
		this.Brand = Brand;
		this.CarryCapacity = CarryCapacity;
	}
	
	/**
	 * The copy constructor
	 * @param agriculturaldrone
	 */
	public AgriculturalDrone(AgriculturalDrone agriculturaldrone) {
		super(agriculturaldrone);
		this.Brand = agriculturaldrone.getBrand();
		this.CarryCapacity = agriculturaldrone.getCarryCapacity();
	}
	
	/**
	 * Brand Accessor
	 * @return
	 */
	public String getBrand() {
		return this.Brand;
	}
	
	/**
	 * Carrying Capacity Accessor
	 * @return
	 */
	public int getCarryCapacity() {
		return this.CarryCapacity;
	}
	
	/**
	 * Brand Mutator
	 * @param Brand
	 */
	public void setBrand(String Brand) {
		this.Brand = Brand;
	}
	
	/**
	 * Carrying Capacity Mutator
	 * @param CarryCapacity
	 */
	public void setCarryCapacity(int CarryCapacity) {
		this.CarryCapacity = CarryCapacity;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return "This Agricultural Drone weighs " + this.Weight + " and costs $" + this.Price + ". It is made by " + this.getBrand() + " and has a carrying capacity of " + this.getCarryCapacity() + " kg";
	}
	
	/**
	 * Overridden equals method
	 * @param agriculturaldrone
	 * @return true||false
	 */
	public boolean equals(AgriculturalDrone agriculturaldrone) {
		if(this != null && agriculturaldrone != null) {
			return super.equals(agriculturaldrone) && this.getBrand() == agriculturaldrone.getBrand() && this.getCarryCapacity() == agriculturaldrone.getCarryCapacity();
		}
		else {
			return false;
		}
		
	}
}
