/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programmingassignment_question_1;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class ProgrammingAssignment_Question_1 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        
        /*
        -Must design a java program to manage students 
        ***requirements***
        -When the application starts it must display given menu 
        -Prompt the user to enter 1 ro launch menu or any other key to exit"make the application quit if 
           1 is not chosen"
        -Create another menu after 1 is chosen with 5 options "maybe use a switch case to manage what to do"
        -use arrays or arrays lists to save student data that the user will capture 
        -if the user wants to capture a new student then ask the user for the following 
           *student id
           *student name 
           *student age "must be >= 16 if anything else repormpt for a valid age"
           *student email
           *student course 
           *then at the bottom have "1 to enter menu" or "another key to exit"
        - when the all data fields are entered output message to show ST details are saved
        - for the main menu we have search functions "if searched is chosen" then ask for st ID then display details of ST
           also have at the bottom have "1 to enter menu" or "another key to exit"
        - if ST number does not exist give a error message and return to menu or quit function 
        - add a delelte functon to delete ST data and have a confirmation message before deleteing 
        - add a final report to show all student data entered 
        */
        
        Scanner KG = new Scanner(System.in);
        student kb = new student(); // call student class 
       
        System.out.println("STUDENT MANAGMENT APPLICATION\n"  // opening message when application runs
        +"*************************************\n"
        +"Enter (1) to launch menu or any other key to exit");
     String menu = KG.next(); // Read input as a string
        
        switch (menu) {
            case "1":   // if casewe continue oranything else quit
                
                kb.menuOption(); // Call the menuOption method from the student class
                break;
            default:
               
                kb.ExitStudentApplication();
                break;
        }
        
        
        
       
        
        
    }
    
}

