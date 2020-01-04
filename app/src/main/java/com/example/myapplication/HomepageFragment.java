package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.myapplication.adapter.TeacherAdapter;
import com.example.myapplication.bean.TeacherBean;
import com.example.myapplication.dummy.DummyContent.DummyItem;


import com.example.myapplication.utlis.BaseUrl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;



import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class HomepageFragment extends Fragment {

    public static HomepageFragment newInstance() {
        return new HomepageFragment();
    }


    private TeacherAdapter adapter;
    private ArrayList<TeacherBean> list;



    @BindView(R.id.banner2)
    BannerLayout bannerLayout2;


    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public HomepageFragment() {
    }




    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static HomepageFragment newInstance(int columnCount) {
        HomepageFragment fragment = new HomepageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }



        adapter = new TeacherAdapter(R.layout.item_teacher_list);
        getDatas();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);


        List<String> urls = new ArrayList<>();
        urls.add(BaseUrl.baseImage + "001/course_pic_1.jpg");
        urls.add(BaseUrl.baseImage + "001/course_pic_1.jpg");
        urls.add(BaseUrl.baseImage + "001/course_pic_1.jpg");
        urls.add(BaseUrl.baseImage + "001/course_pic_1.jpg");

        List<String> titleas = new ArrayList<>();
        titleas.add("标题一");
        titleas.add("标题二");
        titleas.add("标题三");
        titleas.add("标题四");

        bannerLayout2 = view.findViewById(R.id.banner2);


        RecyclerView recycleView;
        recycleView = view.findViewById(R.id.recycleView);
        if (bannerLayout2 != null) {

            bannerLayout2.setViewUrls(view.getContext(),urls, titleas);
            bannerLayout2.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    //Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);

        recycleView.setItemAnimator(new DefaultItemAnimator());
        adapter = new TeacherAdapter(R.layout.item_teacher_list);
        recycleView.setAdapter(adapter);

        recycleView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.cardView1:
                        Intent intent = new Intent(getActivity(), com.example.myapplication.mvvm.MVVMKotlinTeachDetailActivity.class);
                        intent.putExtra("teacherId", list.get(position).getUserid());
                        //Bundle options = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
                        startActivity(intent);
                        break;
                }
            }
        });

        getDatas();

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//          //  mListener = (OnListFragmentInteractionListener) context;
//
//
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {


        // TODO: Update argument type and name

        /**
         * 接受到来自ViewHolder的监听点击事件
         * @param item
         */
        void onListFragmentInteraction(DummyItem item);
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            getDatas();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    private void getDatas() {

        OkGo.<String>get(BaseUrl.baseUrl + "teachers")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("hedb", "onSuccess: " + response.body());
                        Gson gson = new Gson();
                        list = gson.fromJson(response.body(), new TypeToken<List<TeacherBean>>() {
                        }.getType());
                        adapter.setNewData(list);
                    }
                });

    }
}
