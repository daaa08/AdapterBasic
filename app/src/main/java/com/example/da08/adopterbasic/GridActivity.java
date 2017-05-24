package com.example.da08.adopterbasic;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);


        // 1 data
        ArrayList<Data> datas = new ArrayList<>();
        datas = Loader.getData();  //여기서 datas = new ArrayList<>();와 같은 의미라서 위에 new ArrayList<>();는 회색표시 됨
        // 2 adapter
        GridAdapter adapter = new GridAdapter(datas, this);

        // 3 연결
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
    }
}

class GridAdapter extends BaseAdapter {
    ArrayList<Data> datas;
    Context context;
    LayoutInflater inflater;

    public GridAdapter(ArrayList<Data> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        Log.e("Adapter","getItem position="+position);
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.e("Adapter","getItem[Id] position="+position);
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("ConvertView",position+" : convertView="+convertView);

        Holder holder;
        if (convertView == null) {
            holder = new Holder();

            convertView = inflater.inflate(R.layout.item_costom_grid,null);

            holder.image = (ImageView) convertView.findViewById(R.id.imageView);
            holder.text = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }


        Data data = datas.get(position);


        // 1 이미지 suffix 만들기
        int suffix = data.getId()%5 + 1;
        // 2 문자열로 리소스 아이디 가져오기
        int id = context.getResources().getIdentifier("ac" + suffix, "mipmap" , context.getPackageName());
        // 3 리소스 아이디를 이미지에 세팅하기
        holder.image.setImageResource(id);
        holder.text.setText(data.getTitle());

        return convertView;
    }

    class Holder {
        public ImageView image;
        public TextView text;
    }
}