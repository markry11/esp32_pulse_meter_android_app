package com.example.esp32_aplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    private TextView wiek;
    private TextView min_te;
    private TextView max_te;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        try {
            FileInputStream fileInputStream = openFileInput("dane.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

            wiek = findViewById(R.id.textViewWiek);
            String line = reader.readLine();
            wiek.setText(line);

            min_te = findViewById(R.id.textViewmin);
            double min_t = Double.parseDouble(line);
            min_t = (220-min_t)*0.6;
            min_te.setText(Double.toString(min_t));

            max_te = findViewById(R.id.textViewmax);
            double max_t = Double.parseDouble(line);
            max_t = (220-max_t)*0.7;
            max_te.setText(Double.toString(max_t));


        } catch (Exception ignored) {

        }
    }
}
