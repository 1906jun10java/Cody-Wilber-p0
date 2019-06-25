package com.revature.driver;

import java.util.ArrayList;

import com.revature.views.Menu;

public class Driver {
	public static void main(String[] args) {
		// Initialize services
		
		// Display start menu
		ArrayList<String> al = new ArrayList<String>();
		al.add("Exit");
		al.add("Login");
		al.add("Register");
		Menu m = new Menu(al);
		int option = m.display();
		
		switch (option) {
		case 0:
			return;
		case 1:
			System.out.println("Do Login");
			break;
		case 2:
			System.out.println("Do Registration");
			break;
		default:
			break;
		}
	}
}
