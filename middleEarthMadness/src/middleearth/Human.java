package middleearth;


public class Human extends MiddleEarthCharacter {

    // Constructor for Human
    public Human(String name, double health, double power) {
        super(name, health, power);  // Call the constructor of the parent class
    }

    // Override the attack method (specific to Human)
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        // Human does 1.5x damage to Wizard
        if (target instanceof Wizard) {
            target.health -= this.power * 1.5;
            return true;
        } 
        // Human's attack is ineffective against Orcs or other Humans
        else if (target instanceof Orc || target instanceof Human) {
            return false;
        } 
        // Normal damage to Elves and Dwarves
        else {
            target.health -= this.power;
            return true;
        }
    }

    // Override the getRace method (specific to Human)
    @Override
    public String getRace() {
        return "Human";
    }
}