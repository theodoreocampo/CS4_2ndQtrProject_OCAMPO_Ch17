public class Pickaxe {

  private String name; 
  private int price, rarity; 

  public Pickaxe(String name, int price, int rarity){
    this.name = name;
    this.price = price; 
    this.rarity = rarity; 
  }

  public String getName() {
  	return name;
  }
  
  public void setName(String name) {
  	this.name = name;
  }
  
  public int getPrice() {
  	return price;
  }
  
  public void setPrice(int price) {
  	this.price = price;
  }
  
  public int getRarity() {
  	return rarity;
  }
  
  public void setRarity(int rarity) {
  	this.rarity = rarity;
  }

  
}