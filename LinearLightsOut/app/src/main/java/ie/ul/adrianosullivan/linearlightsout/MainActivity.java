package ie.ul.adrianosullivan.linearlightsout;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LightsOutGame mGame;
    private int mButtonCount = 7;
    private String tagAsString;
    private int tagAsInt;
    private Button[] mButtons;
    private TextView headingTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtons = new Button[7];
        mButtons[0] = findViewById(R.id.button0);
        mButtons[1] = findViewById(R.id.button1);
        mButtons[2] = findViewById(R.id.button2);
        mButtons[3] = findViewById(R.id.button3);
        mButtons[4] = findViewById(R.id.button4);
        mButtons[5] = findViewById(R.id.button5);
        mButtons[6] = findViewById(R.id.button6);
        headingTextView = findViewById(R.id.headingTextView);
        //Log.d("TTT", "Loading new game " );
        mGame   = new LightsOutGame(mButtonCount);
        updateView();
    }
    public void pressedLight (View view) {
        tagAsString = view.getTag().toString();
        tagAsInt = Integer.parseInt(tagAsString);
        //Log.d("TTT", "You pressed index " + tagAsInt);
        //Toast.makeText(this, "You pressed index " + tagAsInt, Toast.LENGTH_SHORT).show();
        mGame.pressedButtonAtIndex(tagAsInt);
        updateView();
    }
    public void pressNewGame (View view)
    {
        //Toast.makeText(this, "New Game",Toast.LENGTH_SHORT).show();
        mGame   = new LightsOutGame(mButtonCount);
        updateView();
        for (int i=0;i <= mButtonCount-1;i++)
        {
            mButtons[i].setEnabled(true);
            mButtons[i].setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        }
        headingTextView.setText(R.string.make_buttons_match);
    }
    public void updateView()
    {
        for (int i=0;i <= mButtonCount-1;i++)
        {
            mButtons[i].setText(Integer.toString(mGame.getValueAtIndex(i)));
        }
        if (mGame.checkForWin() == true)
        {
            headingTextView.setText("You have won!");
            for (int i=0;i <= mButtonCount-1;i++)
            {
                mButtons[i].setEnabled(false);
                mButtons[i].setBackgroundColor(getResources().getColor(R.color.buttonBackgroundDisabled));
            }

        } else {
            if (mGame.getNumPresses() == 1)
                headingTextView.setText("You have taken " + mGame.getNumPresses() + " turn");
            else
                headingTextView.setText("You have taken " + mGame.getNumPresses() + " turns");
        }


    }
}
