package com.example.myapplication.usercenter;

import android.graphics.Color;
import android.os.Bundle;

import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    private ImageView blurImageView;
    private ImageView avatarImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.fragment_user_center);
        blurImageView = (ImageView) findViewById(R.id.iv_blur);
        avatarImageView = (ImageView) findViewById(R.id.iv_avatar);


        Glide.with(this).load(R.drawable.course_pic_9).into(blurImageView);
        blurImageView.setBackgroundColor(Color.BLACK);
        blurImageView.setImageAlpha(50);
        Glide.with(this).load(R.drawable.head).into(avatarImageView);
    }
}
