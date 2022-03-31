package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // TODO: Declare member variable

    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionTextView;
    TextView pbar;


    int mIndex;  //This is tracking which question the user is on
    int mQuestion;
    int mScore;
    int pr=2;

    private TrueFalse[] mQuestionBank= new TrueFalse[]{
            new TrueFalse(R.string.question_1,true),
            new TrueFalse(R.string.question_2,false),
            new TrueFalse(R.string.question_3,true),
            new TrueFalse(R.string.question_4,true),
            new TrueFalse(R.string.question_5,false),
            new TrueFalse(R.string.question_6,true),
            new TrueFalse(R.string.question_7,false),
            new TrueFalse(R.string.question_8,true),
            new TrueFalse(R.string.question_9,true),
            new TrueFalse(R.string.question_10,false)

    };

    //final int PROGRESS_BAR_INCREMENT= 100/ 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton  = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        pbar         = findViewById(R.id.textView);
        mQuestionTextView = findViewById(R.id.question_text_view);



        // TODO:  Store QuestionId
        mQuestion = mQuestionBank[mIndex].getQuestionsID();
        mQuestionTextView.setText(mQuestion);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(true);
                updateQuestion();
                if(pr<=10){
                pbar.setText(" Question "+ pr+ "out of 10");}
                pr = pr + 1;
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(false);
                updateQuestion();
                if(pr<=10){
                pbar.setText(" Question "+ pr+ " out of 10");}
                pr = pr + 1;

            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void updateQuestion(){
        mIndex = (mIndex+1)%mQuestionBank.length;



        if(mIndex == 0){
            //AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Quiz Completed ");
            alert.setCancelable(false);
            alert.setMessage("Your Score " + mScore + " Points !");
            alert.setPositiveButton("Reset Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    pr=2;
                    mQuestion=0;
                    mScore=0;
                    pbar.setText(" Question 1 out of 10");
                }
            });
            alert.show();
        }


        mQuestion = mQuestionBank[mIndex].getQuestionsID();
        mQuestionTextView.setText(mQuestion);


    }

    private void checkAnswer(boolean userSelection){
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.trues);
        final MediaPlayer mp1 = MediaPlayer.create(this,R.raw.falses);
        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();
        if (userSelection==correctAnswer){
           mScore = mScore + 1;
           mp.start();
        }
        else{
             mp1.start();
        }
    }
}
