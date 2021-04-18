package com.company;

import java.util.Objects;

/**
 * This class shows the person
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Create a person.
     * This is the only constructor of the class.
     *
     * @param firstName This is a person's firstname.
     * @param lastName  This is a person's lastname.
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Return the person's firstname.
     *
     * @return The person's firstname.
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * Return the person's lastname.
     *
     * @return The person's lastame.
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName());
    }

}
