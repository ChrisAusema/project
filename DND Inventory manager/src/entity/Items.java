package entity;

public class Items extends Entity{
	private String Type;
	private String Info;
	public Items(String name, String type, String info) {
		Name = name;
		Type = type;
		Info = info;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	
	public String toString(){
		return Name;
	}
}
