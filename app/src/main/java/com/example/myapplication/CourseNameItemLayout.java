package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class CourseNameItemLayout extends FrameLayout {
    private Context mContext;
    private View mView;
    private TextView schoolTv;
    private TextView titleTv;
    private TextView hintTv;
    private ImageView redHintImg;
    private ImageView iconImg;
    private OnClickListener onClickListener;
    private String titleText;
    private String hintText;
    private String schoolName;
    private String iconImgUri;
    private String jumpUrl;
    private int iconImgId;
    private String onclickId;
    public static final int NO_LINE = 0;
    public static final int DIVIDE_LINE = 1;
    public static final int DIVIDE_AREA = 2;
    public int divideLineStyle = NO_LINE;
    private boolean isShowRedHintImg = false;

    public int getIconImgId() {
        return iconImgId;
    }

    /**
     * 设置开课学校名称
     * @param schoolName
     */
    public void setSchoolName(String schoolName){
        if (schoolName!=null)
        this.schoolName = schoolName;
        schoolTv.setText(schoolName);
    }

    public void setIconImgId(int iconImgId) {
        if (iconImgId != 10000) {
            this.iconImgId = iconImgId;
            iconImg.setImageResource(iconImgId);
        }
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        if (titleText != null) {
            this.titleText = titleText;
            titleTv.setText(titleText);
        }
    }

    public String getHintText() {
        return hintText;
    }

    public void setHintText(String hintText) {
        if (hintText != null) {
            this.hintText = hintText;
            hintTv.setText(hintText);
        }
    }

    public boolean isShowRedHintImg() {
        return isShowRedHintImg;
    }

    public void setShowRedHintImg(boolean showRedHintImg) {
        isShowRedHintImg = showRedHintImg;
        redHintImg.setVisibility(showRedHintImg ? VISIBLE : GONE);
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        if (jumpUrl != null) {
            this.jumpUrl = jumpUrl;
        }
    }

    public String getOnclickId() {
        return onclickId;
    }

    public void setOnclickId(String onclickId) {
        this.onclickId = onclickId;
    }

    public CourseNameItemLayout(Context context) {
        this(context, null);
    }

    public CourseNameItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CourseNameItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.item_course_name, this, true);
        schoolTv = (TextView) mView.findViewById(R.id.universitytextView);
        titleTv = (TextView) mView.findViewById(R.id.courseNameTextView);
        hintTv = (TextView) mView.findViewById(R.id.menu_item_text_hint);
        iconImg = (ImageView) mView.findViewById(R.id.menu_item_icon_img);
        redHintImg = (ImageView) mView.findViewById(R.id.menu_item_red_hint);

        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.CourseNameItemLayout);
        setSchoolName(a.getString(R.styleable.CourseNameItemLayout_c_school_text));
        setTitleText(a.getString(R.styleable.CourseNameItemLayout_c_title_text));
        setHintText(a.getString(R.styleable.CourseNameItemLayout_c_hint_text));
        setIconImgId(a.getResourceId(R.styleable.CourseNameItemLayout_c_icon_reference, 10000));
        setJumpUrl(a.getString(R.styleable.CourseNameItemLayout_c_jump_url));
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

    public void setViewOnlickListener(OnClickListener onlickListener) {
        this.onClickListener = onlickListener;
        mView.setOnClickListener(onlickListener);
    }

    public TextView getTitleTv() {
        return titleTv;
    }

    public TextView getHintTv() {
        return hintTv;
    }
}