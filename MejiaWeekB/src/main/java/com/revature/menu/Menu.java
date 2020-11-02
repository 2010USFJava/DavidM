package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.Team;
import com.revature.util.League;
import com.revature.util.LogginIt;

public class Menu {
	
	static Scanner input = new Scanner(System.in);
	//user interface
	public static void mainMenu() {
		System.out.println("Welcome to the game\nPlease create a new team"
				+ "\nFirst choose your team's location e.g. name of city"
				+ ", state, country");
		String location = input.nextLine();
		System.out.println("Next choose your team's name");
		String name = input.nextLine();
		System.out.println("Please enter your team's offense rating between 0-100");
		int offenseRating = input.nextInt();
		System.out.println("Please enter your team's defense rating between 0-100");
		int defenseRating = input.nextInt();
		
		//output generated from user input
		Team newTeam = new Team(location, name, offenseRating, defenseRating);
		LogginIt.logIt("info", newTeam.getName() + " just got established");
		System.out.println(League.leagueTeams.toString());
	}
	
}
