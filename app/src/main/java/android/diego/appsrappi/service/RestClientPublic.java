package android.diego.appsrappi.service;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Diego on 6/3/2016.
 */
public class RestClientPublic {

    private static String BASE_URL = "https://itunes.apple.com/";
    private ApiService apiService;
    private PublicService publicService;

    public RestClientPublic() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();


        this.apiService = retrofit.create(ApiService.class);
        this.publicService = new PublicService(getApiService());
    }

    private ApiService getApiService() {
        return this.apiService;
    }

    public PublicService getPublicService() {
        return this.publicService;
    }

    private OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient();

        return client;
    }
}
