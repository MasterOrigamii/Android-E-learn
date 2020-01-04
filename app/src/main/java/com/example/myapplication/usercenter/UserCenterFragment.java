package com.example.myapplication.usercenter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.CourseListFragment;
import com.example.myapplication.R;
import com.example.myapplication.dummy.DummyContent.DummyItem;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class UserCenterFragment extends Fragment {


    private ImageView blurImageView;
    private ImageView avatarImageView;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserCenterFragment() {
    }




    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CourseListFragment newInstance(int columnCount) {
        CourseListFragment fragment = new CourseListFragment();
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





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_center, container, false);


        Context context = view.getContext();

        blurImageView = view.findViewById(R.id.iv_blur);
        avatarImageView = view.findViewById(R.id.iv_avatar);


        Glide.with(this).load(R.drawable.course_pic_9).into(blurImageView);
        blurImageView.setBackgroundColor(Color.BLACK);
        blurImageView.setImageAlpha(50);
        Glide.with(this).load(R.drawable.head).into(avatarImageView);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
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
//        mListener = null;
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
}
