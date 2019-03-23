package objects;

import java.util.ArrayList;

public class Player {

	private int id;
	private String name;
	private int level;
	private ArrayList<Item> items;
	
	public Player() {
		
	}
	
	public Player(int id, String name, int level, ArrayList<Item> items) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.items = items;
	}
}
