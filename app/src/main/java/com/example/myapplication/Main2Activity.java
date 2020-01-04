package com.example.myapplication;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.usercenter.UserCenterFragment;
import com.example.myapplication.dummy.DummyContent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends BaseActivity implements com.example.myapplication.CourseListFragment.OnListFragmentInteractionListener {

    private TextView mTextMessage;

    private FragmentManager fManager;

    private HomepageFragment fg1;

    private UserCenterFragment fg3;

    private com.example.myapplication.CourseListFragment fg2;

    private BottomNavigationView.OnNavigationItemSelectedListener  mOnNavigationItemSelectedListener  = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fTransaction = fManager.beginTransaction();
            switch (item.getItemId()) {


                case R.id.navigation_home:
                    mTextMessage.setText("主页");
                    hideAllFragment(fTransaction);
                    if(fg1 == null){
                        fg1 = new HomepageFragment();
                        fTransaction.add(R.id.ly_content,fg1);
                    }else{
                        fTransaction.show(fg1);
                    }
                    fTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText("全部课程");
                    hideAllFragment(fTransaction);
                    if(fg2 == null){
                        fg2 = new com.example.myapplication.CourseListFragment();
                        fTransaction.add(R.id.ly_content,fg2);
                    }else{
                        fTransaction.show(fg2);
                    }
                    fTransaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("我的信息");
                    hideAllFragment(fTransaction);
                    if(fg3 == null){
                        fg3 = new UserCenterFragment();
                        fTransaction.add(R.id.ly_content,fg3);
                    }else{
                        fTransaction.show(fg3);
                    }
                    fTransaction.commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main2);
        mTextMessage = findViewById(R.id.message);
        fManager = getFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();

        mTextMessage.setText("主页");
        hideAllFragment(fTransaction);
        if(fg1 == null){
            fg1 = new HomepageFragment();
            fTransaction.add(R.id.ly_content,fg1);
        }else{
            fTransaction.show(fg1);
        }
        fTransaction.commit();

        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
        return 0;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }


    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);

    }


    /**
     * 接受到来自ListFragment的监听
     * @param item
     */
    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

        Intent showDetailActivity =
                new Intent(getApplicationContext(), CourseDetailActivity.class);

        showDetailActivity.putExtra("courseName",item.courseName);
        showDetailActivity.putExtra("courseSchoolName",item.courseSchoolName);
        showDetailActivity.putExtra("scheduleBeginEnd",item.scheduleBeginEnd);
        showDetailActivity.putExtra("scheduleNow",item.scheduleNow);
        showDetailActivity.putExtra("picNumber",item.id);

        startActivity(showDetailActivity);
    }
}
