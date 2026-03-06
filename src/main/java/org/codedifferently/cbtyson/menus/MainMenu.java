package org.codedifferently.cbtyson.menus;

import org.codedifferently.cbtyson.data.Group;
import org.codedifferently.cbtyson.data.GroupList;
import org.codedifferently.cbtyson.data.Student;
import org.codedifferently.cbtyson.helpers.InputHandler;

import java.util.ArrayList;

public class MainMenu {

    public void promptMainMenu() {
        //Group-Differently
        //Structured Group Maker

        //generate default students
        generateDefaultStudents();

        //Menus
        AddGroupMenu addGroupMenu = new AddGroupMenu();
        AddStudentMenu addStudentMenu = new AddStudentMenu();

        //main loop for program
        boolean inMainMenu = true;
        while(inMainMenu) {
            System.out.println("=============================================================");
            System.out.println();
            System.out.println("Welcome to Group Differently!");
            System.out.println("Please take a moment to assign a new group, or add new students!");
            System.out.println();
            System.out.println("=============================================================");

            System.out.println("1. Add new Student");
            System.out.println("2. Generate Group");
            System.out.println("3. View Students/Groups");
            System.out.println("4. Remove Students from Group");
            System.out.println("5. Exit");

            int inputCode = InputHandler.handleIntegerInput();

            switch(inputCode) {
                case 1:
                    addStudentMenu.promptAddStudentMenu();
                    break;
                case 2:
                    addGroupMenu.promptGroupMenu();
                    break;
                case 3:
                    ViewMenu viewMenu = new ViewMenu();
                    viewMenu.viewGroups();
                    break;
                case 4:
                    RemoveMenu removeMenu = new RemoveMenu();
                    removeMenu.removeStudentFromGroup();
                    break;
                case 5:
                    System.out.println("Have a Nice Day!");
                    inMainMenu = false;
                    break;
            }
        }
    }

    //generates students, and adds them to a group. then adds them into the static groupList field.
    void generateDefaultStudents() {
        //Make new students
        Student glenn = new Student("Glenn", "Tyson", "mrtyson@gmail.com", "31d13d31", 29, "3.6");
        Student chris = new Student("Chris", "Bennett", "cbswag@gmail.com", "1920vfvw", 30, "2.0");
        Student alex = new Student("Alex", "Trunzo", "vanyllagodzylla@gmail.com", "120-1f1f", 22, "4.0");
        Student bobby = new Student("Bobby", "Money", "bigmoney@gmail.com", "19911-wfwefwe", 25, "3.56");

        //List of students added to arrayList
        ArrayList<Student> students1 = new ArrayList<>();
        students1.add(glenn);
        students1.add(chris);
        students1.add(alex);
        students1.add(bobby);

        Group group = new Group("Vanylla Godzylla Band", "90121jofrv", 4, students1);

        //Add group
        GroupList.AddGroup(group);
    }
}
