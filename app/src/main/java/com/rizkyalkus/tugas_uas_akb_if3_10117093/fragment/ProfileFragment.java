package com.rizkyalkus.tugas_uas_akb_if3_10117093.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rizkyalkus.tugas_uas_akb_if3_10117093.R;
/* NIM : 10116022
 Nama : Syahrifal Dani S
 Kelas : AKB-3
 Tanggal Pengerjaan : 12 Agustus 2020
*/
/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
