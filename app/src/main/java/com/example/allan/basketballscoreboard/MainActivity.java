package com.example.allan.basketballscoreboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView teamA;
    TextView teamB;
    TextView scoreA;
    TextView scoreB;
    TextView scoreAText;
    TextView scoreBText;
    TextView foulAText;
    TextView foulBText;
    TextView foulACount;
    TextView foulBCount;
    Button threeAPointer;
    Button threeBPointer;
    Button twoAPointer;
    Button twoBPointer;
    Button freeThrowA;
    Button freeThrowB;
    Button foulA;
    Button foulB;
    Button reset;
    int scoreAInt;
    int scoreBInt;
    int foulAInt;
    int foulBInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamA = (TextView) findViewById(R.id.teamA);
        teamB = (TextView) findViewById(R.id.teamB);
        scoreA = (TextView) findViewById(R.id.scoreA);
        scoreB = (TextView) findViewById(R.id.scoreB);
        scoreAText = (TextView) findViewById(R.id.scoreAText);
        scoreBText = (TextView) findViewById(R.id.scoreBText);
        foulAText = (TextView) findViewById(R.id.foulAText);
        foulBText = (TextView) findViewById(R.id.foulBText);
        foulACount = (TextView) findViewById(R.id.foulACount);
        foulBCount = (TextView) findViewById(R.id.foulBCount);
        threeAPointer = (Button) findViewById(R.id.threeAPointer);
        threeBPointer = (Button) findViewById(R.id.threeBPointer);
        twoAPointer = (Button) findViewById(R.id.twoAPointer);
        twoBPointer = (Button) findViewById(R.id.twoBPointer);
        freeThrowA = (Button) findViewById(R.id.freeThrowA);
        freeThrowB = (Button) findViewById(R.id.freeThrowB);
        foulA = (Button) findViewById(R.id.foulA);
        foulB = (Button) findViewById(R.id.foulB);
        reset = (Button) findViewById(R.id.reset);
        scoreAInt = 0;
        scoreBInt = 0;
        foulAInt = 0;
        foulBInt = 0;

        threeAPointer.setOnClickListener(clickListener);
        twoAPointer.setOnClickListener(clickListener);
        freeThrowA.setOnClickListener(clickListener);
        foulA.setOnClickListener(clickListener);
        threeBPointer.setOnClickListener(clickListener);
        twoBPointer.setOnClickListener(clickListener);
        freeThrowB.setOnClickListener(clickListener);
        foulB.setOnClickListener(clickListener);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreAInt = 0;
                scoreBInt = 0;
                foulAInt = 0;
                foulBInt = 0;
                scoreA.setText("0");
                scoreB.setText("0");
                foulACount.setText("0");
                foulBCount.setText("0");
                threeAPointer.setEnabled(true);
                threeBPointer.setEnabled(true);
                twoAPointer.setEnabled(true);
                twoBPointer.setEnabled(true);
                freeThrowA.setEnabled(true);
                freeThrowB.setEnabled(true);
                foulA.setEnabled(true);
                foulB.setEnabled(true);
            }
        });



    }

//Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putInt("SCORE_A_INT", scoreAInt);
        savedInstanceState.putInt("SCORE_B_INT", scoreBInt);
        savedInstanceState.putInt("FOUL_A_INT", foulAInt);
        savedInstanceState.putInt("FOUL_B_INT", foulBInt);

        // etc.

        super.onSaveInstanceState(savedInstanceState);
    }

//onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        scoreAInt = savedInstanceState.getInt("SCORE_A_INT");
        scoreBInt = savedInstanceState.getInt("SCORE_B_INT");
        foulAInt = savedInstanceState.getInt("FOUL_A_INT");
        foulBInt = savedInstanceState.getInt("FOUL_B_INT");

        scoreA.setText(String.valueOf(scoreAInt));
        scoreB.setText(String.valueOf(scoreBInt));
        foulACount.setText(String.valueOf(foulAInt));
        foulBCount.setText(String.valueOf(foulBInt));
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.threeAPointer:
                    scoreAInt += 3;
                    break;
                case R.id.twoAPointer:
                    scoreAInt += 2;
                    break;
                case R.id.freeThrowA:
                    scoreAInt++;
                    break;
                case R.id.foulA:
                    foulAInt++;
                    break;
                case R.id.threeBPointer:
                    scoreBInt += 3;
                    break;
                case R.id.twoBPointer:
                    scoreBInt += 2;
                    break;
                case R.id.freeThrowB:
                    scoreBInt++;
                    break;
                case R.id.foulB:
                    foulBInt++;
                    break;
            }

            if (foulAInt < 5) {
                scoreA.setText(String.valueOf(scoreAInt));
                foulACount.setText(String.valueOf(foulAInt));
            } else {
                foulACount.setText(R.string.disqualified);
                buttonsDisabled();
            }

            if (foulBInt < 5) {
                scoreB.setText(String.valueOf(scoreBInt));
                foulBCount.setText(String.valueOf(foulBInt));
            } else {
                foulBCount.setText(R.string.disqualified);
                buttonsDisabled();
            }
        }
    };

    private void buttonsDisabled() {
        threeAPointer.setEnabled(false);
        threeBPointer.setEnabled(false);
        twoAPointer.setEnabled(false);
        twoBPointer.setEnabled(false);
        freeThrowA.setEnabled(false);
        freeThrowB.setEnabled(false);
        foulA.setEnabled(false);
        foulB.setEnabled(false);
        Toast.makeText(MainActivity.this, "GAME OVER.", Toast.LENGTH_LONG).show();
    }
}
