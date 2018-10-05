package com.example.konishky_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditEmotion extends AppCompatActivity {

    private int index;
    private EmotionList mEmotionList;
    private TextView mEmotionName;
    private EditText mDateField;
    private EditText mCommentField;
    private SaveListState stateChanger;



    // called ot edit the fields of data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_emotion);
        stateChanger = new SaveListState(this);
        mEmotionName = findViewById(R.id.emotionTextView_Edit);
        mDateField = findViewById(R.id.date_text_change);
        mCommentField = findViewById(R.id.edit_comment_EditText);
        Button deleteButton = findViewById(R.id.deleteButton);
        Button changeButton = findViewById(R.id.change_button);
        mEmotionList = EmotionList.getInstance();


        Intent intent = getIntent();
        index = intent.getIntExtra(HistoryActivity.EXTRA_IDX, 0);

        //grab emotion
        Emotion mEmotion = mEmotionList.grabElementByIndex(index);

        //initialize all fields with details of the emotion

        mEmotionName.setText(mEmotion.getName());
        mDateField.setText(mEmotion.getDate());
        mCommentField.setText(mEmotion.getComment());
    }


    // when user clicks change the it edits the info about that particular information
    public void onChangeClick(View view) {
        Emotion newEmotion = new Emotion(mEmotionName.getText().toString());
        newEmotion.setDate(mDateField.getText().toString());
        newEmotion.setComment(mCommentField.getText().toString());
        mEmotionList.EditEmotion(index, newEmotion);
        stateChanger.saveInFile();
        finish();
    }


    // calls a fucntion to delete the emotion from the arraylist
    public void onDeleteClick(View view) {
        mEmotionList.deleteEmotion(index);
        stateChanger.saveInFile();
        finish();
    }
}
