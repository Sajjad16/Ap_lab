package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This class makes voting possible.
 */
public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters;
    private HashMap<String, HashSet<Vote>> choices;

    /**
     * Create poll.
     *
     * @param question This is a poll question.
     * @param type     This is a poll type.
     *                 If the typing is zero, each person can vote once.
     *                 If the typing is one, each person can vote twice.
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        voters = new ArrayList<>();
        choices = new HashMap<>();
    }

    /**
     * Return type.
     *
     * @return type.
     */
    public int getType() {
        return type;
    }

    /**
     * Return the pull question.
     *
     * @return The pull question.
     */

    public String getQuestion() {
        return question;
    }

    /**
     * Adds a choice to the poll.
     *
     * @param choice Add to poll.
     */

    void createChoice(String choice) {
        choices.put(choice, new HashSet<>());
    }

    /**
     * Records the vote.
     *
     * @param person  Someone who wants to vote.
     * @param choices Individual choices.
     */

    public void vote(Person person, ArrayList<String> choices) {
        if (!checkVoter(person)) {
            for (int i = 0; i < choices.size(); i++) {
                HashSet<Vote> hashSet = this.choices.get(choices.get(i));
                if (hashSet != null) {
                    hashSet.add(new Vote(person));
                    this.choices.put(choices.get(i), hashSet);
                }
                if (type == 0)
                    break;
            }
            voters.add(person);
        }
    }

    /**
     * Print voters
     */
    public void getVoters() {
        for (Person voter : voters) {
            System.out.println(voter.toString());
        }
    }

    /**
     * Print votes
     */
    public void printVotes() {
        ArrayList<String> choices = getchoicesQuestion();
        for (String choice : choices) {
            HashSet<Vote> votes = this.choices.get(choice);
            for (Vote vote : votes) {
                System.out.println(vote.toString());
            }
        }
    }

    /**
     * Return choices question.
     *
     * @return Choices question.
     */
    public ArrayList<String> getchoicesQuestion() {
        return new ArrayList<>(choices.keySet());
    }

    /**
     * Return choices
     *
     * @return Choices
     */
    public HashMap<String, HashSet<Vote>> getChoices() {
        return choices;
    }

    /**
     * Print the results
     */
    public void printResult() {
        for (String choice : choices.keySet()) {
            System.out.println(choice + "   " + "\t" + "Vote:" + choices.get(choice).size());
        }
    }

    private boolean checkVoter(Person person) {
        for (Person p : voters) {
            if (p.equals(person))
                return true;
        }
        return false;

    }
}

