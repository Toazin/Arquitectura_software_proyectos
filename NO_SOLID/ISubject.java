package NO_SOLID;
/**
 *
 * @author Toatzin Padilla
 */
public interface ISubject {
	public void setName(String name);
	public String getName();
	public int getSemester();
	public boolean isCandidate(Alumno alumno);
}
