package com.company;

import java.io.*;

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
//        Note note1 = new Note("Test1", "this is dummy content1", "1397/2/15");
//        saveNote(note1,"mynote");
        Note note = readNote("mynote");
        System.out.println(note);


    }

    /**
     * Save note in file.
     *
     * @param note     the note to be saved.
     * @param fileName the filename Which the note is stored.
     */
    public static void saveNote(Note note, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("d:\\files\\" + fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(note);

        } catch (IOException e) {
            e.printStackTrace(System.err);

        }
    }

    /**
     * Read a note in file.
     *
     * @param fileName The filename from which the note is read.
     * @return the note in file.
     */
    public static Note readNote(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream("d:\\files\\" + fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Note note = (Note) objectInputStream.readObject();
            return note;
        } catch (IOException e) {
            e.printStackTrace(System.err);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
