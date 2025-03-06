package character;


public class Dwarf extends MiddleEarthCharacter {

    // Constructor for Dwarf
    public Dwarf(String name, double health, double power) {
        super(name, health, power);  // Call the constructor of the parent class
    }

    // Override the attack method (specific to Dwarf)
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        // Dwarf does 1.5x damage to Elf
        if (target instanceof Elf) {
            target.health -= this.power * 1.5;
            return true;
        } 
        // Dwarf's attack is ineffective against Wizards or other Dwarves
        else if (target instanceof Wizard || target instanceof Dwarf) {
            return false;
        } 
        // Normal damage to Humans and Orcs
        else {
            target.health -= this.power;
            return true;
        }
    }

    // Override the getRace method (specific to Dwarf)
    @Override
    public String getRace() {
        return "Dwarf";
    }
}