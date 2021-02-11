package ua.kpi.comsys.io8312.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import ua.kpi.comsys.io8312.fragments.Lab1Fragment;
import ua.kpi.comsys.io8312.fragments.Lab2Fragment;
import ua.kpi.comsys.io8312.fragments.Lab3Fragment;

public class LabAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;

    public LabAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm, totalTabs);
        context = c;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Lab1Fragment();
                break;
            case 1:
                fragment = new Lab2Fragment();
                break;
            case 2:
                fragment = new Lab3Fragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}