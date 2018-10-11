package genaric;

public class CharStats implements Cloneable{

	private Integer strength, dextarity, constitution, intellegence, wisdom, charisma, maxHealth, curentHealth, proficancy, level;
	private Proficiencies proficiencies = new Proficiencies();
	
	
	public CharStats(Integer strength, Integer dextarity, Integer constitution, Integer intellegence, Integer wisdom, Integer charisma, Integer maxHealth, Integer level) {
		this.strength = strength;
		this.dextarity = dextarity;
		this.constitution = constitution;
		this.intellegence = intellegence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.maxHealth = maxHealth;
		this.curentHealth = maxHealth;
		this.level = level;
		this.proficancy =  calcProficancyBonus();
		
	}
	
	
	public void addProficency(String toAdd) {
		proficiencies.addProficancy(toAdd);
	}
	
	public Proficiencies getProficiencies() {
		return proficiencies;
	}
	
	private Integer calcProficancyBonus() {
		return (int) ((Math.floor((Double.valueOf(level)/2)+1)));
	}

	
	public CharStats clone() throws CloneNotSupportedException {
		CharStats statClone = (CharStats) super.clone();
		statClone.proficiencies = (Proficiencies) this.proficiencies.clone();
		return statClone;
	}
	
	public class Proficiencies implements Cloneable{
		protected byte strSave, dexSave, conSave, intSave, chrSave, 
			athletics,
			acrobatics, slightOfHand, stealth, 
			arcana, history, investigation, nature, religion,
			animalHandleing, insight, medicine, perception, survival,
			deception, intimidation, performance, pesuation;
			;
		
		public Proficiencies() {
			this.strSave = 0;
			this.dexSave = 0;
			this.conSave = 0;
			this.intSave = 0;
			this.chrSave = 0;
			this.athletics = 0;
			this.acrobatics = 0;
			this.slightOfHand = 0;
			this.stealth = 0;
			this.arcana = 0;
			this.history = 0;
			this.investigation = 0;
			this.nature = 0;
			this.religion = 0;
			this.animalHandleing = 0;
			this.insight = 0;
			this.medicine = 0;
			this.perception = 0;
			this.survival = 0;
			this.deception = 0;
			this.intimidation =0;
			this.performance = 0;
			this.pesuation = 0;
			
		}
		
		public Proficiencies clone() throws CloneNotSupportedException {
			Proficiencies proClone = (Proficiencies) super.clone();
			return proClone;
		}
		
		public void addProficancy(String toAdd) {
			switch (toAdd){
			case "strSave": strSave++;
			case "dexSave": dexSave++;
			case "conSave": conSave++;
			case "intSave": intSave++;
			case "chrSave": chrSave++;
			
			//TODO: add the remaining proficiencies 
				
			}
		}
	
		
		
	
	}
	
	
	
	
	
}
