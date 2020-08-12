package com.rizkyalkus.tugas_uas_akb_if3_10117093.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rizkyalkus.tugas_uas_akb_if3_10117093.model.Wisata;

  /* NIM : 10116022
   Nama : Syahrifal Dani S
   Kelas : AKB-3
   Tanggal Pengerjaan : 12 Agustus 2020
 */
//Model Home

@Database(entities = {Wisata.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WisataDao wisataDao();

    private static volatile AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = create(context);
        }
        return instance;
    }

    AppDatabase(){
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(context, AppDatabase.class,
                "wisata.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

}

