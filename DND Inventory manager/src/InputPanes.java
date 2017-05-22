import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Characters;
import entity.Entity;
import entity.Inventory;
import entity.Items;

public class InputPanes {
	public void newChar(Model TITS,DefaultListModel<Characters> ListModel){
		
		JPanel Panel=new JPanel();
		JTextField name= new JTextField("Name:",6);
		JLabel Name = new JLabel("Bob");
	
		JTextField str=new JTextField("8",2);
		JLabel Str=new JLabel("Str:");
		JTextField con=new JTextField("8",2);
		JLabel Con=new JLabel("Con:");
		JTextField dex=new JTextField("8",2);
		JLabel Dex=new JLabel("Dex:");
		JTextField cha=new JTextField("8",2);
		JLabel Cha=new JLabel("Cha:");
		JTextField wis=new JTextField("8",2);
		JLabel Wis=new JLabel("Wis:");
		JTextField inte=new JTextField("8",2);
		JLabel Inte=new JLabel("Inte:");
		
		JTextField Inventoryname=new JTextField("Backpack",6);
		JLabel InventoryName= new JLabel("name of his/her Backpack");
		
		
		
		Panel.add(Name);
		Panel.add(name);
		Panel.add(Str);
		Panel.add(str);
		Panel.add(Con);
		Panel.add(con);
		Panel.add(Dex);
		Panel.add(dex);
		Panel.add(Cha);
		Panel.add(cha);
		Panel.add(Wis);
		Panel.add(wis);
		Panel.add(Inte);
		Panel.add(inte);
		Panel.add(InventoryName);
		Panel.add(Inventoryname);
		
		
		int result = JOptionPane.showConfirmDialog(null, Panel, "please fill out this form", JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			int STR=Integer.parseInt(str.getText());
			int CON=Integer.parseInt(con.getText());
			int DEX=Integer.parseInt(dex.getText());
			int CHA=Integer.parseInt(cha.getText());
			int WIS=Integer.parseInt(wis.getText());
			int INTE=Integer.parseInt(inte.getText());
			Characters NewCharacter = new Characters(name.getText(),STR,CON,DEX,CHA,WIS,INTE,Inventoryname.getText());
			TITS.AddCharacter(NewCharacter);
			ListModel.addElement(NewCharacter);
		}
	
	}
	
	public void editCharacter(Characters editableCharacter){
		JPanel Panel=new JPanel();
		JTextField name= new JTextField(editableCharacter.getName(),6);
		JLabel Name = new JLabel("Name:");
		
		Panel.add(Name);
		Panel.add(name);
		
		int result = JOptionPane.showConfirmDialog(null, Panel, "please fill out this form", JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
		 editableCharacter.setName(name.getText());
		}	
	}
	
	public void newInventory(Characters CharacterForNewInv,DefaultListModel<Inventory> Model){
		JPanel Panel=new JPanel();
		JTextField name=new JTextField("Backpack",6);
		JLabel Name=new JLabel("What is the name of this inventory?");
		Panel.add(Name);
		Panel.add(name);
		int result = JOptionPane.showConfirmDialog(null, Panel, "please fill out this form", JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			Inventory New=new Inventory(name.getText());
			CharacterForNewInv.AddInventory(New);
			Model.addElement(New);
		}		
	}
	
	public void editInventory(Inventory editableInventory){
		JPanel Panel=new JPanel();
		JTextField name=new JTextField(editableInventory.getName(),6);
		JLabel Name=new JLabel("What is the name of this inventory?");
		Panel.add(Name);
		Panel.add(name);
		int result = JOptionPane.showConfirmDialog(null, Panel, "please fill out this form", JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			editableInventory.setName(name.getText());
		}	
	}
	public void newItem(Inventory InventoryForNewItem , DefaultListModel<Items> ItemList){
		JPanel Panel=new JPanel();
		
		JTextField name=new JTextField("Item",6);
		JLabel Name=new JLabel("Item Name");
		
		JTextField type=new JTextField("Weapon",6);
		JLabel Type=new JLabel("Item Name");
		
		JTextField info=new JTextField("Item",36);
		JLabel Info=new JLabel("Item Name");
		
		Panel.add(Name);
		Panel.add(name);
		Panel.add(Type);
		Panel.add(type);
		Panel.add(Info);
		Panel.add(info);
		int result = JOptionPane.showConfirmDialog(null, Panel, "please fill out this form", JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			Items New=new Items(name.getText(),type.getText(),info.getText());
			InventoryForNewItem.addItem(New);
			ItemList.addElement(New);
		}	
	}
	
	public void EditItem(Items editableItems ){
		JPanel Panel=new JPanel();
		
		JTextField name=new JTextField(editableItems.getName(),6);
		JLabel Name=new JLabel("Item Info");
		
		JTextField type=new JTextField(editableItems.getType(),6);
		JLabel Type=new JLabel("Item Info");
		
		JTextField info=new JTextField(editableItems.getInfo(),36);
		JLabel Info=new JLabel("Item Info");
		
		Panel.add(Name);
		Panel.add(name);
		Panel.add(Type);
		Panel.add(type);
		Panel.add(Info);
		Panel.add(info);
		int result = JOptionPane.showConfirmDialog(null, Panel, "please fill out this form", JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			editableItems.setName(name.getText());editableItems.setType(type.getText());editableItems.setInfo(info.getText());
		}	
	}
	
	
	/*
	public void transferItem(DataModel data){
		JFrame frame= new JFrame("transfer");
		JPanel panel = new JPanel();
		Characters[] characterList =(Characters[]) data.CharacterToArray();
		
		JComboBox<Characters> characters= new JComboBox<Characters>(characterList);
		panel.add(characters);
		JComboBox<Inventory> inventory= new JComboBox<Inventory>(characterList);
		panel.add(characters);
		String characterName=JOptionPane.showInputDialog(frame, "which character", "yolo", JOptionPane.PLAIN_MESSAGE,null, characterList,characterList[0] ).toString();
		Characters character=(Characters) characterList[getObjectIndex(characterName,characterList)];

	}*/
	
	private int getObjectIndex(String name,Entity[] list){
		System.out.println(list[0]);
		for(int i=0;i<list.length;i++){
			System.out.println(list[i]);
			if( list[i].getName()==name){
				return i;
			}
		}
		return -1;
	}
}
