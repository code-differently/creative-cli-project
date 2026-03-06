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
        for (Group group : groups) {
            if(group.getGroupID().equals(groupID)) {
                group.getStudentList().add(student);
            }
        }
    }

    public static void RemoveStudentFromGroup(String groupID, Student student) {
        for (Group group : groups) {
            if(group.getGroupID().equals(groupID)) {
                group.getStudentList().remove(student);
            }
        }
    }
}
