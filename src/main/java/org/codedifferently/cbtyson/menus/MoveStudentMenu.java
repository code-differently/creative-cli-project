package org.codedifferently.cbtyson.menus;

import org.codedifferently.cbtyson.data.Group;
import org.codedifferently.cbtyson.data.GroupList;
import org.codedifferently.cbtyson.data.Student;
import org.codedifferently.cbtyson.helpers.InputHandler;

public class MoveStudentMenu {

    public void moveGroups() {

        System.out.println("Enter Student ID to move:");
        System.out.println("=============================");

        String studentID = InputHandler.handleStringInput();

        System.out.println("Enter Group ID to move into:");
        String groupID = InputHandler.handleStringInput();


        //Get old GroupID that student used to be in
        String oldGroupID = GroupList.GetGroupIDFromStudentID(studentID);

        //Get reference to student to be moved.
        Student movedStudent = GroupList.GetStudentFromGroup(oldGroupID, studentID);

        //Remove them from old group
        boolean removeResult = GroupList.RemoveStudentFromGroup(oldGroupID, studentID);

        if(removeResult) {
            //Then add them to new group if remove was successful
            boolean result = GroupList.AddStudentToGroup(groupID, movedStudent);

            if(result) System.out.println("Moved Students successfully!");
        }
        else {
            System.out.println("Removing student from previous group has failed!!");
        }

    }

}
