package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class BodyItemFragment extends Fragment {

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
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        return rootV;
    }
}
