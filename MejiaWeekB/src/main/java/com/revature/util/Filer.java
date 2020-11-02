package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import com.revature.beans.Team;

public class Filer {
	//file which contains League arrayList
	public static final String teamLeague = "The League.txt";
	
	//write method
	@SuppressWarnings("resource")
	public static void writeTeamLeague(List<Team> writeLeague) {
		try {
			ObjectOutputStream writeOut = new ObjectOutputStream(new FileOutputStream(teamLeague));
			writeOut.writeObject(writeLeague);
			//writeOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//read method
	@SuppressWarnings({ "unchecked", "resource" })
	public static void readTeamLeague() {
		try {
			ObjectInputStream readIn = new ObjectInputStream(new FileInputStream(teamLeague));
			//readIn.close();
			try {
				League.leagueTeams=(ArrayList<Team>) readIn.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
