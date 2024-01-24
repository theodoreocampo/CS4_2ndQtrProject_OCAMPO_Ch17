public class Ore {

  private String name, locationType; 
  private int rarity, strength, worth; 
  
  public Ore(String name, int rarity, int strength, int worth, String locationType){
    this.name = name;
    this.rarity = rarity;
    this.strength = strength;
    this.worth = worth;
    this.locationType = locationType;
  }

  public String getName() {
  	return name;
  }
  
  public void setName(String name) {
  	this.name = name;
  }
  
  public String getLocationType() {
  	return locationType;
  }
  
  public void setLocationType(String locationType) {
  	this.locationType = locationType;
  }
  
  public int getRarity() {
  	return rarity;
  }
  
  public void setRarity(int rarity) {
  	this.rarity = rarity;
  }
  
  public int getStrength() {
  	return strength;
  }
  
  public void setStrength(int strength) {
  	this.strength = strength;
  }
  
  public int getWorth() {
  	return worth;
  }
  
  public void setWorth(int worth) {
  	this.worth = worth;
  }
  
  
}