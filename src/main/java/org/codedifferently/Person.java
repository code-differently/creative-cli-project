package org.codedifferently;

// Base abstraction for every person record in the system.
// Shared identity/contact fields live here, while child classes define custom summaries.
public abstract class Person {
    // Unique identifier used for login/lookup.
    private int id;
    // Basic profile values shared by all roles.
    private String firstname;
    private String lastname;
    private String email;

    // Constructor initializes all shared Person data at object creation time.
    public Person(int id, String firstname, String lastname, String email){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;

    }
    // Setters allow future updates to profile data.
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // Getters expose read-only access to stored profile values.
    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    // Each subclass provides its own summary.
    public abstract String getSummary();
}
