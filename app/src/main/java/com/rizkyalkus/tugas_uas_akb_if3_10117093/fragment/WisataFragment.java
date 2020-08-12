package com.rizkyalkus.tugas_uas_akb_if3_10117093.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.activity.FormActivity;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.R;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.adapter.WisataAdapter;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.database.AppDatabase;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.model.Wisata;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
/* NIM : 10116022
 Nama : Syahrifal Dani S
 Kelas : AKB-3
 Tanggal Pengerjaan : 12 Agustus 2020
*/

public class WisataFragment extends Fragment {

    private RecyclerView recyclerView;
    private WisataAdapter adapter;

    public WisataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wisata, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        List<Wisata> data = AppDatabase.getInstance(getActivity())
                .wisataDao().getAll();

        adapter = new WisataAdapter(getContext(),data);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FormActivity.class);
                startActivity(intent);
            }
        });
    }
}
