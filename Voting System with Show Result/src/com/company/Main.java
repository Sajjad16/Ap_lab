package com.company;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void menu() {
        VotingSystem votingSystem = new VotingSystem();
        ArrayList<Person> persons = new ArrayList<>();
        while (true) {
            int inputValue;
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    1.New person
                    2.Create voting
                    3.Print voting list
                    4.Vote
                    5.Print result
                    6.Print voters
                    7.Print votes
                    8.Show result
                    9.Exit""");
            inputValue = scanner.nextInt();
            if (inputValue == 1) {
                System.out.println("Firstname:");
                String firstName = scanner.next();
                System.out.println("Lastname:");
                String lastName = scanner.next();
                persons.add(new Person(firstName, lastName));
                System.out.println("Person created");
            } else if (inputValue == 2) {
                System.out.println("Enter question:");
                scanner.nextLine();
                String question = scanner.nextLine();
                System.out.println("Enter type:");
                int type = scanner.nextInt();
                System.out.println("Enter person Choices");
                System.out.println("Finally Enter -1");
                ArrayList<String> personChoices = new ArrayList<>();
                String choice = scanner.next();
                while (!choice.equals("-1")) {
                    personChoices.add(choice);
                    choice = scanner.next();
                }
                votingSystem.createVoting(question, type, personChoices);
                System.out.println("Voting created");
            } else if (inputValue == 3) {
                votingSystem.printListOfVotings();
            } else if (inputValue == 4) {
                System.out.println("Enter number of person");
                for (int i = 0; i < persons.size(); i++) {
                    System.out.println(i + 1 + ")" + persons.get(i).toString());
                }
                int index = scanner.nextInt() - 1;
                System.out.println("Enter number of voting");
                votingSystem.printListOfVotings();
                int number = scanner.nextInt() - 1;
                ArrayList<String> personChoices = new ArrayList<>();
                ArrayList<String> choices = votingSystem.getChoicesQuestion(number);
                System.out.println("Choose:\n1.Manual voting\n2.Automatic voting");
                inputValue = scanner.nextInt();
                if (inputValue == 2) {
                    Random randomChoice = new Random();
                    personChoices.add(choices.get(randomChoice.nextInt(choices.size() - 1)));
                } else if (inputValue == 1) {
                    System.out.println("Enter your choice:");
                    System.out.println("Finally Enter -1");
                    votingSystem.printVoting(number);
                    String choice = scanner.next();
                    personChoices.add(choice);
                    int counter = 1;
                    while (!choice.equals("-1")) {
                        choice = scanner.next();
                        if (votingSystem.getVotingType(number) == 1 && counter < choices.size()) {
                            personChoices.add(choice);
                            counter++;
                        }
                    }
                }
                votingSystem.vote(number, persons.get(index), personChoices);
            } else if (inputValue == 5) {
                System.out.println("Enter number of voting:");
                votingSystem.printListOfVotings();
                int number = scanner.nextInt();
                votingSystem.printResult(number - 1);
            } else if (inputValue == 6) {
                System.out.println("Enter number of voting:");
                votingSystem.printListOfVotings();
                int number = scanner.nextInt();
                votingSystem.printVoters(number - 1);
            } else if (inputValue == 7) {
                System.out.println("Enter number of voting:");
                votingSystem.printListOfVotings();
                int number = scanner.nextInt();
                votingSystem.printvotes(number - 1);
            } else if (inputValue == 8) {
                System.out.println("Enter number of voting:");
                votingSystem.printListOfVotings();
                int number = scanner.nextInt() - 1;
                Result result = new Result(votingSystem.getChoices(number));
                result.showResult();
            } else if (inputValue == 9) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
