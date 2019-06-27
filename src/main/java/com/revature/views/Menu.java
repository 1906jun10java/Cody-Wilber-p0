package com.revature.views;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
	protected Scanner sc = new Scanner(System.in);
	protected ArrayList<String> menuItems;

	// Constructor
	public Menu() {}
	
	// Display the menu and return selection
	public int display() {
		int option = 0;
		boolean notValid = true;
		
		while (notValid) {
			// Display
			int count = 0;
			System.out.println();
			for (String item : this.menuItems) {
				System.out.println(count + ". " + item);
				count++;
			}
			System.out.print(">>> ");
			
			// Get input
			if (sc.hasNext()) {
				option = sc.nextInt();
				sc.nextLine();
				if (option < 0 || option >= this.menuItems.size()) {
					System.out.println("Invalid option");
					continue;
				}
				notValid = false;
			} else {
				System.out.println("Invalid option");
				sc.nextLine();
			}
		}
		
		return option;
	}
	
	// Retrieve user response from menu
	public abstract void getResponse(int option);
	
	public ArrayList<String> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(ArrayList<String> menuItems) {
		this.menuItems = menuItems;
	}
}
