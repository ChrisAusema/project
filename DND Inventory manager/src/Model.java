import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import entity.Characters;
import entity.Inventory;

public class Model extends Observable {
private ArrayList<Characters> CharacterList=new ArrayList<Characters>();
@Override
	public synchronized void addObserver(Observer o) {
		// TODO Auto-generated method stub
		super.addObserver(o);
	}

public Model(){
//	Items This =new Items("sword","Weapon","yolo");
//	CharacterList.add(new Characters("Chrissieboy050","backpack",This));
	
}
public int getSize(){
	return CharacterList.size();
}
public void AddCharacter(Characters NewCharacter){
	
	CharacterList.add(NewCharacter);
	setChanged();
	notifyObservers();
}
public void AddInventory(int index,Inventory inventory){
	CharacterList.get(index).AddInventory(inventory);
}

public Characters returnCharacter(int index){
	return CharacterList.get(index);
	
}

public void ModelUpdate(){
	setChanged();
	notifyObservers();
}
}
