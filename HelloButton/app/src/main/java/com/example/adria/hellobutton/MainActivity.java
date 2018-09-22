package com.example.adria.hellobutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mMessageTextView;
    private int mCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageTextView = findViewById(R.id.message_textview);
        //mMessageTextView.setText("Changed name");
        //Log.d("HB","This is a log cat log.");

        final Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter = 0;
                updateView();
            }
        });
    }
    public void handleDecrement (View view)
    {
        mCounter--;
        updateView();
    }
    public void handleIncrement (View view)
    {
        mCounter++;
        updateView();
    }
    private void updateView()
    {
        if (mCounter > 10)
            mMessageTextView.setVisibility(View.INVISIBLE);
        else
            mMessageTextView.setVisibility(View.VISIBLE);

        mMessageTextView.setText((getString(R.string.message_format, mCounter)));
    }
}
