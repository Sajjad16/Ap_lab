package com.company;


import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class enables read and write operations on the file.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class FileUtils {

    /**
     * Performs the write operation of a text file with a buffer.
     *
     * @param text     the text that is written in the text file.
     * @param fileName the name of the text file in which the text is written.
     */
    public static void writeBufferedTextFile(String text, String fileName) {
        try (FileWriter fileWriter = new FileWriter("d:\\files\\" + fileName + ".txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Performs the read operation of a text file with a buffer.
     *
     * @param fileName the name of the text file to be read.
     */
    public static void readBufferedTextFile(String fileName) {
        try (FileReader fileReader = new FileReader("d:\\files\\" + fileName + ".txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int count;
            char[] buffer = new char[4096];
            while (bufferedReader.ready()) {
                count = bufferedReader.read(buffer);
                System.out.println(new String(buffer, 0, count));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    /**
     * Performs the read operation of a file with a buffer.
     *
     * @param fileName the name of the file to be read.
     */
    public static void readBufferedFile(String fileName) {
        try (FileReader fileReader = new FileReader("d:\\files\\" + fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int count;
            char[] buffer = new char[4096];
            while (bufferedReader.ready()) {
                count = bufferedReader.read(buffer);
                System.out.println(new String(buffer, 0, count));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    /**
     * Performs the write operation of file.
     *
     * @param text     the text that is written file.
     * @param fileName the name of the file to be read.
     */
    public static void writeBinaryFile(String text, String fileName) {
        try (FileOutputStream binaryFile = new FileOutputStream("d:\\files\\" + fileName + ".bin")) {
            byte[] array = text.getBytes(StandardCharsets.UTF_8);
            for (byte a : array) {
                binaryFile.write(a);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Performs the read operation of a binary file.
     *
     * @param fileName the name of the binary file in which the text is written.
     */
    public static void readBinaryFile(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream("d:\\files\\" + fileName + ".bin")) {
            int input;
            StringBuilder text = new StringBuilder();
            while (-1 != (input = fileInputStream.read())) {
                text.append((char) input);
            }
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Delete a file.
     *
     * @param fileName the name of the file to be delete.
     */
    public static void deleteFile(String fileName) {
        try {
            Path path = Paths.get("d:\\files\\" + fileName);
            Files.delete(path);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Show the all file in directory.
     */
    public static void showFilesInDirectory() {
        try {
            Path path = Paths.get("d:\\files");
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            int counter = 1;
            for (Path p : directoryStream) {
                System.out.println(counter + ")" + p.getFileName());
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Show the text of the file in the directory.
     *
     * @param index index of file to be shown.
     */
    public static void showTextOfFileInDirectory(int index) {
        try {
            readBufferedFile(findFile(index));

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Find file in directory.
     *
     * @param index index of file in directory.
     * @return the string of file name in directory.
     */
    public static String findFile(int index) {
        try {
            Path path = Paths.get("d:\\files");
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            Iterator<Path> it = directoryStream.iterator();
            for (int i = 0; i < index; i++) {
                it.next();
            }
            Path p = it.next();
            return p.getFileName().toString();

        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    /**
     * Show the summary of all notes.
     */
    public static void showSummaryOfNotes() {
        try {
            Path path = Paths.get("d:\\files");
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            for (Path p : directoryStream) {
                showSummaryOfNote(p.getFileName().toString());
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Show the summary of one note.
     */
    public static void showSummaryOfNote(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream("d:\\files\\" + fileName);
             Scanner scanner = new Scanner(fileInputStream)) {
            System.out.println(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }


}
