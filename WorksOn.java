import java.util.List;

public class WorksOn {
	private Task task;
	private List<TeamMember> teamMembers;
	
	//!!Warning, These function uses shallow copy.
	public WorksOn(Task task, List<TeamMember> teamMembers) {
		this.task = task;
		this.teamMembers = teamMembers;
	}
	
	public WorksOn() {
		this(null, null);
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
	
	public void setTeamMembers(List<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}
	
	public Task getTask() {
		return task;
	}
	
	public List<TeamMember> getTeamMembers() {
		return teamMembers;
	}
	
	public void display() {
		System.out.println("Task Information.");
		task.display();
		
		System.out.println("Team Members Information.");
		for(TeamMember teamMemberObject : teamMembers) {
			System.out.println(teamMemberObject);
		}
	}
}
