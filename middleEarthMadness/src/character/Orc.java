package character;


public class Orc extends MiddleEarthCharacter {

    // Constructor for Orc
    public Orc(String name, double health, double power) {
        super(name, health, power);  // Call the constructor of the parent class
    }

    // Override the attack method (specific to Orc)
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        // Orc does 1.5x damage to Human
        if (target instanceof Human) {
            target.health -= this.power * 1.5;
            return true;
        } 
        // Orc's attack is ineffective against Elves or other Orcs
        else if (target instanceof Elf || target instanceof Orc) {
            return false;
        } 
        // Normal damage to Dwarves and Wizards
        else {
            target.health -= this.power;
            return true;
        }
    }

    // Override the getRace method (specific to Orc)
    @Override
    public String getRace() {
        return "Orc";
    }
}