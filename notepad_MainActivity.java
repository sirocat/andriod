package com.example.notepadexam;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.notepadexam.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ActivityMainBinding binding;
    ArrayList<String> noteData,titleData;
    ArrayAdapter<String> noteAdapter,titleAdapter;

    int m_selPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Spinner용 array list data채우기
        titleData = new ArrayList<>();
        titleData.add("선택");
        titleData.add("1학년");
        titleData.add("2학년");
        titleData.add("3학년");
        //Adapter 생성
        titleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,titleData);
        //Spinner 와 Adapter 연결
        binding.spinner.setAdapter(titleAdapter);


        //ListView용 Array list 만들기
        noteData = new ArrayList<>();
        //Adapter생성
        noteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,noteData);
        //ListView 와 Adapter연결
        binding.listView.setAdapter(noteAdapter);

        binding.btnSave.setOnClickListener(this);
        binding.btnDelete.setOnClickListener(this);
        binding.btnFinish.setOnClickListener(this);
        binding.btnNew.setOnClickListener(this);

        binding.listView.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //버튼이 클릭되면 실행
        if(view.getId()==R.id.btnFinish){
            finish();
        }
        else if(view.getId()==R.id.btnNew){
            binding.textInpurt.setText("");
        }
        else if(view.getId()==R.id.btnSave){

            //예외처리 - 스피너 값을 선택하지 않았을때
            if(binding.spinner.getSelectedItemPosition()==0){
                Toast.makeText(this,"학년을 선택해주세요",Toast.LENGTH_SHORT).show();
                return;
            }




            String title = binding.spinner.getSelectedItem().toString();
            String data = binding.textInpurt.getText().toString();

            //예외처리 - dataInput값이 0일때
            if(data.length()==0){
                Toast.makeText(this, "저장할 내용이 없습니다", Toast.LENGTH_SHORT).show();
                return;
            }

            noteData.add("["+title+"]"+data);
            noteAdapter.notifyDataSetChanged();
        }
        else if(view.getId() == R.id.btnDelete){

            //예외처리 - 삭제할 데이터가 없을때
            if(binding.listView.getCount()==0){
                Toast.makeText(this, "삭제할 데이터가 없습니다", Toast.LENGTH_SHORT).show();
                return;
            }

            //예외처리 - ListView에서 삭제할 것을 선택 안할때
            if(m_selPos < 0){
                Toast.makeText(this, "삭제할 데이터를 선택해주세요", Toast.LENGTH_SHORT).show();
                return;
            }


            noteData.remove(m_selPos);
            noteAdapter.notifyDataSetChanged();
        }



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //리스트뷰가 클릭되면 실행
        m_selPos = i;

        //선택한 내용을 edittext에 보이기
        binding.textInpurt.setText(noteData.get(i));
    }
}
