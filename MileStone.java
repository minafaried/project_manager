
public class MileStone {
	private int ID;
	private String name;
	private Date date;
	
	public MileStone(int ID, String name, Date date) {
		this.ID = ID;
		this.name = name;
		this.date = date;
	}
	
	public MileStone() {
		this(0, "", new Date());
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String toString() {
		return ID + " " + name + " " + date;
	}
}
