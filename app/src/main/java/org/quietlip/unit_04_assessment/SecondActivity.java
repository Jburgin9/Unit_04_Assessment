package org.quietlip.unit_04_assessment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {
    private DetailFragment detailFragment;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        intent = getIntent();

        detailFragment = DetailFragment.newInstance(intent.getStringExtra("name"), intent.getStringExtra("link"), intent.getStringExtra("image"));

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .commit();

    }

    @Override
    public void onFragmentInteraction(String website) {
//    intent.getStringExtra("name");
    }
}
