package com.treecode.tassbih;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class select_item extends AppCompatActivity {
ListView lv;
TextView tv_title;
String title;
ArrayList<String> list;
Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_item);
        tv_title=findViewById(R.id.tv_title);
        lv=findViewById(R.id.lv);
        title=getIntent().getExtras().getString("title");
        tv_title.setText(title);

        preparelist();
        lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.item_list,list));
lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String result=list.get(position);
        Intent i=new Intent();
        i.putExtra("result",""+result);
        setResult(RESULT_OK,i);
        finish();
    }
});
    }
    void preparelist(){
        list=new ArrayList<>();
        res=getResources();
        String t1=res.getString(R.string.choooselastcount);
        String t2=res.getString(R.string.choose);
        if(title.equals(t2)){
            list.add(res.getString(R.string.nothing));
            list.add(res.getString(R.string.sound));
            list.add(res.getString(R.string.vibrates));
            list.add(res.getString(R.string.both));
        }else{
        for(int i =100;i<5000;i+=100){
            list.add(""+i);
        }
        }
    }
}