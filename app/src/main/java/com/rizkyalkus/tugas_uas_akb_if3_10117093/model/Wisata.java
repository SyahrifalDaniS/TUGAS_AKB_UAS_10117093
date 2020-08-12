package com.rizkyalkus.tugas_uas_akb_if3_10117093.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

  /* NIM : 10116022
   Nama : Syahrifal Dani S
   Kelas : AKB-3
   Tanggal Pengerjaan : 12 Agustus 2020
 */
//Model Home

@Entity
public class Wisata implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public Long id;
    public String nama;
    public String alamat;
    public String kota;


}
