package com.example.adria.scorecalculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private int mWBPoints = 0;
    private int mTotalPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView total_points_textView = findViewById(R.id.total_points_textView);
        final TextView color_points_textView = findViewById(R.id.color_points_textView);

        final SeekBar birthdaySlider = (SeekBar) findViewById(R.id.colour_ident_seekBar);

        birthdaySlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
        mTotalPoints = mTotalPoints + mFarBallPoints + mNearBallPoints + mRobotHomePoints + mWBPoints;
    }
}
