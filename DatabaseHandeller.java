import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DatabaseHandeller {

	private String databaseIP = "DESKTOP-R87PDJN";

	// Don't forget to change the local host in the connection according to which
	// laptop we use
	public DatabaseHandeller() {

	}

	private Date convertSqltoDate(java.sql.Date sqldate) {
		return Date.convarte_from_date_format(sqldate.toString());
	}

	@SuppressWarnings("deprecation")
	public List<Task> getAllTasks() { // mina
		List<Task> tasks = new ArrayList<Task>();

		String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task;";
			ResultSet res = stmt.executeQuery(SQL);
			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			while (res.next()) {
				Task t = new Task();
				if (res.getInt("parentTaskId") == 0) {
					t.setID(res.getInt("taskId"));
					t.setWorkingHours(res.getInt("workingHours"));

					sqldate = new java.sql.Date(res.getDate("plannedStartDate").getTime());

					t.setPlannedStartDate(convertSqltoDate(sqldate));
					sqldate = new java.sql.Date(res.getDate("plannedDueDate").getTime());

					t.setPlannedDueDate(convertSqltoDate(sqldate));

					sqldate = new java.sql.Date(res.getDate("actualStartDate").getTime());

					t.setActualStartDate(convertSqltoDate(sqldate));

					sqldate = res.getDate("actualDueDate");

					t.setActualDueDate(convertSqltoDate(sqldate));
					// t.display();
					tasks.add(t);
				}
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			System.out.println(e);
		}

		return tasks;
	}

	@SuppressWarnings("deprecation")
	public Task getTaskByID(int taskID) {// mina
		String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task where taskid=" + taskID + ";";
			ResultSet res = stmt.executeQuery(SQL);

			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			res.next();
			Task t = new Task();
			t.setID(res.getInt("taskId"));
			t.setWorkingHours(res.getInt("workingHours"));

			sqldate = res.getDate("plannedStartDate");

			t.setPlannedStartDate(convertSqltoDate(sqldate));

			sqldate = res.getDate("plannedDueDate");

			t.setPlannedDueDate(convertSqltoDate(sqldate));

			sqldate = res.getDate("actualStartDate");

			t.setActualStartDate(convertSqltoDate(sqldate));

			sqldate = res.getDate("actualDueDate");

			t.setActualDueDate(convertSqltoDate(sqldate));
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
		String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task;";
			ResultSet res = stmt.executeQuery(SQL);

			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			while (res.next()) {
				SubTask t = new SubTask();
				if (res.getInt("parentTaskId") > 0) {
					t.setParentID(res.getInt("parentTaskId"));

					t.setID(res.getInt("taskId"));
					t.setWorkingHours(res.getInt("workingHours"));

					sqldate = res.getDate("plannedStartDate");

					t.setPlannedStartDate(convertSqltoDate(sqldate));

					sqldate = res.getDate("plannedDueDate");

					t.setPlannedDueDate(convertSqltoDate(sqldate));

					sqldate = res.getDate("actualStartDate");
					convertSqltoDate(sqldate);

					t.setActualStartDate(convertSqltoDate(sqldate));

					sqldate = res.getDate("actualDueDate");

					t.setActualDueDate(convertSqltoDate(sqldate));

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
		String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task where taskid=" + taskID + ";";
			ResultSet res = stmt.executeQuery(SQL);

			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			res.next();
			SubTask t = new SubTask();
			t.setParentID(res.getInt("parentTaskId"));
			t.setID(res.getInt("taskId"));
			t.setWorkingHours(res.getInt("workingHours"));

			sqldate = res.getDate("plannedStartDate");

			t.setPlannedStartDate(convertSqltoDate(sqldate));

			sqldate = res.getDate("plannedDueDate");

			t.setPlannedDueDate(convertSqltoDate(sqldate));

			sqldate = res.getDate("actualStartDate");

			t.setActualStartDate(convertSqltoDate(sqldate));

			sqldate = res.getDate("actualDueDate");

			t.setActualDueDate(convertSqltoDate(sqldate));
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
		String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "SELECT  * FROM task where parentTaskId=" + task.getID() + ";";
			ResultSet res = stmt.executeQuery(SQL);

			java.sql.Date sqldate;
			// Iterate through the data in the result set and display it.
			while (res.next()) {
				SubTask t = new SubTask();
				t.setParentID(res.getInt("parentTaskId"));

				t.setID(res.getInt("taskId"));
				t.setWorkingHours(res.getInt("workingHours"));

				sqldate = res.getDate("plannedStartDate");

				t.setPlannedStartDate(convertSqltoDate(sqldate));

				sqldate = res.getDate("plannedDueDate");

				t.setPlannedDueDate(convertSqltoDate(sqldate));

				sqldate = res.getDate("actualStartDate");

				t.setActualStartDate(convertSqltoDate(sqldate));

				sqldate = res.getDate("actualDueDate");

				t.setActualDueDate(convertSqltoDate(sqldate));

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

	public List<MileStone> getAllMileStones() throws SQLException, ClassNotFoundException { // test done Badr
		// TODO Auto-generated method stub

		List<MileStone> mile = new ArrayList<MileStone>();
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I3MSHN8;databaseName=PM_db;integratedsecurity=true;";
		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "select * from mileStone";
			ResultSet rs = stmt.executeQuery(SQL);
			java.sql.Date date1 = null;
			while (rs.next()) {
				date1 = rs.getDate("date");

				mile.add(new MileStone(rs.getInt("mileStoneId"), rs.getString("name"), convertSqltoDate(date1)));
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		// System.out.println("Done");
		for (int i = 0; i < mile.size(); i++) {
			System.out.println(mile.get(i).toString());
		}
		return mile;
	}

	public MileStone getMileStoneByID(int mileStoneID) { // test done Badr
		// TODO Auto-generated method stub
		MileStone mile = new MileStone();
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I3MSHN8;databaseName=PM_db;integratedsecurity=true;";
		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "select * from mileStone where mileStoneId =" + mileStoneID;
			java.sql.Date date1 = null;
			ResultSet rs = stmt.executeQuery(SQL);
			rs.next();

			mile.setID(rs.getInt("mileStoneId"));
			mile.setName(rs.getString("name"));
			date1 = rs.getDate("date");

			mile.setDate(convertSqltoDate(date1));
			System.out.println(mile.toString());
			return mile;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<TeamMember> getAllTeamMembers() {// test done Badr
		List<TeamMember> teammember = new ArrayList<TeamMember>();
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I3MSHN8;databaseName=PM_db;integratedsecurity=true;";

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
		for (int i = 0; i < teammember.size(); i++) {
			System.out.println(teammember.get(i).toString());
		}
		return teammember;
	}

	public MileStone addNewMileStone(MileStone mileStone) {// test done //Badr
		// TODO Auto-generated method stub
		MileStone mile = new MileStone();
		String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "insert into mileStone (name,date) values ( " + "'" + mileStone.getName() + "'" + "," + "'"
					+ mileStone.getDate().getYear() + "-" + mileStone.getDate().getMonth() + '-'
					+ mileStone.getDate().getDay() + " " + mileStone.getDate().getHours() + ":00:00" + "'" + ");";
			stmt.executeUpdate(SQL);
			// System.out.println(SQL);
		} catch (Exception e) {
			System.out.println(e);

		}

		try (Connection s = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = s.createStatement();) {

			String SQL = "select * from mileStone where name='" + mileStone.getName() + "';";
			// System.out.println(SQL);
			ResultSet rs = stmt.executeQuery(SQL);
			rs.next();
			mile.setID(rs.getInt("mileStoneId"));
			mile.setDate(mileStone.getDate());
			mile.setName(mileStone.getName());
			return mile;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public TeamMember getTeamMemberByID(int teamMemberID) {// test done Badr
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I3MSHN8;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "select*from teamMember where teamMemberId=" + teamMemberID + ";";
			ResultSet res = stmt.executeQuery(SQL);
			res.next();
			TeamMember t = new TeamMember();
			t.setID(res.getInt("teamMemberId"));
			t.setName(res.getString("name"));
			t.setTitle(res.getString("title"));
			t.setWorkingHours(res.getInt("workingHours"));
			System.out.println(t.toString());
			return t;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public List<TeamMember> getTeamMembersOnTask(Task task) {// test done // Badr
		// TODO Auto-generated method stub
		List<TeamMember> tm = new ArrayList<TeamMember>();
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I3MSHN8;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "select * from teamMember where teamMemberId  in ( select WORKS_ON.teamMemberId from WORKS_ON where  WORKS_ON.taskId = "
					+ task.getID() + ")";
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				TeamMember t = new TeamMember();
				t.setID(rs.getInt("teamMemberId"));
				t.setName(rs.getString("name"));
				t.setTitle(rs.getString("title"));
				t.setWorkingHours(rs.getInt("workingHours"));
				tm.add(t);
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		for (int i = 0; i < tm.size(); i++) {
			System.out.println(tm.get(i).toString());
		}

		return tm;
	}

	public List<TeamMember> getTeamMembersOnSubTask(SubTask subTask) {// test done // Badr
		// TODO Auto-generated method stub
		List<TeamMember> tm = new ArrayList<TeamMember>();
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I3MSHN8;databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "select * from teamMember where teamMemberId  in ( select WORKS_ON.teamMemberId from WORKS_ON where  WORKS_ON.taskId = "
					+ subTask.getID() + ")";
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				TeamMember t = new TeamMember();
				t.setID(rs.getInt("teamMemberId"));
				t.setName(rs.getString("name"));
				t.setTitle(rs.getString("title"));
				t.setWorkingHours(rs.getInt("workingHours"));
				tm.add(t);
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		for (int i = 0; i < tm.size(); i++) {
			System.out.println(tm.get(i).toString());
		}
		return tm;
	}

//*********************************************************************
	public void resetDataBase() throws ClassNotFoundException, SQLException { // test done// omar

		String connectionUrl = "jdbc:sqlserver://"+databaseIP+";databaseName=PM_db;integratedsecurity=true;";
		Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
		
		
		String SQL1 = "DELETE FROM WORKS_ON;";
		String SQL2 = "DELETE FROM DEPENDS_ON;";
		String SQL3 = "DELETE FROM Task;";
		String resetId = "DBCC CHECKIDENT (Task, RESEED,0)";
		String SQL4 = "DELETE FROM mileStone;";
		String resetId1 = "DBCC CHECKIDENT (mileStone, RESEED,0)";
		String SQL5 = "DELETE FROM teamMember;";
		String resetId2 = "DBCC CHECKIDENT (teamMember, RESEED,0)";
		//String SQL6 = "DBCC CHECKIDENT ('PM_db', RESEED, 1)";
		
		Statement stmt1 = con.createStatement();
		Statement stmt2 = con.createStatement();
		Statement stmt3 = con.createStatement();
		Statement stmt4 = con.createStatement();
		Statement stmt5 = con.createStatement();
		Statement stmt6 = con.createStatement();
		Statement stmt7 = con.createStatement();
		Statement stmt8 = con.createStatement();
		Statement stmt9 = con.createStatement();
		
		stmt1.executeUpdate(SQL1);
		stmt2.executeUpdate(SQL2);
		stmt3.executeUpdate(SQL3);
		stmt4.executeUpdate(SQL4);
		stmt5.executeUpdate(SQL5);
		stmt6.executeUpdate(resetId);
		stmt7.executeUpdate(resetId1);
		stmt8.executeUpdate(resetId2);
		
	}

//---------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	public Task addNewTask(Task task) throws SQLException { // omar

		try {
			String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";
			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
			Statement stmt1 = con.createStatement();
			String SQL = "INSERT INTO Task (workingHours , plannedStartDate , plannedDueDate , actualStartDate , actualDueDate , parentTaskId) "
					+ " VALUES ('" + task.getWorkingHours() + "' ,'"
					+ task.getPlannedStartDate().convarte_to_date_format(task.getPlannedStartDate()) + "' ,'"
					+ task.getPlannedDueDate().convarte_to_date_format(task.getPlannedDueDate()) + "','"
					+ task.getActualStartDate().convarte_to_date_format(task.getActualStartDate()) + "','"
					+ task.getActualDueDate().convarte_to_date_format(task.getActualDueDate()) + "' , 0);";
			stmt1.executeUpdate(SQL);

			Statement stmt2 = con.createStatement();
			SQL = "SELECT max(taskId) as taskid from task ";
			ResultSet res = stmt2.executeQuery(SQL);
			res.next();
			task.setID(res.getInt("taskId"));
			return task;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

//---------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	public SubTask addNewSubTask(Task task, SubTask subTask) throws SQLException { // omar

		try {
			String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";
			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
			Statement stmt1 = con.createStatement();
			String SQL = "INSERT INTO Task (workingHours , plannedStartDate , plannedDueDate , actualStartDate , actualDueDate , parentTaskId) "
					+ " VALUES ('" + subTask.getWorkingHours() + "' ,'"
					+ task.getPlannedStartDate().convarte_to_date_format(subTask.getPlannedStartDate()) + "' ,'"
					+ subTask.getPlannedDueDate().convarte_to_date_format(subTask.getPlannedDueDate()) + "','"
					+ subTask.getActualStartDate().convarte_to_date_format(subTask.getActualStartDate()) + "','"
					+ subTask.getActualDueDate().convarte_to_date_format(subTask.getActualDueDate()) + "' , '"
					+ task.getID() + "');";
			stmt1.executeUpdate(SQL);

			Statement stmt2 = con.createStatement();
			SQL = "SELECT max(taskId) as subtaskid from task ";
			ResultSet res = stmt2.executeQuery(SQL);
			res.next();
			subTask.setID(res.getInt("subtaskid"));
			return subTask;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

//---------------------------------------------------------------------
	public TeamMember addNewTeamMember(TeamMember teamMember) throws SQLException {// test done // omar

		String connectionUrl = "jdbc:sqlserver://"+ databaseIP +";databaseName=PM_db;integratedsecurity=true;";
		Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
		try {
		Statement stat = con.createStatement();
		String SQL = "insert into teamMember(name,title,teamMember.workingHours) values" +" ('"+teamMember.getName()+"','"+ teamMember.getTitle()+"'," +teamMember.getWorkingHours()+")";
		stat.executeUpdate(SQL);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		try {
			String sql = "select max(teamMemberId) as ID from teamMember";
			Statement stat1 = con.createStatement();
			ResultSet set1 = stat1.executeQuery(sql);
			set1.next();
			teamMember.setID(set1.getInt("ID"));	
			return teamMember;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}

//---------------------------------------------------------------------
	//---------------------------------------------------------------------
	public void assignTeamMemberToTask(TeamMember teamMember, Task task) throws SQLException { // test done // omar

		String connectionUrl = "jdbc:sqlserver://"+ databaseIP +";databaseName=PM_db;integratedsecurity=true;";
		Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
		try {
		Statement stmt = con.createStatement();
		String SQL = "INSERT INTO WORKS_ON (taskid , teamMemberid , workingDays) "
				+ " VALUES (" +task.getID()+ "," + teamMember.getID()+ ","+ 0 +");";
		stmt.executeUpdate(SQL);

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

//---------------------------------------------------------------------
	public void assignTeamMemberToSubTask(TeamMember teamMember, SubTask subTask) throws SQLException { // test done// omar

		String connectionUrl = "jdbc:sqlserver://"+ databaseIP +";databaseName=PM_db;integratedsecurity=true;";
		Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
		try {
		Statement stmt = con.createStatement();
		String SQL = "INSERT INTO WORKS_ON (taskid , teamMemberid , workingDays) "
				+ " VALUES (" +subTask.getID()+ "," + teamMember.getID()+ ","+ 0 +");";
		stmt.executeUpdate(SQL);

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

//---------------------------------------------------------------------
	public void saveTask(Task task) throws SQLException {// omar

		String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";
		Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
		Statement stmt = con.createStatement();
		String SQL = "UPDATE Task set workingHours=" + task.getWorkingHours() + ", plannedStartDate="
				+ task.getPlannedStartDate() + ", plannedDueDate=" + task.getPlannedDueDate() + ", actualStartDate="
				+ task.getActualStartDate() + ", actualDueDate=" + task.getActualDueDate() + ", parentTaskId=" + -1
				+ " WHERE taskid=" + task.getID() + ";";
		ResultSet res = stmt.executeQuery(SQL);
	}

//---------------------------------------------------------------------
	public void saveSubTask(SubTask subTask) throws SQLException { // omar

		String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";
		Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
		Statement stmt = con.createStatement();
		String SQL = "UPDATE Task set workingHours=" + subTask.getWorkingHours() + ", plannedStartDate="
				+ subTask.getPlannedStartDate() + ", plannedDueDate=" + subTask.getPlannedDueDate()
				+ ", actualStartDate=" + subTask.getActualStartDate() + ", actualDueDate=" + subTask.getActualDueDate()
				+ ", parentTaskId=" + subTask.getParentID() + " WHERE taskid=" + subTask.getID() + ";";
		ResultSet res = stmt.executeQuery(SQL);
	}

	public void saveAllTasks(List<Task> tasksList) throws SQLException {
		for (Task task : tasksList) {
			saveTask(task);
		}
	}

	public void saveAllSubTasks(List<SubTask> subTasksList) throws SQLException {
		for (SubTask subTask : subTasksList) {
			saveSubTask(subTask);
		}
	}

	public void assignTaskToDependentTask(Task task, Task dependentTask) { // Mark the task, so it depends on the
																			// dependent task.
		String connectionUrl = "jdbc:sqlserver://" + databaseIP + ";databaseName=PM_db;integratedsecurity=true;";

		try (Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
				Statement stmt = con.createStatement();) {
			String SQL = "insert into DEPENDS_ON (taskId,dependsONTaskId) values (" + task.getID() + ","
					+ dependentTask.getID() + ");";
			stmt.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void modifyTaskWorkingHours(Task task, int actualWorkingDays) throws SQLException {
		List<Task> tasksList = getAllTasks();
		List<SubTask> subTasksList = getAllSubTasks();
		updateDataBaseOnTask(tasksList, subTasksList, task, actualWorkingDays);
		saveAllTasks(tasksList);
		saveAllSubTasks(subTasksList);
	}

	public void modifySubTaskWorkingHours(SubTask subTask, int actualWorkingDays) throws SQLException {
		List<Task> tasksList = getAllTasks();
		List<SubTask> subTasksList = getAllSubTasks();
		updateDataBaseOnSubTask(tasksList, subTasksList, subTask, actualWorkingDays);
		saveAllTasks(tasksList);
		saveAllSubTasks(subTasksList);
	}

	private void updateDataBaseOnTask(List<Task> tasksList, List<SubTask> subTasksList, Task task,
			int actualWorkingDays) { // Mina.
		// TODO Auto-generated method stub

	}

	private void updateDataBaseOnSubTask(List<Task> tasksList, List<SubTask> subTasksList, SubTask subTask,
			int actualWorkingDays) { // Fares.
		// TODO Auto-generated method stub

	}
}
