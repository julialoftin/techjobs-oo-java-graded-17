package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer {

    // Declares/instantiates private fields
    private int id;
    private static int nextId = 1;
    private String value;

    // Constructor with no parameters that assigns an ID and increments nextID after
    public Employer() {
        id = nextId;
        nextId++;
    }

    // Constructor that calls above constructor, then assigns the passed in String value to this.value
    public Employer(String value) {
        this();
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:

    // Custom toString method returns value assigned in overloaded constructor
    // Usage is print job.getEmployer
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return getId() == employer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
