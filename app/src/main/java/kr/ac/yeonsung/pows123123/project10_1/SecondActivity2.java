package kr.ac.yeonsung.pows123123.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class SecondActivity2 extends AppCompatActivity {
    RatingBar rating1 , rating2 , rating3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rating1 = findViewById(R.id.rating1);
        rating2 = findViewById(R.id.rating2);
        rating3 = findViewById(R.id.rating3);

        Button btnInt = findViewById(R.id.btn_inc);
        Button btnDec = findViewById(R.id.btn_dec);

        btnInt.setOnClickListener(btnListener);
        btnDec.setOnClickListener(btnListener);

    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_inc:
                    rating1.setRating(rating1.getRating() + rating1.getStepSize());
                    rating1.setRating(rating2.getRating() + rating2.getStepSize());
                    rating1.setRating(rating3.getRating() + rating3.getStepSize());
                    break;
                case R.id.btn_dec:
                    rating1.setRating(rating1.getRating() - rating1.getStepSize());
                    rating1.setRating(rating2.getRating() - rating2.getStepSize());
                    rating1.setRating(rating3.getRating() - rating3.getStepSize());
                    break;
            }
        }
    };
}