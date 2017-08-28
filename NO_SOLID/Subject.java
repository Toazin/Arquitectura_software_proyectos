package NO_SOLID;
/**
 *
 * @author Toatzin Padilla
 */
public class Subject implements ISubject{
	private String name;
	private int semester;

	public Subject(String name, int semester) {
		this.name = name;
		this.semester = semester;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public int getSemester() {
		// TODO Auto-generated method stub
		return this.semester;
	}
	@Override
	public boolean isCandidate(Alumno a) {
		// TODO Auto-generated method stub
		if(a.getSemester()>= this.semester){
			return true;
		}else{
			return false;
		}

	}

}
