package android.diego.appsrappi.service;

import android.diego.appsrappi.service.responses.ResponseApps;

import retrofit.Call;

/**
 * Created by Diego on 6/3/2016.
 */
public class PublicService {

    private ApiService apiService;

    public PublicService(ApiService apiService) {
        this.apiService = apiService;

    }

    /**
     * Get json feed.
     */
    public Call<ResponseApps> getFeed() {
        return apiService.getApps();
    }
}
