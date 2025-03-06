

package character;

/**
 * 
 * Abstract class of middle earth character.
 * 
 */

public abstract class MiddleEarthCharacter {
	/** Character name */
	protected String name;
	
	/** Character health */
	protected double health;
	
	/** Character power */
	protected double power;
	
	/**
	 * 
	 * Constructs of middleEarthCharacter with name, health and power.
	 * 
	 * @param name  The name of character.
	 * @param health  the characters health.
	 * @param power  The characters power.
	 */
	
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	/**
	 * 
	 * Gets name
	 * 
	 * @return The characters name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Sets of character
	 * 
	 * @param name The characters new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Gets health
	 * 
	 * @return The characters health
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * 
	 * Sets health
	 * 
	 * @param health The characters health
	 */
	public void setHealth(double health) {
		this.health = health;
	}

	/**
	 * 
	 * Gets power
	 * 
	 * @return  The characters power
	 */
	public double getPower() {
		return power;
	}

	/**
	 * 
	 * Sets power
	 * 	 
	 * @param power  The characters power
	 */
	public void setPower(double power) {
		this.power = power;
	}


	/**
	 *Abstract method used for attacks.
	 *
	 * @param target The target of the attack
	 * @return true if attack was successful 
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	
	/**
	 * Abstract method to get race of middle earth character
	 * 
	 * @return A string for race
	 */
	public abstract String getRace();
	
	/**
	 * Displays info  about character
	 * 
	 */
	public void displayInfo() {
		System.out.print("Name: " + name);
		System.out.print("Health: " + health);
		System.out.print("Power: " + power);
		System.out.print("Race: " + getRace());
		
	}
}
