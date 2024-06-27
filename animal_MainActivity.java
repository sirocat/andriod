package com.example.animalshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.animalshop.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    int val_price; //제품 총 가격(배송비 미포함)

    int val_delivery; //배송비
    int val_pay; //총 결제 금액
    int selected_product = 1500; // 선택한 제품 1개 가격

    int selected_count; //선택한 수량

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        sumTotal();

        binding.radio1.setOnClickListener(this);
        binding.radio2.setOnClickListener(this);
        binding.radio3.setOnClickListener(this);
        binding.btnPlus.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnPay.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.radio1){
            binding.imgProductMain.setImageResource(R.drawable.product1);
            selected_product = 1500;
            sumTotal();
        }
        else if(view.getId()==R.id.radio2){
            binding.imgProductMain.setImageResource(R.drawable.product2);
            selected_product = 2000;
            sumTotal();
        }
        else if (view.getId()==R.id.radio3){
            binding.imgProductMain.setImageResource(R.drawable.product3);
            selected_product = 1000;
            sumTotal();
        }
        else if(view.getId()==R.id.btn_plus) {
            binding.editCount.setText(selected_count+1+"");
            sumTotal();
        }
        else if(view.getId()==R.id.btn_minus){
            if(selected_count==1)
                Toast.makeText(this, "최소 주문 수량은 1개 입니다", Toast.LENGTH_SHORT).show();
            else {
                binding.editCount.setText(selected_count - 1 + "");
                sumTotal();
            }
        }
        else if(view.getId()==R.id.btn_pay){
            if(binding.chkAgree.isChecked()==true) {
                Toast.makeText(this, val_pay+"원을 결제하겠습니다", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "결제 동의에 체크해주세요", Toast.LENGTH_SHORT).show();
        }

    }

    private void sumTotal(){

        selected_count = Integer.parseInt(binding.editCount.getText().toString());
        val_price = selected_product * selected_count; //제품 총 가격
        if(val_price>=10000)
            val_delivery = 0;
        else
            val_delivery = 2500;
        val_pay = val_price + val_delivery;//최종 결제 금액

        binding.txtPrice.setText(val_price+"원");
        binding.txtDelivery.setText(val_delivery+"원");
        binding.txtPay.setText(val_pay+"원");
    }

}