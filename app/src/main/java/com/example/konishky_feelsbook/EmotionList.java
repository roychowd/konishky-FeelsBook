package com.example.konishky_feelsbook;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;



// a singleton class

public class EmotionList{
    // an instance
    private static EmotionList instance;
    private static ArrayList<Emotion> emotionArray;
    private Context context;
    private final String FILENAME = "file.sav";

    // private constructor
    private EmotionList() {
        emotionArray = new ArrayList<Emotion>();
    }

    //access or create class instance
    public static EmotionList getInstance() {
        if (instance == null) {
            instance = new EmotionList();
        }

        return instance;
    }


    // retrieve list from anywhere
    public static ArrayList<Emotion> getEmotionList() {
        return emotionArray;
    }

    public static void setEmotionArray(ArrayList<Emotion> array) {
        emotionArray = array;

    }

    // add an emotion to our list
    public void addToEmotionList(Emotion emotion) {
        Emotion newEmotion = new Emotion(emotion.getName());
        emotionArray.add(newEmotion);
        sortArray();
    }


    public void EditEmotion(int index, Emotion e) {
        emotionArray.set(index, e);
    }

    // returns the size of the emotionlist
    public int getListCount() {
        return emotionArray.size();
    }


    // retrieves an emotion through index
    public Emotion grabElementByIndex(int index) {
        return emotionArray.get(index);
    }

    // deletes a particular emotion
    public void deleteEmotion(int index) {
        emotionArray.remove(index);
    }


    // sorts the emotionlist by date
    public void sortArray() {
        Collections.sort(emotionArray, new Comparator<Emotion>() {
            @Override
            public int compare(Emotion t1, Emotion t2) {
                return t2.getDate().compareTo(t1.getDate());
            }
        });
    }


}
