import java.io.Serializable;

public class Deliverable implements Serializable {
	private int ID;
	private String description;
	
	public Deliverable(int ID, String description) {
		this.ID = ID;
		this.description = description;
	}
	
	public Deliverable() {
		this(0, "");
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return ID + " " + description;
	}
}
