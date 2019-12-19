import java.util.List;

public class DependsOn {
	private Task task;
	private List<Task> dependentTasks;
	
	//!!Warning, These functions uses shallow copy.
	public DependsOn(Task task, List<Task> dependentTasks) {
		this.task = task;
		this.dependentTasks = dependentTasks;
	}
	
	public DependsOn() {
		this(null, null);
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
	
	public void setDependentTasks(List<Task> dependentTasks) {
		this.dependentTasks = dependentTasks;
	}
	
	public Task getTask() {
		return task;
	}
	
	public List<Task> getDependentTasks() {
		return dependentTasks;
	}
	
	public void display() {
		System.out.println("Task Information.");
		task.display();
		
		System.out.println("Dependent Tasks Information.");
		for(Task taskObject : dependentTasks) {
			taskObject.display();
		}
	}
}
