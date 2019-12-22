import java.util.Scanner;

public class Form {

	public Project newProjectForm() {
		Scanner scanner = new Scanner(System.in);
		Project project = new Project();

		System.out.print("Enter the project's name :");
		project.setName(scanner.nextLine());

		System.out.print("Enter the project's cost :");
		project.setCost(scanner.nextDouble());
		scanner.nextLine();

		System.out.println("Enter the start date.");
		project.getStartDate().input();

		System.out.println("Enter the due date.");
		project.getDueDate().input();

		int numberOfDeliverables = 0;
		System.out.print("Enter the number of deliverables :");
		numberOfDeliverables = scanner.nextInt();

		for (int i = 0; i < numberOfDeliverables; i++) {
			System.out.println("Deliverable #" + (i + 1));
			Deliverable tempDeliverable = newExpectedDeliverableForm();
			project.getExpectedDeliverables().add(tempDeliverable);
		}

		System.out.print("Enter the working hours per day :");
		project.setWorkingHours(scanner.nextInt());

		project.setStartOfWeek(startOfWeekForm());
		return project;
	}

	private String startOfWeekForm() {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		String day = "";

		System.out.println("Enter the starting day of the week.");
		System.out.println("1-Sunday.");
		System.out.println("2-Monday.");

		while (true) {
			System.out.print("Your Choice :");
			input = scanner.nextLine();

			if (input.equals("1")) {
				day = Project.sunDay();
				break;

			} else if (input.equals("2")) {
				day = Project.monDay();
				break;

			} else {
				System.out.println("Invalid input.");
			}
		}

		return day;
	}

	private Deliverable expectedDeliverableForm() {
		Scanner scanner = new Scanner(System.in);
		Deliverable deliverable = new Deliverable();

		System.out.print("Enter the number order of the deliverable :");
		deliverable.setID(scanner.nextInt());
		scanner.nextLine();

		System.out.print("Enter the description of the deliverable :");
		deliverable.setDescription(scanner.nextLine());

		return deliverable;
	}

	public Deliverable newExpectedDeliverableForm() {
		System.out.println("Enter the new deliverable data.");
		Deliverable deliverable = expectedDeliverableForm();

		return deliverable;
	}

	public Deliverable updateExpectedDeliverableForm() {
		System.out.println("Enter the updated deliverable data.");
		Deliverable deliverable = expectedDeliverableForm();

		return deliverable;
	}

	public Task newTaskForm(int hoursPerDay) { // Fares
		Scanner scanner = new Scanner(System.in);
		Task task = new Task();

		System.out.println("Enter the required working days.");
		int days = scanner.nextInt();

		task.setWorkingHours(days * hoursPerDay);

		System.out.println("Enter the planned start date.");
		task.getPlannedStartDate().input();

		System.out.println("Enter the planned due date.");
		task.getPlannedDueDate().input();

		task.setActualStartDate(task.getPlannedStartDate());
		task.setActualDueDate(task.getPlannedDueDate());
		return task;
	}

	public SubTask newSubTaskForm(int hoursPerDay) {
		Scanner scanner = new Scanner(System.in);
		SubTask subTask = new SubTask();

		System.out.println("Enter the required working days.");
		int days = scanner.nextInt();

		subTask.setWorkingHours(days * hoursPerDay);

		System.out.println("Enter the planned start date.");
		subTask.getPlannedStartDate().input();

		System.out.println("Enter the planned due date.");
		subTask.getPlannedDueDate().input();

		subTask.setActualStartDate(subTask.getPlannedStartDate());
		subTask.setActualDueDate(subTask.getPlannedDueDate());

		return subTask;
	}

	public MileStone newMileStoneForm() {
		Scanner scanner = new Scanner(System.in);
		MileStone mileStone = new MileStone();

		System.out.println("Enter the milestone's name.");
		mileStone.setName(scanner.nextLine());

		System.out.println("Enter the milestone's date.");
		mileStone.getDate().input();

		return mileStone;
	}

	public TeamMember newTeamMemberForm() {
		Scanner scanner = new Scanner(System.in);
		TeamMember teamMember = new TeamMember();

		System.out.print("Enter the team member's name :");
		teamMember.setName(scanner.nextLine());

		System.out.print("Enter the team member's title :");
		teamMember.setTitle(scanner.nextLine());

		System.out.print("Enter the team member's working hours :");
		teamMember.setWorkingHours(scanner.nextInt());
		scanner.nextLine();

		return teamMember;
	}

}
