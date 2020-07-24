package com.treecode.tassbih;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;



public class splash extends AppCompatActivity {
int periode=4500;
    MediaPlayer mp;
PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefManager=new PrefManager(getApplicationContext());
        mp=MediaPlayer.create(getApplicationContext(),R.raw.intro);
       boolean b=prefManager.getsoundIntro();
       if(b)
        mp.start();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, periode);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mp.isPlaying())
            mp.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying())
        mp.stop();
    }
}
