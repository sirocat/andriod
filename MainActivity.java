package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText heightEditText,weightEditText;
    Button resultButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        resultButton = findViewById(R.id.resultButton);
        resultText = findViewById(R.id.resultText);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_height = heightEditText.getText().toString();
                String str_weight = weightEditText.getText().toString();

                if(str_height.isEmpty() || str_weight.isEmpty()){
                    Toast.makeText(MainActivity.this, "빈값이 있습니다", Toast.LENGTH_SHORT).show();
                    return;
                }
                int height = Integer.parseInt(str_height);
                int weight = Integer.parseInt(str_weight);
                double bmi = weight/Math.pow(height/100.0,2.0);

                resultText.setVisibility(view.VISIBLE);

                if(bmi > 35)
                    resultText.setText("고도비만");
                else if(bmi >= 30.0)
                    resultText.setText("중정도비만");
                else if(bmi >= 25.0)
                    resultText.setText("경도비만");
                else if(bmi >= 23.0)
                    resultText.setText("과체중");
                else if(bmi >= 18.5)
                    resultText.setText("정상체중");
                else
                    resultText.setText("저체중");
            }
        });
    }
}