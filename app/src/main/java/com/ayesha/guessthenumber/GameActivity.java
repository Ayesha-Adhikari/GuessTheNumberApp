package com.ayesha.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    static int steps = 0;
    ArrayList<Integer> hints = new ArrayList<Integer>();
    private TextView question;
    private EditText answer;
    private Button guess;
    Random rn = new Random();
    int num = rn.nextInt(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        question = findViewById(R.id.question);
        answer = findViewById(R.id.answer);
        guess = findViewById(R.id.guessBtn);

        String player_name = getIntent().getStringExtra("name");

        question.setText("Hi " + player_name + " Let's start!");
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                playGame();
            }
        }, 3000);
    }

    public void playGame() {

        if (num < 50)
            question.setText("Make a guess! \nIt's a number between 0 and 50");
        else
            question.setText("Make a guess! \nIt's a number between 50 and 100");
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                getHint(-1);
            }
        }, 3000);

    }

    public void guess(View view) {
        int user_ans = Integer.parseInt(answer.getText().toString());
        steps++;
        if( steps == 5) {
            question.setText("Correct answer: "+num);
            failed();
            System.exit(0);
        }
        if (user_ans == num) {
            Toast.makeText(this, "Congratulations! You guessed it right.", Toast.LENGTH_SHORT).show();
            success();
        } else {
            Toast.makeText(this, "Bad luck! Try again!", Toast.LENGTH_SHORT).show();
            getHint(user_ans);
        }
    }

    public void success() {
        successDialog sd = new successDialog();
        sd.show(getSupportFragmentManager(), "correct guess!");
    }

    public void failed()
    {
        failDialog fd = new failDialog();
        fd.show(getSupportFragmentManager(), "No more guesses left!");
    }
    
    public void getHint(int user_ans)
    {
        int hint = rn.nextInt(6);
        if( user_ans == -1)
            hint = 0;
        if( hints.contains(hint))
            hint = 1;
        else
            hints.add(hint);
        switch (hint) {
            case 0:
                int dig = num % 10;
                question.setText(" Its unit digit is: " + dig);
                break;


            case 1:
                if (user_ans > num)
                    question.setText("Go Down!!");
                else
                    question.setText("Think Higher! ");
                break;

            case 2:
                if (num % 2 == 0)
                    question.setText(" Its a multiple of 2");
                else
                    question.setText(" Its an Odd Number");
                break;
            case 3:
                if (Math.abs(user_ans - num) <= 2)
                    question.setText(" You are 2 steps away!");
                else
                    question.setText("You are "+Math.abs(user_ans-num)+" steps away!");
                break;
            case 4:
                if (Math.abs(user_ans - num) <= 5)
                    question.setText(" Hint: Take 5 steps!");
                else
                    question.setText("Guess Again!!");
                break;
            case 5:
                int sum = 0;
                int temp = num;
                while( temp != 0)
                {
                    sum += temp % 10;
                    temp /= 10;
                }
                question.setText("Sum of the digits of the number = "+sum);
                break;

            default: question.setText(" You already tried "+steps+" times!");
                break;

        }
    }
}