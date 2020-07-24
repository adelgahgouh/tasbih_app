package com.treecode.tassbih;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class settings extends AppCompatActivity {
Button btnsoundintro,btnvibrate,btnsoundbib,btnrestartlastcount,btnremindlastcount;
PrefManager prefManager;
TextView tv_lastcount;
int remidlast_code=2,lastcount_code=3;
Resources res;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        btnremindlastcount=findViewById(R.id.btnremindlastcount);
        btnsoundintro=findViewById(R.id.btnsoundintro);
        btnvibrate=findViewById(R.id.btnvibrate);
        tv_lastcount=findViewById(R.id.tv_lastcount);

        btnsoundbib=findViewById(R.id.btnsoundbib);
        btnrestartlastcount=findViewById(R.id.btnrestartlastcount);
        prefManager=new PrefManager(getApplicationContext());
        res=getResources();
        mp=new MediaPlayer();
        preparedata();

    }
    boolean soundbib=false;
    boolean soundintro=false;
    boolean vibrate=false;
    boolean restartlastcount=false;
void preparedata(){
    soundbib=prefManager.getsoundBib();
    soundintro=prefManager.getsoundIntro();
    vibrate=prefManager.getVibrate();
    restartlastcount=prefManager.getrestartlastcount();
     String remindlastcount=prefManager.getremindlast();
     btnremindlastcount.setText(remindlastcount);
     if(soundbib)
         btnsoundbib.setText(res.getString(R.string.yes));
     else
         btnsoundbib.setText(res.getString(R.string.no));
     if(soundintro)
         btnsoundintro.setText(res.getString(R.string.yes));
     else
         btnsoundintro.setText(res.getString(R.string.no));
    if(vibrate)
        btnvibrate.setText(res.getString(R.string.yes));
    else
        btnvibrate.setText(res.getString(R.string.no));

    if(restartlastcount)
        btnrestartlastcount.setText(res.getString(R.string.yes));
    else
        btnrestartlastcount.setText(res.getString(R.string.no));


    tv_lastcount.setText(""+prefManager.getLastcount());


}
    public void btnsoundintro(View view) {
        soundintro=prefManager.getsoundIntro();
    if(soundintro){
        prefManager.setsoundBib(false);
        btnsoundintro.setText(res.getString(R.string.no));
        if(mp.isPlaying()){
            mp.stop();
        }

    }else{
        prefManager.setsoundBib(true);
        btnsoundintro.setText(res.getString(R.string.yes));
        mp=MediaPlayer.create(getApplicationContext(),R.raw.intro);
        mp.start();

    }
    }

    public void btnvibrate(View view) {
        vibrate=prefManager.getVibrate();

        if(vibrate){
            prefManager.setVibrate(false);
            btnvibrate.setText(res.getString(R.string.no));

        }else{
            prefManager.setVibrate(true);
            btnvibrate.setText(res.getString(R.string.yes));
            vibrateme();
        }
    }

    public void btnsoundbib(View view) {
        soundbib=prefManager.getsoundBib();

        if(soundbib){
            prefManager.setsoundBib(false);
            btnsoundbib.setText(res.getString(R.string.no));
            if(mp.isPlaying()){
                mp.stop();
            }

        }else{
            prefManager.setsoundBib(true);
            btnsoundbib.setText(res.getString(R.string.yes));
            mp=MediaPlayer.create(getApplicationContext(),R.raw.soundbib);
            mp.start();

        }
    }

    public void btnchouselastcount(View view) {
    Intent i=new Intent(getApplicationContext(),select_item.class);
    i.putExtra("title",res.getString(R.string.choooselastcount));
    startActivityForResult(i,lastcount_code);
    }

    public void btnplus(View view) {
    int count=prefManager.getLastcount()+1;
    tv_lastcount.setText(""+count);
    prefManager.setLastcount(count);
    }

    public void btnminus(View view) {
        int count=prefManager.getLastcount()-1;
        tv_lastcount.setText(""+count);
        prefManager.setLastcount(count);
    }

    public void btnrestartlastcount(View view) {
    restartlastcount=prefManager.getrestartlastcount();
    if(restartlastcount){
        prefManager.setrestartlastcount(false);
        btnrestartlastcount.setText(res.getString(R.string.no));
    }else {
        prefManager.setrestartlastcount(true);
        btnrestartlastcount.setText(res.getString(R.string.yes));
    }
    }

    public void btnremindlastcount(View view) {
        Intent i=new Intent(getApplicationContext(),select_item.class);
        i.putExtra("title",res.getString(R.string.choose));
        startActivityForResult(i,remidlast_code);
    }

    public void btnrestarttotal(View view) {
    prefManager.settotal(0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==lastcount_code){
                String result=data.getExtras().getString("result");
                tv_lastcount.setText(result);
                prefManager.setLastcount(Integer.valueOf(result));
            }else {
                String result=data.getExtras().getString("result");
                btnremindlastcount.setText(result);
                prefManager.setremindlast(result);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying())
            mp.stop();
    }

    public void btnback(View view) {
    finish();
    }
    void vibrateme(){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }
    }
}