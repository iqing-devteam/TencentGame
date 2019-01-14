package in.iqing.tencentgame.net;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adam on 2017/4/6.
 */

public class HttpFactory {
    private static OkHttpClient sClient;
    private static Gson sGson;
    private static ApiService service;
    private static ApiService testService;
    private static Retrofit mRetrofit;
    private static Retrofit mTestRetrofit;

    static {
        /**组装okhttp**/
        final OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(GlobalConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(GlobalConfig.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(GlobalConfig.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        builder.addInterceptor(new LogInterceptor());
        builder.addInterceptor(new IQingHeaderInterceptor());
        sClient = builder
                .build();

        /**组装gson**/
        sGson = new GsonBuilder()
                .setDateFormat(GlobalConfig.GSON_DATEFORMAT)
                .create();
        /**组装Retrofit**/
        mRetrofit = new Retrofit.Builder()
                .baseUrl(GlobalConfig.SERVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(sGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(sClient).build();

        mTestRetrofit = new Retrofit.Builder()
                .baseUrl(GlobalConfig.SERVER_TEST_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(sGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(sClient).build();
    }

    public HttpFactory() {
    }


    public static ApiService getApiService() {
        if (service == null) {
            service = mRetrofit.create(ApiService.class);
        }
        return service;
    }
}
