package copters;

/**
 * A class for creating Quadcopter Objects, inheriting from Helicopter
 * @author Sangeethan Thaventhiran
 */
public class Quadcopter extends Helicopter{
	
	/**
	 * The Quadcopter's max flying speed
	 */
	private int MaxFlyingSpeed;
	
	/**
	 * The default constructor
	 */
	public Quadcopter() {
		super();
		this.MaxFlyingSpeed = 0;
	}
	
	/**
	 * The parameterized constructor
	 * @param Brand
	 * @param Price
	 * @param HorsePower
	 * @param Cylinders
	 * @param CreationYear
	 * @param PassengerCapacity
	 * @param MaxFlyingSpeed
	 */
	public Quadcopter(String Brand, double Price, int HorsePower, int Cylinders, int CreationYear, int PassengerCapacity, int MaxFlyingSpeed) {
		super(Brand, Price, HorsePower, Cylinders, CreationYear, PassengerCapacity);
		this.MaxFlyingSpeed = MaxFlyingSpeed;
	}
	
	/**
	 * The copy constructor
	 * @param quadcopter
	 */
	public Quadcopter(Quadcopter quadcopter) {
		super(quadcopter);
		this.MaxFlyingSpeed = quadcopter.getMaxFlyingSpeed();
	}
	
	/**
	 * Max Flying Speed Accessor
	 * @return
	 */
	public int getMaxFlyingSpeed() {
		return this.MaxFlyingSpeed;
	}
	
	/**
	 * Max Flying Speed Mutator
	 * @param MaxFlyingSpeed
	 */
	public void setMaxFlyingSpeed(int MaxFlyingSpeed) {
		this.MaxFlyingSpeed = MaxFlyingSpeed;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return "This quadcopter is made by " + this.Brand + " in " + this.CreationYear + ", it has a horse power of " + this.HorsePower + " and costs $" + this.Price +
				". It has " + this.Cylinders + " cylinders and a passenger capacity of " + this.PassengerCapacity + ". It also has a top flying speed of " + this.getMaxFlyingSpeed();
	}
	
	/**
	 * Overridden equals method
	 * @param quadcopter
	 * @return
	 */
	public boolean equals(Quadcopter quadcopter) {
		if(this != null && quadcopter != null) {
			return super.equals(quadcopter) && this.PassengerCapacity == quadcopter.PassengerCapacity && this.getMaxFlyingSpeed() == quadcopter.getMaxFlyingSpeed();
			}
		else {
			return false;
		}
	}
	
}
