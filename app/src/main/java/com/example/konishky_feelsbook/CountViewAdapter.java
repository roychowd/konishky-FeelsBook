package com.example.konishky_feelsbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CountViewAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[] emotionName;
    private final Integer[] emotionCount;


    CountViewAdapter(Activity context, String[] nameParam, Integer[] countParam) {
        super(context,R.layout.listview_row, nameParam);
        this.context = context;
        this.emotionCount = countParam;
        this.emotionName = nameParam;

    }

    @NonNull
    public View getView(int pos, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.listview_row, null,true);
        TextView name = row.findViewById(R.id.EmotionTextView);
        TextView count = row.findViewById(R.id.countTextView);
        name.setText(emotionName[pos]);
        count.setText(String.valueOf(emotionCount[pos]));

        return row;
    }




}
