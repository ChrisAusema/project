import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class View extends JFrame implements Observer {
	
	DataModel Data=new DataModel();
	CharInfo charInfo=new CharInfo("",0,0,0,0,0,0);
	ItemInfo itemInfo=new ItemInfo("","","");
	JPanel characterPanel = new JPanel();
	JPanel itemPanel = new JPanel();
	public View(){
	super("Character inventory manager");
	Buttonclass Buttons=new Buttonclass(Data,this);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1000,300);
	
	JMenuBar MenuBar=new JMenuBar();
	JMenu File = new JMenu("File");
	JButton AddingCharacter=new JButton("Add Character");
	JButton AddingInventory=new JButton("Add Inventory");
	JButton AddingItem=new JButton("Add Item");
	JButton Save =new JButton("Save");
	JButton Load=new JButton("Load");
	JButton EditItem=new JButton("Edit Item");
	JButton EditInventory = new JButton("Edit Inventory");
	JButton EditCharacter = new JButton("Edit Character");
	JButton RemoveItem = new JButton("Remove Item");
	JButton RemoveInventory= new JButton("Remove Inventory");
	JButton transferItem = new JButton("Transfer Item");
	Data.characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	Data.inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	
	
	
	JPanel infoPanel=new JPanel(new BorderLayout());
	JPanel ButtonPanel=new JPanel(new BorderLayout());
	JPanel Lists= new JPanel(new BorderLayout());
	JPanel looseButtons =new JPanel(new FlowLayout());
	looseButtons.add(AddingCharacter);
	looseButtons.add(AddingInventory);
	looseButtons.add(AddingItem);
	looseButtons.add(EditCharacter);
	looseButtons.add(EditInventory);
	looseButtons.add(EditItem);
	looseButtons.add(transferItem);
	looseButtons.add(RemoveInventory);
	looseButtons.add(RemoveItem);
	File.add(Save);
	File.add(Load);
	MenuBar.add(File);
	ButtonPanel.add(MenuBar,BorderLayout.NORTH);
	ButtonPanel.add(looseButtons,BorderLayout.SOUTH);
	
	characterPanel.setLayout(new BoxLayout(characterPanel, BoxLayout.PAGE_AXIS));
	characterPanel.add(charInfo);
	Lists.add(new JScrollPane(Data.characterList),BorderLayout.WEST);
	infoPanel.add(characterPanel, BorderLayout.WEST);
	Data.characterList.setFixedCellWidth(200);
	Data.characterList.setVisibleRowCount(4);
	Lists.add(new JScrollPane(Data.inventoryList),BorderLayout.CENTER);
	Data.inventoryList.setFixedCellWidth(200);
	Data.inventoryList.setVisibleRowCount(4);
	itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.PAGE_AXIS));
	itemPanel.add(itemInfo,BorderLayout.WEST);
	Lists.add(new JScrollPane(Data.itemList),BorderLayout.EAST);
	infoPanel.add(itemPanel,BorderLayout.EAST);
	Lists.add(infoPanel,BorderLayout.SOUTH);
	Data.itemList.setFixedCellWidth(200);
	Data.itemList.setVisibleRowCount(4);
	add(ButtonPanel,BorderLayout.NORTH);
	add(Lists,BorderLayout.CENTER);
	
	
	
	
Save.addActionListener(Buttons.save);
	
	Load.addActionListener(Buttons.load);
	transferItem.addActionListener(Buttons.transferItem);
	AddingCharacter.addActionListener(Buttons.addChar);
	
	AddingInventory.addActionListener(Buttons.addInv);
	
	AddingItem.addActionListener(Buttons.addItem);
	
	EditItem.addActionListener(Buttons.editItem);
	
	EditInventory.addActionListener(Buttons.editInv);
	
	EditCharacter.addActionListener(Buttons.editChar);	
	
	RemoveItem.addActionListener(Buttons.removeItem);
	
	RemoveInventory.addActionListener(Buttons.removeInv);
	
	Data.characterList.addListSelectionListener(Buttons.charList);
	
	Data.inventoryList.addListSelectionListener(Buttons.invList);
			
	Data.itemList.addListSelectionListener(Buttons.itemList);
	
	
	
	
	setVisible(true);
}
	
	@Override
	public void update(Observable o, Object arg) {
			Data.characterList.setModel(Data.characterModel);
			Data.inventoryList.setModel(Data.inventoryModel);
			Data.itemList.setModel(Data.itemModel);
}

}