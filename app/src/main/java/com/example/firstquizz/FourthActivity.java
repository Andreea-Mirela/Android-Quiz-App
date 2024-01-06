package com.example.firstquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    TextView textViewScor;
    Button btnInchide;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        textViewScor = findViewById(R.id.stanciu_andreea_fourth_tv_scor);
        btnInchide = findViewById(R.id.stanciu_andreea_fourth_btn);

        int nrRaspunsuriCorecte = getIntent().getIntExtra("raspunsuri_corecte", 0);

        textViewScor.setText(getString(R.string.scor).toString() + " " +nrRaspunsuriCorecte +" "+ getString(R.string.din_5).toString());

        btnInchide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}