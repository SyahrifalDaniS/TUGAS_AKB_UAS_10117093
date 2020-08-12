package com.rizkyalkus.tugas_uas_akb_if3_10117093.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.R;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.adapter.IntroViewPagerAdapter;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.model.Model;

import java.util.ArrayList;
import java.util.List;

/* NIM : 10116022
 Nama : Syahrifal Dani S
 Kelas : AKB-3
 Tanggal Pengerjaan : 12 Agustus 2020
*/
//Model Home
public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // Check Saat Activity terbuka jika sudah terbuka sebelumnya atau tidak

        if (restorePrefData())
        {
            Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivity);
            finish();
        }



        //hide action bar


        //deklarasi views
        tabIndicator = findViewById(R.id.tab_indicator);
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_getstarted);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);


        //fill list screen

        final List<Model> mList = new ArrayList<>();
        mList.add(new Model("Syahrifal Apps", "Welcome to my Apps",R.drawable.wisata));
        mList.add(new Model("Syahrifal Apps","Enjoy on my Apps",R.drawable.wisata));


        //setup viewpager
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager = findViewById(R.id.screen_view_pager);
        screenPager.setAdapter(introViewPagerAdapter);

        //setup tablayout view pager
        tabIndicator.setupWithViewPager(screenPager);

        //Button Next  Click Listener (Pindah Activity)
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                position = screenPager.getCurrentItem();
                if (position < mList.size())
                {
                    position ++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size() - 1) //saat pada page terakhir
                {

                    //TODO : Menampilkan GET STARTED BUTTON dan menghilangkan INDICATOR dan NEXT BUTTON

                    loadLastScreen();

                }


            }
        });

        //TAB LAYOUT AND CHANGE LISTENER

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == mList.size()-1){

                    loadLastScreen();

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // GET STARTED BUTTON CLICK LISTENER
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //OPEN MAIN ACTIVITY
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);

                // Kita perlu  save a boolean untuk mengatahui informasi USER bahwa telah melewati intro screen Activity

                savePrefsData();
                finish();
            }
        });
    }

    private boolean restorePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        return pref.getBoolean("IsIntroOpnend",false);

    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("IsIntroOpnend",true);
        editor.apply();

    }

    //Menampilkan GET STARTED BUTTON dan menghilangkan INDICATOR dan NEXT BUTTON

    private void loadLastScreen() {

        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

        //TODO : ADD ANIMATION GET STARTED
        btnGetStarted.setAnimation(btnAnim);

    }
}
