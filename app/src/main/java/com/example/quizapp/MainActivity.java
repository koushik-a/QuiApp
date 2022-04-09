package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // TODO: Declare member variable

    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionTextView;
    TextView pbar;


    int mIndex;  //This is to track which question the user is on
    int mQuestion; // question variable
    int mScore;//This is to track the score user
    int pr=2;// index to show question number


    // question bank boolean array
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

        // action to do when true button is clicked
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(true);
                updateQuestion(); // updates to next question
                if(pr<=10){
                pbar.setText(" Question "+ pr+ " out of 10");}
                pr = pr + 1;
            }
        });

        // action to do when false button is clicked
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
            altb();//  this is to display alert dialogue after last question
        }

        mQuestion = mQuestionBank[mIndex].getQuestionsID();
        mQuestionTextView.setText(mQuestion);

    }

   // this is a method which has the content to display the alert dialogue message after quiz is done
   public void altb(){
       //AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());

       AlertDialog.Builder alert = new AlertDialog.Builder(this);
       alert.setTitle("Quiz Completed ");
       alert.setCancelable(false);// cannot cancel alert
       alert.setMessage("Your Score " + mScore + " Points !");

       alert.setPositiveButton("Rate Quiz", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               pr=2;
               mQuestion=0;
               mScore=0;
               pbar.setText("  Question 1 out of 10");
               Intent intent=new Intent(MainActivity.this,rating.class);  // intent to goto rating screen
               startActivity(intent);
           }
       });
       alert.create();
       alert.show();

   }

    // this method is to check the answer when user chooses option
    private void checkAnswer(boolean userSelection){
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.trues);// sound for true button
        final MediaPlayer mp1 = MediaPlayer.create(this,R.raw.falses);// sound for false button
        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();
        if (userSelection==correctAnswer){
           mScore = mScore + 1;
           mp.start();
            Toast.makeText(getApplicationContext(),"Correct Answer: True",Toast.LENGTH_SHORT).show();// message to show selected option
        }
        else{
             mp1.start();
            Toast.makeText(getApplicationContext(),"Correct Answer: False",Toast.LENGTH_SHORT).show();// message to show selected option

        }
    }


}
