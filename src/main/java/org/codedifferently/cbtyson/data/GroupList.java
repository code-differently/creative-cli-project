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

    public static boolean AddStudentToGroup(String groupID,Student student) {

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

        return groupFound;

    }

    public static boolean RemoveStudentFromGroup(String groupID, String studentID) {

        boolean groupFound = false;
        boolean studentFound = false;

        for (Group group : groups) {
            if(group.getGroupID().equals(groupID)) {
                groupFound = true;
                for(Student student : group.getStudentList()) {
                    if(student.getStudentID().equals(studentID)) {
                        studentFound = true;
                        group.getStudentList().remove(student);
                        return true;
                    }
                }

            }
        }

        if(!studentFound && groupFound) {
            System.out.println("Student ID not found!");
        }

        if(!groupFound) {
            System.out.println("Group ID not found!");
        }
        return false;
    }

    public static Student GetStudentFromGroup(String groupID, String studentID) {
        boolean groupFound = false;
        boolean studentFound = false;

        for (Group group : groups) {
            if(group.getGroupID().equals(groupID)) {
                groupFound = true;
                for(Student student : group.getStudentList()) {
                    if(student.getStudentID().equals(studentID)) {
                        studentFound = true;
                        return student;
                    }
                }

            }
        }

        if(!studentFound && groupFound) {
            System.out.println("Student ID not found!");
        }

        if(!groupFound) {
            System.out.println("Group ID not found!");
        }
        return null;
    }

    public static String GetGroupIDFromStudentID(String studentID) {
        for(Group group  : groups) {
            for(Student student : group.getStudentList()) {
                if(student.getStudentID().equals(studentID)) {
                    return group.getGroupID();
                }
            }
        }
        return null;
    }
}
