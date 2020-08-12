package com.rizkyalkus.tugas_uas_akb_if3_10117093.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.rizkyalkus.tugas_uas_akb_if3_10117093.R;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.database.AppDatabase;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.model.Wisata;
  /* NIM : 10116022
   Nama : Syahrifal Dani S
   Kelas : AKB-3
   Tanggal Pengerjaan : 12 Agustus 2020
 */
//Model Home

public class FormActivity extends AppCompatActivity {

    private EditText inNama,inAlamat;
    private Spinner spKota;
    private Button btnSave;

    private Wisata wisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        inNama = findViewById(R.id.in_nama);
        inAlamat = findViewById(R.id.in_alamat);
        btnSave = findViewById(R.id.btn_save);

        spKota = findViewById(R.id.sp_kota);
        final String[] kota = {"Kota Bandung", "Kota Cimahi", "Kabupaten Bandung Barat", "Kabupaten Bandung"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(FormActivity.this,
                android.R.layout.simple_spinner_dropdown_item, kota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota.setAdapter(adapter);

        Intent intent = getIntent();
        wisata = (Wisata) intent.getSerializableExtra("wisata");
        if (wisata != null) {
            inNama.setText(wisata.nama);
            inAlamat.setText(wisata.alamat);

            for(int i=0;i<kota.length;i++){
                String s = kota[i];
                if (s.equalsIgnoreCase((wisata.kota))) {
                    spKota.setSelection(i);
                }
            }
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = inNama.getText().toString();
                String alamat = inAlamat.getText().toString();
                String selectedKota = (String) spKota.getSelectedItem();

                if (nama.isEmpty()) {
                    inNama.setError("Nama Tidak Boleh Kosong");
                    inNama.requestFocus();
                } else if (alamat.isEmpty()){
                    inAlamat.setError("Alamat tidak boleh kosong");
                    inAlamat.requestFocus();
                }

                if (wisata == null) {
                    wisata = new Wisata();
                    wisata.nama = nama;
                    wisata.alamat = alamat;
                    wisata.kota = selectedKota;

                    AppDatabase.getInstance(FormActivity.this)
                            .wisataDao().insert(wisata);
                    Toast.makeText(FormActivity.this, "Data telah berhasil disimpan", Toast.LENGTH_LONG).show();

                } else {
                    wisata = new Wisata();
                    wisata.nama = nama;
                    wisata.alamat = alamat;
                    wisata.kota = selectedKota;

                    AppDatabase.getInstance(FormActivity.this)
                            .wisataDao().update(wisata);
                    Toast.makeText(FormActivity.this, "Data telah berhasil diubah", Toast.LENGTH_LONG).show();
                }
                Intent intent1 = new Intent(FormActivity.this, MainActivity.class);
                startActivity(intent1);
            }

        });
    }
}
