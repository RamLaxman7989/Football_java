package com.spring.angular.football.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="football")
public class FootballPlayer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "player_name")
	private String playerName;
	
	@Column(name = "team_name")
	private String teamName;
	
	@Column(name = "player_goals")
	private String playerGoals;
	
	@Column(name = "player_role")
	private String playerRole;
	
	public FootballPlayer() {
		
	}
	
	public FootballPlayer(String playerName, String teamName, String playerGoals, String playerRole) {
		super();
		this.playerName = playerName;
		this.teamName = teamName;
		this.playerGoals = playerGoals;
		this.playerRole = playerRole;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getPlayerGoals() {
		return playerGoals;
	}
	public void setPlayerGoals(String playerGoals) {
		this.playerGoals = playerGoals;
	}
	public String getPlayerRole() {
		return playerRole;
	}
	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}
	
	

}
