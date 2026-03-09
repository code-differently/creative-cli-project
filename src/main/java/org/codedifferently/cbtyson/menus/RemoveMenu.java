package org.codedifferently.cbtyson.menus;

import org.codedifferently.cbtyson.data.Group;
import org.codedifferently.cbtyson.data.GroupList;
import org.codedifferently.cbtyson.data.Student;
import org.codedifferently.cbtyson.helpers.InputHandler;

public class RemoveMenu {

    public void removeStudentFromGroup() {

        System.out.println("Enter Group ID:");
        String groupID = InputHandler.handleStringInput();

        System.out.println("Enter Student ID:");
        String studentID = InputHandler.handleStringInput();

        for (Group group : GroupList.GetGroups()) {

            if (group.getGroupID().equals(groupID)) {

                Student studentToRemove = null;

                for (Student student : group.getStudentList()) {
                    if (student.getStudentID().equals(studentID)) {
                        studentToRemove = student;
                        break;
                    }
                }

                if (studentToRemove != null) {
                    group.getStudentList().remove(studentToRemove);
                    System.out.println("Student removed successfully!");
                } else {
                    System.out.println("Student not found in this group.");
                }

                return;
            }
        }

        System.out.println("Group not found.");
    }
}