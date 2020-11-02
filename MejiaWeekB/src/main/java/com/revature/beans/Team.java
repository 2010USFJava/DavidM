package com.revature.beans;

import java.io.Serializable;

import com.revature.util.Filer;
import com.revature.util.League;
import com.revature.util.LogginIt;

public class Team implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7884340691856442297L;
	private String location;
	private String name;
	private int offenseRating;
	private int defenseRating;
	
	public Team() {
		super();
		League.leagueTeams.add(this);
		Filer.writeTeamLeague(League.leagueTeams);
	}
	
	public Team(String location, String name, int offenseRating, int defenseRating) {
		super();
		this.location = location;
		this.name = name;
		this.offenseRating = offenseRating;
		this.defenseRating = defenseRating;
		League.leagueTeams.add(this);
		Filer.writeTeamLeague(League.leagueTeams);
		LogginIt.logIt("info", "A new team" + this.location + " " + this.name + " has been established.");
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOffenseRating() {
		return offenseRating;
	}

	public void setOffenseRating(int offenseRating) {
		this.offenseRating = offenseRating;
	}

	public int getDefenseRating() {
		return defenseRating;
	}

	public void setDefenseRating(int defenseRating) {
		this.defenseRating = defenseRating;
	}

	@Override
	public String toString() {
		return "Team " + location + " " + name + ", with Offense Rating: " + offenseRating + ", and Defense Rating: "
				+ defenseRating + " has been established\n";
	}
	
	
}
