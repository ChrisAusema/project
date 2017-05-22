package entity;
import java.util.ArrayList;

public class Inventory extends Entity {
	private ArrayList<Items> Inventory=new ArrayList<>();
	public Inventory() {
		Name="BackPack";
	}
	
	public Inventory(String name){
		Name=name;
	}

	public ArrayList<Items> getInventory() {
		return Inventory;
	}
	public void addItem(Items newItem){
		Inventory.add(newItem);
	}
	
	public void removeItem(int Index){
		Inventory.remove(Index);
	}
	
	public int getSize(){
		return Inventory.size();
	}
	public Items getItem(int index) {
		return Inventory.get(index);
	}

	public void setInventory(ArrayList<Items> inventory) {
		Inventory = inventory;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public String toString(){
		return Name;
	}


}
