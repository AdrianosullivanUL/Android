package com.example.adria.scorecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    private TextView total_points_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView total_points_textview = findViewById(R.id.total_points_textview);

        final Button three_fixes_button = findViewById(R.id.three_fixes_button);
        three_fixes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorPoints = 0;
                RecalcTotalPoints();
            }
        });

        final Button two_fixes_button = findViewById(R.id.two_fixes_button);
        two_fixes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorPoints = 25;
                RecalcTotalPoints();
            }
        });
        final Button one_fixes_button = findViewById(R.id.one_fixes_button);
        one_fixes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorPoints = 75;
                RecalcTotalPoints();
            }
        });
        final Button zero_fixes_button = findViewById(R.id.zero_fixes_button);
        zero_fixes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorPoints = 150;
                RecalcTotalPoints();
            }
        });


    }
    private void RecalcTotalPoints()
    {
        mTotalPoints = mColorPoints + mFarBallPoints + mNearBallPoints + mRobotHomePoints + mWBPoints;

        total_points_textview.setText(mTotalPoints + " points");
    }

}
