package com.company;

import java.io.Serializable;

/**
 * This class shows notes.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Note implements Serializable {
    private String title;
    private String content;
    private String date;

    /**
     * Instantiates a new Note.
     *
     * @param title   the title.
     * @param content the content.
     * @param date    the date.
     */
    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return content;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Converts a note to a string.
     *
     * @return string of note.
     */
    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
