package com.rizkyalkus.tugas_uas_akb_if3_10117093.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.rizkyalkus.tugas_uas_akb_if3_10117093.model.Wisata;

import java.util.List;
/* NIM : 10116022
 Nama : Syahrifal Dani S
 Kelas : AKB-3
 Tanggal Pengerjaan : 12 Agustus 2020
*/


@Dao
public interface WisataDao {
    @Query("SELECT * FROM Wisata")
    List<Wisata> getAll();

    @Query("SELECT * FROM Wisata WHERE id=:id")
    Wisata getById(Long id);

    @Insert
    void insert(Wisata wisata);

    @Update
    void update(Wisata wisata);

    @Delete
    void delete(Wisata wisata);

    @Query("SELECT COUNT(*) from Wisata")
    Integer count();

}
