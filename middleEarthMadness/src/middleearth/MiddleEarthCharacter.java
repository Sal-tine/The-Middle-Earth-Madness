

package middleearth;

public abstract class MiddleEarthCharacter {
	protected String name;
	protected double health;
	protected double power;
	
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	//Abstract methods
	public abstract boolean attack(MiddleEarthCharacter target);
	public abstract String getRace();
	
	//Concrete method
	public void displayInfo() {
		System.out.print("Name: " + name);
		System.out.print("Health: " + health);
		System.out.print("Power: " + power);
		System.out.print("Race: " + getRace());
		
	}
}
