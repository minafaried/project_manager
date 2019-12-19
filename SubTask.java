
public class SubTask extends Task {
	private int parentID;

	public SubTask(int ID, int workingHours, Date plannedStartDate, Date plannedDueDate, Date actualStartDate,
			Date actualDueDate, int parentID) {
		super(ID, workingHours, plannedStartDate, plannedDueDate, actualStartDate, actualDueDate);
		this.parentID = parentID;
	}

	public SubTask() {
		this(0, 0, null, null, null, null, 0);
	}
	
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	
	public int getParentID() {
		return parentID;
	}
	
	public void display() {
		super.display();
		System.out.println("Task Parent ID :" + parentID);
	}
}
