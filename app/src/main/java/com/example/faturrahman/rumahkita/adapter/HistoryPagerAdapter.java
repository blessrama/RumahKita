package com.example.faturrahman.rumahkita.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.faturrahman.rumahkita.R;
import com.example.faturrahman.rumahkita.fragment.DalamProsesFragment;
import com.example.faturrahman.rumahkita.fragment.SelesaiFragment;

public class HistoryPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public HistoryPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DalamProsesFragment();
        } else {
            return new SelesaiFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public String getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Dalam Proses";
            case 1:
                return "Selesai";
            default:
                return null;
        }
    }
}
