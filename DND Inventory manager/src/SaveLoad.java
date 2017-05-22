import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import entity.Characters;
import entity.Inventory;
import entity.Items;

public class SaveLoad {

	public void Save(Model Characters) throws FileNotFoundException{
		JFileChooser saveFile =new JFileChooser();
		if (saveFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = saveFile.getSelectedFile();
			PrintWriter output = new PrintWriter(file);
			output.println(Characters.getSize());
			for(int i=0;i<Characters.getSize();i++ ){
				Characters SaveCharacter =Characters.returnCharacter(i);
				SaveCharacter.setName(SaveCharacter.getName().replaceAll(" ", "_"));
				output.println(SaveCharacter);
				output.println(SaveCharacter.getInventorySize());
				for(int j=0;j<SaveCharacter.getInventorySize();j++){
					Inventory SaveInventory=SaveCharacter.getInventory(j);
					SaveInventory.setName(SaveInventory.getName().replaceAll(" ", "_"));
					output.println("	"+SaveInventory.getName());
					output.println("	"+SaveInventory.getSize());
					for(int k=0;k<SaveInventory.getSize();k++){
						Items SaveItem=SaveInventory.getItem(k);
						SaveItem.setName(SaveItem.getName().replaceAll(" ", "_"));
						SaveItem.setInfo(SaveItem.getInfo().replaceAll(" ", "_"));
						SaveItem.setType(SaveItem.getType().replaceAll(" ", "_"));
						output.println("		"+SaveItem.getName());
						output.println("		"+SaveItem.getType());
						output.println("		"+SaveItem.getInfo());
					}
				}		
				
			}
			output.close();
			}

}
	public void Load(Model Characters,DefaultListModel<Characters> CharacterModel) throws FileNotFoundException{
		int amountCharacters,amountInventorys, amountItems;
		Model LoadModel=new Model();
		ArrayList<Inventory> Inventorys = new ArrayList<Inventory>();
		JFileChooser SaveFile=new JFileChooser();
		int returnVal = SaveFile.showOpenDialog(null);
		if(returnVal == JFileChooser.CANCEL_OPTION) {
			return;
		}
		File File = SaveFile.getSelectedFile();
		Scanner Input=new Scanner(File);
		amountCharacters=Input.nextInt();
		for(int i=0;i<amountCharacters;i++){
			Characters LoadChar=new Characters(Input.next());
			LoadChar.setName(LoadChar.getName().replaceAll("_", " "));
			amountInventorys=Input.nextInt();
			for(int j=0;j<amountInventorys;j++){
				Inventory LoadInventory=new Inventory(Input.next());
				LoadInventory.setName(LoadInventory.getName().replaceAll("_", " "));
				amountItems=Input.nextInt();
				for(int k=0;k<amountItems;k++){
					Items LoadItems=new Items(Input.next(),Input.next(),Input.next());
					LoadItems.setName(LoadItems.getName().replaceAll("_"," "));
					LoadItems.setInfo(LoadItems.getInfo().replaceAll("_"," "));
					LoadItems.setType(LoadItems.getType().replaceAll("_"," "));
					LoadInventory.addItem(LoadItems);
					
				}
				LoadChar.AddInventory(LoadInventory);;
			}
			LoadModel.AddCharacter(LoadChar);
			
		}
		Input.close();
		Characters=LoadModel;
		CharacterModel.removeAllElements();
		for(int i=0;i<amountCharacters;i++){
			CharacterModel.addElement(Characters.returnCharacter(i));
		}
		
		Characters.ModelUpdate();
		
	}
}
