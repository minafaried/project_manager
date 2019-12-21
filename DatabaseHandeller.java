import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DatabaseHandeller {  // Don't forget to change the local host in the connection according to which laptop we use
	public DatabaseHandeller() {

	}

//1433
	@SuppressWarnings("deprecation")
	public List<Task> getAllTasks() { // mina
		List<Task> tasks = new ArrayList<Task>();

		String connectionUrl = "jdbc:sqlserver://DESKTOP-R87PDJN;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task;";
			ResultSet res = stmt.executeQuery(SQL);
			Date tempdate = new Date();
			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			while (res.next()) {
				Task t = new Task();
				if (res.getInt("parentTaskId") == 0) {
					t.setID(res.getInt("taskId"));
					t.setWorkingHours(res.getInt("workingHours"));

					sqldate = res.getDate("plannedStartDate");

					tempdate.setYear(sqldate.getYear());
					tempdate.setMonth(sqldate.getMonth());
					tempdate.setDay(sqldate.getDay());
					// tempdate.setHours(sqldate.getHours());
					t.setPlannedStartDate(tempdate);

					sqldate = res.getDate("plannedDueDate");

					tempdate.setYear(sqldate.getYear());
					tempdate.setMonth(sqldate.getMonth());
					tempdate.setDay(sqldate.getDay());
					// tempdate.setHours(sqldate.getHours());
					t.setPlannedDueDate(tempdate);

					sqldate = res.getDate("actualStartDate");

					tempdate.setYear(sqldate.getYear());
					tempdate.setMonth(sqldate.getMonth());
					tempdate.setDay(sqldate.getDay());
					// tempdate.setHours(sqldate.getHours());
					t.setActualStartDate(tempdate);

					sqldate = res.getDate("actualDueDate");

					tempdate.setYear(sqldate.getYear());
					tempdate.setMonth(sqldate.getMonth());
					tempdate.setDay(sqldate.getDay());
					// tempdate.setHours(sqldate.getHours());
					t.setActualDueDate(tempdate);
					// t.display();
					tasks.add(t);
				}
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}

		return tasks;
	}
	@SuppressWarnings("deprecation")
	public Task getTaskByID(int taskID) {// mina
		String connectionUrl = "jdbc:sqlserver://DESKTOP-R87PDJN;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task where taskid=" + taskID + ";";
			ResultSet res = stmt.executeQuery(SQL);
			Date tempdate = new Date();
			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			res.next();
			Task t = new Task();
			t.setID(res.getInt("taskId"));
			t.setWorkingHours(res.getInt("workingHours"));

			sqldate = res.getDate("plannedStartDate");

			tempdate.setYear(sqldate.getYear());
			tempdate.setMonth(sqldate.getMonth());
			tempdate.setDay(sqldate.getDay());
			// tempdate.setHours(sqldate.getHours());
			t.setPlannedStartDate(tempdate);

			sqldate = res.getDate("plannedDueDate");

			tempdate.setYear(sqldate.getYear());
			tempdate.setMonth(sqldate.getMonth());
			tempdate.setDay(sqldate.getDay());
			// tempdate.setHours(sqldate.getHours());
			t.setPlannedDueDate(tempdate);

			sqldate = res.getDate("actualStartDate");

			tempdate.setYear(sqldate.getYear());
			tempdate.setMonth(sqldate.getMonth());
			tempdate.setDay(sqldate.getDay());
			// tempdate.setHours(sqldate.getHours());
			t.setActualStartDate(tempdate);

			sqldate = res.getDate("actualDueDate");

			tempdate.setYear(sqldate.getYear());
			tempdate.setMonth(sqldate.getMonth());
			tempdate.setDay(sqldate.getDay());
			// tempdate.setHours(sqldate.getHours());
			t.setActualDueDate(tempdate);
			// t.display();
			return t;
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}

	}
	@SuppressWarnings("deprecation")
	public List<SubTask> getAllSubTasks() {// mina
		List<SubTask> subtasks = new ArrayList<SubTask>();
		String connectionUrl = "jdbc:sqlserver://DESKTOP-R87PDJN;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task;";
			ResultSet res = stmt.executeQuery(SQL);
			Date tempdate = new Date();
			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			while (res.next()) {
				SubTask t = new SubTask();
				if (res.getInt("parentTaskId") > 0) {
					t.setParentID(res.getInt("parentTaskId"));

					t.setID(res.getInt("taskId"));
					t.setWorkingHours(res.getInt("workingHours"));

					sqldate = res.getDate("plannedStartDate");

					tempdate.setYear(sqldate.getYear());
					tempdate.setMonth(sqldate.getMonth());
					tempdate.setDay(sqldate.getDay());
					// tempdate.setHours(sqldate.getHours());
					t.setPlannedStartDate(tempdate);

					sqldate = res.getDate("plannedDueDate");

					tempdate.setYear(sqldate.getYear());
					tempdate.setMonth(sqldate.getMonth());
					tempdate.setDay(sqldate.getDay());
					// tempdate.setHours(sqldate.getHours());
					t.setPlannedDueDate(tempdate);

					sqldate = res.getDate("actualStartDate");

					tempdate.setYear(sqldate.getYear());
					tempdate.setMonth(sqldate.getMonth());
					tempdate.setDay(sqldate.getDay());
					// tempdate.setHours(sqldate.getHours());
					t.setActualStartDate(tempdate);

					sqldate = res.getDate("actualDueDate");

					tempdate.setYear(sqldate.getYear());
					tempdate.setMonth(sqldate.getMonth());
					tempdate.setDay(sqldate.getDay());
					// tempdate.setHours(sqldate.getHours());
					t.setActualDueDate(tempdate);

					// t.display();
					subtasks.add(t);
				}
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}

		return subtasks;
	}
	@SuppressWarnings("deprecation")
	public SubTask getSubTaskByID(int taskID) {// mina
		String connectionUrl = "jdbc:sqlserver://DESKTOP-R87PDJN;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task where taskid=" + taskID + ";";
			ResultSet res = stmt.executeQuery(SQL);
			Date tempdate = new Date();
			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			res.next();
			SubTask t = new SubTask();
			t.setParentID(res.getInt("parentTaskId"));
			t.setID(res.getInt("taskId"));
			t.setWorkingHours(res.getInt("workingHours"));

			sqldate = res.getDate("plannedStartDate");

			tempdate.setYear(sqldate.getYear());
			tempdate.setMonth(sqldate.getMonth());
			tempdate.setDay(sqldate.getDay());
			// tempdate.setHours(sqldate.getHours());
			t.setPlannedStartDate(tempdate);

			sqldate = res.getDate("plannedDueDate");

			tempdate.setYear(sqldate.getYear());
			tempdate.setMonth(sqldate.getMonth());
			tempdate.setDay(sqldate.getDay());
			// tempdate.setHours(sqldate.getHours());
			t.setPlannedDueDate(tempdate);

			sqldate = res.getDate("actualStartDate");

			tempdate.setYear(sqldate.getYear());
			tempdate.setMonth(sqldate.getMonth());
			tempdate.setDay(sqldate.getDay());
			// tempdate.setHours(sqldate.getHours());
			t.setActualStartDate(tempdate);

			sqldate = res.getDate("actualDueDate");

			tempdate.setYear(sqldate.getYear());
			tempdate.setMonth(sqldate.getMonth());
			tempdate.setDay(sqldate.getDay());
			// tempdate.setHours(sqldate.getHours());
			t.setActualDueDate(tempdate);
			// t.display();
			return t;
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}
	}
	@SuppressWarnings("deprecation")
	public List<SubTask> getSubTasksOfTask(Task task) { // mina
		List<SubTask> subtasks = new ArrayList<SubTask>();
		String connectionUrl = "jdbc:sqlserver://DESKTOP-R87PDJN;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task where parentTaskId=" + task.getID() + ";";
			ResultSet res = stmt.executeQuery(SQL);
			Date tempdate = new Date();
			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			while (res.next()) {
				SubTask t = new SubTask();
				t.setParentID(res.getInt("parentTaskId"));

				t.setID(res.getInt("taskId"));
				t.setWorkingHours(res.getInt("workingHours"));

				sqldate = res.getDate("plannedStartDate");

				tempdate.setYear(sqldate.getYear());
				tempdate.setMonth(sqldate.getMonth());
				tempdate.setDay(sqldate.getDay());
				// tempdate.setHours(sqldate.getHours());
				t.setPlannedStartDate(tempdate);

				sqldate = res.getDate("plannedDueDate");

				tempdate.setYear(sqldate.getYear());
				tempdate.setMonth(sqldate.getMonth());
				tempdate.setDay(sqldate.getDay());
				// tempdate.setHours(sqldate.getHours());
				t.setPlannedDueDate(tempdate);

				sqldate = res.getDate("actualStartDate");

				tempdate.setYear(sqldate.getYear());
				tempdate.setMonth(sqldate.getMonth());
				tempdate.setDay(sqldate.getDay());
				// tempdate.setHours(sqldate.getHours());
				t.setActualStartDate(tempdate);

				sqldate = res.getDate("actualDueDate");

				tempdate.setYear(sqldate.getYear());
				tempdate.setMonth(sqldate.getMonth());
				tempdate.setDay(sqldate.getDay());
				// tempdate.setHours(sqldate.getHours());
				t.setActualDueDate(tempdate);

				// t.display();
				subtasks.add(t);
			}

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}

		return subtasks;
	}

	public List<MileStone> getAllMileStones() { // Badr
		// TODO Auto-generated method stub
		return null;
	}

	public MileStone getMileStoneByID(int mileStoneID) { // Badr
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeamMember> getAllTeamMembers() {// mina
		List<TeamMember> teammember = new ArrayList<TeamMember>();
		String connectionUrl = "jdbc:sqlserver://DESKTOP-R87PDJN;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "select*from teamMember";
			ResultSet res = stmt.executeQuery(SQL);
			while (res.next()) {
				TeamMember t = new TeamMember();
				t.setID(res.getInt("teamMemberId"));
				t.setName(res.getString("name"));
				t.setTitle(res.getString("title"));
				t.setWorkingHours(res.getInt("workingHours"));
				// System.out.println( t.toString());
				teammember.add(t);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return teammember;
	}

	public MileStone addNewMileStone(MileStone mileStone) { // Badr
		// TODO Auto-generated method stub
		return null;
	}

	public TeamMember getTeamMemberByID(int teamMemberID) {// mina
		String connectionUrl = "jdbc:sqlserver://DESKTOP-R87PDJN;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "select*from teamMember where teamMemberId="+teamMemberID+";";
			ResultSet res = stmt.executeQuery(SQL);
			res.next();
			TeamMember t = new TeamMember();
			t.setID(res.getInt("teamMemberId"));
			t.setName(res.getString("name"));
			t.setTitle(res.getString("title"));
			t.setWorkingHours(res.getInt("workingHours"));
			 System.out.println( t.toString());
			return t;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

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
