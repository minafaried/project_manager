import java.util.List;

public class DatabaseHandeller {
	public DatabaseHandeller() {

	}

	public List<Task> getAllTasks() {  // mina
		// TODO Auto-generated method stub
		return null;
	}

	public Task getTaskByID(int taskID) {// mina
		// TODO Auto-generated method stub
		return null;
	}

	public List<SubTask> getAllSubTasks() {// mina
		// TODO Auto-generated method stub
		return null;
	}

	public SubTask getSubTaskByID(int taskID) {// mina
		// TODO Auto-generated method stub
		return null;
	}

	public List<SubTask> getSubTasksOfTask(Task task) { // mina
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MileStone> getAllMileStones() { // Badr
		// TODO Auto-generated method stub
		return null;
	}

	public MileStone getMileStoneByID(int mileStoneID) { // Badr
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeamMember> getAllTeamMembers() {// Badr
		// TODO Auto-generated method stub
		return null;
	}

	public MileStone addNewMileStone(MileStone mileStone) { //Badr
		// TODO Auto-generated method stub
		return null;
	}
	
	public TeamMember getTeamMemberByID(int teamMemberID) {// Badr
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeamMember> getTeamMembersOnTask(Task task) {// Badr
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeamMember> getTeamMembersOnSubTask(SubTask subTask) {// Badr
		// TODO Auto-generated method stub
		return null;
	}


	public void resetDataBase() { // omar
		// TODO Auto-generated method stub
		
	}

	public Task addNewTask(Task task) { // omar
		// TODO Auto-generated method stub
		return null;
	}

	public SubTask addNewSubTask(Task task, SubTask subTask) { // omar
		// TODO Auto-generated method stub
		return null;
	}

	

	public TeamMember addNewTeamMember(TeamMember teamMember) {// omar
		// TODO Auto-generated method stub
		return null;
	}

	public void assignTeamMemberToTask(TeamMember teamMember, Task task) {// omar
		// TODO Auto-generated method stub
		
	}

	public void assignTeamMemberToSubTask(TeamMember teamMember, SubTask subTask) {// omar
		// TODO Auto-generated method stub
		
	}

	public void saveTask(Task task) {// omar
		// TODO Auto-generated method stub
		
	}

	public void saveSubTask(SubTask subTask) { // omar
		// TODO Auto-generated method stub
		
	}
	
	
}
