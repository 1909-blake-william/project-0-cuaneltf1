package com.fdesign.darksouls.models;

public class Darksoul {
	
	private int id;
	private String name;
	private int vitality;
	private int endurance;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int level;
	private DarksoulType type;
	private User SoulBearer;
	
	public Darksoul() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Darksoul(int id, String name, int vitality, int endurance, int strength, int dexterity, int intelligence,
			int level, DarksoulType type, User soulBearer) {
		super();
		this.id = id;
		this.name = name;
		this.vitality = vitality;
		this.endurance = endurance;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.level = level;
		this.type = type;
		SoulBearer = soulBearer;
	}

	public Darksoul(int vitality, int endurance, int strength, int dexterity, int intelligence, int level) {
		super();
		this.vitality = vitality;
		this.endurance = endurance;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.level = level;
	}

	public Darksoul(String name, User soulBearer) {
		super();
		this.name = name;
		SoulBearer = soulBearer;
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

	public int getVitality() {
		return vitality;
	}

	public void setVitality(int vitality) {
		this.vitality = vitality;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public DarksoulType getType() {
		return type;
	}

	public void setType(DarksoulType type) {
		this.type = type;
	}

	public User getSoulBearer() {
		return SoulBearer;
	}

	public void setSoulBearer(User soulBearer) {
		SoulBearer = soulBearer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SoulBearer == null) ? 0 : SoulBearer.hashCode());
		result = prime * result + dexterity;
		result = prime * result + endurance;
		result = prime * result + id;
		result = prime * result + intelligence;
		result = prime * result + level;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + strength;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + vitality;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Darksoul other = (Darksoul) obj;
		if (SoulBearer == null) {
			if (other.SoulBearer != null)
				return false;
		} else if (!SoulBearer.equals(other.SoulBearer))
			return false;
		if (dexterity != other.dexterity)
			return false;
		if (endurance != other.endurance)
			return false;
		if (id != other.id)
			return false;
		if (intelligence != other.intelligence)
			return false;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (strength != other.strength)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (vitality != other.vitality)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Darksoul [id=" + id + ", name=" + name + ", vitality=" + vitality + ", endurance=" + endurance
				+ ", strength=" + strength + ", dexterity=" + dexterity + ", intelligence=" + intelligence + ", level="
				+ level + ", type=" + type + ", SoulBearer=" + SoulBearer + "]";
	}
	
	
	}