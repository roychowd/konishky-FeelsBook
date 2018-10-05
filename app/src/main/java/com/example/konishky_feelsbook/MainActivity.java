package com.example.konishky_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.FileNameMap;

public class MainActivity extends AppCompatActivity {

    private EmotionList mEmotionList = EmotionList.getInstance();
    private SaveListState stateChanger;

    public static final String EXTRA_MESSAGE = "com.example.konishky_feelsbook.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stateChanger = new SaveListState(this);
        stateChanger.loadFromFile();
    }

    public void startClickActivity(String mEmotionString) {

        Emotion newEmotion = new Emotion(mEmotionString);
        mEmotionList.addToEmotionList(newEmotion);
        stateChanger.saveInFile();
        Intent intent = new Intent(MainActivity.this, EmotionActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mEmotionString);
        startActivity(intent);
    }

    /**
     * the onClick function ditects which image the user clicked
     * @param view - parameter in which ImageView the user clicked
     * it will then direct them to start a newStartClickActivity - for pictures (shouldve used a better name lol)
     */

    public void onImageClick(View view) {

        switch (view.getId()) {
            case R.id.AngerPicture:
                startClickActivity(getString(R.string.Anger));
                break;
            case R.id.SadPicture:
                startClickActivity(getString(R.string.Sadness));
                break;
            case R.id.JoyPicture:
                startClickActivity(getString(R.string.Joy));
                break;
            case R.id.LovePicture:
                startClickActivity(getString(R.string.Love));
                break;
            case R.id.FearPicture:
                startClickActivity(getString(R.string.Fear));
                break;
            case R.id.SurprisedPicture:
                startClickActivity(getString(R.string.Surprised));
                break;
            default:
                break;
        }

    }

    public void onCountClick(View view) {
        Intent countIntent = new Intent(MainActivity.this, CountedLayout.class);
        startActivity(countIntent);
    }

    public void onHistoryClick(View view) {
        Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(historyIntent);

    }


}
