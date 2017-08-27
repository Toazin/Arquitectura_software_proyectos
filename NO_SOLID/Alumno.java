package NO_SOLID;

import java.util.ArrayList;
import java.util.LinkedList;

public class Alumno implements IAlumno{
	String name;
	int semester;
	private LinkedList<Subject> enrollment = new LinkedList<Subject>();
	public Alumno(){
		
	}
	@Override
	public void setName(String name) {
		this.name = name;
		
	}
	@Override
	public void setSemester(int semester) {
		this.semester = semester;
	}
	@Override
	public void enroll(Subject subject) {
		// TODO Auto-generated method stub
		this.enrollment.add(subject);
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public int getSemester() {
		
		return this.semester;
	}
	@Override
	public LinkedList<Subject> getSubjects() {
		return this.enrollment;
	}


}
