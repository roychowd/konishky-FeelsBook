package com.example.konishky_feelsbook;


import android.annotation.SuppressLint;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// An emotion should only hold the name of the feeling, the date, and the optional comment
public class Emotion implements Serializable {


    /**  member variables representing the name of the emotion
     *   and the number of times it gets clicked
     */
    private String name;
    private String comment;
    private String date;

    Emotion(String name) {
        this.name = name;
        this.date = getCurrentDate();
        this.date = getCurrentDate();
    }

    /**
     * Gets the emotion of the sport.
     *
     * @return The name of the emotion.
     */
    String getName() {
        return name;
    }


    /**
     * the following sets a comment String field - it is optional!
     * @param comment - a String
     */

    void setComment(String comment) {
        this.comment = comment;

    }

    /**
     * the function below retrieves the comment stored!
     * @return comment
     */

    String getComment() {
        if (comment == null) {
            return "";
        }
        return comment;
    }


    /**
     * Sets the date that the emotion was created
     * @param date - a string representing the ISO8901 standard
     */

    void setDate(String date) {
        this.date = date;
    }

    String getDate() {
        return date;
    }

    private String getCurrentDate() {
        Date date = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat ISO8601Date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String text = ISO8601Date.format(date);
        return text;

    }




}



