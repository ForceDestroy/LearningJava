package copters;
import planes.Airplane;;

/**
 * A class for creating Helicopter Objects, inheriting from Airplane
 * @author Sangeethan Thaventhiran
 */
public class Helicopter extends Airplane{
	
	/**
	 * The helicopter's number of cylinders
	 */
	protected int Cylinders;
	
	/**
	 * The helicopter's creation year
	 */
	protected int CreationYear;
	
	/**
	 * The heliocpter's passenger capacity
	 */
	protected int PassengerCapacity;
	
	/**
	 * The default constructor
	 */
	public Helicopter() {
		super();
		this.Cylinders = 0;
		this.CreationYear = 0;
		this.PassengerCapacity = 0;
	}
	
	/**
	 * The parameterized constructor
	 * @param Brand
	 * @param Price
	 * @param HorsePower
	 * @param Cylinders
	 * @param CreationYear
	 * @param PassengerCapacity
	 */
	public Helicopter(String Brand, double Price, int HorsePower, int Cylinders, int CreationYear, int PassengerCapacity) {
		super(Brand, Price, HorsePower);
		this.Cylinders = Cylinders;
		this.CreationYear = CreationYear;
		this.PassengerCapacity = PassengerCapacity;
	}
	
	/**
	 * The copy constructor
	 * @param helicopter
	 */
	public Helicopter(Helicopter helicopter) {
		super(helicopter);
		this.Cylinders = helicopter.Cylinders;
		this.CreationYear = helicopter.CreationYear;
		this.PassengerCapacity = helicopter.PassengerCapacity;
	}
	
//	/**
//	 * Cylinders Accessor
//	 * @return Cylinders
//	 */
//	public int getCylinders() {
//		return this.Cylinders;
//	}
//	
//	/**
//	 * Creation Year Accessor
//	 * @return CreationYear
//	 */
//	public int getCreationYear() {
//		return this.CreationYear;
//	}
//	
//	/**
//	 * Passenger Capacity Accessor
//	 * @return PassengerCapacity
//	 */
//	public int getPassengerCapacity() {
//		return this.PassengerCapacity;
//	}
	
	/**
	 * Cylinders Mutator
	 * @param Cylinders
	 */
	public void setCylinders(int Cylinders) {
		this.Cylinders = Cylinders;
	}
	
	/**
	 * Creation Year Mutator
	 * @param CreationYear
	 */
	public void setCreationYear(int CreationYear) {
		this.CreationYear = CreationYear;
	}
	
	/**
	 * Passenger Capacity Mutator
	 * @param PassengerCapacity
	 */
	public void setPassengerCapacity(int PassengerCapacity) {
		this.PassengerCapacity = PassengerCapacity;
	}
	
	/**
	 * Overridden toString method
	 */
	public String toString() {
		return "This helicopter is made by " + this.Brand + " in " + this.CreationYear + ", it has a horse power of " + this.HorsePower + " and costs $" + this.Price +
				". It has " + this.Cylinders + " cylinders and a passenger capacity of " + this.PassengerCapacity;
	}
	
	/**
	 * Overridden equals method
	 * @param helicopter
	 * @return true||false
	 */
	public boolean equals(Helicopter helicopter) {
		if(this != null && helicopter != null) {
			return super.equals(helicopter) && this.Cylinders == helicopter.CreationYear && this.CreationYear == helicopter.CreationYear && this.PassengerCapacity == helicopter.PassengerCapacity;
			}
		else {
			return false;
		}
	}
	
}
