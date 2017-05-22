import javax.swing.DefaultListModel;
import javax.swing.JList;

import entity.Characters;
import entity.Entity;
import entity.Inventory;
import entity.Items;

public class DataModel {
	DefaultListModel<Characters> characterModel= new DefaultListModel<Characters>();
	DefaultListModel<Inventory> inventoryModel=new DefaultListModel<Inventory>();
	DefaultListModel<Items> itemModel=new DefaultListModel<Items>();
	JList characterList = new JList<Characters>(characterModel);
	JList inventoryList=new JList<Inventory>(inventoryModel);
	JList itemList = new JList<Items>(itemModel);

	public Entity[] CharacterToArray(){
		Characters[] arr=new Characters[characterModel.size()];
		for(int i=0;i<characterModel.size();i++){
			arr[i]=characterModel.getElementAt(i);
		}
		return arr;
		
	}

}
