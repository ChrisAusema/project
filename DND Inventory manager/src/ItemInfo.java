import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemInfo extends JPanel {
	public ItemInfo(String name, String type, String info){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new JLabel("Name: " + name));
		add(new JLabel("Type: " + type));
		add(new JLabel("Info: " + info));
	}

}
