package com.ayesha.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private Button startBtn;
    public String player_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        startBtn = findViewById(R.id.startBtn);
    }

    public void start(View view)
    {
        player_name = name.getText().toString();
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("name", player_name);
        startActivity(intent);
        Toast.makeText(this, "Game Started", Toast.LENGTH_SHORT).show();
    }
}