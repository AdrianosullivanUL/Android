package ie.ul.adrianosullivan.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TicTacToeGame mGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGame   = new TicTacToeGame(this);
    }
    public void pressedSquare (View view) {
        String tagAsString = view.getTag().toString();
        int tagAsInt = Integer.parseInt(tagAsString);
        //Log.d("TTT", "You pressed index " + tagAsInt);
        //Toast.makeText(this, "You pressed index " + tagAsInt, Toast.LENGTH_SHORT).show();
    }
    public void pressNewGame (View view)
    {
        Toast.makeText(this, "New Game",Toast.LENGTH_SHORT).show();
    }
}
