
public class TeamMember {
	private int ID;
	private String name;
	private String title;
	private int workingHours;
	
	public TeamMember(int ID, String name, String title, int workingHours) {
		this.ID = ID;
		this.name = name;
		this.title = title;
		this.workingHours = workingHours;
	}
	
	public TeamMember() {
		this(0, "", "", 0);
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getWorkingHours() {
		return this.workingHours;
	}
	
	public String toString() {
		return ID + " " + name + " " + title + " " + workingHours;
	}
}
