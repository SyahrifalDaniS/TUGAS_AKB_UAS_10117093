package com.rizkyalkus.tugas_uas_akb_if3_10117093.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.R;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.fragment.ProfileFragment;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.fragment.WisataFragment;

/* NIM : 10116022
 Nama : Syahrifal Dani S
 Kelas : AKB-3
 Tanggal Pengerjaan : 12 Agustus 2020
*/
//Model Home
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new WisataFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.wisata_menu:
                fragment = new WisataFragment();
                break;
            case R.id.profile_menu:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
