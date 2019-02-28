package org.quietlip.unit_04_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        detailFragment = new DetailFragment();
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, detailFragment)
//                .commit();

    }
}
