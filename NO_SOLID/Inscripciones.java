package NO_SOLID;

import java.util.ArrayList;
import java.util.Scanner;

public class Inscripciones {
	private Alumno alumno = new Alumno();
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	public Inscripciones(){
		this.obtainSubjects();
	}
	
	public void start(){
		this.obtainStudent();
		this.startEnrollment(this.alumno, this.subjects);
	}
	
	private void obtainSubjects() {
		this.subjects.add(new Subject("Maths", 4));
		this.subjects.add(new Subject("OOPs", 5));
		this.subjects.add(new Subject("SoftwareDesigns", 6));
	}
	
	private void obtainStudent(){
		System.out.println("-----SCHEDULE-TEC-----");
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Name:");
	    String name = scanner.nextLine();
	    System.out.println("Semester:");
	    int semester = Integer.parseInt(scanner.nextLine());
	    alumno.setName(name);
	    alumno.setSemester(semester);
	}
	
	private void startEnrollment(Alumno alumno, ArrayList<Subject> subjects){
		Scanner scanner = new Scanner(System.in);
		String answer;
		
		System.out.println("Which subject you like to enroll?");
		for(Subject s : subjects){
		    System.out.println("\t" + s.getName());
		}
		System.out.println("Subject:");
		answer = scanner.nextLine();
		this.executeAnswer(answer, subjects, alumno);
	}

	private void executeAnswer(String answer, ArrayList<Subject> sc, Alumno alumno){
		if(answer.length() == 0){
			startEnrollment(alumno, sc);
			return ;
		}else if(new String(answer.toLowerCase()).equals("exit")){
			this.inscriptionResume(alumno);
		}else{
			int index = 0;
			for(Subject s : sc){
				if(new String(s.getName().toLowerCase()).equals(answer.toLowerCase())){
					if(s.isCandidate(alumno)){
						System.out.println("Done. Good look on your '" + s.getName() + "' class");
						alumno.enroll(s);
						sc.remove(index);
					}else{
						System.out.println(">>>  You can't enroll on this subject until 6th semester");
					}
					break;
				}
				index++;
			}
			startEnrollment(alumno, sc);
		}
	}
	
	private void inscriptionResume(Alumno a){
		System.out.println();
	    System.out.println("------ Enrollment " + a.getName() + "-------");
	    for(Subject s : a.getSubjects()){
	      System.out.println(s.getName());
	    }
	}
}
