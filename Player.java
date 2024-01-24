import java.util.ArrayList;

public class Player {

  private String name;
  private int money; 
  private Pickaxe playerPickaxe; 
  ArrayList<Ore> playerInventory = new ArrayList<Ore>();

  public Player(String name, int money, Pickaxe playerPickaxe){
    this.name = name; 
    this.money = money; 
    this.playerPickaxe = playerPickaxe; 
  }

  public String getName() {
  	return name;
  }
  
  public void setName(String name) {
  	this.name = name;
  }
  
  public int getMoney() {
  	return money;
  }
  
  public void setMoney(int money) {
  	this.money = money;
  }
  
  public Pickaxe getPlayerPickaxe() {
  	return playerPickaxe;
  }
  
  public void setPlayerPickaxe(Pickaxe playerPickaxe) {
  	this.playerPickaxe = playerPickaxe;
  }
  
  public ArrayList<Ore> getPlayerInventory() {
  	return playerInventory;
  }
  
  public void setPlayerInventory(ArrayList<Ore> playerInventory) {
  	this.playerInventory = playerInventory;
  }

  public void displayInventory() {
    if(playerInventory.size() == 0){
      System.out.println("empty");
    }

    else{
      for (int i = 0; i < playerInventory.size(); i++){
        System.out.println(playerInventory.get(i).getName());
      }
    }
  }

  //methods begin here

  public void mine(Ore givenOre){
    
    if(playerPickaxe.getRarity() >= givenOre.getRarity()){
      givenOre.setStrength(givenOre.getStrength() - 1);
      System.out.println("You chipped a bit at " + givenOre.getName() + ".");
      if(givenOre.getStrength() == 0){
        playerInventory.add(givenOre);
        System.out.println("The ore breaks and you mined " + givenOre.getName() + ".");
      }
    }
      
    else{
      System.out.println("You don't have the right pickaxe!");
    }
    
  }

  public void sellOre(Ore givenOre){
    
    if(playerInventory.contains(givenOre)){
      
      money = money + givenOre.getRarity(); 
      playerInventory.remove(givenOre);
      System.out.println("You have successfully sold " + givenOre.getName() + ".");
    }
      
    else{
      
      System.out.println("You sold 1 air block. (You don't have that ore.)");
      
    }
    
  }


  public void buyPickaxe(Pickaxe givenPickaxe){

    if(money >= givenPickaxe.getPrice()){
      
      playerPickaxe = givenPickaxe; 
      money = money - givenPickaxe.getPrice();
      System.out.println("successful purchase!"); 
    }

    else{

      System.out.println("You're too broke! haha");
      
    }
    
  }
  
}