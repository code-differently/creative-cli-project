package org.codedifferently.cbtyson.data;

import java.util.ArrayList;
import java.util.List;

public class GroupList {

    static ArrayList<Group> groups = new ArrayList<>();

    public static List<Group> GetGroups() {
        return groups;
    }

    public static void AddGroup(Group group) {
        groups.add(group);
    }

    public static void AddStudentToGroup(String groupID,Student student) {

        boolean groupFound = false;

        for (Group group : groups) {
            if(group.getGroupID().equals(groupID)) {
                groupFound = true;
                group.getStudentList().add(student);
            }
        }

        if(!groupFound) {
            System.out.println("Group not found!");
        }

    }

    public static void RemoveStudentFromGroup(String groupID, Student student) {

        boolean groupFound = false;

        for (Group group : groups) {
            if(group.getGroupID().equals(groupID)) {
                groupFound = true;
                group.getStudentList().remove(student);
            }
        }

        if(!groupFound) {
            System.out.println("Group not found!");
        }
    }
}
