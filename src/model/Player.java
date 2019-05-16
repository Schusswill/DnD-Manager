package model;

import java.util.ArrayList;

import dataBase.DataBasePlayer;

public class Player{

	private String name;
	private Integer level;
	private PlayerClass pcclass;
	private ArrayList<Item> items;
	
	public Player() {
		this.items = new ArrayList<Item>();
	}
	
	public Player( String name, int level, String pcClass) {
		this.name = name;
		this.level = level;
		this.pcclass = new PlayerClass(pcClass);
		this.items = new ArrayList<Item>();
	}
	
	public String toString() {
		
		return name + "\t" + level + pcclass.getName() + "\t" + getItems();
		
	}
	
	public ArrayList<Item> getItems(){
		if (items.size() == 0) {
			items = DataBasePlayer.populateItems(this.name);
		}
		return this.items;
	}

	public String getName() {
		return this.name;
	}
	
	public Integer getLevel() {
		return this.level;
	}
}
