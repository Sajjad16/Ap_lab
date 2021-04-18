package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.util.Objects;

/**
 * This class represents a vote
 */
public class Vote {
    private Person person;
    private String date;

    /**
     * Create a Vote.
     *
     * @param person This person is a voter.
     */
    public Vote(Person person) {
        this.person = person;
        this.date = new JalaliCalendar().toString();
    }

    /**
     * Create a Vote.
     *
     * @param person This person is a voter.
     * @param date   This is the voting date.
     */
    public Vote(Person person, String date) {
        this.person = person;
        this.date = date;
    }

    /**
     * Return the person is a voter.
     *
     * @return The person is a voter.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Return the voting date.
     *
     * @return The voting date
     */
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "person=" + person +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return Objects.equals(getPerson(), vote.getPerson()) && Objects.equals(getDate(), vote.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPerson(), getDate());
    }
}
