package middleearth;
/**
 * MiddleEarthCouncil class creates an instance of the middle 
 * earth council for the user to manipulate characters in middle earth
 */
public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	
	private CharacterManager characterManager;
	
	/*
	 * Character manager constructor
	 */
	private MiddleEarthCouncil() {
		// Initialize the CharacterManager
		this.characterManager = new CharacterManager(5);
	}
	
	/*
	 * getInstance method creates an instance of MiddleEarthCouncil
	 *  if there isn't one already
	 */
	private static MiddleEarthCouncil getInstance() {
		// If instance is null, create the instance
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		
		return instance;
	}
	
	/*
	 *  Method to get the CharacterManager object
	 */
	public CharacterManager getCharacterManager() {
		return characterManager;
	}
}
