package com.treecode.tassbih;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private   String PREF_NAME = "settings";

    private final String soundBib = "soundBib";
    private final String soundIntro = "soundBib";
    private final  String Vibrate = "Vibrate";
    private final String remindlast = "non";//vibrate,sound
    private final  String lastcount = "lastcount";//100,500
    private  final String restartlastcount = "restartlastcount";//false,true
    private  final String total = "total";//false,true


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }




    public boolean getrestartlastcount() {
        return     pref.getBoolean(restartlastcount, false);
    }

    public void setrestartlastcount(boolean restartlastcount1) {
        editor.putBoolean(restartlastcount, restartlastcount1);
        editor.commit();

    }
    public boolean getsoundBib() {
        return     pref.getBoolean(soundBib, false);
    }

    public void setsoundBib(boolean soundBib1) {
        editor.putBoolean(soundBib, soundBib1);
        editor.commit();

    }

    public boolean getsoundIntro() {
        return
                pref.getBoolean(soundIntro, false);
    }

    public void setsoundIntro(boolean soundIntro1) {
        editor.putBoolean(soundIntro, soundIntro1);
        editor.commit();

    }


    public boolean getVibrate() {
        return
                pref.getBoolean(Vibrate, false);
    }

    public void setVibrate(boolean Vibrate1) {
        editor.putBoolean(Vibrate, Vibrate1);
        editor.commit();

    }


    public String getremindlast() {
    return     pref.getString(
            remindlast, "لاشيء");
    }

    public void setremindlast(String remindlast1) {
        editor.putString(remindlast, remindlast1);
        editor.commit();

    }

    public int getLastcount() {
        return
                pref.getInt(lastcount, 100);
    }

    public void setLastcount(int lastcount1) {
        editor.putInt(lastcount, lastcount1);
        editor.commit();

    }

    public int gettotal() {
        return
                pref.getInt(total, 0);
    }

    public void settotal(int total1) {
        editor.putInt(total, total1);
        editor.commit();

    }


}
