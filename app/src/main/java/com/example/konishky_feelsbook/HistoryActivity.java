package com.example.konishky_feelsbook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class HistoryActivity extends AppCompatActivity {


    public static final String EXTRA_IDX = "index";
    ListView historyListView;
    EmotionList mEmotionlist  = EmotionList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mEmotionlist.sortArray();
        final ArrayList<Emotion> mEmotionList = EmotionList.getEmotionList();

        // the following code just displays the recent entries in the listview

        // have to sort by date!
        String[] dateArray = new String[mEmotionList.size()];
        String[] nameArray = new String[mEmotionList.size()];
        for (int i = 0; i < mEmotionList.size(); i++) {
            String name = mEmotionList.get(i).getName();
            String date = mEmotionList.get(i).getDate();
            dateArray[i] = date;
            nameArray[i] = name;
        }

        HistoryAdapter adapter = new HistoryAdapter(this, nameArray, dateArray);
        historyListView = findViewById(R.id.historyListView);
        historyListView.setAdapter(adapter);

        // For the following code, I used these resources to learn how to handle onclick events on list items!
        // http://ezzylearning.com/tutorial/handling-android-listview-onitemclick-event
        // https://developer.android.com/reference/android/widget/AdapterView.OnItemClickListener

        historyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pos = String.valueOf(position);
                Intent emotionInfo = new Intent(HistoryActivity.this, EditEmotion.class);
                emotionInfo.putExtra(EXTRA_IDX, position);
                startActivity(emotionInfo);
            }
        });
    }

    public void onHomeClick(View view) {
        Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
