package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CourseSyllabusItemLayout extends FrameLayout {

    public static final int NO_LINE = 0;
    public static final int DIVIDE_LINE = 1;
    public static final int DIVIDE_AREA = 2;
    public int divideLineStyle = NO_LINE;

    private Context mContext;
    private View mView;
    private TextView syllabusTitleTextView;
    private TextView syllabusContentTextView;
    private ImageButton seeMoreBtn;

    public CourseSyllabusItemLayout(Context context) {
        this(context, null);
    }

    public CourseSyllabusItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CourseSyllabusItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.item_course_syllabus_layout, this, true);
        syllabusTitleTextView = (TextView) mView.findViewById(R.id.syllabusTitleTextView);
        syllabusContentTextView = (TextView) mView.findViewById(R.id.syllabusContentTextView);
        seeMoreBtn = mView.findViewById(R.id.SeeMoreButton);


        seeMoreBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams linearParams =  mView.findViewById(R.id.fuckme).getLayoutParams();
                linearParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;

                mView.findViewById(R.id.fuckme).setLayoutParams(linearParams);
                seeMoreBtn.setVisibility(INVISIBLE);
            }
        });


    }


}
