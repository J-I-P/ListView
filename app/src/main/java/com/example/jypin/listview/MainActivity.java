package com.example.jypin.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private ListView lstPrefer;
    String [] Balls=new String [] {"basketball", "soccer", "baseball", "籃球", "足球", "棒球", "其他"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult=(TextView)findViewById(R.id.txtResult);
        lstPrefer=(ListView)findViewById(R.id.lstPrefer);

        lstPrefer.setTextFilterEnabled(true);//啟用按鍵過濾功能
        lstPrefer.setSelector(R.drawable.green);//改變選取選項的背景色為圖片

        ArrayAdapter<String> adapterBalls=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Balls);

        lstPrefer.setAdapter(adapterBalls);

        lstPrefer.setOnItemClickListener(lstPreferListener);
    }

    private ListView.OnItemClickListener lstPreferListener=new ListView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
            String sel=parent.getItemAtPosition(position).toString();
            txtResult.setText("我最喜歡的球類運動："+sel);
        }
    };
}
