package com.treecode.tassbih;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public TextView tv_total,tv_countdown,tv_tasbih_title,tv_tasbih_detail;
int countdown=0;
int countdownTotal=0;
LinearLayout container_tasbih;
Resources res;
PrefManager prefManager;
    MediaPlayer mp;
   public static ArrayList<tasbih> arrayList;
    int current_tasbih=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_total=findViewById(R.id.tv_total);
        tv_countdown=findViewById(R.id.tv_countdown);
        tv_tasbih_title=findViewById(R.id.tv_tasbih_title);
        container_tasbih=findViewById(R.id.container_tasbih);
        tv_tasbih_detail=findViewById(R.id.tv_tasbih_detail);
        res=getResources();
        prefManager=new PrefManager(getApplicationContext());
        preparedata();
        mp=new MediaPlayer();
        prepareList();
        container_tasbih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_tasbih<arrayList.size()-1)
                    current_tasbih++;
                else
                    current_tasbih=0;

                tasbih ctasbih=arrayList.get(current_tasbih);
                tv_tasbih_title.setText(ctasbih.getTitle());
                tv_tasbih_detail.setText(ctasbih.getDetaill());
            }
        });

    }
void preparedata(){
        countdownTotal=prefManager.gettotal();
        tv_total.setText(res.getString(R.string.total)+":"+countdownTotal);
        tv_countdown.setText(""+countdown);

}

    @Override
    protected void onResume() {
        super.onResume();
        preparedata();
    }

    public void btnsettings(View view) {
        Intent i=new Intent(getApplicationContext(),settings.class);
        startActivity(i);
    }

    public void btnrestart(View view) {
        countdown=0;
        tv_countdown.setText(""+countdown);
    }
    void prepareList(){
        arrayList=new ArrayList<>();
        tasbih s1=new tasbih("سُبْحَانَ اللَّهِ ","يكتب له ألف حسنة أو يحط عنه ألف خطيئة.");
        arrayList.add(s1);
        s1=new tasbih("سُبْحَانَ اللَّهِ وَبِحَمْدِهِ ","حُطَّتْ خَطَايَاهُ وَإِنْ كَانَتْ مِثْلَ زَبَدِ الْبَحْرِ. لَمْ يَأْتِ أَحَدٌ يَوْمَ الْقِيَامَةِ بِأَفْضَلَ مِمَّا جَاءَ بِهِ إِلَّا أَحَدٌ قَالَ مِثْلَ مَا قَالَ أَوْ زَادَ عَلَيْهِ.");
        arrayList.add(s1);
        s1=new tasbih("سُبْحَانَ اللَّهِ وَالْحَمْدُ لِلَّهِ ","تَمْلَآَنِ مَا بَيْنَ السَّمَاوَاتِ وَالْأَرْضِ.");
        arrayList.add(s1);

        s1=new tasbih("سُبْحَانَ اللهِ العَظِيمِ وَبِحَمْدِهِ ","غرست له نخلة في الجنة (أى عدد).");

        arrayList.add(s1);
        s1=new tasbih("سُبْحَانَ اللَّهِ وَبِحَمْدِهِ ، سُبْحَانَ اللَّهِ الْعَظِيمِ","ثقيلتان في الميزان حبيبتان إلى الرحمن (أى عدد).");

        arrayList.add(s1);
        s1=new tasbih("لَا إلَه إلّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلُّ شَيْءِ قَدِيرِ. ","كانت له عدل عشر رقاب، وكتبت له مئة حسنة، ومحيت عنه مئة سيئة، وكانت له حرزا من الشيطان.");
        arrayList.add(s1);

        s1=new tasbih("الْحَمْدُ للّهِ رَبِّ الْعَالَمِينَ ","تملأ ميزان العبد بالحسنات.");

        arrayList.add(s1);
        s1=new tasbih("لا حَوْلَ وَلا قُوَّةَ إِلا بِاللَّهِ ","كنز من كنوز الجنة (أى عدد).");
        arrayList.add(s1);

        s1=new tasbih("الْلَّهُم صَلِّ وَسَلِم وَبَارِك عَلَى سَيِّدِنَا مُحَمَّد ","من صلى على حين يصبح وحين يمسى ادركته شفاعتى يوم القيامة.");
        arrayList.add(s1);

        s1=new tasbih("أستغفر الله ","لفعل الرسول صلى الله عليه وسلم.");
        arrayList.add(s1);

        s1=new tasbih("سُبْحَانَ الْلَّهِ، وَالْحَمْدُ لِلَّهِ، وَلَا إِلَهَ إِلَّا الْلَّهُ، وَالْلَّهُ أَكْبَرُ ","أنهن أحب الكلام الى الله، ومكفرات للذنوب، وغرس الجنة، وجنة لقائلهن من النار، وأحب الى النبي عليه السلام مما طلعت عليه الشمس، والْبَاقِيَاتُ الْصَّالِحَات.");
        arrayList.add(s1);

        s1=new tasbih("لَا إِلَهَ إِلَّا اللَّهُ ","أفضل الذكر لا إله إلاّ الله.");
        arrayList.add(s1);

        s1=new tasbih("الْلَّهُ أَكْبَرُ ","من قال الله أكبر كتبت له عشرون حسنة وحطت عنه عشرون سيئة. الله أكبر من كل شيء.");

        arrayList.add(s1);
        s1=new tasbih("اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ وَعَلَى آلِ مُحَمَّدٍ كَمَا صَلَّيْتَ عَلَى إِبْرَاهِيمَ , وَعَلَى آلِ إِبْرَاهِيمَ إِنَّكَ حَمِيدٌ مَجِيدٌ , اللَّهُمَّ بَارِكْ عَلَى مُحَمَّدٍ وَعَلَى آلِ مُحَمَّدٍ كَمَا بَارَكْتَ عَلَى إِبْرَاهِيمَ وَعَلَى آلِ إِبْرَاهِيمَ إِنَّكَ حَمِيدٌ مَجِيدٌ. ","في كل مره تحط عنه عشر خطايا ويرفع له عشر درجات ويصلي الله عليه عشرا وتعرض على الرسول صلى الله عليه وسلم (أى عدد).");
        arrayList.add(s1);
        tasbih ctasbih=arrayList.get(current_tasbih);
        tv_tasbih_title.setText(ctasbih.getTitle());
        tv_tasbih_detail.setText(ctasbih.getDetaill());
    }

    public void update_countdown(View view) {
        countdown++;
        countdownTotal++;
        tv_countdown.setText(""+countdown);
        tv_total.setText(res.getString(R.string.total)+":"+countdownTotal);
        prefManager.settotal(countdownTotal);

        if(prefManager.getsoundBib()){
            soundbib();
        }
        if(prefManager.getVibrate()){
            vibrateme();
        }
        if(countdown==prefManager.getLastcount()){

            notice();
        }


    }
    void notice(){
        String notice_val=prefManager.getremindlast();
        String v=res.getString(R.string.vibrates);
        String s=res.getString(R.string.sound);
        String b=res.getString(R.string.both);
        if(notice_val.equals(s)){
        soundnotice();
        }else if(notice_val.equals(v)) {
        vibrateme();
        }else if(notice_val.equals(b)){
            soundnotice();
            vibrateme();
        }
    }
    void soundnotice(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.notice);
        mp.start();
    }
    void soundbib(){
        mp=MediaPlayer.create(getApplicationContext(),R.raw.soundbib);
        mp.start();
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

    public void btn_showlist(View view) {
        Intent i=new Intent(getApplicationContext(),List_tasbih.class);
        startActivity(i);
    }
}