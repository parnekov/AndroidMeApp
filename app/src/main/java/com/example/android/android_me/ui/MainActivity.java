package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnItemImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legsIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemClickImage(int position) {
        Toast.makeText(this, "Position " + position, Toast.LENGTH_SHORT).show();

        // Dividing by 12 gives us these integer values because each list of images resources has a size of 12
        int bodyPartNumber = position / 12;

        // Store the correct list index no matter where in the image list has been clicked
        // This ensures that the index will always be a value between 0-11
        int listIndex = position - 12 * bodyPartNumber;

        // Set the currently displayed item for the correct body part fragment
        switch (bodyPartNumber) {
            case 0:
                headIndex = listIndex;
                break;
            case 1:
                bodyIndex = listIndex;
                break;
            case 2:
                legsIndex = listIndex;
            default:
                break;
        }

        // Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        Bundle bundle = new Bundle();
        bundle.putInt("headIndex", headIndex);
        bundle.putInt("bodyIndex", bodyIndex);
        bundle.putInt("legsIndex", legsIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);

        Button button = (Button) findViewById(R.id.button_new_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }
}
