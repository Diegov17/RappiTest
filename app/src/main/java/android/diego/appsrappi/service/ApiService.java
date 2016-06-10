package android.diego.appsrappi.service;

import android.diego.appsrappi.service.responses.ResponseApps;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Diego on 6/3/2016.
 */
public interface ApiService {

    @GET("us/rss/topfreeapplications/limit=20/json")
    Call<ResponseApps> getApps();
}
