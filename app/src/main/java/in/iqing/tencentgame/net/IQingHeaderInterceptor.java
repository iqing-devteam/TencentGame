package in.iqing.tencentgame.net;

import android.os.Build;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class IQingHeaderInterceptor implements Interceptor {
    private final Charset charset = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original.newBuilder()
//                .header("AppVersion", "v3")
//                .header("System", "android")
//                .header("Version", Build.MODEL + ","
//                        + Build.VERSION.SDK_INT + ","
//                        + Build.VERSION.RELEASE)
//                .header("GUID", Build.SERIAL)
//                .header("Build", BuildConfig.VERSION_CODE + "")
//                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);
    }
}
