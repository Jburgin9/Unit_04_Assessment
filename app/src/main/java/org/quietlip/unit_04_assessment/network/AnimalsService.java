package org.quietlip.unit_04_assessment.network;

import org.quietlip.unit_04_assessment.model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimalsService {
    @GET("JDVila/storybook/master/echinoderms.json")
    Call<JSONResponse> getAnimals();
}
