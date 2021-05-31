package com.company;

import java.util.HashMap;
import java.util.HashSet;

/**
 * This class shows the voting results
 */
public class Result {
    private HashMap<String, HashSet<Vote>> choices;

    /**
     * This is the only constructor of the class.
     *
     * @param choices Individual choices.
     */
    public Result(HashMap<String, HashSet<Vote>> choices) {
        this.choices = choices;
    }

    /**
     * Show result of the voting.
     */
    public void showResult() {
        int numberOfVotes = calculateNumberOfVotes();
        int[] arrayOfNumber = new int[choices.size()];
        String[] arrayString = choices.keySet().toArray(new String[0]);
        for (int i = 0; i < choices.size(); i++) {
            arrayOfNumber[i] = choices.get(arrayString[i]).size();
        }
        sort(arrayOfNumber, arrayString);
        for (int i = 0; i < choices.size(); i++) {
            System.out.println(arrayString[i] + "   " + "\t" + "Vote:" + ((float) arrayOfNumber[i] / numberOfVotes * 100) + "%");
        }
    }

    private void sort(int[] arrayOfNumber, String[] arrayString) {
        for (int i = 0; i < arrayOfNumber.length; i++) {
            for (int j = i + 1; j < arrayOfNumber.length; j++) {
                if (arrayOfNumber[i] <= arrayOfNumber[j]) {
                    int tempValue = arrayOfNumber[i];
                    String tempString = arrayString[i];
                    arrayOfNumber[i] = arrayOfNumber[j];
                    arrayString[i] = arrayString[j];
                    arrayOfNumber[j] = tempValue;
                    arrayString[j] = tempString;
                }
            }
        }
    }

    private int calculateNumberOfVotes() {
        int numberOfVotes = 0;
        for (String choice : choices.keySet()) {
            numberOfVotes += choices.get(choice).size();
        }
        return numberOfVotes;
    }
}
