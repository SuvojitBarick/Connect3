package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //0:yellow, 1:red , 2: empty
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winingPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer = 0 ;
    boolean gameActive = true;
    public void dropIn(View view)
    {
        ImageView counter = (ImageView) view;
        Log.i("Tag", counter.getTag().toString());
        int tappedcounter =Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedcounter]==2 && gameActive) {
            gameState[tappedcounter] = activePlayer;
            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {

                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).setDuration(300);
            for (int[] winingPosition : winingPositions) {
                if (gameState[winingPosition[0]] == gameState[winingPosition[1]] && gameState[winingPosition[1]] == gameState[winingPosition[2]] && gameState[winingPosition[0]] != 2) {
                    //Someone has won
                    gameActive = false;
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }
                    Toast.makeText(this, winner + " has won!", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}