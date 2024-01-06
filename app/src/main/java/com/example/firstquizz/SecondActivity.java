package com.example.firstquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button buttonIncepator;
    private Button buttonExperimentat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonIncepator=findViewById(R.id.stanciu_andreea_second_b_incepator);
        buttonIncepator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
                intent.putExtra("cod",0);
                startActivity(intent);
            }
        });

        buttonExperimentat=findViewById(R.id.stanciu_andreea_second_b_avansat);
        buttonExperimentat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
                intent.putExtra("cod",1);
                startActivity(intent);
            }
        });
    }
}