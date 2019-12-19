import java.util.List;
import java.util.ArrayList;

public class ControlUnit {
	private DatabaseHandeller databaseHandeller;
	private FileHandeller fileHandeller;

	public ControlUnit() {
		databaseHandeller = new DatabaseHandeller();
		fileHandeller = new FileHandeller();
	}
	
	public void createProject(Project currentProject) {
		// TODO Auto-generated method stub
		
	}

	public Project loadProject() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Task> loadTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	public Task loadTask(int taskID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Task> loadSubTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	public SubTask loadSubTask(int taskID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MileStone> loadMileStones() {
		// TODO Auto-generated method stub
		return null;
	}

	public MileStone loadMileStone(int mileStoneID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeamMember> loadTeamMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	public TeamMember loadTeamMember(int teamMemberID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeamMember> loadTeamMembers(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SubTask> loadSubTasks(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Task> loadAllTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SubTask> loadAllSubTask() {
		// TODO Auto-generated method stub
		return null;
	}

	public void constructProjectPlanBeforeStart() {
		// TODO Auto-generated method stub
		
	}

	public void constructProjectPlanAfterFinish() {
		// TODO Auto-generated method stub
		
	}

	public void destoryProjectPlan() {
		// TODO Auto-generated method stub
		
	}

	public Task addNewTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	public SubTask addNewSubTask(SubTask subTask) {
		// TODO Auto-generated method stub
		return null;
	}

	public MileStone addNewMileStone(MileStone mileStone) {
		// TODO Auto-generated method stub
		return null;
	}

	public TeamMember addTeamMember(TeamMember teamMember) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addTeamMemberToTask(TeamMember teamMember, Task task) {
		// TODO Auto-generated method stub
		
	}

	public void addTeamMemberToSubTask(TeamMember teamMember, SubTask subTask) {
		// TODO Auto-generated method stub
		
	}

	public void saveSubTask(SubTask subTask) {
		// TODO Auto-generated method stub
		
	}

	public void saveProject(Project currentProject) {
		// TODO Auto-generated method stub
		
	}

	public void saveTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	public List<Task> loadDependentTasks(Task task) {
		// TODO Auto-generated method stub
		return null;
	}


//	public void resetDataBase() {
//		databaseHandeller.resetDataBase();
//	}
//
//	public List<Task> loadTasks(boolean isSubTask) {
//		List<Task> tasksList = new ArrayList<Task>();
//		if (isSubTask) {
//			tasksList = databaseHandeller.loadAllSubTasks();
//		} else {
//			tasksList = databaseHandeller.loadAllTasks();
//		}
//		return tasksList;
//	}
//
//	public Task loadTask(int taskID, boolean isSubTask) {
//		Task task = null;
//		if (isSubTask) {
//
//		} else {
//
//		}
//
//		return task;
//	}
}
