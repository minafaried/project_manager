import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

	public void interact() throws SQLException, ClassNotFoundException, IOException {
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
			System.out.print("Your choice :");
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
				break;
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

			case "Construct Analysis Report": { // Mina
				List<Task> tasksList = controlUnit.loadTasks();
				List<SubTask> subTasksList = controlUnit.loadSubTasks();

				List<Task> finishedOnTimeTasks = new ArrayList<Task>();
				List<Task> notFinishedOnTimeTasks = new ArrayList<Task>();
				for (Task task : tasksList) {
					if (task.getActualStartDate().compare(task.getPlannedStartDate()) == 0
							|| task.getActualStartDate().compare(task.getPlannedStartDate()) == -1) {
						if (task.getActualDueDate().compare(task.getPlannedDueDate()) == 0
								|| task.getActualDueDate().compare(task.getPlannedDueDate()) == -1) {
							finishedOnTimeTasks.add(task);
						} else {
							notFinishedOnTimeTasks.add(task);
						}
					} else {
						if (task.getActualDueDate().compare(task.getPlannedDueDate()) == 0
								|| task.getActualDueDate().compare(task.getPlannedDueDate()) == -1) {
							finishedOnTimeTasks.add(task);
						} else {
							notFinishedOnTimeTasks.add(task);
						}
					}
				}
				for (SubTask subtask : subTasksList) {
					if (subtask.getActualStartDate().compare(subtask.getPlannedStartDate()) == 0
							|| subtask.getActualStartDate().compare(subtask.getPlannedStartDate()) == -1) {
						if (subtask.getActualDueDate().compare(subtask.getPlannedDueDate()) == 0
								|| subtask.getActualDueDate().compare(subtask.getPlannedDueDate()) == -1) {
							finishedOnTimeTasks.add(subtask);
						} else {
							notFinishedOnTimeTasks.add(subtask);
						}
					} else {
						if (subtask.getActualDueDate().compare(subtask.getPlannedDueDate()) == 0
								|| subtask.getActualDueDate().compare(subtask.getPlannedDueDate()) == -1) {
							finishedOnTimeTasks.add(subtask);
						} else {
							notFinishedOnTimeTasks.add(subtask);
						}
					}
				}
				ioHandeller.displayOnTimeTasks(finishedOnTimeTasks);
				ioHandeller.displayNotOnTimeTasks(notFinishedOnTimeTasks);
				break;
			}

			case "Construct Project Plan Before Start": { // Mina
				List<Task> tasksList = controlUnit.loadTasks();
				List<SubTask> subTasksList = controlUnit.loadSubTasks();

				// Some Code.
				int[]x_axis=new int[tasksList.size()+subTasksList.size()];
				Date []y_axis_start=new Date[tasksList.size()+subTasksList.size()];
				Date []y_axis_finished=new Date[tasksList.size()+subTasksList.size()];
				for (int i = 0; i < tasksList.size(); i++) {
					x_axis[i]=tasksList.get(i).getID();
					y_axis_start[i]=tasksList.get(i).getPlannedStartDate();
					y_axis_finished[i]=tasksList.get(i).getPlannedDueDate();
				}
				for (int i = 0; tasksList.size() <tasksList.size()+subTasksList.size() ; i++) {
					x_axis[i]=subTasksList.get(i-tasksList.size()).getID();
					y_axis_start[i]=subTasksList.get(i-tasksList.size()).getPlannedStartDate();
					y_axis_finished[i]=subTasksList.get(i-tasksList.size()).getPlannedDueDate();
				}
				controlUnit.constructProjectPlanBeforeStart(x_axis,y_axis_start,y_axis_finished);
				break;
			}

			case "Construct Project Plan After Finish": { // Mina
				List<Task> tasksList = controlUnit.loadTasks();
				List<SubTask> subTasksList = controlUnit.loadSubTasks();

				// Some Code.
				int[]x_axis=new int[tasksList.size()+subTasksList.size()];
				Date []y_axis_start=new Date[tasksList.size()+subTasksList.size()];
				Date []y_axis_finished=new Date[tasksList.size()+subTasksList.size()];
				for (int i = 0; i < tasksList.size(); i++) {
					x_axis[i]=tasksList.get(i).getID();
					y_axis_start[i]=tasksList.get(i).getActualStartDate();
					y_axis_finished[i]=tasksList.get(i).getActualDueDate();
				}
				for (int i = 0; tasksList.size() <tasksList.size()+subTasksList.size() ; i++) {
					x_axis[i]=subTasksList.get(i-tasksList.size()).getID();
					y_axis_start[i]=subTasksList.get(i-tasksList.size()).getActualStartDate();
					y_axis_finished[i]=subTasksList.get(i-tasksList.size()).getActualDueDate();
				}
				controlUnit.constructProjectPlanAfterFinish(x_axis,y_axis_start,y_axis_finished);
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
				int deliverableIndex = getDeliverableIndexByID(currentProject, expectedID);
				if(deliverableIndex != -1) {
					Deliverable updatedDeliverable = forms.updateExpectedDeliverableForm();
					currentProject.getExpectedDeliverables().set(deliverableIndex, updatedDeliverable);
				} else {
					ioHandeller.displayDeliverableNotFoundError();
				}
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
			
			case "Mark Task As A Dependent For Another Task": {
				int taskID = ioHandeller.taskIDInput();
				int dependentTaskID = ioHandeller.dependentTaskIDInput();
				
				Task task = controlUnit.loadTask(taskID);
				Task dependentTask = controlUnit.loadTask(dependentTaskID);
				
				controlUnit.addDependentTask(task, dependentTask);
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
				task.setWorkingHours(acutalWorkingHours);
				int actualWorkingDays = acutalWorkingHours * currentProject.getWorkingHours();
				controlUnit.saveTask(task, actualWorkingDays);
			}
			
			case "Insert Actual Working Hours To SubTask": {
				int taskID = ioHandeller.taskIDInput();
				int acutalWorkingHours = ioHandeller.actualWorkingHoursInput();
				
				SubTask subTask = controlUnit.loadSubTask(taskID);
				subTask.setWorkingHours(acutalWorkingHours);
				int actualWorkingDays = acutalWorkingHours * currentProject.getWorkingHours();
				controlUnit.saveSubTask(subTask, actualWorkingDays);
			}
			
			case "Exit The Program": {
				controlUnit.saveProject(currentProject);
				break loop;
			}
			}
		}
	}
	
	private int getDeliverableIndexByID(Project project, int ID) {
		int deliverableIndex = -1;
		List<Deliverable> expectedList = project.getExpectedDeliverables();
		for(int i = 0; i < expectedList.size(); i++) {
			if(expectedList.get(i).getID() == ID) {
				deliverableIndex = i;
				break;
			}
		}
		return deliverableIndex;
	}
	
	private void deleteDeliverableByID(Project project, int ID) {
		int listLength = project.getExpectedDeliverables().size();
		for(int i = listLength - 1; i >= 0; i--) {
			if(project.getExpectedDeliverables().get(i).getID() == ID) {
				project.getExpectedDeliverables().remove(i);
			}
		}
	}
}
