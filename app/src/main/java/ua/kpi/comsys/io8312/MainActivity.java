package ua.kpi.comsys.io8312;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.Window;
import com.google.android.material.tabs.TabLayout;
import java.util.Objects;

import io.realm.Realm;
import ua.kpi.comsys.io8312.adapters.LabAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        Realm.init(this);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Lab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Lab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Lab3/4/6/7"));
        tabLayout.addTab(tabLayout.newTab().setText("Lab5/6/7"));
        tabLayout.getTabAt(0).setIcon(R.drawable.first_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.second_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.third_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.fourth_icon);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        LabAdapter adapter = new LabAdapter(this, getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}