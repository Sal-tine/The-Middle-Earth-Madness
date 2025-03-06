//overarching package
package main.app;



/**
 * MiddleEarthApp.java
 * 
 * this class provides the user with a menu interface to manage
 * the middle earth characters. It allows things such as battles, adding and updating 
 * characters and even deletion.
 * @author
 * 
 */
import java.util.Scanner;

import character.*;
import middle.Earth.Utilities.*;

//main class
public class MiddleEarthApp {

	
		/**
		 * Main method that runs user menu interface
		 * @param args Command line not used 
		 */
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			
			MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
			CharacterManager manager = council.getCharacterManager();
			
			
			//this simplifies the exit function and allows streamlined user experience.
			boolean menu = true;
			
			while(menu) {
				//menu options
				System.out.println("\n-----Main Menu----");
				System.out.println("1. Add a new character.");
				System.out.println("2. View all characters.");
				System.out.println("3. Update a character.");
				System.out.println("4. Delete a character.");
				System.out.println("5. Execute all characters’ attack actions.-");
				System.out.println("6. Exit.");
				System.out.println("Please enter numbered choice");
				
				/*creates user choice and takes it from scanner. we then check for valid values
				 * in user choice. We check for exceptions in-case a string is input
				 * */
				
				int UserChoice;
					try {
						UserChoice = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("Please enter a numberd choice");
						continue;
					}
					
				
				//Using a switch case for easy input handling  
				switch(UserChoice){
					case 1:
						//Case 1 adds a new character
						String type;
						while(true) {
							System.out.println("Enter character type. (Wizard, Orc, Human, Dwarf, Elf)");
							type = scanner.nextLine().trim();
							
							//checking if input meets character requirements and if not we re-prompt the user
							if(type.equalsIgnoreCase("Elf") || type.equalsIgnoreCase("Dwarf") || type.equalsIgnoreCase("Orc") || type.equalsIgnoreCase("Wizard") || type.equalsIgnoreCase("Human")) {
								break;
							} else {
								System.out.println("Invalid Charcter type. Please try again");
							}
						}
						
						System.out.println("Enter your " + type +"'s name:");
						String name = scanner.nextLine().trim();
						
						//checking for valid input. Health cannot be negative. if input if invalid we re-prompt the user
						double health;
						while(true) {
							System.out.println("Enter " + name + "'s Health (number value)");
							try {
								health = Double.parseDouble(scanner.nextLine());
								if(health < 0) {
									System.out.println("Health cannot be negative try again");
									continue;
								}
								break;
							} catch (NumberFormatException e) {
								System.out.println("Invalid Health Value. Please try again");		
							}
						}
						
						//checking for valid power inputs. cannot be negative
						double power;
						while(true) {
							System.out.println("Enter " + name + "'s power (Number value");
							try {
								power = Double.parseDouble(scanner.nextLine());
								if(power < 0) {
									System.out.println("Power canntot be negative. Try again");
									continue;
								}
								break;
							} catch (NumberFormatException e) {
								System.out.println("Invalid Power value. Please try again");
							}

						}
						
						//create a new middle earth character. 
						MiddleEarthCharacter character = null;
						
						//checking input and inputing corresponding character;
						if(type.equalsIgnoreCase("Elf")) {
							character = new Elf(name, health, power);
						} else if (type.equalsIgnoreCase("Dwarf")) {
							character = new Dwarf(name, health, power);
						} else if (type.equalsIgnoreCase("Human")) {
							character = new Human(name, health, power);
						} else if (type.equalsIgnoreCase("Orc")) {
							character = new Orc(name, health, power);
						} else if (type.equalsIgnoreCase("Wizard")) {
							character = new Wizard(name, health, power);
						} else {
							System.out.println("Error has occured please try again");
							break;
						}
						
						if (manager.addCharacter(character)) {
							System.out.println( name + " the " + type + " with " +  health + " health and " + power + " power has been added");
						} else {
							System.out.println("Failed to add charcter");
						}
						break;
					
					case 2:
						//view characters
						System.out.println("\n---All Characters---");
						manager.displayAllCharacters();
						break;
						
					case 3:
						//update Character
						System.out.println("Enter Character name");
						String updateName = scanner.nextLine().trim();
						MiddleEarthCharacter update = manager.getCharacter(updateName);
						
						if(update == null) {
							System.out.println("Charcter not found");
						} else {
							System.out.println("Enter new name");
							String newName = scanner.nextLine().trim();
							int newHealth;
							while(true) {
								System.out.println("Enter " + newName + "'s Health (number value)");
								try {
									newHealth = Integer.parseInt(scanner.nextLine());
									if(newHealth < 0) {
										System.out.println("Health cannot be negative try again");
										continue;
									}
									break;
								} catch (NumberFormatException e) {
									System.out.println("Invalid Health Value. Please try again");		
								}
							}
							
							int newPower;
							while(true) {
								System.out.println("Enter " + newName + "'s power (Number value");
								try {
									newPower = Integer.parseInt(scanner.nextLine());
									if(newPower < 0) {
										System.out.println("Power canntot be negative. Try again");
										continue;
									}
									break;
								} catch (NumberFormatException e) {
									System.out.println("Invalid Power value. Please try again");
								}
							}
							
							if(manager.updateCharacter(update,newName, newHealth, newPower)) {
								System.out.println("Character Updated");
							} else {
								System.out.println("Error occured. Nothing changed");
							}	
						}
						break;
						
					case 4:
						//delete a character
						
						System.out.println("Enter character to destroy! (delete) ");
						String deadName = scanner.nextLine().trim();
						MiddleEarthCharacter deadChar = manager.getCharacter(deadName);
						
						if(deadChar == null) {
							System.out.println("Character not found");
						} else { 
							if(manager.deleteCharacter(deadChar)) {
								System.out.println("Character couldnt defeat god. Successfully destroyed");	
							} else {
								System.out.println("Failed to delete character. they're strong then god");
							}
						}
						break;
						
					case 5:
						System.out.println("\n---Battle initiated---");
						
						if(manager.getSize() < 2) {
							System.out.println("Characters cant fight themselves. Add more characters");
							break;
						}
						
						for(int i = 0; i < manager.getSize(); i++) {
							MiddleEarthCharacter attacker = manager.getCharacterAt(i);
							
							int targetIndex = (i + 1) % manager.getSize();
							MiddleEarthCharacter target = manager.getCharacterAt(targetIndex);
							
							boolean result = attacker.attack(target);
							
							System.out.println("the " + attacker.getRace()+ " " + attacker.getName() + "has attacked " + "the " + 
									target.getRace() + " " + target.getName() + " The attacke was "+ (result ? "successful" : "unsuccessful"));
						}
						break;
						
					case 6:
						menu = false;
						System.out.println("Exit initiated. Goodbye my friend");
						break;
						
					default: 
						System.out.println("Seems you missed the option menu. Please try again");					
				}
			}
			
			scanner.close();
		}
}
