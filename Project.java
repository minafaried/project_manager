import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Project implements Serializable {
	private String name;
	private double cost;
	private Date startDate;
	private Date dueDate;
	private List<Deliverable> expectedDeliverables;
	private int workingHours; //hours / day.
	private String startOfWeek;
	
	//!!Warning these functions shallow copy the list of expected deliverables.
	public Project(String name, double cost, Date startDate, Date dueDate, List<Deliverable> expectedDeliverables, int workingHours, String startOfWeek) {
		this.name = name;
		this.cost = cost;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.expectedDeliverables = expectedDeliverables;
		this.workingHours = workingHours; //Hours / Day.
		this.startOfWeek = startOfWeek;
	}
	
	public Project() {
		this("", 0.0, new Date(), new Date(), new ArrayList<Deliverable>(), 0, Project.sunDay()); //By default the start of the week is Sunday.
	}

	public static String sunDay() {
		return "Sunday";
	}
	
	public static String monDay() {
		return "Monday";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setExpectedDeliverables(List<Deliverable> expectedDeliverables) {
		this.expectedDeliverables = expectedDeliverables;
	}
	
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	
	public void setStartOfWeek(String startOfWeek) {
		this.startOfWeek = startOfWeek;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getCost() {
		return cost;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public List<Deliverable> getExpectedDeliverables() {
		return expectedDeliverables;
	}
	
	public int getWorkingHours() {
		return workingHours;
	}
	
	public String getStartOfWeek() {
		return startOfWeek;
	}
	
	public void Display() {
		System.out.println("Project Name :" + name);
		System.out.println("Project Cost :" + cost);
		System.out.println("Project Start Date :" + startDate);
		System.out.println("Project Due Date :" + dueDate);
	
		String temp = "";
		for(Deliverable deliverableObject : expectedDeliverables) {
			temp += deliverableObject + " ";
		}
		System.out.println("Project Expected Deliverables :" + temp);
		
		System.out.println("Project Working Hours Per Day :" + workingHours);
		System.out.println("Project Start Of The Week Day :" + startOfWeek);
	}
}
