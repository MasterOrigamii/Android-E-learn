package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;

public class CourseDetailActivity extends AppCompatActivity {


    private VideoView mVideoView;
    private Button mButton;
    private TextView mCourseNameTextView;
    private TextView mSchoolTextView;
    private TextView mJoinNumTextView;
    private TextView mBeginEndTextView;
    private TextView mScheduleNowView;

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

        Intent in = getIntent();
        String courseName = in.getStringExtra("courseName");
        String courseSchoolName = in.getStringExtra("courseSchoolName");
        String scheduleBeginEnd = in.getStringExtra("scheduleBeginEnd");
        String scheduleNow = in.getStringExtra("scheduleNow");
        int picNumber = Integer.parseInt(in.getStringExtra("picNumber"));
        int pic = getImg(picNumber);
        if (pic != -1) {

            mVideoView.setBackgroundResource(pic);

        }



        mCourseNameTextView = findViewById(R.id.courseNameTextView);
        mSchoolTextView = findViewById(R.id.universitytextView);
        mBeginEndTextView = findViewById(R.id.course_schedule_beginEnd_textView);
        mScheduleNowView = findViewById(R.id.course_schedule_now_textView);

        mCourseNameTextView.setText(courseName);
        mSchoolTextView.setText(courseSchoolName);
        mBeginEndTextView.setText(scheduleBeginEnd);
        mScheduleNowView.setText(scheduleNow);


    }

    private int getImg(int index) {
        switch (index) {
            case 0:
                return R.drawable.course_pic_1;
            case 1:
                return R.drawable.course_pic_2;
            case 2:
                return R.drawable.course_pic_3;
            case 3:
                return R.drawable.course_pic_4;
            case 4:
                return R.drawable.course_pic_5;
            case 5:
                return R.drawable.course_pic_6;
            case 6:
                return R.drawable.course_pic_7;
            case 7:
                return R.drawable.course_pic_8;
            case 8:
                return R.drawable.course_pic_9;
            case 9:
                return R.drawable.course_pic_10;

            default:
                return -1;
        }
    }

}
