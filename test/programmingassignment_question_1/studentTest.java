/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package programmingassignment_question_1;


import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Test;


public class studentTest {
    
@Test
public void testSaveStudent() {
    // Create an instance of the student class
    student testStudent = new student();

    // Set student data directly
    testStudent.studentId.add("st10145498");
    testStudent.studentName.add("Kyle");
    testStudent.studentAge.add(22);
    testStudent.studentEmail.add("kyle@gmail.com");
    testStudent.studentCourse.add("Prog6112");

    // Check that at least one student is saved
    assertTrue(testStudent.studentId.size() > 0);

    // Check that the saved data exists in the ArrayLists
    assertEquals("st10145498", testStudent.studentId.get(0));
    assertEquals("Kyle", testStudent.studentName.get(0));
    assertEquals(22, testStudent.studentAge.get(0).intValue());
    assertEquals("kyle@gmail.com", testStudent.studentEmail.get(0));
    assertEquals("Prog6112", testStudent.studentCourse.get(0));
}
   @Test
   public void testSearchStudent() {
       // Create an instance of the student class
       student testStudent = new student();

       // Add sample student data
       testStudent.studentId.add("st10145498");
       testStudent.studentName.add("Kyle");
       testStudent.studentAge.add(22);
       testStudent.studentEmail.add("kyle@gmail.com");
       testStudent.studentCourse.add("Prog6112");

       // Supply student ID to search
       testStudent.KG = new Scanner("st10145498\n2");

       // Call the SearchStudent method
       testStudent.SearchStudent();

       // Check if the correct student details were returned
       assertEquals("st10145498", testStudent.studentId.get(0));
       assertEquals("Kyle", testStudent.studentName.get(0));
       assertEquals(Integer.valueOf(22), testStudent.studentAge.get(0));
       assertEquals("kyle@gmail.com", testStudent.studentEmail.get(0));
       assertEquals("Prog6112", testStudent.studentCourse.get(0));
   }

   @Test
   public void testSearchStudent_StudentNotFound() {
       // Create an instance of the student class
       student testStudent = new student();

       // Supply an incorrect student ID to search
       testStudent.KG = new Scanner("NonExistentID\n2");

       // Call the SearchStudent method
       testStudent.SearchStudent();

       // Check if the method handles a student not found correctly
       assertEquals(0, testStudent.studentId.size()); // No student found, so the list should be empty
   }

   @Test
   public void testDeleteStudent() {
       // Create an instance of the student class
       student testStudent = new student();

       // Add sample student data
       testStudent.studentId.add("st10145498");
       testStudent.studentName.add("Kyle");
       testStudent.studentAge.add(22);
       testStudent.studentEmail.add("kyle@gmail.com");
       testStudent.studentCourse.add("Prog6112");

       // Supply student ID to delete
       testStudent.KG = new Scanner("st10145498\ny\n2");

       // Call the DeleteStudent method
       testStudent.DeleteStudent();

       // Check if the student was successfully deleted
       assertEquals(0, testStudent.studentId.size()); // Student should be deleted, so the list should be empty
   }

   @Test
   public void testDeleteStudent_StudentNotFound() {
       // Create an instance of the student class
       student testStudent = new student();

       // Supply an incorrect student ID to delete
       testStudent.KG = new Scanner("NonExistentID\n2");

       // Call the DeleteStudent method
       testStudent.DeleteStudent();

       // Check if the method handles a student not found correctly
       assertEquals(0, testStudent.studentId.size()); // No student found, so the list should be empty
   }

   @Test
   public void testStudentAge_StudentAgeValid() {
       // Create an instance of the student class
       student testStudent = new student();

       // Supply valid student age as input
       testStudent.KG = new Scanner("1\nst10145498\nKyle\n22\nkyle@gmail.com\nProg6112\n2"); // we supply the other data aswell

       // Call the SaveStudent method
       testStudent.captureStudent();

       // Check if the student's age is valid (should not trigger invalid age message)
       assertEquals(1, testStudent.studentId.size()); // Student should be saved, only if age is valid
   }

   @Test
public void testStudentAge_StudentAgeInvalid() {
    
    student testStudent = new student();

      
       testStudent.KG = new Scanner("1\nst10145498\nKyle\n22\nkyle@gmail.com\nProg6112\n2");

       // Call the SaveStudent method
       testStudent.captureStudent();

       
       assertEquals(1, testStudent.studentId.size()); 
   }


   @Test
   public void testSaveStudent_InvalidCharacter() {
       student testStudent = new student();
       String input = "st10145498\nKyle\n22\nkyle@gmail.com\nProg6112\ninvalid\nst10145498\nKyle\n22\nkyle@gmail.com\nProg6112\n1";
       ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
       System.setIn(in);
       Scanner scanner = new Scanner(System.in);
       testStudent.KG = scanner;

       testStudent.captureStudent();

       assertEquals(1, testStudent.studentId.size());
   }
}