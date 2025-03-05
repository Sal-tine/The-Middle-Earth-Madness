package middleearth;

/*
 * CharacterManager class is filled with methods to help
 *  manage characters in middle earth
 */
public class CharacterManager {
	MiddleEarthCharacter[] characters;
	int size;
	
	/*
	 *  Constructor to initialize the array that hold the characters
	 */
    public CharacterManager(int initialCapacity) {
    	characters = new MiddleEarthCharacter[initialCapacity];
        size = 0;
    }
	
    /*
     * addCharacter method adds characters to an array
     *  that doubles in size when its full
     */
	public boolean addCharacter(MiddleEarthCharacter c) {
		// Check if array is full
		if (size == characters.length) {
			// Doubles array size with new array
			MiddleEarthCharacter[] newArray = new MiddleEarthCharacter[characters.length * 2];
			// Copy elements over and update characters array
			System.arraycopy(characters, 0, newArray, 0, characters.length);
			characters = newArray;
		}
		
		return true;
	}
	
	/*
	 * getCharacter method iterates through the array
	 *  of characters and checks for a name
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		for (int i = 0; i < size; i++) {
			// Checks for the character at each index
			if(characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		// If no character is found
		return null;
	}
	
	/*
	 * updateCharacter method updates a given character returning
	 *  false if the character was not updated or not found
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		// Search for the character
		for (int i = 0; i < size; i++) {
			if (characters[i].getName().equals(name)) {
				// Initialize character update status
				boolean isUpdated = false;
				
				// Update health if different
				if (characters[i].getHealth() != health) {
					characters[i].setHealth(health);
					isUpdated = true;
				}
				
				// Update power if different
				if (characters[i].getPower() != power) {
					characters[i].setPower(power);
					isUpdated = true;
				}
				
				//Return weather or not change was made
				return isUpdated;
			}
			
			// Character not found
			System.out.println("Character with name " + name + " does not exist.");
			return false;
		}
	}
	
	/*
	 * deleteCharacter method deletes characters from the array
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		// Find the character
		for (int i = 0; i < size; i++) {
			if (characters[i].getName().equals(character.getName())) {
				// Shift elements to the left
				for (int j = i; j < size - 1; j++) {
					characters[j] = characters[j + 1];
				}
				// Set the last element to null
				characters[size - 1] = null;
				size--;
				
				return true;
			}
		}
		// Character not found
		return false;
	}
	
	/*
	 * displayAllCharacters method displays all characters in the array
	 */
	public void displayAllCharacters() {
		// No characters in the array
		if (size == 0) {
			System.out.println("No characters to display.");
			
			return;
		}
		for (int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}

}
