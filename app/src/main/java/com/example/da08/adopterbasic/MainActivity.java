package com.example.da08.adopterbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String datas[] = {"선택하세요", "ListView", "GridView", "RecycleView","CustomView"};

    final int LIST = 1;
    final int GRID = 2;
    final int RECYCLE = 3;
    final int CUSTOM = 4;


    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        //listview에 데이터 연결하기
        // 1 데이터 정의
        // datas 정의
        // 2 아답터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        // 3 뷰에 아답터 연결
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                   Log.i("spinner", datas[position]);
               Intent intent;
                switch (position){
                    case LIST :
                        intent = new Intent(MainActivity.this, ListActivity.class);
                        startActivity(intent);
                        break;
                    case GRID :
                        intent = new Intent(MainActivity.this, GridActivity.class);
                        startActivity(intent);
                        break;
                    case RECYCLE :
                        intent = new Intent(MainActivity.this, RecylcleActivity.class);
                        startActivity(intent);
                        break;
                    case CUSTOM :
                        intent = new Intent(MainActivity.this, CustomListActivity.class);
                        startActivity(intent);
                        break;
                    default:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
