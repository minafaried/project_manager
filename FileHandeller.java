import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

//****************************************************************************
public class FileHandeller { // omar
	final private String projectData = "ProjectData.txt";
	final private String beforeStartPlanFile = "BeforeStart.csv";
	final private String afterFinishPlanFile = "AfterFinish.csv";

	public FileHandeller() {
		// System.out.println("filehandeller is called");
	}

//----------------------------------------------------------------------------
	public void saveProject(Project currentProject) throws IOException {

		FileOutputStream file = new FileOutputStream(new File(projectData));
		ObjectOutputStream object = new ObjectOutputStream(file);
		object.writeObject(currentProject);
		object.close();
		file.close();

	}

//----------------------------------------------------------------------------
	public Project loadProject() throws IOException, ClassNotFoundException {

		FileInputStream file = new FileInputStream(new File(projectData));
		ObjectInputStream object = new ObjectInputStream(file);
		Project p = (Project) object.readObject();
		return p;

	}

//----------------------------------------------------------------------------
	public void constructProjectPlanBeforeStart(int[] x_axis, Date[] y_axis_start, Date[] y_axis_finished)
			throws FileNotFoundException {

		constructExcelFile(x_axis, y_axis_start, y_axis_finished, beforeStartPlanFile);
	}

//----------------------------------------------------------------------------
	public void constructProjectPlanAfterFinish(int[] x_axis, Date[] y_axis_start, Date[] y_axis_finished)
			throws FileNotFoundException {
		
		constructExcelFile(x_axis, y_axis_start, y_axis_finished, afterFinishPlanFile);
	}
	private void constructExcelFile(int[] x_axis, Date[] y_axis_start, Date[] y_axis_finished, String fileName) throws FileNotFoundException {
		FileOutputStream file = new FileOutputStream(fileName);
		PrintWriter print = new PrintWriter(file);
		print.println("ID , Start , Finish");
		for (int i = 0; i < x_axis.length; i++) {
			print.println(x_axis[i] + "," + y_axis_start[i].convarte_to_date_format(y_axis_start[i]) + ","
					+ y_axis_finished[i].convarte_to_date_format(y_axis_finished[i]));
		}
		print.close();
	}

//----------------------------------------------------------------------------
	public void clearProjectData() throws FileNotFoundException {

		File file = new File(projectData);
		PrintWriter delete = new PrintWriter(file);
		delete.write("");
		delete.close();

	}

}
//****************************************************************************
