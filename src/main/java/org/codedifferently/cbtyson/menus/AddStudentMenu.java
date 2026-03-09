package org.codedifferently.cbtyson.menus;

import org.codedifferently.cbtyson.data.GroupList;
import org.codedifferently.cbtyson.data.Student;
import org.codedifferently.cbtyson.helpers.InputHandler;

import java.util.UUID;

public class AddStudentMenu {

    public void promptAddStudentMenu() {

        System.out.println("=============================================================");
        System.out.println();
        System.out.println("Add Student Menu:");
        System.out.println("Lets add some students!");
        System.out.println();
        System.out.println("=============================================================");

        boolean inStudentMenu = true;

        while (inStudentMenu) {

            System.out.println("Enter their First Name: ");
            String firstName = InputHandler.handleStringInput();

            System.out.println("Enter their Last Name: ");
            String lastName = InputHandler.handleStringInput();

            System.out.println("Enter their Email: ");
            String email = InputHandler.handleStringInput();

            System.out.println("Enter their Age: ");
            int age = InputHandler.handleIntegerInput();

            System.out.println("Enter their GPA: ");
            double gpa = InputHandler.handleDoubleInput();

            // Generate a new UUID object
            String studentID = UUID.randomUUID().toString();
            studentID = studentID.substring(0,6);

            Student student = new Student(firstName, lastName, email, studentID, age, gpa);

            System.out.println();
            System.out.println("Which group is this new student going to?");
            System.out.println("Enter the Group ID here:");

            //Actually add student to group
            String groupID = InputHandler.handleStringInput();
            GroupList.AddStudentToGroup(groupID, student);

            System.out.println();
            System.out.println("Make another one? (y/n)");
            System.out.println("=========================================");

            String answerStr = InputHandler.handleYesNoInput();
            if(answerStr.equals("n")) {
                inStudentMenu = false;
            }

        }

    }


}
