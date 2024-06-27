package com.example.intentexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.intentexam.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    ActivitySubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int result = intent.getIntExtra("key",1);
        if(result == 1){
            binding.txtChoice.setText("원을 선택했습니다.");
        }
        else if(result==2){
            binding.txtChoice.setText("사각형을 선택했습니다.");
        }
        binding.resultImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("result",binding.txtChoice.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}