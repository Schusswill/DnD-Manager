package genaric;

import javax.swing.JFrame;

public abstract class Player {

	private ItemBag bag;
	private CharStats stats, tempStats;
	
	
	
	public abstract void levelUp();
	
	public void UpdateStats() {
		
	}
	
	public Player(CharStats stats) {
		this.stats = stats;
		bag = new ItemBag();
		try {
			tempStats = stats.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Player(Integer strength, Integer dextarity, Integer constitution, Integer intellegence, Integer wisdom, Integer charisma, Integer maxHealth, Integer level) {
		this.stats = new CharStats(strength, dextarity, constitution, intellegence, wisdom, charisma, maxHealth, level);
		bag = new ItemBag();
		try {
			tempStats = stats.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void playerCreation() {
		PlayerCreationWindow playerWindow = new PlayerCreationWindow();
		playerWindow.setVisible(true);
	}
	
	
	private static class PlayerCreationWindow extends JFrame{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public PlayerCreationWindow() {
			
		}
		
	}
}
