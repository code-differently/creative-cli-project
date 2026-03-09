package org.codedifferently.cbtyson.menus;

import org.codedifferently.cbtyson.data.Group;
import org.codedifferently.cbtyson.data.GroupList;
import org.codedifferently.cbtyson.data.Student;
import org.codedifferently.cbtyson.helpers.InputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddGroupMenu {

    public void promptGroupMenu() {

        boolean inGroupMenu = true;

        while(inGroupMenu) {
            System.out.println("Enter your Group Name:");
            String name = InputHandler.handleStringInput();

         //   System.out.println("How big is your group? ");
         //   int groupSize = InputHandler.handleIntegerInput();

            // Generate a new UUID object
            String groupID = UUID.randomUUID().toString();
            groupID = groupID.substring(0,6);

            Group group = new Group(name, groupID, new ArrayList<Student>());

            System.out.println();

            //Add new Group to List
            GroupList.AddGroup(group);

            System.out.println("Continue adding groups? (y/n)");
            String answer = InputHandler.handleYesNoInput();
            if(answer.equals("n")) {
                inGroupMenu = false;
            }
        }
    }

    public void promptGroupMenu(Student student) {
        boolean inGroupMenu = true;
        boolean addedStudent = false;

        while(inGroupMenu) {
            System.out.println("Enter your new Group Name:");
            String name = InputHandler.handleStringInput();

            //System.out.println("How big is your group? ");
            //int groupSize = InputHandler.handleIntegerInput();

            // Generate a new UUID object
            String groupID = UUID.randomUUID().toString();
            groupID = groupID.substring(0,6);

            //add student to studentList here, only diff in overloaded method
            ArrayList<Student> studentList = new ArrayList<>();
            if(!addedStudent) studentList.add(student);
            addedStudent = true;

            Group group = new Group(name, groupID, studentList);

            System.out.println();

            //Add new Group to List
            GroupList.AddGroup(group);
            System.out.println("The " + group.getName() + " has been made! ID: " + group.getGroupID());

            System.out.println("Continue adding groups? (y/n)");
            System.out.println("===================================");
            String answer = InputHandler.handleYesNoInput();
            if(answer.equals("n")) {
                inGroupMenu = false;
            }
        }
    }
}
