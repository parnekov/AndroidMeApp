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

import java.util.ArrayList;
import java.util.List;


public class BodyItemFragment extends Fragment {

    private static final String TAG = "BodyItemFragment";

    private static final String ARRAY_IDS = "arrayIds";
    private static final String INDEX_INT = "indexInt";

    private List<Integer> mIntegerList;
    private int mIntIndex;


    public BodyItemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mIntegerList = savedInstanceState.getIntegerArrayList(ARRAY_IDS);
            mIntIndex = savedInstanceState.getInt(INDEX_INT);
        }
        // inflate fragment layout
        View rootV = inflater.inflate(R.layout.body_image_view_layout, container, false);

        // get a reference for ImageView
        final ImageView imageView = (ImageView) rootV.findViewById(R.id.body_image_view_id);


        // set image for display
        if (mIntegerList != null) {
            imageView.setImageResource(mIntegerList.get(mIntIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mIntIndex < mIntegerList.size() - 1) {
                        mIntIndex++;
                    } else {
                        mIntIndex = 0;
                    }
                    imageView.setImageResource(mIntegerList.get(mIntIndex));
                }

            });

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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(ARRAY_IDS, (ArrayList<Integer>) mIntegerList);
        outState.putInt(INDEX_INT, mIntIndex);
    }
}
