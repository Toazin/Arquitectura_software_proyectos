package NO_SOLID;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author zjaramil
 */
public class Main {

  private static ArrayList<String> subjects    = new ArrayList<>();
  private static LinkedList<String> enrollment = new LinkedList<>();

  public static void main(String[] args){
    subjects.add("Math");
    subjects.add("OOP");
    subjects.add("SoftwareDesign");

    System.out.println("-----SCHEDULE-TEC-----");

    Scanner scanner = new Scanner(System.in);
    System.out.println("Name:");
    String name = scanner.nextLine();
    System.out.println("Semester:");
    int semester = Integer.parseInt(scanner.nextLine());


    String answer = null;
    do{
      System.out.println("Which subject you like to enroll?");

      for(String s : subjects){
        System.out.println("\t" + s);
      }

      System.out.println("Subject:");
      answer = scanner.nextLine();

      if( subjects.contains(answer) ){
        if("SoftwareDesign".equals(answer)){
          if(semester <= 5){
            System.out.println(">>>  You can't enroll on this subject until 6th semester");
          }
          else{
            System.out.println();
            System.out.println();
            System.out.println(">>> Done. Good look on your '" + answer + "' class");
            enrollment.add(answer);
          }
        }
        else{
          System.out.println();
          System.out.println();
          System.out.println("Done. Good look on your '" + answer + "' class");
          enrollment.add(answer);
        }
      }
    }
    while(!"Exit".equals(answer));
    System.out.println();
    System.out.println("------ Enrollment " + name + "-------");
    for(String s : enrollment){
      System.out.println(s);
    }
  }

}
