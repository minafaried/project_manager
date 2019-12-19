import java.util.List;

//All the input an output operations on the console are done through IOHandeller Class.
//All big input from the console are done through Form Class.
public class Interface {
	private ControlUnit controlUnit;
	private Form forms;
	private IOHandeller ioHandeller;

	public Interface() {
		controlUnit = new ControlUnit();
		forms = new Form();
		ioHandeller = new IOHandeller();
	}

	public void interact() {
		String inputChoice = "";
		Project currentProject = null;

		ioHandeller.displayStartMenu();
		inputChoice = ioHandeller.startMenuInput();

		switch (inputChoice) {
		case "newProject": {
			currentProject = forms.newProjectForm();
			controlUnit.createProject(currentProject);
			break;
		}

		case "currentProject": {
			currentProject = controlUnit.loadProject();
			break;
		}
		}

		ioHandeller.displayMainMenu();

		loop: while (true) {
			inputChoice = ioHandeller.mainMenuInput();
			
			switch (inputChoice) {
			case "Display Project Details": {
				ioHandeller.displayProject(currentProject);
				break;
			}

			case "Display All Expected Deliverables": {
				ioHandeller.displayExpectedDeliverables(currentProject.getExpectedDeliverables());
				break;
			}

			case "Display All Tasks": {
				List<Task> tasksList = controlUnit.loadTasks();
				ioHandeller.displayTasks(tasksList);
				break;
			}

			case "Display Task By ID": {
				int taskID = ioHandeller.taskIDInput();
				Task task = controlUnit.loadTask(taskID);
				ioHandeller.displayTask(task);
				break;
			}

			case "Display All SubTasks": {
				List<SubTask> tasksList = controlUnit.loadSubTasks();
				ioHandeller.displaySubTasks(tasksList);
				break;
			}

			case "Display SubTask By ID": {
				int taskID = ioHandeller.taskIDInput();
				SubTask subTask = controlUnit.loadSubTask(taskID);
				ioHandeller.displayTask(subTask);
				break;
			}

			case "Display All MileStones": {
				List<MileStone> mileStonesList = controlUnit.loadMileStones();
				ioHandeller.displayMileStones(mileStonesList);
				break;
			}

			case "Display MileStone By ID": {
				int mileStoneID = ioHandeller.mileStoneIDInput();
				MileStone mileStone = controlUnit.loadMileStone(mileStoneID);
				ioHandeller.displayMileStone(mileStone);
				break;
			}
			
			case "Display All Team Members": {
				List<TeamMember> teamMembersList = controlUnit.loadTeamMembers();
				ioHandeller.displayTeamMembers(teamMembersList);
				break;
			}
			
			case "Display Team Member By ID": {
				int teamMemberID = ioHandeller.teamMemberIDInput();
				TeamMember teamMember = controlUnit.loadTeamMember(teamMemberID);
				ioHandeller.displayTeamMember(teamMember);
			}

			case "Display Team Members On Task By TaskID": {
				int taskID = ioHandeller.taskIDInput();
				Task task = controlUnit.loadTask(taskID);
				List<TeamMember> teamMembersList = controlUnit.loadTeamMembers(task);
				ioHandeller.displayTeamMembers(teamMembersList);
				break;
			}
			
			case "Display Team Members On SubTask By TaskID": {
				int taskID = ioHandeller.taskIDInput();
				SubTask subTask = controlUnit.loadSubTask(taskID);
				List<TeamMember> teamMembersList = controlUnit.loadTeamMembers(subTask);
				ioHandeller.displayTeamMembers(teamMembersList);
				break;
			}

			case "Display Dependent Tasks On Task By TaskID": {
				int taskID = ioHandeller.taskIDInput();
				Task task = controlUnit.loadTask(taskID);
				List<Task> tasksList = controlUnit.loadDependentTasks(task);
				ioHandeller.displayTasks(tasksList);
				break;
			}
			
			case "Display Dependent Tasks On SubTask By TaskID": {
				int taskID = ioHandeller.taskIDInput();
				SubTask subTask = controlUnit.loadSubTask(taskID);
				List<Task> subTasksList = controlUnit.loadDependentTasks(subTask);
				ioHandeller.displayTasks(subTasksList);
				break;
			}

			case "Display SubTasks Of Task By TaskID": {
				int taskID = ioHandeller.taskIDInput();
				Task task = controlUnit.loadTask(taskID);
				List<SubTask> subTasksList = controlUnit.loadSubTasks(task);
				ioHandeller.displaySubTasks(subTasksList);
				break;
			}

			case "Construct Analysis Report": { //Mina
				List<Task> tasksList = controlUnit.loadTasks();
				List<SubTask> subTasksList = controlUnit.loadSubTasks();
				
				List<Task> finishedOnTimeTasks = null;
				List<Task> notFinishedOnTimeTasks = null;
				
				//Some code to define which tasks finished on time and which are not.
				
				ioHandeller.displayOnTimeTasks(finishedOnTimeTasks);
				ioHandeller.displayNotOnTimeTasks(notFinishedOnTimeTasks);
				break;
			}

			case "Construct Project Plan Before Start": { //Mina
				List<Task> tasksList = controlUnit.loadTasks();
				List<SubTask> subTasksList = controlUnit.loadSubTasks();
				
				//Some Code.
				
				controlUnit.constructProjectPlanBeforeStart();
				break;
			}

			case "Construct Project Plan After Finish": { //Mina
				List<Task> tasksList = controlUnit.loadTasks();
				List<SubTask> subTasksList = controlUnit.loadSubTasks();
				
				//Some Code.
				
				controlUnit.constructProjectPlanAfterFinish();
				break;
			}

			case "Destory Project Plan": {
				controlUnit.destoryProjectPlan();
				break loop;
			}

			case "New Expected Deliverable": {
				Deliverable newExpected = forms.newExpectedDeliverableForm();
				currentProject.getExpectedDeliverables().add(newExpected);
				break;
			}

			case "Update Expected Deliverable By ID": {
				int expectedID = ioHandeller.expectedDeliverableIDInput();
				Deliverable wantedDeliverable = getDeliverableByID(currentProject, expectedID);
				wantedDeliverable = forms.updateExpectedDeliverableForm(wantedDeliverable);
				break;
			}

			case "Delete Expected Deliverable By ID": {
				int expectedID = ioHandeller.expectedDeliverableIDInput();
				deleteDeliverableByID(currentProject, expectedID);
				break;
			}

			case "New Task": {
				Task task = forms.newTaskForm(currentProject.getWorkingHours());
				task = controlUnit.addNewTask(task);
				break;
			}

			case "New SubTask": {
				int taskID = ioHandeller.taskIDInput();
				Task task = controlUnit.loadTask(taskID);
				
				SubTask subTask = forms.newSubTaskForm(currentProject.getWorkingHours());
				subTask = controlUnit.addNewSubTask(task, subTask);
				break;
			}

			case "New MileSTone": {
				MileStone mileStone = forms.newMileStoneForm();
				mileStone = controlUnit.addNewMileStone(mileStone);
				break;
			}
			
			case "New Team Member": {
				TeamMember teamMember = forms.newTeamMemberForm();
				teamMember = controlUnit.addTeamMember(teamMember);
				break;
			}
			
			case "Mark Task As A Dependent For Another Task": { //Big Problem.
				int taskID = ioHandeller.taskIDInput();
				int dependentTaskID = ioHandeller.dependentTaskIDInput();
				break;
			}
			
			case "Assign Team Member To Task": {
				int teamMemberID = ioHandeller.teamMemberIDInput();
				int taskID = ioHandeller.taskIDInput();
				
				TeamMember teamMember = controlUnit.loadTeamMember(teamMemberID);
				Task task = controlUnit.loadTask(taskID);
				
				controlUnit.addTeamMemberToTask(teamMember, task);
				break;
			}
			
			case "Assign Team Member To SubTask": {
				int teamMemberID = ioHandeller.teamMemberIDInput();
				int taskID = ioHandeller.taskIDInput();
				
				TeamMember teamMember = controlUnit.loadTeamMember(teamMemberID);
				SubTask subTask = controlUnit.loadSubTask(taskID);
				
				controlUnit.addTeamMemberToSubTask(teamMember, subTask);
				break;
			}
			
			case "Insert Actual Working Hours To Task": {
				int taskID = ioHandeller.taskIDInput();
				int acutalWorkingHours = ioHandeller.actualWorkingHoursInput();
				
				Task task = controlUnit.loadTask(taskID);
				calculateDateBasedOnWorkingHours(task, acutalWorkingHours);
				controlUnit.saveTask(task);
			}
			
			case "Insert Actual Working Hours To SubTask": {
				int taskID = ioHandeller.taskIDInput();
				int acutalWorkingHours = ioHandeller.actualWorkingHoursInput();
				
				SubTask subTask = controlUnit.loadSubTask(taskID);
				calculateDateBasedOnWorkingHours(subTask, acutalWorkingHours);
				controlUnit.saveSubTask(subTask);
			}
			
			case "Exit The Program": {
				controlUnit.saveProject(currentProject);
				break loop;
			}
			}
		}
	}
	
	private Deliverable getDeliverableByID(Project project, int ID) {
		Deliverable wantedDeliverable = null;
		
		for(Deliverable deliverableObject : project.getExpectedDeliverables()) {
			if(deliverableObject.getID() == ID) { 
				wantedDeliverable = deliverableObject;
				break;
			}
		}
				
		return wantedDeliverable;
	}
	
	private void deleteDeliverableByID(Project project, int ID) {
		for(int i = 0; i < project.getExpectedDeliverables().size(); i++) {
			if(project.getExpectedDeliverables().get(i).getID() == ID) {
				project.getExpectedDeliverables().remove(i);
				break;
			}
		}
	}
	
	private void calculateDateBasedOnWorkingHours(Task task, int actualWorkingHours) { // Mina
		//Modify the acutalStartDate and the actualDueDate of the input task based on the input working hours.
	}
}
