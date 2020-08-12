package com.rizkyalkus.tugas_uas_akb_if3_10117093.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.rizkyalkus.tugas_uas_akb_if3_10117093.R;
import com.rizkyalkus.tugas_uas_akb_if3_10117093.model.Model;

import java.util.List;

  /* NIM : 10116022
   Nama : Syahrifal Dani S
   Kelas : AKB-3
   Tanggal Pengerjaan : 12 Agustus 2020
 */
//Model Home

public class IntroViewPagerAdapter extends PagerAdapter {

    Context mContext;
    List<Model> mList;

    public IntroViewPagerAdapter(Context mContext, List<Model> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View screenLayout = inflater.inflate(R.layout.layout_screen,null);

        ImageView imgslide = screenLayout.findViewById(R.id.intro_img);
        TextView title = screenLayout.findViewById(R.id.intro_title);
        TextView description = screenLayout.findViewById(R.id.intro_description);

        title.setText(mList.get(position).getTitle());
        description.setText(mList.get(position).getDescription());
        imgslide.setImageResource(mList.get(position).getScreenImg());

        container.addView(screenLayout);
        return  screenLayout;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
