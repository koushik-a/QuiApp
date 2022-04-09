package com.example.quizapp;

import android.content.Intent;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Button;
import android.os.Bundle;

// this is for rating activity
public class rating  extends MainActivity {
    RatingBar rt;
    Button s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);

        rt = (RatingBar) findViewById(R.id.ratingBar);// rating bar
        rt.setNumStars(5);// to set no of stars to display
        rt.setStepSize(1);// to set increment or step size to select stars
        rt.setRating(1); // set rating
        rt.setMax(5); // max stars
        s  = findViewById(R.id.sub);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(rating.this,MainActivity.class); // intent to go to main activity after reset is clicked
                startActivity(intent);
            }

        });
}
    }