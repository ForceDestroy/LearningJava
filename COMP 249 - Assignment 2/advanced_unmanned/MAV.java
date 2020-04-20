package advanced_unmanned;
import unmanned.UAV;

/**
 * A class for creating MAV objects, inheriting from UAV
 * @author Sangeethan Thaventhiran
 */
public class MAV extends UAV{
	
	/**
	 * The MAV's model name
	 */
	private String Model;
	
	/**
	 * The MAV's Size rating
	 */
	private double Size;
	
	/**
	 * The default constructor
	 */
	public MAV() {
		super();
		this.Model = null;
		this.Size = 0.00;
	}
	
	/**
	 * The parameterized constructor
	 * @param Weight
	 * @param Price
	 * @param Model
	 * @param Size
	 */
	public MAV(double Weight, double Price, String Model, double Size) {
		this.Weight = Weight;
		this.Price = Price;
		this.Model = Model;
		this.Size = Size;
	}
	
	/**
	 * The copy constructor
	 * @param mav
	 */
	public MAV(MAV mav) {
		super(mav);
		this.Model = mav.getModel();
		this.Size = mav.getSize();
	}
	
	/**
	 * Model Accessor
	 * @return
	 */
	public String getModel() {
		return this.Model;
	}
	
	/**
	 * Size Accessor
	 * @return
	 */
	public double getSize() {
		return this.Size;
	}
	
	/**
	 * Model Mutator
	 * @param Model
	 */
	public void setModel(String Model) {
		this.Model = Model;
	}
	
	/**
	 * Size Mutator
	 * @param Size
	 */
	public void setSize(double Size) {
		this.Size = Size;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return "This MAV weighs " + this.Weight + " and costs $" + this.Price + ". It is a " + this.getModel() + " and is a Size rating of " + this.getSize(); 
	}
	
	/**
	 * Overridden equals method
	 */
	public boolean equals(MAV mav) {
		if(this != null && mav != null) {
			return super.equals(mav) && this.getModel() == mav.getModel() && this.getSize() == mav.getSize();
		}
		else {
			return false;
		}
	}
	
}
