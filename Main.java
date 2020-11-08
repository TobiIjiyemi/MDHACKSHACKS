/*
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
  public static ArrayList<String> readFile(String file) {
    File readerFile = new File(file);
    ArrayList<String> students = new ArrayList<String>();
    try {
      String studentsInTxt;
      FileReader in = new FileReader(file);
      BufferedReader readTxt = new BufferedReader(in);
      while ((studentsInTxt = readTxt.readLine()) != null) {
        students.add(studentsInTxt);
      }
      readTxt.close();
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("The file could not be found.");
      System.err.println("FileNotFoundException: " +e.getMessage());
    } catch (IOException e) {
      System.out.println("Problem Reading File.");
      System.err.println("IOException: " +e.getMessage());
    }
    return students;
  }
  public static void overWriteFile() {
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
      FileWriter myWriter = new FileWriter("students.txt");
      if (students_file.createNewFile()) {
        System.out.println("File created: " + students_file.getName());
        for (int a = 0; a < students.size(); a++) {
          myWriter.write(students.get(a) + "\n");
        }
        myWriter.close();
      } else {
        for (int a = 0; a < students.size(); a++) {
          myWriter.write(students.get(a) + "\n");
        }
        myWriter.close();
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Would you like to use an existing file or would you like to overwrite the file?(type in either overwrite or existing):");
    String chosen = input.nextLine();
    if (chosen.equals("overwrite")) {
      System.out.println("Overwriting...");
      overWriteFile();
      readFile("students.txt");
    } else if (chosen.equals("existing")) {
      System.out.println("Retrieving Existing File...");
      readFile("students.txt");
    } else {
      System.out.println("We don't know what that means. Please try again.");
    }
    System.out.println("When a student is present, please type in their name along with the letter p\n");
    ArrayList<String> studentsPresent = new ArrayList<String>();
    System.out.print("Enter the student's name: ");
    String user_input = input.next().toLowerCase();
    while (!user_input.equals("none")) {
      if (readFile("students.txt").contains(user_input)) {
        studentsPresent.add(user_input);
      }
      System.out.print("Enter the student's name: ");
      user_input = input.next().toLowerCase();
    }
    //oh ok you just passed some parameters
    //gimme a second lemme search something up, ik i changed some of the readfile though
    System.out.println("The students present are" + studentsPresent);
    // boolean flagger = false;
    // while (flagger == false) {
    //   System.out.print("Enter the student's name: ");
    //   String studentNamePresent = input.next();
    //   for (int i=0;i<studentNamePresent.length();i++) {
    //     // String studentName = studentName.isWhiteSpace(studentNamePresent.charAt(i));
    //     String studentName = studentNamePresent.replaceAll("", " ");
    //     System.out.println(studentName);
    //     //having problems, gonna get help
    //   }
      
    // }
    input.close();
  }
}