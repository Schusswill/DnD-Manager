package objects;

import java.util.ArrayList;

public class Player{

	private int id;
	private String name;
	private Integer level;
	private PlayerClass pcclass;
	private ArrayList<Item> items;
	
	public Player() {
		
	}
	
	public Player(int id, String name, int level, ArrayList<Item> items) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.items = items;
	}
	
	public String toString() {
		
		return id + "\t" + name + "\t" + level + "\t" + items.toString();
		
	}

	public String getName() {
		return this.name;
	}
	
	public Integer getLevel() {
		return this.level;
	}
}
