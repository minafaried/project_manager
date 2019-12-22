
public class Task {
	private int ID;
	private int workingHours;
	private Date plannedStartDate;
	private Date plannedDueDate;
	private Date actualStartDate;
	private Date actualDueDate;

	public Task(int ID, int workingHours, Date plannedStartDate, Date plannedDueDate, Date actualStartDate,
			Date actualDueDate) {
		this.ID = ID;
		this.workingHours = workingHours;
		this.plannedStartDate = plannedStartDate;
		this.plannedDueDate = plannedDueDate;
		this.actualStartDate = actualStartDate;
		this.actualDueDate = actualDueDate;
	}

	public Task() {
		this(0, 0, new Date(), new Date(), new Date(), new Date());
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public void setPlannedStartDate(Date plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public void setPlannedDueDate(Date plannedDueDate) {
		this.plannedDueDate = plannedDueDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public void setActualDueDate(Date actualDueDate) {
		this.actualDueDate = actualDueDate;
	}

	public int getID() {
		return ID;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public Date getPlannedStartDate() {
		return plannedStartDate;
	}

	public Date getPlannedDueDate() {
		return plannedDueDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public Date getActualDueDate() {
		return actualDueDate;
	}
	
	public void display() {
		System.out.println("Task ID :" + ID);
		System.out.println("Task Working Hours :" + workingHours);
		System.out.println("Task Planned Start Date :" + plannedStartDate);
		System.out.println("Task Planned Due Date :" + plannedDueDate);
		System.out.println("Task Actual Start Date :" + actualStartDate);
		System.out.println("Task Actual Due Date :" + actualDueDate);
	}
}
