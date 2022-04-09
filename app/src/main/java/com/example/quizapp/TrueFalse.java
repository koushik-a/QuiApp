package com.example.quizapp;

// this is true or false activity
public class TrueFalse {

    private int mQuestionsID;// question id
    private boolean mAnswer; // answer variable

    // Constructor
    public TrueFalse(int questionResourceID,boolean trueOrFalse){
        mQuestionsID=questionResourceID;
        mAnswer=trueOrFalse;
    }

    public int getQuestionsID() {
        return mQuestionsID;
    }

    public void setQuestionsID(int questionsID) {
        mQuestionsID = questionsID;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
