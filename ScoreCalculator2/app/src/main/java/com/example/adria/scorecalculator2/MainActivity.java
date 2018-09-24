package com.example.adria.scorecalculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mColorPoints = 0;
    private int mNearBallFeet = 0;
    private int mFarBallFeet = 0;
    private int mRobotHomeFeet = 0;
    private int mNearBallPoints = 0;
    private int mFarBallPoints = 0;
    private int mRobotHomePoints = 0;
    private int mDistancePoints = 0;
    private int mWBPoints = 0;
    private int mTotalPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView total_points_textView = findViewById(R.id.total_points_textView);
        final TextView color_points_textView = findViewById(R.id.color_points_textView);
        final TextView far_ball_editText = findViewById(R.id.far_ball_editText);


        final TextView near_bal_editText = findViewById(R.id.near_bal_editText);
        near_bal_editText.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }



            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            public void afterTextChanged(Editable s) {
                mNearBallFeet = Integer.parseInt(near_bal_editText.getText().toString());
                mNearBallPoints = 0;
                if (mNearBallFeet <= 5)
                    mNearBallPoints = 110;
                else if (mNearBallFeet <=10)
                    mNearBallPoints = 100;
                else if (mNearBallFeet <=20)
                    mNearBallPoints = 80;
                else if (mNearBallFeet <=30)
                    mNearBallPoints = 50;
                else if (mNearBallFeet <=45)
                    mNearBallPoints = 10;

                CalcTotalPoints();
                color_points_textView.setText(mDistancePoints + " Points");
                total_points_textView.setText(mTotalPoints + " Points");

            }
        });




        final SeekBar colour_ident_seekBar = (SeekBar) findViewById(R.id.colour_ident_seekBar);
        colour_ident_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress) {
                    case 0:
                        mColorPoints = 150;
                        break;
                    case 1:
                        mColorPoints = 75;
                        break;
                    case 2:
                        mColorPoints = 25;
                        break;
                    case 3:
                        mColorPoints = 0;
                        break;
                }
                CalcTotalPoints();
                color_points_textView.setText(mColorPoints + " Points");
                total_points_textView.setText(mTotalPoints + " Points");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void CalcTotalPoints() {
        mDistancePoints = mNearBallPoints + mFarBallPoints + mRobotHomePoints;
        mTotalPoints = mColorPoints + mDistancePoints + mWBPoints;
    }
    private void ConvertFeetToPoints(int feet)
    {

    }
}
