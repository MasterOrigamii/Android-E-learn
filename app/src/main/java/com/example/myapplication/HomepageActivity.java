package com.example.myapplication;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;


import com.example.myapplication.dummy.DummyContent;
import com.example.myapplication.R;
import com.example.myapplication.utlis.BaseUrl;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends BaseActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_homepage);

        BannerLayout bannerLayout2 = (BannerLayout) findViewById(R.id.banner2);
        List<String> urls = new ArrayList<>();
        urls.add(BaseUrl.baseImage + "001/course_pic_1.jpg");
        urls.add(BaseUrl.baseImage + "001/course_pic_1.jpg");
        urls.add(BaseUrl.baseImage + "001/course_pic_1.jpg");
        urls.add(BaseUrl.baseImage + "001/course_pic_1.jpg");

        List<String> titleas = new ArrayList<>();
        titleas.add("标题一");
        titleas.add("标题二");
        titleas.add("标题三");
        titleas.add("标题四");
        if (bannerLayout2 != null) {
//            bannerLayout2.
//            bannerLayout2.setViewUrls(MainActivity.this ,urls, titleas);
//            bannerLayout2.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
//                @Override
//                public void onItemClick(int position) {
//                    //Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
//                }
//            });
        }


//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        mTextMessage = findViewById(R.id.message);
//        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
        return 0;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }






}
