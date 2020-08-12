package com.rizkyalkus.tugas_uas_akb_if3_10117093.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.rizkyalkus.tugas_uas_akb_if3_10117093.R;

  /* NIM : 10116022
   Nama : Syahrifal Dani S
   Kelas : AKB-3
   Tanggal Pengerjaan : 12 Agustus 2020
 */
//Model Home

public class SplashActivity extends AppCompatActivity {

    private ImageView logosplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logosplash = (ImageView) findViewById(R.id.splash_logo);
        Animation logoanim = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        logosplash.startAnimation(logoanim);

        final Intent i = new Intent(this, IntroActivity.class);
        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                    startActivity(i);
                    finish();

                }
            }
        };

        timer.start();
    }
}
