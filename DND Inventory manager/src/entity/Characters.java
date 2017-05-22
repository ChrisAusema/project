package entity;
import java.util.ArrayList;

public class Characters extends Entity {
	private int str;
	private int con;
	private int dex;
	private int cha;
	private int wis;
	private int Inte;
	private ArrayList<Inventory> inventory=new ArrayList<Inventory>();
	public Characters(String name,  ArrayList<Inventory> inventory) {
		Name = name;
		this.inventory = inventory;
	}


	public Entity[] InventoryToArray(){
		Inventory[] arr=new Inventory[inventory.size()];
		for(int i=0;i<inventory.size();i++){
			arr[i]=inventory.get(i);
		}
		return arr;
		
	}
	public Characters(String name) {
		Name = name;
	}
	public Characters(String name,int str,int con,int dex, int cha,int wis,int Inte,String InventoryName) {
		Name = name;
		Inventory TITS=new Inventory(InventoryName);
		this.str=str;
		this.con=con;
		this.dex=dex;
		this.cha=cha;
		this.wis=wis;
		this.Inte=Inte;
		inventory.add(TITS);
	}

	public Characters(String name,String InventoryName,Items item) {
		Name = name;
		Inventory TITS=new Inventory(InventoryName);
		inventory.add(TITS);
		TITS.addItem(item);
	}
	public int getInventorySize(){
		return this.inventory.size();
	}
	
	public void AddInventory(Inventory inventory){
		this.inventory.add(inventory);
	}
	
	public void RemoveInventory(int Index){
		inventory.remove(Index);
	}

	public Inventory getInventory(int index) {
		return inventory.get(index);
	}
	public void setInventory(ArrayList<Inventory> inventory) {
		this.inventory = inventory;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
	
	public int getStr() {
		return str;
	}



	public void setStr(int str) {
		this.str = str;
	}



	public int getCon() {
		return con;
	}



	public void setCon(int con) {
		this.con = con;
	}



	public int getDex() {
		return dex;
	}



	public void setDex(int dex) {
		this.dex = dex;
	}



	public int getCha() {
		return cha;
	}



	public void setCha(int cha) {
		this.cha = cha;
	}



	public int getWis() {
		return wis;
	}



	public void setWis(int wis) {
		this.wis = wis;
	}



	public int getInte() {
		return Inte;
	}



	public void setInte(int inte) {
		Inte = inte;
	}



	public ArrayList<Inventory> getInventory() {
		return inventory;
	}



	public String toString(){
		String Name = getName();
		return Name;
	}
	
}
