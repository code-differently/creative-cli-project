package org.codedifferently.cbtyson.data;

import java.util.ArrayList;

public class Group {
    String name;
    String groupID;
    ArrayList<Student> studentList;


    public Group(String name, String groupID, ArrayList<Student> studentList) {
        this.name = name;
        this.groupID = groupID;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public String getGroupID() {
        return groupID;
    }
}
