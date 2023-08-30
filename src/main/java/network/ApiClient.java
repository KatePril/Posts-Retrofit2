package network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import utils.Constants;

public class ApiClient {

    public ApiService getService() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.DATA_URL).client(httpClient.build()).build();

        return retrofit.create(ApiService.class);
    }
}
