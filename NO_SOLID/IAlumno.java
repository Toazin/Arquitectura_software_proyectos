package NO_SOLID;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author Toatzin Padilla
 */
public interface IAlumno {
	public void setName(String name);
	public void setSemester(int semester);
	public String getName();
	public int getSemester();
	public void enroll(Subject subject);
	public LinkedList<Subject> getSubjects();
}
