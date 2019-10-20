package com.example.myapplication;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.CourseListFragment.OnListFragmentInteractionListener;
import com.example.myapplication.dummy.DummyContent.DummyItem;
import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    String[] items;
    String[] prices;
    String[] descriptions;
    Context mContext;


    public MyItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);


        mContext = parent.getContext();

        return new ViewHolder(view);
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

    public static Bitmap zoomBitmap(Bitmap bitmap, int w, int h){
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) w / width);
        float scaleHeight = ((float) h / height);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newBmp = Bitmap.createBitmap(bitmap, 0, 0, width, height,
                matrix, true);
        return newBmp;
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final int mPosition = position;
        final AppCompatImageView imageView = holder.coursePicImageView;

        //使用bitmap 时间过长无法加载全部 固换为直接设置Background
        {
//        ViewTreeObserver vto2 = imageView.getViewTreeObserver();
//        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                //从列表中定位一项
//                holder.mItem = mValues.get(mPosition);
//
//                holder.CourseNameTextView.setText(holder.mItem.courseName);
//                holder.CourseSchoolTextView.setText(holder.mItem.courseSchoolName);
//
//                int pic = getImg(mPosition);
//                if (pic != -1) {
//                   // Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), pic);
//
////                    Bitmap new_bitmap = zoomBitmap(bitmap, imageView.getWidth(), imageView.getHeight());
////                    holder.coursePicImageView.setImageBitmap(new_bitmap);
//                    holder.coursePicImageView.setBackgroundResource(pic);
//
//                }
//            }   });
        }

                        //从列表中定位一项
                holder.mItem = mValues.get(mPosition);


                //若不是精品课程则隐藏精品课程标志
                if(!holder.mItem.niceCourse) holder.NiceCourseImageView.setVisibility(View.INVISIBLE);

                //填充文字信息
                holder.CourseNameTextView.setText(holder.mItem.courseName);
                holder.CourseSchoolTextView.setText(holder.mItem.courseSchoolName);
                holder.numberOfJoinTextView.setText(holder.mItem.numberOfJoin+"");


                int pic = getImg(mPosition);
                if (pic != -1) {

                    holder.coursePicImageView.setBackgroundResource(pic);

                }

        /**
         * 给课程列表视图设置监听器
         */
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        //public final TextView mContentView;
        public DummyItem mItem;

        public final TextView CourseNameTextView;
        public final TextView CourseSchoolTextView;

        public final AppCompatImageView coursePicImageView;
        public final AppCompatImageView NiceCourseImageView;
        public final TextView numberOfJoinTextView;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);

            coursePicImageView = view.findViewById(R.id.coursePicImageView);



            CourseNameTextView = view.findViewById(R.id.CourseNameTextView);
            CourseSchoolTextView = view.findViewById(R.id.CourseDetailTextView);

            NiceCourseImageView = view.findViewById(R.id.NiceCourse);
            numberOfJoinTextView = view.findViewById(R.id.numberOfJoinTextView);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
