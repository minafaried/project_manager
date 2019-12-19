
public class MileStone {
	private int ID;
	private String name;
	private String date;
	
	public MileStone(int ID, String name, String date) {
		this.ID = ID;
		this.name = name;
		this.date = date;
	}
	
	public MileStone() {
		this(0, "", "");
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDate() {
		return date;
	}
	
	public String toString() {
		return ID + " " + name + " " + date;
	}
}
