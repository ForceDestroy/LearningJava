package advanced_copters;
import copters.Helicopter;

/**
 * A class for creating Multirotor Objects, inheriting from Helicopter
 * @author Sangeethan Thaventhiran
 */
public class Multirotor extends Helicopter{
	
	/**
	 * The multirotor's number of rotors
	 */
	private int Rotors;
	
	/**
	 * The default constructor
	 */
	public Multirotor() {
		super();
		this.Rotors = 0;
	}
	
	/**
	 * The parameterized constructor
	 * @param Brand
	 * @param Price
	 * @param HorsePower
	 * @param Cylinders
	 * @param CreationYear
	 * @param PassengerCapacity
	 * @param Rotors
	 */
	public Multirotor(String Brand, double Price, int HorsePower, int Cylinders, int CreationYear, int PassengerCapacity, int Rotors) {
		super(Brand, Price, HorsePower, Cylinders, CreationYear, PassengerCapacity);
		this.Rotors = Rotors;
	}
	
	/**
	 * The copy constructor
	 * @param multirotor
	 */
	public Multirotor(Multirotor multirotor) {
		super(multirotor);
		this.Rotors = multirotor.getRotors();
	}
	
	/**
	 * Rotors Accessor
	 * @return Rotors
	 */
	public int getRotors() {
		return this.Rotors;
	}
	
	/**
	 * Rotors Mutator
	 * @param Rotors
	 */
	public void setRotors(int Rotors) {
		this.Rotors = Rotors;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return "This multirotor is made by " + this.Brand + " in " + this.CreationYear + ", it has a horse power of " + this.HorsePower + " and costs $" + this.Price +
				". It has " + this.Cylinders + " cylinders and a passenger capacity of " + this.PassengerCapacity + ". It also has " + this.getRotors() + " rotors";
	}
	
	/**
	 * Overridden equals method
	 * @param multirotor
	 * @return true||false
	 */
	public boolean equals(Multirotor multirotor) {
		if(this != null && multirotor != null) {	
			return super.equals(multirotor) && this.getRotors() == multirotor.getRotors();
		}
		else {
			return false;
		}
	}
}
