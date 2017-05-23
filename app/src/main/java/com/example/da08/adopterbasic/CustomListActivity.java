package com.example.da08.adopterbasic;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        listView = (ListView) findViewById(R.id.listView);

        // 1 데이터
        ArrayList<Data> datas = Loader.getData();

        // 2 아답터
        CustomAdapter adapter = new CustomAdapter(datas, this);


        // 3 연결
        listView.setAdapter(adapter);
    }
}

class Loader{
    public static ArrayList<Data> getData(){  //함수만들기
        ArrayList<Data> result = new ArrayList<>();
        for(int i = 0; i<100; i++){
            Data data = new Data();
            data.setId(i);
            data.setTitle("title"+i);

            result.add(data);
        }
        return result;
    }
}

class CustomAdapter extends BaseAdapter{
    ArrayList<Data> datas;
    Context context;
    LayoutInflater inflater;

    public CustomAdapter(ArrayList<Data> datas, Context context){
        this.datas = datas;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {  //  사용하는 데이터의 총 개수를 리턴
        return datas.size();
    }

    @Override
    public Object getItem(int position) {  // 데이터 클래스 하나를 리턴
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {  // 뷰에 아이디값이 리턴 대부분 인덱스가 그대로 리턴
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {  //아이템 뷰 하나를 리턴


        // xml을 class로 변환
        Log.d("convertView 체크",position +": convertView"+convertView);
        if(convertView == null)
            convertView = inflater.inflate(R.layout.itemcustomlist, null);  // inflater : itemcustomlist의 넘버랑 타이틀을 하나로 만들어 가져 옴
            // null은 상속받는게없으므로..
        TextView no = (TextView) convertView.findViewById(R.id.txtno);  // 이미 itemcustomlist의 textView를 액세스화 할 수 있으므로 convertview. 이라고 작성
        TextView title = (TextView) convertView.findViewById(R.id.txttitle);

        // 매줄에 해당되는 데이터를 꺼냄
        Data data =  datas.get(position);

        no.setText(data.getId()+"");
        title.setText(data.getTitle());

        return convertView;
    }
}





class Data{
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;

    }
}