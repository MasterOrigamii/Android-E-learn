package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.myapplication.adapter.CourseVideoMuiltAdapter;
import com.example.myapplication.bean.CourseListBean;
import com.example.myapplication.bean.Coursevideo;
import com.example.myapplication.utlis.BaseUrl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

import butterknife.BindView;


public class MultiMediaActivity extends BaseActivity {

    @BindView(R.id.myrecycleView)
    RecyclerView recycleView;

    @BindView(R.id.serachview)
    androidx.appcompat.widget.SearchView searchView;
    private CourseVideoMuiltAdapter adapter;
    private CourseListBean courseListBean;
    private List<Coursevideo> list;

    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
        //overridePendingTransition(R.anim.fade_in, 0);
        return R.layout.activity_multi_media;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

        //显示搜索框控件
        searchView = findViewById(R.id.serachview);
        //设置查询提示字符串
        searchView.setQueryHint("请输入搜索内容");
        //设置搜索图标是否显示在搜索框内
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                getDatas(query);
                recycleView.setAdapter(adapter);
                return false;
            }

            //当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });


        courseListBean = (CourseListBean) getIntent().getSerializableExtra("list");

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);

        recycleView.setItemAnimator(new DefaultItemAnimator());
        adapter = new CourseVideoMuiltAdapter();
        recycleView.setAdapter(adapter);

        recycleView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.cardView1) {
                    switch (list.get(position).getMediatype()) {
                        case "video":
                        case "audio":
                            Intent intent = new Intent(MultiMediaActivity.this, PlayVideoActivity.class);
                            intent.putExtra("list", list.get(position));
                            startActivity(intent);
                            break;
                        case "image":
                        case "pdf":
                            Intent intent1 = new Intent(MultiMediaActivity.this, ImageOrPdfActivity.class);
                            intent1.putExtra("list", list.get(position));
                            startActivity(intent1);
                            break;
                    }
                }
            }
        });

        if (courseListBean != null) {
//            TextView header = new TextView(this);
//            header.setLineSpacing(1.6f, 1.6f);
//            header.setPadding(20, 20, 20, 20);
//            header.setTextSize(22);
//            header.setText("Course Description:" + courseListBean.getDescription());
//            adapter.addHeaderView(header);

            getDatas(courseListBean.getId());
        }

        findViewById(R.id.share).setOnClickListener(view ->
                shareText(courseListBean.getDescription()));
    }

    /**
     * 分享文本
     */
    private void shareText(String content) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);
        //切记需要使用Intent.createChooser，否则会出现别样的应用选择框，您可以试试
        shareIntent = Intent.createChooser(shareIntent, "Here is the title of Select box");
        startActivity(shareIntent);
    }

    private void getDatas(String courseId) {

        OkGo.<String>get(BaseUrl.baseUrl + "courses/" + courseId + "/materials")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        list = gson.fromJson(response.body(), new TypeToken<List<Coursevideo>>() {
                        }.getType());
                        adapter.setNewData(list);
                    }
                });

    }


}
