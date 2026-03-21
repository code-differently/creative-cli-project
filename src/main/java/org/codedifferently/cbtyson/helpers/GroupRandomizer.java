package org.codedifferently.cbtyson.helpers;

import org.codedifferently.cbtyson.data.Group;
import org.codedifferently.cbtyson.data.GroupList;
import org.codedifferently.cbtyson.data.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class GroupRandomizer {
    public static void randomizeStudentsIntoGroups(ArrayList<Student> allStudents, int groupSize) {
        List<Group> groups = GroupList.GetGroups();

        if (groups.isEmpty()) {
            System.out.println("No groups exist. Please add groups first.");
            return;
        }
        if (allStudents == null || allStudents.isEmpty()) {
            System.out.println("No students to assign.");
            return;
        }

        // Clear existing students from all groups
        for (Group group : groups) {
            group.getStudentList().clear();
        }

        // Shuffle a copy of the student list
        ArrayList<Student> shuffled = new ArrayList<>(allStudents);
        Collections.shuffle(shuffled);

        // Determine how many groups we need based on desired group size
        int numGroupsNeeded = (int) Math.ceil((double) shuffled.size() / groupSize);

        if (numGroupsNeeded > groups.size()) {
            System.out.println("Warning: Not enough groups for group size of " + groupSize +
                    ". Need " + numGroupsNeeded + " but only have " + groups.size() +
                    ". Some groups will be larger than requested.");
        }

        // Assign students round-robin across available groups
        for (int i = 0; i < shuffled.size(); i++) {
            int groupIndex = i % groups.size();
            groups.get(groupIndex).getStudentList().add(shuffled.get(i));
        }

        System.out.println("Students assigned! Group breakdown:");
        for (Group g : groups) {
            System.out.println("  " + g.getName() + ": " + g.getStudentList().size() + " students");
        }
    }

    public static void randomizeStudentsIntoGroupsInteractive(ArrayList<Student> allStudents) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter desired group size: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }

        int groupSize = scanner.nextInt();

        if (groupSize <= 0) {
            System.out.println("Group size must be at least 1.");
            return;
        }

        randomizeStudentsIntoGroups(allStudents, groupSize);
    }

    public static void randomizeGroups() {
        ArrayList<Student> studentList = new ArrayList<>();

        for (Group group : GroupList.GetGroups()) {
            for(Student student : group.getStudentList()) {
                studentList.add(student);
            }
        }
        randomizeStudentsIntoGroupsInteractive(studentList);
    }
}
