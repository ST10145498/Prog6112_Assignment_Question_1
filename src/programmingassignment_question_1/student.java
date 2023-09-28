/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment_question_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */

public class student { //Contain my working methods to do menu functions 
     Scanner KG = new Scanner(System.in); // 1 scanner used for every method 
     /*
     general notes on code 
     -many times do i add the same swicth case to launch or quit applicataions,
     it serves as a means to make the application run smoothly and wont just quit 
     if the user enters invalid data , i do this to the user have a easier time 
     as the application will confirm if the user wants the menu or quit before it ends
    therefore for effeciency purposes i used the same type of switch case to quit or go to menu
     */
     
     /*
          methods to keep in mind when working with arraylists 
         removeAll()
         clear()
         size()
         clone()
         contains() 
         isEmpty ()
         indexOf() 
          */
    
    //add arraylists here to hold data saved 
    public ArrayList<String> studentId = new ArrayList<>();
    public ArrayList<String> studentName= new ArrayList<>();
    public ArrayList<String> studentEmail = new ArrayList<>();
    public ArrayList<Integer> studentAge = new ArrayList<>();
    public ArrayList<String> studentCourse = new ArrayList<>();
    
    
    public void menuOption() {
    /*
     I didnt like the idea that if the user enters a variable not 1-5 the program would quit
    to make the program run more smoothly we re-prompt for an invalid option.
    this makes the program more user-friendly as the user would not have to restart the program if they accidentally 
    input the wrong key 
    */
     int choice;

    while (true) {  // when the menuoption is called after the user chooses 1 we display this menu 
        System.out.println("Please select one of the following menu items:"
                + "\n(1) Capture a new student."
                + "\n(2) Search for a student."
                + "\n(3) Delete a student."
                + "\n(4) Print student report."
                + "\n(5) Exit application.");

        if (KG.hasNextInt()) {
            choice = KG.nextInt();
            KG.nextLine();

            if (choice >= 1 && choice <= 5) {
                break; // Valid choice, exit the loop
            } else {
                System.out.println("Option does not exist please enter a valid option(1-5)");
            }
        } else {
            KG.nextLine(); // Clear invalid input
            System.out.println("Option does not exist please enter a valid option(1-5)");
        }
    }

    // Now that you have a valid choice, use a switch statement to call the related method for the given task
    switch (choice) {
        case 1:
            captureStudent();
            break;
        case 2:
            SearchStudent();
            break;
        case 3:
            DeleteStudent();
            break;
        case 4:
            StudentReport();
            break;
        case 5:
            ExitStudentApplication();
            break;
        default:
            System.out.println("Invalid choice.");
            break;
    }
}
    
    public void captureStudent() {
    /*
    Purpose for this method is to capture the data that the user enters for a student.
    */
    System.out.println("CAPTURE A NEW STUDENT\n"
            + "*************************");
    System.out.print("Enter the student ID: ");
    String stId = KG.next();
    KG.nextLine();

    System.out.print("Enter the student name: ");
    String stName = KG.nextLine();

    int age;
    boolean invalidAge = false;

    do {  
        // Do-while loop for valid or invalid age
        if (invalidAge) {
            System.out.println("You have entered an incorrect student age!!!");
            System.out.print("Please re-enter the student age>> ");
        } else {
            System.out.print("Enter the student age: ");
        }

        while (!KG.hasNextInt()) {
            System.out.println("You have entered an incorrect student age!!!");
            System.out.print("Please re-enter the student age>> ");
            KG.next(); // Clear the invalid input
        }

        age = KG.nextInt();
        KG.nextLine();
        invalidAge = (age < 16);

        if (invalidAge) {
            continue; // Skip adding data if age is invalid
        }

        if (age >= 16) {
            System.out.print("Enter the student email: ");
            String stEmail = KG.nextLine();

            System.out.print("Enter the student course: ");
            String stCourse = KG.nextLine();

            saveStudent(stId, stName, age, stEmail, stCourse);
            
            System.out.println("Student details are saved.");
            
            System.out.println("Enter (1) to launch the menu or any other key to exit");
            String menuChoice = KG.nextLine();

            // Process the user's menu choice
            switch (menuChoice) {
                case "1":
                    menuOption();
                    break;
                default:
                    ExitStudentApplication();
                    break;
            }
        }
    } while (invalidAge);
}
public void saveStudent(String stId, String stName, int age, String stEmail, String stCourse) { //pass variables from capture 
    /*
    This method is responsible for saving the student's data to the respective ArrayLists.
    It takes the student ID, name, age, email, and course as parameters and adds them to the arrays.
    */
    studentId.add(stId);
    studentName.add(stName);
    studentAge.add(age);
    studentEmail.add(stEmail);
    studentCourse.add(stCourse);
}
   
   public void SearchStudent() {
    /*
    this method must find the id with the corresponding student and output whatever data has been entered 
    -we can use the arraylist to search for the info in the array 
   */
    
    // Prompt the user to enter the student ID to search
    System.out.print("Enter the student id to search: ");
    String findStudentId = KG.nextLine();

    // Find the index of the student ID in the ArrayList
    int findInfo = studentId.indexOf(findStudentId);

    // Check if the student ID was found or not
    if (findInfo != -1) {
        // Display student details if the ID was found
        System.out.println("----------------------------------------");
        System.out.println("STUDENT ID: " + studentId.get(findInfo));
        System.out.println("STUDENT NAME: " + studentName.get(findInfo));
        System.out.println("STUDENT AGE: " + studentAge.get(findInfo));
        System.out.println("STUDENT EMAIL: " + studentEmail.get(findInfo));
        System.out.println("STUDENT COURSE: " + studentCourse.get(findInfo));
        System.out.println("----------------------------------------");
    } else {
        // Display error message if the ID was not found
        System.out.println("---------------------------------------");
        System.out.println("Student with student ID: " + findStudentId + " was not found!");
        System.out.println("---------------------------------------");
    }

    // Prompt the user for menu choice
    System.out.println("Enter (1) to launch menu or any other key to exit");
    String menuChoice = KG.nextLine();

    // Process the user's menu choice
    switch (menuChoice) {
        case "1":
            menuOption();
            break;
        default:
             ExitStudentApplication();
            break;
    }
}
    public void DeleteStudent() {
    
     /*
     This method allows the user to delete a student by entering their student ID.
     It searches for the student ID in the ArrayList of student IDs and removes
     the corresponding data from all other ArrayLists if found. It asks for confirmation
     before deleting and handles the deletion. 
        
     we made it so that if the user enters an id that is non existant then we output menu or quit
     we made it so that if the user press any random key when choosing to press y to confirm deletion then 
     we cancel the deletion and reprompt to menu or quit so that the program is seamless and does not bomb out 
     this also ensures that the code is user friendly ensuring the program does not quit from the user pressing an incorrect key 
        
     After deletion 
     it prompts the user to return to the menu or exit the application.
     */
        System.out.print("Enter the student id to delete: ");
        String delStudentId = KG.nextLine();
        int index = studentId.indexOf(delStudentId);
    
        if (index == -1) {
        System.out.println("No such student ID (" + delStudentId + ") exists in the system.");
        System.out.println("Enter (1) to launch menu or any other key to exit");
         String menu = KG.nextLine();

      switch (menu) { // same switch case to menu or quit
         case "1":
            menuOption();
            break;
        default:
             ExitStudentApplication();
            break;
    }
        
    } else {
        System.out.println("Are you sure you want to delete student " + delStudentId + " from the system? Enter (y) to delete.");
        String answer = KG.nextLine();
         
         
        switch (answer) {
        case "y":
            if (index != -1) {
                studentId.remove(index);
                studentName.remove(index);
                studentAge.remove(index);
                studentEmail.remove(index);
                studentCourse.remove(index);

                System.out.println("----------------------------------------");
                System.out.println("Student with student ID: " + delStudentId + " WAS deleted!");
                System.out.println("----------------------------------------");
            } else {
                System.out.println("Student with student ID: " + delStudentId + " does not exist.");
            }
            
            break;

        default:
            System.out.println("Student deletion canceled.");
            break;
    }

    System.out.println("Enter (1) to launch menu or any other key to exit");
    String menu = KG.nextLine();

    switch (menu) {
        case "1":
            menuOption();
            break;
        default:
             ExitStudentApplication();
            break;
    }

        }
    }
    
    public void StudentReport() {
        
        /*
        Basic method - Prints the student reports of all students in the system, 
        this will not print out students who have been removed
        make use of .get to get student info for printing 
        */
        
        //.size shows the size of the arraylist 
       int count = studentId.size(); 

    for (int i = 0; i < count; i++) { // simple for loop that goes trough the array to print out all data ,we increment to output all students
        System.out.println("STUDENT " + (i + 1)); // outputs student position and increases after each print
        
        System.out.println("-----------------------------------------");//41 dashes 
        System.out.println("STUDENT ID: " + studentId.get(i)); 
        System.out.println("STUDENT NAME: " + studentName.get(i));
        System.out.println("STUDENT AGE: " + studentAge.get(i));
        System.out.println("STUDENT EMAIL: " + studentEmail.get(i));
        System.out.println("STUDENT COURSE: " + studentCourse.get(i));
        System.out.println("-----------------------------------------");//41 dashes
        
    }
    
    System.out.println("Enter (1) to launch menu or any other key to exit");
    String menuChoice = KG.nextLine();
    
    // Process the user's menu choice
    switch (menuChoice) {
        case "1":
            menuOption();
            break;
        default:
             ExitStudentApplication();
            break;
    }
    }
    
    public void ExitStudentApplication()
            /*
            all this does is quits the application and give an end message 
            */
    {
        System.out.println("Thank you for using the program\n"
                + "The program has ended ;)"); 
        
     
    }

}
