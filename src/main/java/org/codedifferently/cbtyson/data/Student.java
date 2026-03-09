package org.codedifferently.cbtyson.data;

public class Student {

    public String firstName;
    public String lastName;
    public String email;
    public String studentID;
    public int age;
    public double gpa;


    public Student(String firstName, String lastName, String email, String studentID, int age, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentID = studentID;
        this.age = age;
        this.gpa = gpa;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public double getGpa() {
        return gpa;
    }

    public String getStudentID() {
        return studentID;
    }
}
