package com.revature.main;

import com.revature.menu.Menu;
import com.revature.util.Filer;

public class Main {
	//loading persisting data file of teams created
	static {Filer.readTeamLeague();}

	public static void main(String[] args) {
		Menu.mainMenu();

	}

}
