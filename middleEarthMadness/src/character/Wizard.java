package character;


public class Wizard extends MiddleEarthCharacter {

    // Constructor for Wizard
    public Wizard(String name, double health, double power) {
        super(name, health, power);  // Call the constructor of the parent class
    }

    // Override the attack method (specific to Wizard)
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        // Wizard does 1.5x damage to Dwarf
        if (target instanceof Dwarf) {
            target.health -= this.power * 1.5;
            return true;
        } 
        // Wizard's attack is ineffective against Humans or other Wizards
        else if (target instanceof Human || target instanceof Wizard) {
            return false;
        } 
        // Normal damage to Elves and Orcs
        else {
            target.health -= this.power;
            return true;
        }
    }

    // Override the getRace method (specific to Wizard)
    @Override
    public String getRace() {
        return "Wizard";
    }
}
