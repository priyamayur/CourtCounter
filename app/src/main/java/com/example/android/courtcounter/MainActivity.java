package com.example.android.courtcounter;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.DecimalFormat;
/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;

    //Tracks the wicket for team A
    int wicketTeamA = 0;

    //Tracks Overs for Team A
    double overTeamA = 0.0;

    //Display for game over
    String message = "Game over";
    // Tracks the score for Team B
    int scoreTeamB = 0;

    //Tracks the wicket for team B
    int wicketTeamB = 0;

    //Tracks Overs for Team B
    double overTeamB = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            ScrollView scrollView = (ScrollView)findViewById(R.id.scrollview1);
            scrollView.setEnabled(false);}
        if(savedInstanceState != null){
            scoreTeamA=savedInstanceState.getInt("scoreTeamA");
            scoreTeamB=savedInstanceState.getInt("scoreTeamB");
            wicketTeamA=savedInstanceState.getInt("wicketTeamA");
            wicketTeamB=savedInstanceState.getInt("wicketTeamB");
            overTeamA=savedInstanceState.getDouble("overTeamA");
            overTeamB=savedInstanceState.getDouble("overTeamB");
            message=savedInstanceState.getString("message");


            ((TextView)findViewById(R.id.team_a_score)).setText(String.valueOf(scoreTeamA));
            ((TextView)findViewById(R.id.team_b_score)).setText(String.valueOf(scoreTeamB));
            ((TextView)findViewById(R.id.team_a_wicket)).setText(String.valueOf(wicketTeamA));
            ((TextView)findViewById(R.id.team_b_wicket)).setText(String.valueOf(wicketTeamB));
            TextView overView1 = (TextView) findViewById(R.id.team_a_over_number);
            overView1.setText(new DecimalFormat("##.#").format(overTeamA));
            TextView overView2 = (TextView) findViewById(R.id.team_b_over_number);
            overView2.setText(new DecimalFormat("##.#").format(overTeamA));

        }
    }
    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreTeamA", scoreTeamA);
        outState.putInt("wicketTeamA", wicketTeamA);
        outState.putDouble("overTeamA", overTeamA);
        outState.putString("message", message);
        outState.putInt("scoreTeamB", scoreTeamB);
        outState.putInt("wicketTeamB", wicketTeamB);
        outState.putDouble("overTeamB", overTeamB);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("scoreTeamA");
        wicketTeamA = savedInstanceState.getInt("wicketTeamA");
        overTeamA = savedInstanceState.getDouble("overTeamA");
        scoreTeamB = savedInstanceState.getInt("scoreTeamB");
        wicketTeamB = savedInstanceState.getInt("wicketTeamB");
        overTeamB = savedInstanceState.getDouble("overTeamB");
        message = savedInstanceState.getString("message");
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {

        scoreTeamA = scoreTeamA + 1;
        overTeamA = overTeamA + 0.1;
        displayForTeamA(scoreTeamA, overTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        overTeamA = overTeamA + 0.1;
        displayForTeamA(scoreTeamA, overTeamA);
    }

    /**
     * Increase the score for Team A by 4 points.
     */
    public void addFourForTeamA(View v) {
        scoreTeamA = scoreTeamA + 4;
        overTeamA = overTeamA + 0.1;
        displayForTeamA(scoreTeamA, overTeamA);

    }

    /**
     * Increase the score for Team A by 6 points.
     */
    public void addSixForTeamA(View v) {
        scoreTeamA = scoreTeamA + 6;
        overTeamA = overTeamA + 0.1;
        displayForTeamA(scoreTeamA, overTeamA);

    }

    /**
     * Increase Wicket for  Team A by 1.
     */
    public void addOutForTeamA(View v) {
        wicketTeamA = wicketTeamA + 1;
        if (wicketTeamA > 9)
            displayGameOverForTeamA(message);
        else
            displayWicketForTeamA(wicketTeamA);
    }

    /**
     * Increase a score and no extra ball wasted
     */
    public void addWideForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA, overTeamA);


    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score, double over) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
        if (over > 1.6)
            displayGameOverForTeamA(message);
        if (over == 0.7) {
            overTeamA = overTeamA + 0.3;
            over = overTeamA;
        }
        TextView overView = (TextView) findViewById(R.id.team_a_over_number);
        overView.setText(new DecimalFormat("##.#").format(over));


    }

    public void displayWicketForTeamA(int wicket) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_wicket);
        scoreView.setText(String.valueOf(wicket));


    }

    public void displayGameOverForTeamA(String message) {
        TextView gameView = (TextView) findViewById(R.id.team_a_game_over);
        gameView.setText(message);
        gameView.setTextColor(Color.RED);
        Button btn1 =(Button)findViewById(R.id.button1);
        btn1.setEnabled(false);
        Button btn2 =(Button)findViewById(R.id.button2);
        btn2.setEnabled(false);
        Button btn3 =(Button)findViewById(R.id.button3);
        btn3.setEnabled(false);
        Button btn4 =(Button)findViewById(R.id.button4);
        btn4.setEnabled(false);
        Button btn5 =(Button)findViewById(R.id.button5);
        btn5.setEnabled(false);
        Button btn6 =(Button)findViewById(R.id.button6);
        btn6.setEnabled(false);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        overTeamA = 0.0;
        wicketTeamA = 0;
        scoreTeamB = 0;
        overTeamB =0;
        wicketTeamB = 0;
        displayForTeamA(scoreTeamA, overTeamA);
        displayGameOverForTeamA("");
        displayForTeamB(scoreTeamB, overTeamB);
        displayGameOverForTeamB("");
        displayWicketForTeamA(wicketTeamA);
        displayWicketForTeamB(wicketTeamB);
        TextView resultView1 = (TextView) findViewById(R.id.team_a);
        resultView1.setTextColor(Color.BLACK);
        TextView resultView2 = (TextView) findViewById(R.id.team_b);
        resultView2.setTextColor(Color.BLACK);
        TextView resultView3 = (TextView) findViewById(R.id.showResult);
        resultView3.setText("");
        Button btn1 =(Button)findViewById(R.id.button1);
        btn1.setEnabled(true);
        Button btn2 =(Button)findViewById(R.id.button2);
        btn2.setEnabled(true);
        Button btn3 =(Button)findViewById(R.id.button3);
        btn3.setEnabled(true);
        Button btn4 =(Button)findViewById(R.id.button4);
        btn4.setEnabled(true);
        Button btn5 =(Button)findViewById(R.id.button5);
        btn5.setEnabled(true);
        Button btn6 =(Button)findViewById(R.id.button6);
        btn6.setEnabled(true);
        Button btn7 =(Button)findViewById(R.id.button7);
        btn7.setEnabled(true);
        Button btn8 =(Button)findViewById(R.id.button8);
        btn8.setEnabled(true);
        Button btn9 =(Button)findViewById(R.id.button9);
        btn9.setEnabled(true);
        Button btn10 =(Button)findViewById(R.id.button10);
        btn10.setEnabled(true);
        Button btn11 =(Button)findViewById(R.id.button11);
        btn11.setEnabled(true);
        Button btn12 =(Button)findViewById(R.id.button12);
        btn12.setEnabled(true);
    }

    /**
     * Increase the score for Team b by 1 point.
     */
    public void addOneForTeamB(View v) {

        scoreTeamB = scoreTeamB + 1;
        overTeamB = overTeamB + 0.1;
        displayForTeamB(scoreTeamB, overTeamB);
    }

    /**
     * Increase the score for Team b by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        overTeamB = overTeamB + 0.1;
        displayForTeamB(scoreTeamB, overTeamB);
    }

    /**
     * Increase the score for Team b by 4 points.
     */
    public void addfourForTeamB(View v) {
        scoreTeamB = scoreTeamB + 4;
        overTeamB = overTeamB + 0.1;
        displayForTeamB(scoreTeamB, overTeamB);

    }

    /**
     * Increase the score for Team b by 6 points.
     */
    public void addSixForTeamB(View v) {
        scoreTeamB = scoreTeamB + 6;
        overTeamB = overTeamB + 0.1;
        displayForTeamB(scoreTeamB, overTeamB);

    }

    /**
     * Increase Wicket for  Team B by 1.
     */
    public void addOutForTeamB(View v) {
        wicketTeamB = wicketTeamB + 1;
        if (wicketTeamB > 9)
            displayGameOverForTeamB(message);
        else
            displayWicketForTeamB(wicketTeamB);
    }

    /**
     * Increase a score and no extra ball wasted
     */
    public void addWideForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB, overTeamB);


    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score, double over) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
        if (over > 1.6)
            displayGameOverForTeamB(message);
        if (over == 0.7) {
            overTeamB = overTeamB + 0.3;
            over = overTeamB;
        }
        TextView overView = (TextView) findViewById(R.id.team_b_over_number);
        overView.setText(new DecimalFormat("##.#").format(over));


    }

    public void displayWicketForTeamB(int wicket) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_wicket);
        scoreView.setText(String.valueOf(wicket));


    }

    public void displayGameOverForTeamB(String message) {
        TextView gameView = (TextView) findViewById(R.id.team_b_game_over);
        gameView.setText(message);
        gameView.setTextColor(Color.RED);
        Button btn1 =(Button)findViewById(R.id.button7);
        btn1.setEnabled(false);
        Button btn2 =(Button)findViewById(R.id.button8);
        btn2.setEnabled(false);
        Button btn3 =(Button)findViewById(R.id.button9);
        btn3.setEnabled(false);
        Button btn4 =(Button)findViewById(R.id.button10);
        btn4.setEnabled(false);
        Button btn5 =(Button)findViewById(R.id.button11);
        btn5.setEnabled(false);
        Button btn6 =(Button)findViewById(R.id.button12);
        btn6.setEnabled(false);
    }
    public void displayResult(View v)
    {
        if (scoreTeamA > scoreTeamB) {
            TextView resultView = (TextView) findViewById(R.id.showResult);
            resultView.setText(R.string.winA);

            resultView.setTextColor(Color.parseColor("#4A148C"));
            TextView resultView2 = (TextView) findViewById(R.id.team_a);
            resultView2.setTextColor(Color.parseColor("#4A148C"));


        }
        else if (scoreTeamB > scoreTeamA) {
            TextView resultView = (TextView) findViewById(R.id.showResult);
            resultView.setText(R.string.winB);
            resultView.setTextColor(Color.parseColor("#4A148C"));
            TextView resultView2 = (TextView) findViewById(R.id.team_b);
            resultView2.setTextColor(Color.parseColor("#4A148C"));
        }
        else
        {
            TextView resultView = (TextView) findViewById(R.id.showResult);
            resultView.setText(R.string.tie);
            resultView.setTextColor(Color.parseColor("#4A148C"));
            TextView resultView2 = (TextView) findViewById(R.id.team_a);
            resultView2.setTextColor(Color.parseColor("#4A148C"));
            TextView resultView3 = (TextView) findViewById(R.id.team_b);
            resultView3.setTextColor(Color.parseColor("#4A148C"));

        }
    }
}