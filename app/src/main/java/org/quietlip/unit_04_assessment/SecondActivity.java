package org.quietlip.unit_04_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {
    private DetailFragment detailFragment;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


//        detailFragment = DetailFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .commit();

    }

    @Override
    public void onFragmentInteraction(String website) {

    }
}
