// Adapter class

package com.example.konishky_feelsbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class HistoryAdapter extends ArrayAdapter {
    private final Activity context;
    private String[] date;
    private String[] name;


    HistoryAdapter(Activity context, String[] nameArr, String[] dateArr) {
        super(context,R.layout.listview_row, nameArr);
        this.context = context;
        this.date = dateArr;
        this.name = nameArr ;

    }


    @NonNull
    public View getView(int pos, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"}) View row = inflater.inflate(R.layout.historyrow, null,true);
        TextView nameText = row.findViewById(R.id.EmotionName);
        TextView dateText = row.findViewById(R.id.DateAdded);
        nameText.setText(name[pos]);
        dateText.setText(date[pos]);

        return row;
    }




}
