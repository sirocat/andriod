package com.example.intenttest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.dialButton).setOnClickListener(this);
        findViewById(R.id.mapButton).setOnClickListener(this);
        findViewById(R.id.smsButton).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dialButton:
                Intent dialintent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"));
                startActivity(dialintent);
                break;
            case R.id.mapButton:
                Intent mapButtonintent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=서울"));
                startActivity(mapButtonintent);
                break;
            case R.id.smsButton:
                Intent smsButtonintent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:01011111111"));
                smsButtonintent.putExtra("sms_body","Hello World!");
                startActivity(smsButtonintent);
                break;
        }
    }
}