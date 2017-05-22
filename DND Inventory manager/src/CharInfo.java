import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CharInfo extends JPanel {
public CharInfo(String name,int str,int con,int dex,int cha,int wis,int Inte){
	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	add(new JLabel("Name: " + name));
	add(new JLabel("Str: " + str));
	add(new JLabel("Con: " + con));
	add(new JLabel("Dex: " + dex));
	add(new JLabel("Cha: " + cha));
	add(new JLabel("Wis: " + wis));
	add(new JLabel("Inte: " + Inte));
	
}

}
