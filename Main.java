import java.util.Scanner; 
import java.util.ArrayList; 

class Main {
  public static void main(String[] args) {

    
    //initialization of Scanner and Theme
    Scanner scan = new Scanner(System.in);

    System.out.println("Choose Mode: (Aboveground/Underground)"); 
    String theme = scan.nextLine();
    

    
    
    //initialization of Ores
    Ore underWood = new Ore("underWood", 1, 2, 4, "Under");
    Ore vines = new Ore("vines", 1, 2, 1, "Under");
    Ore basalt = new Ore("basalt", 1, 2, 2, "Under");
    Ore gravel = new Ore("gravel", 2, 3, 5, "Under"); 
    Ore sulphur = new Ore("sulphur", 2, 4, 5, "Under");
    Ore quartz = new Ore("quartz", 2, 3, 6, "Under");
    Ore pyrite = new Ore("pyrite", 3, 4, 1, "Under");
    Ore magma = new Ore("magma", 3, 4, 10, "Under");
    Ore garnet = new Ore("garnet", 3, 5, 11, "Under");
    Ore gold = new Ore("gold", 4, 6, 15, "Under"); 
    Ore obsidian = new Ore("obsidian", 4, 7, 16, "Under");
    Ore bedrock = new Ore("bedrock", 5, 15, 40, "Under");

    ArrayList<Ore> underOres = new ArrayList<Ore>();
   
    underOres.add(underWood);
    underOres.add(vines);
    underOres.add(basalt);
    underOres.add(gravel);
    underOres.add(sulphur);
    underOres.add(quartz);
    underOres.add(pyrite);
    underOres.add(magma);
    underOres.add(garnet);
    underOres.add(gold);
    underOres.add(obsidian);
    underOres.add(bedrock);
    
    Ore dirt = new Ore("dirt", 1, 1, 2, "Above");
    Ore wood = new Ore("wood", 1, 2, 4, "Above");
    Ore sand = new Ore("sand", 2, 3, 2, "Above");
    Ore mud = new Ore("mud", 2, 3, 5, "Above");
    Ore stone = new Ore("stone", 2, 4, 4, "Above");
    Ore coal = new Ore("coal", 3, 5, 6, "Above");
    Ore iron = new Ore("iron", 3, 6, 8, "Above");
    Ore copper = new Ore("emerald", 3, 6, 10, "Above");
    Ore diamond = new Ore("diamond", 4, 7, 12, "Above");
    Ore emerald = new Ore("copper", 4, 8, 14, "Above");
    Ore titanium = new Ore("titanium", 5, 15, 40, "Above");

    ArrayList<Ore> aboveOres = new ArrayList<Ore>();
 
    aboveOres.add(dirt);
    aboveOres.add(wood);
    aboveOres.add(sand);
    aboveOres.add(mud);
    aboveOres.add(stone);
    aboveOres.add(coal);
    aboveOres.add(iron);
    aboveOres.add(copper);
    aboveOres.add(diamond);
    aboveOres.add(emerald);
    aboveOres.add(titanium);
    
    
    //initialization of Pickaxes
    Pickaxe woodPick = new Pickaxe("Wooden Pickaxe", 0, 1);
    Pickaxe stonePick = new Pickaxe("Stone Pickaxe", 20, 2);
    Pickaxe ironPick = new Pickaxe("Iron Pickaxe", 50, 3);
    Pickaxe emeraldPick = new Pickaxe("Emerald Pickaxe", 200, 4);
    Pickaxe crystalPick = new Pickaxe("Crystal Pickaxe", 400, 5);
    
    //initialization of Player
    System.out.println("Enter name: "); 
    String name = scan.nextLine(); 
    Player player = new Player(name, 0, woodPick);

   
    
    //initialization of Locations 
    Location undergroundLocation = new Location("Underground", underOres);
    Location abovegroundLocation = new Location("Aboveground", aboveOres);
    
    Location themeLocation = abovegroundLocation; 

    

    
    if(theme.equals("underground")){
      System.out.println("Underground is more difficult! Good Luck, " + name + "!");
      themeLocation = undergroundLocation; 
    }
    
    //initialization of main screen
    Ore slot1 = themeLocation.generateEasy(); 
    Ore slot2 = themeLocation.generateEasy();
    Ore slot3 = themeLocation.generate();
    Ore slot4 = themeLocation.generate();
    Ore slot5 = themeLocation.generate();
    Ore slot6 = themeLocation.generate();
    Ore slot7 = themeLocation.generate();
    Ore slot8 = themeLocation.generate(); 
    Ore slot9 = themeLocation.generate();
    
    System.out.println("slot1 is " + slot1.getName());
    System.out.println("slot2 is " + slot2.getName());
    System.out.println("slot3 is " + slot3.getName());
    System.out.println("slot4 is " + slot4.getName());
    System.out.println("slot5 is " + slot5.getName());
    System.out.println("slot6 is " + slot6.getName());
    System.out.println("slot7 is " + slot7.getName());
    System.out.println("slot8 is " + slot8.getName());
    System.out.println("slot9 is " + slot9.getName());

    System.out.println("note: this system of display is to be updated every 2 seconds in the UI. ");

    System.out.println("Pick a Scenario (1,2,3): ");
    int scenario = scan.nextInt();

    //SCENARIO 1 - player buys pickaxe
    if(scenario == 1){
      player.setMoney(1000000); 
      player.buyPickaxe(crystalPick); 

      if(player.getPlayerPickaxe() == crystalPick){
        System.out.println("You now have a " + crystalPick.getName()); 
      }

      System.out.println("You have" + player.getMoney() + " left."); 
    }

    //SCENARIO 2 - player mines slot 2
    if(scenario == 2){
      player.mine(slot2); 
      System.out.println("Player Inventory: "); 
      player.displayInventory(); 

      if(slot2.getStrength() == 0){
        if(slot2.getRarity() == 1){ 
          slot2 = themeLocation.generateEasy(); 
        }

        else{
          slot2 =  themeLocation.generate(); 
        }
      }
      
    }

    //SCENARIO 3 - player sells Ore
    if(scenario == 3){
      player.setMoney(0); 
      ArrayList<Ore> playerinv = player.getPlayerInventory(); 
      playerinv.add(dirt); 

      player.setPlayerInventory(playerinv); 
      
      player.sellOre(dirt); 
      System.out.println("Player Inventory: ");
      player.displayInventory();

      System.out.println("You now have " + player.getMoney() + " money"); 
    }
    
    
  }
}