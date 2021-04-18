package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This class creates the voting system
 */
public class VotingSystem {
    private ArrayList<Voting> votingList;

    /**
     * This is the only constructor of the class.
     */
    public VotingSystem() {
        votingList = new ArrayList<>();
    }

    /**
     * Make a new poll.
     *
     * @param question This is a poll question.
     * @param type     This is a poll type.
     * @param choices  choice Add to poll.
     */
    public void createVoting(String question, int type, ArrayList<String> choices) {
        Voting voting = new Voting(type, question);
        for (String choice : choices) {
            voting.createChoice(choice);
        }
        votingList.add(voting);
    }

    /**
     * Prints polling questions.
     */
    public void printListOfVotings() {
        for (int i = 0; i < votingList.size(); i++) {
            System.out.println(i + 1 + ")" + votingList.get(i).getQuestion());
        }
    }

    /**
     * Prints questions and choices for a poll.
     *
     * @param number Number of voting.
     */
    public void printVoting(int number) {
        System.out.println(votingList.get(number).getQuestion());
        ArrayList<String> poll = votingList.get(number).getchoicesQuestion();
        for (String p : poll) {
            System.out.println(p);
        }
    }

    /**
     * Records the vote.
     *
     * @param number  Number of voting.
     * @param person  Someone who wants to vote.
     * @param choices Individual choices.
     */
    public void vote(int number, Person person, ArrayList<String> choices) {
        votingList.get(number).vote(person, choices);
    }

    /**
     * Return type of voting.
     *
     * @param number Number of voting.
     * @return type of voting.
     */
    public int getVotingType(int number) {
        return votingList.get(number).getType();
    }

    /**
     * Print the results
     *
     * @param number Number of voting.
     */
    public void printResult(int number) {
        votingList.get(number).printResult();

    }

    /**
     * Print the voters.
     *
     * @param number Number of voting.
     */
    public void printVoters(int number) {
        votingList.get(number).getVoters();
    }

    /**
     * Print the votes.
     *
     * @param number Number of voting.
     */
    public void printvotes(int number) {
        votingList.get(number).printVotes();
    }

    /**
     * Return choices question.
     *
     * @param number Number of voting.
     * @return Choices question.
     */
    public ArrayList<String> getChoicesQuestion(int number) {
        return votingList.get(number).getchoicesQuestion();
    }

    /**
     * Return choices.
     *
     * @param number Number of voting.
     * @return Choices.
     */
    public HashMap<String, HashSet<Vote>> getChoices(int number) {
        return votingList.get(number).getChoices();
    }
}
