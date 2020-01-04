package com.example.myapplication.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.TeacherBean;
import com.example.myapplication.utlis.BaseUrl;


public class TeacherAdapter extends BaseQuickAdapter<TeacherBean, BaseViewHolder> {

    public TeacherAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    protected void convert(BaseViewHolder helper, TeacherBean item) {

        TextView teacher_name = helper.getView(R.id.teacher_name);
        TextView teacher_phone = helper.getView(R.id.teacher_phone);
        TextView email = helper.getView(R.id.email);
        TextView descrip = helper.getView(R.id.descrip);
        ImageView image = helper.getView(R.id.image);

        teacher_name.setText(item.getName());
        teacher_phone.setText(item.getTelephone());
        email.setText(item.getEmail());
        descrip.setText(item.getDescription());

        Glide.with(mContext).load(BaseUrl.baseImage+item.getPhoto()).into(image);

        helper.addOnClickListener(R.id.cardView1);

    }
}
