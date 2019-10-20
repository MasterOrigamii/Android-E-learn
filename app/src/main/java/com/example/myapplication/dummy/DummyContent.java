package com.example.myapplication.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 10;

    public static final String courseName[] = new String[]{
            "微积分","大学物理","商务英语","马克思原理","微积分",
            "线性代数","Java程序编写","安卓移动应用开发","C语言基础","用户界面设计"
    };

    public static final String schoolName[] = new String[]{
            "北京交通大学","北京大学","清华大学","上海交通大学","复旦大学",
            "浙江大学","香港大学","北京科技大学","武汉大学","北京航空航天大学"
    };

    public static final String beginEnd[] = new String[]{

    };

    public static final String scheduleNow[] = new String[]{

    };

    public static final Boolean niceCourse[] = new Boolean[]{
            Boolean.TRUE,Boolean.FALSE,Boolean.TRUE,Boolean.FALSE,Boolean.TRUE,
            Boolean.FALSE,Boolean.TRUE,Boolean.FALSE,Boolean.TRUE,Boolean.FALSE,
    };

    static {
        // Add some sample items.
        for (int i = 0; i < COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * 填充一项数据
     * @param position
     * @return
     */
    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), makeCourseName(position), makeDetails(position), makeBeginEnd(position), makeScheduleNow(position), makeNiceCourse(position), makeNumberOfJoin(position));
    }


    private static String makeCourseName(int position){
        return courseName[position];
    }


    private static String makeDetails(int position) { return schoolName[position]; }


    private static String makeBeginEnd(int position){
        return "2019-9-20 至 2019-12-20";
    }

    private static Boolean makeNiceCourse(int position){
        return niceCourse[position];
    }


    private static int makeNumberOfJoin(int position){
        Random random = new Random();//默认构造方法
        int numberOfJoin = random.nextInt(1000);
        return numberOfJoin;
    }



    private static String makeScheduleNow(int position) { return "进行至第5周，共14周"; }


    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String courseName;
        public final String courseSchoolName;
        public final String scheduleBeginEnd;
        public final String scheduleNow;
        public final Boolean niceCourse;
        public final int numberOfJoin;

        public DummyItem(String id, String courseName, String details, String scheduleBeginEnd, String scheduleNow, Boolean niceCourse, int numberOfJoin) {
            this.id = id;
            this.courseName = courseName;
            this.courseSchoolName = details;
            this.scheduleBeginEnd = scheduleBeginEnd;
            this.scheduleNow = scheduleNow;
            this.niceCourse = niceCourse;
            this.numberOfJoin = numberOfJoin;

        }

        @Override
        public String toString() {
            return courseName;
        }
    }
}
