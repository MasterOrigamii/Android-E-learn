package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class CourseScheduleOverallLayout extends FrameLayout {

    public static final int NO_LINE = 0;
    public static final int DIVIDE_LINE = 1;
    public static final int DIVIDE_AREA = 2;
    public int divideLineStyle = NO_LINE;

    private Context mContext;
    private View mView;
    private TextView begin_end;
    private TextView now;

    public CourseScheduleOverallLayout(Context context) {
        this(context, null);
    }

    public CourseScheduleOverallLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CourseScheduleOverallLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.item_schedule_overall, this, true);
        begin_end = (TextView) mView.findViewById(R.id.course_schedule_beginEnd_textView);
        now = (TextView) mView.findViewById(R.id.course_schedule_now_textView);


        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CourseNameItemLayout);

        divideLineStyle = a.getInt(R.styleable.CourseNameItemLayout_c_divide_line_style, NO_LINE);
        setDivideLine(divideLineStyle);
    }

    public void setDivideLine(int bootomLineStyle) {
        View lineView = findViewById(R.id.divide_line_view);
        View areaView = findViewById(R.id.divide_area_view);
        lineView.setVisibility(GONE);
        areaView.setVisibility(GONE);
        if (bootomLineStyle == DIVIDE_LINE) {
            lineView.setVisibility(VISIBLE);
        } else if (bootomLineStyle == DIVIDE_AREA) {
            areaView.setVisibility(VISIBLE);
        }
    }
}

