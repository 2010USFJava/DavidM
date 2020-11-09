package com.project0.bankapp.main;

import com.project0.bankapp.menus.StartMenu;
import com.project0.util.Filer;

public class Driver {
	static {Filer.readAccountFile();}
	static {Filer.readCustomerFile();}
	static {Filer.readEmployeeFile();}
	public static void main(String[] args) {
		StartMenu.startMenu();
	}

}
