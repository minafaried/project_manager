import java.util.List;
import java.util.ArrayList;

public class ControlUnit {
	private DatabaseHandeller dataBaseHandeller;
	private FileHandeller fileHandeller;

	public ControlUnit() {
		dataBaseHandeller = new DatabaseHandeller();
		fileHandeller = new FileHandeller();
	}
	
	public void createProject(Project currentProject) {
		fileHandeller.saveProject(currentProject);
	}

	public Project loadProject() {
		Project project = fileHandeller.loadProject();
		return project;
	}

	public List<Task> loadTasks() {
		List<Task> tasksList = dataBaseHandeller.getAllTasks();
		return tasksList;
	}

	public Task loadTask(int taskID) {
		Task task = dataBaseHandeller.getTaskByID(taskID);
		return task;
	}

	public List<SubTask> loadSubTasks() {
		List<SubTask> subTasksList = dataBaseHandeller.getAllSubTasks();
		return subTasksList;
	}

	public SubTask loadSubTask(int taskID) {
		SubTask subTask = dataBaseHandeller.getSubTaskByID(taskID);
		return subTask;
	}

	public List<MileStone> loadMileStones() {
		List<MileStone> mileStonesList = dataBaseHandeller.getAllMileStones();
		return mileStonesList;
	}

	public MileStone loadMileStone(int mileStoneID) {
		MileStone mileStone = dataBaseHandeller.getMileStoneByID(mileStoneID);
		return mileStone;
	}

	public List<TeamMember> loadTeamMembers() {
		List<TeamMember> teamMembersList = dataBaseHandeller.getAllTeamMembers();
		return teamMembersList;
	}

	public TeamMember loadTeamMember(int teamMemberID) {
		TeamMember teamMember = dataBaseHandeller.getTeamMemberByID(teamMemberID);
		return teamMember;
	}

	public List<TeamMember> loadTeamMembers(Task task) {
		List<TeamMember> taskTeamMembersList = null;
		if(task instanceof SubTask) {
			taskTeamMembersList = dataBaseHandeller.getTeamMembersOnSubTask((SubTask) task);
		} else {
			taskTeamMembersList = dataBaseHandeller.getTeamMembersOnTask(task);
		}
		return taskTeamMembersList;
	}

	public List<SubTask> loadSubTasks(Task task) {
		List<SubTask> subTasksList = dataBaseHandeller.getSubTasksOfTask(task);
		return subTasksList;
	}

	public void constructProjectPlanBeforeStart() {
		fileHandeller.constructProjectPlanBeforeStart();
	}

	public void constructProjectPlanAfterFinish() {
		fileHandeller.constructProjectPlanAfterFinish();
	}

	public void destoryProjectPlan() {
		fileHandeller.clearProjectData();
		dataBaseHandeller.resetDataBase();
	}

	public Task addNewTask(Task task) {
		task = dataBaseHandeller.addNewTask(task);
		return task;
	}

	public SubTask addNewSubTask(Task task, SubTask subTask) {
		subTask = dataBaseHandeller.addNewSubTask(task, subTask);
		return subTask;
	}

	public MileStone addNewMileStone(MileStone mileStone) {
		mileStone = dataBaseHandeller.addNewMileStone(mileStone);
		return mileStone;
	}

	public TeamMember addTeamMember(TeamMember teamMember) {
		teamMember = dataBaseHandeller.addNewTeamMember(teamMember);
		return teamMember;
	}

	public void addTeamMemberToTask(TeamMember teamMember, Task task) {
		dataBaseHandeller.assignTeamMemberToTask(teamMember, task);
	}

	public void addTeamMemberToSubTask(TeamMember teamMember, SubTask subTask) {
		dataBaseHandeller.assignTeamMemberToSubTask(teamMember, subTask);
	}

	public void saveTask(Task task) {
		dataBaseHandeller.saveTask(task);
	}
	
	public void saveSubTask(SubTask subTask) {
		dataBaseHandeller.saveSubTask(subTask);
	}

	public void saveProject(Project currentProject) {
		fileHandeller.saveProject(currentProject);
	}

	public List<Task> loadDependentTasks(Task task) {
		// TODO Auto-generated method stub
		return null;
	}
}
