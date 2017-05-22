import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entity.Characters;
import entity.Inventory;
import entity.Items;

public class Buttonclass {
SaveLoad saveLoad=new SaveLoad();
private Model Characters=new Model();
private DataModel Data;
private View view;
public Buttonclass(DataModel Data,View view){
	this.Data=Data;
	this.view=view;
}
ActionListener save=new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			saveLoad.Save(Characters);
		} catch (FileNotFoundException e1) {
			System.out.println("Error opening the file graph.txt.");
			System.exit(0);
		}
		
	}
};

ActionListener load =new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			saveLoad.Load(Characters,Data.characterModel);
		} catch (FileNotFoundException e) {
			System.out.println("No Such File");
			System.exit(0);
		}
		
	}
};

ActionListener addChar=new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		InputPanes yolo=new InputPanes();
		yolo.newChar(Characters,Data.characterModel);
		
	}
};

ActionListener addInv=new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		InputPanes yolo=new InputPanes();
		if(Data.characterList.getSelectedIndex()!=-1){
			yolo.newInventory(Data.characterModel.getElementAt(Data.characterList.getSelectedIndex()),Data.inventoryModel);
			Characters.ModelUpdate();
		}
		else{
			JOptionPane.showMessageDialog(null,"Please Select a Character first", "alert", JOptionPane.ERROR_MESSAGE);
		}
	}
};

ActionListener addItem=new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		InputPanes yolo=new InputPanes();
		if(Data.characterList.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null,"Please Select a Character first", "alert", JOptionPane.ERROR_MESSAGE);
		}
		else if(Data.inventoryList.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null,"Please Select a inventory first", "alert", JOptionPane.ERROR_MESSAGE);
		}
		else{
			yolo.newItem(Data.inventoryModel.getElementAt(Data.inventoryList.getSelectedIndex()), Data.itemModel);
			Characters.ModelUpdate();
		}
	}
};


	

ActionListener editItem = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		InputPanes yolo=new InputPanes();
		if(Data.characterList.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null,"Please Select a Character first", "alert", JOptionPane.ERROR_MESSAGE);
		}
		else if(Data.inventoryList.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null,"Please Select a inventory first", "alert", JOptionPane.ERROR_MESSAGE);
		}
		else{
			yolo.EditItem(Data.itemModel.getElementAt(Data.itemList.getSelectedIndex()));
			Characters.ModelUpdate();
		}
	}
		
};

ActionListener editInv =new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		InputPanes yolo=new InputPanes();
		if(Data.characterList.getSelectedIndex()!=-1){
			yolo.editInventory(Data.inventoryModel.getElementAt(Data.inventoryList.getSelectedIndex()));
			Characters.ModelUpdate();
		}
		else{
			JOptionPane.showMessageDialog(null,"Please Select a Character first", "alert", JOptionPane.ERROR_MESSAGE);
		}
	}
};

ActionListener editChar=new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		InputPanes yolo=new InputPanes();
		if(Data.characterList.getSelectedIndex()!=-1){
			yolo.editCharacter(Data.characterModel.getElementAt(Data.characterList.getSelectedIndex()));
			Characters.ModelUpdate();
		}
		else{
			JOptionPane.showMessageDialog(null,"Please Select a Character first", "alert", JOptionPane.ERROR_MESSAGE);
		}
	}
};

ActionListener removeItem=new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Data.itemList.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null,"Please select an item first", "alert", JOptionPane.ERROR_MESSAGE);
		}
		else{
			Data.inventoryModel.getElementAt(Data.inventoryList.getSelectedIndex()).removeItem(Data.itemList.getSelectedIndex());
		}
		Data.itemModel.remove(Data.itemList.getSelectedIndex());
		Characters.ModelUpdate();
	}
};

ActionListener removeInv=new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Data.inventoryList.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null,"Please select a Inventory first", "alert", JOptionPane.ERROR_MESSAGE);
		}
		else{
			Data.characterModel.getElementAt(Data.characterList.getSelectedIndex()).RemoveInventory(Data.inventoryList.getSelectedIndex());;
		}
		Data.inventoryModel.remove(Data.inventoryList.getSelectedIndex());
		Characters.ModelUpdate();
	}
};

ListSelectionListener charList=new ListSelectionListener() {
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Data.inventoryList.removeAll();
		Data.inventoryModel.removeAllElements();
		Data.itemModel.removeAllElements();
		Data.itemList.removeAll();
		Characters TITS=Data.characterModel.getElementAt(Data.characterList.getSelectedIndex()) ;
		for(int i=0;i<TITS.getInventorySize();i++){
			Data.inventoryModel.addElement(TITS.getInventory(i));
		}
		view.charInfo=new CharInfo(TITS.getName(),TITS.getStr(),TITS.getCon(),TITS.getDex(),TITS.getCha(),TITS.getWis(),TITS.getInte());
		view.characterPanel.remove(0);
		view.characterPanel.add(view.charInfo);
		view.characterPanel.setVisible(false);
		view.characterPanel.setVisible(true);
		Data.inventoryList.setModel(Data.inventoryModel);
	}
};

ListSelectionListener invList=new ListSelectionListener() {
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Data.itemList.removeAll();
		Data.itemModel.removeAllElements();
		
		if(Data.inventoryList.getSelectedIndex()!=-1){
			
			Inventory ASS= Data.inventoryModel.get(Data.inventoryList.getSelectedIndex());
			for(int i=0;i<ASS.getSize();i++){
				Data.itemModel.addElement(ASS.getItem(i));
			}
			Data.itemList.setModel(Data.itemModel);
		}
		Characters.ModelUpdate();
	}
};

ListSelectionListener itemList=new ListSelectionListener() {
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(Data.itemList.getSelectedIndex()!=-1){
	Items TITS=Data.itemModel.getElementAt(Data.itemList.getSelectedIndex()) ;
		view.itemInfo = new ItemInfo(TITS.getName(),TITS.getType(),TITS.getInfo());
		view.itemPanel.remove(0);
		view.itemPanel.add(view.itemInfo);
		view.itemPanel.setVisible(false);
		view.itemPanel.setVisible(true);
		}
	}	
};

ActionListener transferItem=new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e) {
		InputPanes yolo=new InputPanes();
		if(Data.itemList.getSelectedIndex()!=-1){
		//	yolo.transferItem(Data);
			Characters.ModelUpdate();
		}
		else{
			JOptionPane.showMessageDialog(null,"Please Select a Item first", "alert", JOptionPane.ERROR_MESSAGE);
		}
	}
	
};

}
