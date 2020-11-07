/*
Visu Vasa
Visu Vasa
Yash Santhosh
Tobi Ijiyemi
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;
import java.util.Collections;
import java.io.*;
class Main {
  public static void main(String[] args) {
    ArrayList<String> students = new ArrayList<String>();
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the number of students: ");
    int studentNum = s.nextInt();
    for (int i=0;i<studentNum;i++) {
      switch (i+1) {
        case 1:
          System.out.print("Enter the " + (i+1) + "st student's name: ");
          break;
        case 2:
          System.out.print("Enter the " + (i+1) + "nd student's name: ");
          break;
        case 3:
          System.out.print("Enter the " + (i+1) + "rd student's name: ");
          break;
        default:
          System.out.print("Enter the " + (i+1) + "th student's name: ");
          break;
      }
      String nameTemp = s.next();
      nameTemp = nameTemp.toLowerCase();
      students.add(nameTemp);
    }
    s.close();
    Collections.sort(students);
    System.out.println("Your students: " + students);
    try {
      File students_file = new File("students.txt");
      if (students_file.createNewFile()) {
        System.out.println("File created: " + students_file.getName());
        for (int a = 0; a < students.size(); a++) {
          students_file.write(students.get(a) + "\n");
        }
        students_file.close();
      } else {
        for (int a = 0; a < students.size(); a++) {
          students_file.write(students.get(a) + "\n");
        }
        students_file.close();
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    //String[] students = s.next().split(",");
    //for (int i = 0; i < students.length(); i++) {
      
    //}
  }
}