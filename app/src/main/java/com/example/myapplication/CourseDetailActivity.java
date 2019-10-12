package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class CourseDetailActivity extends AppCompatActivity {


    private VideoView mVideoView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        mVideoView= (VideoView) findViewById(R.id.videoView);
        mButton= (Button) findViewById(R.id.playBtn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mVideoView.setVideoURI(Uri.parse("https://www.pornhub.com/view_video.php?viewkey=ph5d771a42eb593"));
                mVideoView.setVideoURI(Uri.parse("android.resource://com.example.myapplication/"+R.raw.test3));
                //mVideoView.setZOrderOnTop(true);
                mVideoView.setMediaController(new MediaController(CourseDetailActivity.this));
                mVideoView.start();
            }
        });

    }
}
