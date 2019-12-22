import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class IOHandeller { // Badr

	public IOHandeller() {
		// JOptionPane.showMessageDialog(null, "Good Afternoon");
		// System.out.println("Good Morning....\n");
	}

	public void displayStartMenu() {
		System.out.println("1-Create New Project.\n2- Load Current Project.");
	}

	public String startMenuInput() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int choose = scanner.nextInt();
			scanner.nextLine();
			if (choose == 1) {
				return "newProject";
			} else if (choose == 2) {
				return "currentProject";
			} else
				System.out.println("Insert 1 or 2 only to continue.....\nInsert Again");
		}
	}

	public void displayMainMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"1-Display Project Details\n2-Display All Expected Deliverables\n3-Display All Tasks\n4-Display Task By ID\n5-Display All SubTasks"
						+ "\n6-Display SubTask By ID\n7-Display All MileStones\n8-Display MileStone By ID\n9-Display All Team Members\n10-Display Team Member By ID"
						+ "\n11-Display Team Members On Task By TaskID\n12-Display Team Members On SubTask By TaskID\n13-Display Dependent Tasks On Task By TaskID"
						+ "\n14-Display Dependent Tasks On SubTask By TaskID\n15-Display SubTasks Of Task By TaskID\n16-Construct Analysis Report"
						+ "\n17-Construct Project Plan Before Start\n18-Construct Project Plan After Finish\n19-Destory Project Plan\n20-New Expected Deliverable"
						+ "\n21-Update Expected Deliverable By ID\n22-Delete Expected Deliverable By ID\n23-New Task\n24-New SubTask\n25-New MileSTone\n26-New Team Member"
						+ "\n27-Mark Task As A Dependent For Another Task\n28-Assign Team Member To Task\n29-Assign Team Member To SubTask\n30-Insert Actual Working Hours To Task"
						+ "\n31-Insert Actual Working Hours To SubTask\n32-Exit The Program");
	}

	// Long function.
	public String mainMenuInput() {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			int choose = scanner.nextInt();
			scanner.nextLine();
			if (choose == 1) {
				return "Display Project Details";
			} else if (choose == 2) {
				return "Display All Expected Deliverables";
			} else if (choose == 3) {
				return "Display All Tasks";
			} else if (choose == 4) {
				return "Display Task By ID";
			} else if (choose == 5) {
				return "Display All SubTasks";
			} else if (choose == 6) {
				return "Display SubTask By ID";
			} else if (choose == 7) {
				return "Display All MileStones";
			} else if (choose == 8) {
				return "Display MileStone By ID";
			} else if (choose == 9) {
				return "Display All Team Members";
			} else if (choose == 10) {
				return "Display Team Member By ID";
			} else if (choose == 11) {
				return "Display Team Members On Task By TaskID";
			} else if (choose == 12) {
				return "Display Team Members On SubTask By TaskID";
			} else if (choose == 13) {
				return "Display Dependent Tasks On Task By TaskID";
			} else if (choose == 14) {
				return "Display Dependent Tasks On SubTask By TaskID";
			} else if (choose == 15) {
				return "Display SubTasks Of Task By TaskID";
			} else if (choose == 16) {
				return "Construct Analysis Report";
			} else if (choose == 17) {
				return "Construct Project Plan Before Start";
			} else if (choose == 18) {
				return "Construct Project Plan After Finish";
			} else if (choose == 19) {
				return "Destory Project Plan";
			} else if (choose == 20) {
				return "New Expected Deliverable";
			} else if (choose == 21) {
				return "Update Expected Deliverable By ID";
			} else if (choose == 22) {
				return "Delete Expected Deliverable By ID";
			} else if (choose == 23) {
				return "New Task";
			} else if (choose == 24) {
				return "New SubTask";
			} else if (choose == 25) {
				return "New MileSTone";
			} else if (choose == 26) {
				return "New Team Member";
			} else if (choose == 27) {
				return "Mark Task As A Dependent For Another Task";
			} else if (choose == 28) {
				return "Assign Team Member To Task";
			} else if (choose == 29) {
				return "Assign Team Member To SubTask";
			} else if (choose == 30) {
				return "Insert Actual Working Hours To Task";
			} else if (choose == 31) {
				return "Insert Actual Working Hours To SubTask";
			} else if (choose == 32) {
				return "Exit The Program";
			} else {
				System.out.println("Insert Number Between 1 to 32 to continue....\nPlease Insert Again Correctly...\n");
			}
		}
	}

	public void displayProject(Project currentProject) {
		// TODO Auto-generated method stub
		currentProject.Display();
	}

	public void displayExpectedDeliverables(List<Deliverable> expectedDeliverables) {
		// TODO Auto-generated method stub
		for (int i = 0; i < expectedDeliverables.size(); i++) {
			System.out.println(i + " : " + expectedDeliverables.get(i).toString());
		}
	}

	public int taskIDInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter The Task ID: ");
		while (true) {
			int ID = scanner.nextInt();
			if (ID < 0)
				System.out.println("Please Insert Correct ID.....");
			else {
				System.out.println();
				return ID;
			}
		}
	}

	public void displayTask(Task task) {
		// TODO Auto-generated method stub
		task.display();
	}

	public void displayTasks(List<Task> tasksList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < tasksList.size(); i++) {
			tasksList.get(i).display();
		}
	}

	public void displayMileStones(List<MileStone> mileStonesList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mileStonesList.size(); i++) {
			System.out.println(i + " : " + mileStonesList.get(i).toString());
		}
	}

	public int mileStoneIDInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert MileStone ID.....");
		while (true) {
			int mile = scanner.nextInt();
			if (mile < 0)
				System.out.println("Insert Correct ID......");
			else {
				System.out.println();
				return mile;
			}
		}
	}

	public void displayMileStone(MileStone mileStone) {
		// TODO Auto-generated method stub
		System.out.println("\n" + mileStone.toString());
	}

	public void displayTeamMembers(List<TeamMember> teamMembersList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < teamMembersList.size(); i++) {
			System.out.println(i + " : " + teamMembersList.get(i).toString());
		}
	}

	public int teamMemberIDInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert Team Member ID.....");
		while (true) {
			int teammember = scanner.nextInt();
			if (teammember < 0)
				System.out.println("Insert MileStones Correct......");
			else {
				System.out.println();
				return teammember;
			}
		}
	}

	public void displayTeamMember(TeamMember teamMember) {
		// TODO Auto-generated method stub
		System.out.println(teamMember.toString());
	}

	public void displayDependsOn(DependsOn dependsOn) {
		// TODO Auto-generated method stub
		dependsOn.display();
	}

	public void displaySubTasks(List<SubTask> subTasksList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < subTasksList.size(); i++) {
			subTasksList.get(i).display();
		}
	}

	public void displayOnTimeTasks(List<Task> finishedOnTimeTasks) {
		// TODO Auto-generated method stub
		System.out.println("On time tasks.");
		for (int i = 0; i < finishedOnTimeTasks.size(); i++) {
			finishedOnTimeTasks.get(i).display();
		}
	}

	public void displayNotOnTimeTasks(List<Task> notFinishedOnTimeTasks) {
		// TODO Auto-generated method stub
		System.out.println("Not on time tasks.");
		for (int i = 0; i < notFinishedOnTimeTasks.size(); i++) {
			notFinishedOnTimeTasks.get(i).display();
		}
	}

	public int expectedDeliverableIDInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert Expected Deliverables ID.....");
		while (true) {
			int ex = scanner.nextInt();
			if (ex < 0)
				System.out.println("Insert Correctly Please......");
			else {
				System.out.println();
				return ex;
			}
		}
	}

	public int dependentTaskIDInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dependent TasK ID.....");
		while (true) {
			int ex = scanner.nextInt();
			if (ex < 0)
				System.out.println("Insert Correctly Please......");
			else {
				System.out.println();
				return ex;
			}
		}
	}

	public int actualWorkingHoursInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert Actual Working Hours.....");
		while (true) {
			int ex = scanner.nextInt();
			if (ex < 0 || ex > 24)
				System.out.println("Insert Correctly Please......");
			else {
				System.out.println();
				return ex;
			}
		}
	}

	public void displayDeliverableNotFoundError() {
		System.out.println("!!No deliverable is found.");
	}

}
