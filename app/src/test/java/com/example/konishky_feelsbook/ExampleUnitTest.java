package com.example.konishky_feelsbook;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private EmotionList emotearr = EmotionList.getInstance();


    @Test
    public void EmotionAdd() {
        Emotion emote = new Emotion("Test");

        Emotion emote2 = new Emotion("Test2");
        emotearr.addToEmotionList(emote);
        emotearr.addToEmotionList(emote2);
        emotearr.deleteEmotion(emote2);
        assertTrue("SIZEIS1",emotearr.getListCount() == 1 );

    }


    @Test
    public void Emotion1Add() {
        assertTrue("SIZE1", emotearr.getListCount()==1);

    }






}