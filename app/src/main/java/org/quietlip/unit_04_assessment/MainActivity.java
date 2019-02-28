package org.quietlip.unit_04_assessment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.quietlip.unit_04_assessment.controller.RecyclerViewAdapter;
import org.quietlip.unit_04_assessment.model.JSONResponse;
import org.quietlip.unit_04_assessment.network.AnimalsService;
import org.quietlip.unit_04_assessment.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "PROUD";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonResponse();

        recyclerView = findViewById(R.id.animals_recycler_view);


    }

    private void jsonResponse() {
        RetrofitSingleton.getOurInstance().create(AnimalsService.class).getAnimals()
                .enqueue(new Callback<JSONResponse>() {
                    @Override
                    public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                        Log.d(TAG, "onResponse: get that!" + response.body().getStatus());
                        recyclerView.setAdapter(new RecyclerViewAdapter(response.body().getMessage()));
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }

                    @Override
                    public void onFailure(Call<JSONResponse> call, Throwable t) {

                    }
                });
    }
}
