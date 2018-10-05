package com.example.konishky_feelsbook;

import android.content.Context;
import android.util.Log;

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
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class SaveListState {
    private static final String FILENAME = "file.sav";
    private Context context;
    ArrayList<Emotion> emotionArray;

    SaveListState(Context context) {
        this.context = context;
    }



    public void loadFromFile() {

        try {

            FileInputStream fis = context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);
            Gson gson = new Gson();
            Type emotionListType = new TypeToken<ArrayList<Emotion>>(){}.getType();
            emotionArray = gson.fromJson(reader, emotionListType );
            EmotionList.setEmotionArray(emotionArray);
            fis.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            emotionArray =new ArrayList<Emotion>();
            EmotionList.setEmotionArray(emotionArray);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void saveInFile() {
        try {
            FileOutputStream fos =  context.openFileOutput(FILENAME, 0);
            OutputStreamWriter osw  = new OutputStreamWriter(fos);
            // open a file output string which is a byte string and when i created a ouput stream writere instance it becomes a writer stream
            // data will wrtie character b ycharacter = ineffiecnet
            //we need buffered writere
            BufferedWriter writer = new BufferedWriter(osw);
            Gson gson = new Gson();
            gson.toJson( EmotionList.getEmotionList(), writer);
            writer.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//		catch (TweetTooLongException e) {
//            e.printStackTrace();
//        }
    }
}
