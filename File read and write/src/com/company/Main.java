package com.company;

import java.util.Scanner;

/**
 * The type Main.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    1.Save new notes
                    2.See a summary of the notes
                    3.Select a note and see its text
                    4.Delete note
                    5.Exit""");
            Scanner scanner = new Scanner(System.in);
            int inputValue = scanner.nextInt();
            String text;
            String filename;
            if (inputValue == 1) {
                System.out.println("1.Sava note in text file\n2.Sava note in binary file");
                inputValue = scanner.nextInt();
                System.out.println("Enter the text");
                scanner.nextLine();
                text = scanner.nextLine();
                System.out.println("Enter the file name");
                filename = scanner.next();

                if (inputValue == 1) {
                    FileUtils.writeBufferedTextFile(text, filename);
                } else if (inputValue == 2) {
                    FileUtils.writeBinaryFile(text, filename);
                }

            } else if (inputValue == 2) {
                FileUtils.showSummaryOfNotes();
            } else if (inputValue == 3) {
                System.out.println("Enter the number of note");
                FileUtils.showFilesInDirectory();
                FileUtils.showTextOfFileInDirectory(scanner.nextInt() - 1);
            } else if (inputValue == 4) {
                System.out.println("Enter the number of note");
                FileUtils.showFilesInDirectory();
                FileUtils.deleteFile(FileUtils.findFile(scanner.nextInt() - 1));
            } else if (inputValue == 5) {
                return;
            }
        }
    }
}
