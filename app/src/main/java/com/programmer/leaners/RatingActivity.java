package com.programmer.leaners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import static com.programmer.leaners.R.id.ratingBar;
//import android.widget.RatingBar;


public class RatingActivity extends AppCompatActivity {
    Button button;
    RatingBar ratingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        ratingbar=(RatingBar)findViewById(R.id.ratingBar);
        button=(Button) findViewById(R.id.submit);

        //performing action on button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the rating and display it on a toast message
                String rating=String.valueOf(ratingbar.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }
        });
    }
}
