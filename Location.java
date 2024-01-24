import java.util.ArrayList; 
import java.util.Random;

public class Location {
  private String name; 
  ArrayList<Ore> locationOres = new ArrayList<Ore>();

  public Location(String name, ArrayList<Ore> locationOres){
    this.name = name; 
    this.locationOres = locationOres; 
  }
  
  public String getName() {
  	return name;
  }
  public void setName(String name) {
  	this.name = name;
  }
  public ArrayList<Ore> getLocationOres() {
  	return locationOres;
  }
  public void setLocationOres(ArrayList<Ore> locationOres) {
  	this.locationOres = locationOres;
  }

  Random rand1 = new Random();
  
  public Ore generate(){

    //random index in locationOres, essentially a random ore picked
    int random = rand1.nextInt(locationOres.size()); 
    return locationOres.get(random); 
  }

  public Ore generateEasy(){

    //guarantees a rarity 1 ore for beginners
    int random = rand1.nextInt(2); 
    return locationOres.get(random); 
  }

  
}