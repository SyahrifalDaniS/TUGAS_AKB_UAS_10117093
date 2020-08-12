package com.rizkyalkus.tugas_uas_akb_if3_10117093.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rizkyalkus.tugas_uas_akb_if3_10117093.activity.FormActivity;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.activity.MainActivity;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.R;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.activity.MapsActivity;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.database.AppDatabase;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.model.Wisata;

import java.util.List;

  /* NIM : 10116022
   Nama : Syahrifal Dani S
   Kelas : AKB-3
   Tanggal Pengerjaan : 12 Agustus 2020
 */
//Model Home


public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {

    private Context context;
    List<Wisata> wisata;

    public WisataAdapter(Context context, List<Wisata> wisata) {
        this.context = context;
        this.wisata = wisata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wisata, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Wisata wisata1 = wisata.get(position);
        viewHolder.txtNama.setText(wisata1.nama);
        viewHolder.txtAlamat.setText(wisata1.alamat);
        viewHolder.txtKota.setText(wisata1.kota);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FormActivity.class);
                intent.putExtra("wisata",wisata1);
                context.startActivity(intent);
            }
        });
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Konfirmasi");
                builder.setMessage("Hapus data?");
                builder.setPositiveButton("Hapus",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                delete(wisata1);
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        viewHolder.btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(context, MapsActivity.class);
                intent1.putExtra("wisata",wisata1);
                context.startActivity(intent1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return (wisata != null) ? wisata.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtNama, txtAlamat, txtKota;
        CardView cardView;
        Button btnDelete,btnMaps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = itemView.findViewById(R.id.txt_nama);
            txtAlamat = itemView.findViewById(R.id.txt_alamat);
            txtKota = itemView.findViewById(R.id.txt_kota);

            cardView = itemView.findViewById(R.id.card);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            btnMaps = itemView.findViewById(R.id.btn_maps);

        }
    }
    private void delete(Wisata wisata){
        AppDatabase.getInstance(context).wisataDao().delete(wisata);
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

}
