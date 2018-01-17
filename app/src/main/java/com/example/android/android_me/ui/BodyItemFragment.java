package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;


public class BodyItemFragment extends Fragment {

    private static final String TAG = "BodyItemFragment";

    private List<Integer> mIntegerList;
    private int mIntIndex;


    public BodyItemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate fragment layout
        View rootV = inflater.inflate(R.layout.body_image_view_layout, container, false);

        // get a reference for ImageView
        ImageView imageView = (ImageView) rootV.findViewById(R.id.body_image_view_id);


        // set image for display
        if (mIntegerList != null) {
            imageView.setImageResource(mIntegerList.get(mIntIndex));
        } else {
            Log.v(TAG, "This fragment has a null list of image id's");
        }

        return rootV;
    }

    public void setIntegerList(List<Integer> integerList) {
        mIntegerList = integerList;
    }

    public void setIntIndex(int intIndex) {
        mIntIndex = intIndex;
    }
}
