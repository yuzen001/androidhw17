package com.app.myapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private TextView txt_ItemSelect;
        private ListView lsv_main; //ListView 宣告

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txt_ItemSelect = (TextView) findViewById(R.id.txt_ItemSelect);
            lsv_main = (ListView) findViewById(R.id.lsv_main);
            ArrayAdapter<CharSequence> arrAdap = ArrayAdapter.createFromResource(MainActivity.this, R.array.region_list,  //設定清單內容資訊
                    android.R.layout.simple_list_item_single_choice); //設定列表選項格式
            lsv_main.setAdapter(arrAdap); //將設定好的 ArrayAdapter 丟進 ListView
            //lsv_main.setSelector(R.drawable.green); //改變選取項目的背景色為圖片
            lsv_main.setSelection(2); //ListView 預設會選取第3筆資料
            lsv_main.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //設定列表選擇模式(單選)
            lsv_main.setOnItemClickListener(listViewRegionOnItemClick);
        }

        private AdapterView.OnItemClickListener listViewRegionOnItemClick
                = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                txt_ItemSelect.setText("你選擇了: " + ((TextView) view).getText());
            }
        };
    }

