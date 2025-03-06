package character;

public class Elf extends MiddleEarthCharacter {
	public Elf(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Orc) {
			target.health -= this.power * 1.5;
			return true;
		} else if (target instanceof Dwarf || target instanceof Elf) {
			return false;
		} else {
			target.health -= this.power;
			return true;
		}
	}
	
	@Override
	public String getRace() {
		return "Elf";
	}

}
