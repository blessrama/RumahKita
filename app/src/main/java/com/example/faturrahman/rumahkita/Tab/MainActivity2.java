package com.example.faturrahman.rumahkita.Tab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.faturrahman.rumahkita.Fragment.ChatFragment;
import com.example.faturrahman.rumahkita.Fragment.HistoryFragment;
import com.example.faturrahman.rumahkita.Fragment.HomeFragment;
import com.example.faturrahman.rumahkita.Fragment.ProfileFragment;
import com.example.faturrahman.rumahkita.R;
import com.example.faturrahman.rumahkita.Utils.BottomNavigationViewHelper;

/**
 * Created by Faturrahman on 5/24/2018.
 */

public class MainActivity2 extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager mViewPager;
    private FrameLayout mFrameLayout;
    private int prevMenuItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        mViewPager = (ViewPager) findViewById(R.id.ViewPager);
//        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
////                int itemId = 0;
////                switch (position) {
////                    case 0:
//////                            mViewPager.setCurrentItem(0);
////                        itemId = R.id.home_button;
////                        break;
////                    case 1:
//////                            mViewPager.setCurrentItem(1);
////                        itemId = R.id.chat_button;
////                        break;
////                    case 2:
////                        itemId = R.id.history_button;
////                        break;
////                    case 3:
////                        itemId = R.id.profil_button;
////                        break;
////                }
//                if (prevMenuItem != -1) {
//
//                    bottomNavigationView.getMenu().getItem(prevMenuItem).setChecked(false);
//                }
//                else {
//                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
//                }
//                bottomNavigationView.getMenu().getItem(position).setChecked(true);
//                prevMenuItem = position;
//
//            }
//
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomView);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);//disable BottomNavigationView shift mode
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                isTabClick = true;
                switch (item.getItemId()) {
                    case R.id.home_button:
                        replaceFragment(new HomeFragment());
//                        mViewPager.setCurrentItem(0);
//                        bottomNavigationView.setSelectedItemId(R.id.home_button);
                        break;
                    case R.id.history_button:
                        replaceFragment(new HistoryFragment());
//                        mViewPager.setCurrentItem(1);
//                        bottomNavigationView.setSelectedItemId(R.id.chat_button);
                        break;
                    case R.id.chat_button:

                        replaceFragment(new ChatFragment());
//                        mViewPager.setCurrentItem(2);
//                        bottomNavigationView.setSelectedItemId(R.id.history_button);
                        break;
                    case R.id.profil_button:

                        replaceFragment(new ProfileFragment());
//                        mViewPager.setCurrentItem(3);
//                        bottomNavigationView.setSelectedItemId(R.id.profil_button);
                        break;
                }
//                isTabClick = false;
                return true;
            }
        });

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_layout, new HomeFragment());
        ft.commit();
    }

    void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}