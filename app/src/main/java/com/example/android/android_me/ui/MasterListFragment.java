package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


public class MasterListFragment extends Fragment {
    public MasterListFragment() {
    }

    OnItemImageClickListener mCallBack;

    public interface OnItemImageClickListener {
        void onItemClickImage(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallBack = (OnItemImageClickListener) context;
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + "must implement " +
                    "OnItemImageClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);

        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView = (GridView) view.findViewById(R.id.images_grid_view);
        // Create the adapter
        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        // Set the adapter on the GridView
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallBack.onItemClickImage(position);
            }
        });

        return view;
    }
}
