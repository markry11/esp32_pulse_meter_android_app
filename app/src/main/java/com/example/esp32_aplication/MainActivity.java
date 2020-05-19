package com.example.esp32_aplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    String wiek;
    private EditText etMainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMainEditText = (EditText) findViewById(R.id.ed);
    }

    @Override
    protected void onPause() {
        super.onPause();

        wiek=etMainEditText.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput("dane.txt", Context.MODE_PRIVATE);

            outputStream.write(wiek.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception ignored) {

        }
    }

    public void P_Conf(View view)
    {
        Intent intent =new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
