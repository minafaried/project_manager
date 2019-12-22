import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControlUnit {
	private DatabaseHandeller dataBaseHandeller;
	private FileHandeller fileHandeller;

	public ControlUnit() {
		dataBaseHandeller = new DatabaseHandeller();
		fileHandeller = new FileHandeller();
	}

	public void createProject(Project currentProject) {
		try {
			fileHandeller.saveProject(currentProject);
			//dataBaseHandeller.resetDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Project loadProject() {
		Project project = null;
		try {
			project = fileHandeller.loadProject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		List<MileStone> mileStonesList = null;
		try {
			mileStonesList = dataBaseHandeller.getAllMileStones();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		if (task instanceof SubTask) {
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

	public void constructProjectPlanBeforeStart(int[] x_axis, Date[] y_axis_start, Date[] y_axis_finished)
			throws FileNotFoundException {
		fileHandeller.constructProjectPlanBeforeStart(x_axis, y_axis_start, y_axis_finished);
	}

	public void constructProjectPlanAfterFinish(int[] x_axis, Date[] y_axis_start, Date[] y_axis_finished)
			throws FileNotFoundException {
		fileHandeller.constructProjectPlanAfterFinish(x_axis, y_axis_start, y_axis_finished);
	}

	public void destoryProjectPlan() throws FileNotFoundException, ClassNotFoundException, SQLException {
		fileHandeller.clearProjectData();
		dataBaseHandeller.resetDataBase();
	}

	public Task addNewTask(Task task) throws SQLException {
		task = dataBaseHandeller.addNewTask(task);
		return task;
	}

	public SubTask addNewSubTask(Task task, SubTask subTask) throws SQLException {
		subTask = dataBaseHandeller.addNewSubTask(task, subTask);
		return subTask;
	}

	public MileStone addNewMileStone(MileStone mileStone) {
		mileStone = dataBaseHandeller.addNewMileStone(mileStone);
		return mileStone;
	}

	public TeamMember addTeamMember(TeamMember teamMember) throws SQLException {
		teamMember = dataBaseHandeller.addNewTeamMember(teamMember);
		return teamMember;
	}

	public void addTeamMemberToTask(TeamMember teamMember, Task task) throws SQLException {
		dataBaseHandeller.assignTeamMemberToTask(teamMember, task);
	}

	public void addTeamMemberToSubTask(TeamMember teamMember, SubTask subTask) throws SQLException {
		dataBaseHandeller.assignTeamMemberToSubTask(teamMember, subTask);
	}

	public void saveTask(Task task) throws SQLException {
		dataBaseHandeller.modifyTaskWorkingHours(task);
	}

	public void saveSubTask(SubTask subTask) throws SQLException {
		dataBaseHandeller.modifySubTaskWorkingHours(subTask);
	}

	public void saveProject(Project currentProject) throws IOException {
		fileHandeller.saveProject(currentProject);
	}

	public List<Task> loadDependentTasks(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addDependentTask(Task task, Task dependentTask) {
		dataBaseHandeller.assignTaskToDependentTask(task, dependentTask);

	}
}
