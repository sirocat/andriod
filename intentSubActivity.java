package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    Intent intent;
    Button prevButton;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        prevButton = findViewById(R.id.prevButton);
        txt = findViewById(R.id.txt);

        intent =getIntent();
        String msg = intent.getStringExtra("message");
        txt.setText(msg);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = getIntent();
                intent.putExtra("result","success");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}