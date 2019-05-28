package model;

import java.util.ArrayList;

import dataBase.DataBasePlayer;
import ux.mainUi;

public class Player{

	private int id;
	private String name;
	private Integer level;
	private Integer maxHealth;
	private String pcClassName;
	private PlayerClass pcclass;
	private ArrayList<Item> items;
	
	public Player() {
		this.items = new ArrayList<Item>();
	}
	
	public Player(int id, String name, String pcclass, int maxHealth, int level) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.pcclass = new PlayerClass(pcclass);
		this.pcClassName = this.pcclass.getName();
		this.maxHealth = maxHealth;
		this.items = new ArrayList<Item>();
	}
	
	public String toString() {
		
		return name + "\t" + level + "\t" + pcclass.getName() /*+ "\t" + getItems()*/;
		
	}
	
	public ArrayList<Item> getItems(){
		if (items.size() == 0) {
			items = DataBasePlayer.populateItems(mainUi.getConnection(),this);
		}
		return this.items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public PlayerClass getPcclass() {
		return pcclass;
	}
	
	public String getPcClassName() {
		return pcClassName;
	}

	public void setPcclass(PlayerClass pcclass) {
		this.pcclass = pcclass;
		this.pcClassName = pcclass.getName();
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Integer getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(Integer maxHealth) {
		this.maxHealth = maxHealth;
	}

}
