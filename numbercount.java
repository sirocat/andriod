package com.example.numbercounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView numberTextView;
    Button resetButton,plusButton;
    int number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberTextView = findViewById(R.id.numberTextView);
        resetButton = findViewById(R.id.resetButton);
        plusButton = findViewById(R.id.plusButton);

        resetButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) { //이벤트 처리
        switch (view.getId()){
            case R.id.resetButton:
                number = 0;
                numberTextView.setText(Integer.toString(number));
                break;
            case R.id.plusButton:
                number += 1;
                numberTextView.setText(Integer.toString(number));
                break;
        }
    }
}
