package in.iqing.tencentgame.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import in.iqing.tencentgame.R;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String baseURL = "http://tencent-quin.iqing.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.wb);

        getToken();
        init();
    }

    private void getToken() {
        //"http://tencent-quin.iqing.com/index.html?gid=15&token="+"2b8f2e3e0d0373617f262888516b22a31ee91d68"+"from=webview"

//        HttpFactory.getApiService().getTencentToken("tencent_uname","tencent_token","tencent_sign",1)
//                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableSubscriber<GameToken>() {
//            @Override
//            public void onNext(GameToken gameToken) {
//                演会入口地址
                webView.loadUrl("http://tencent-marisa.iqing.com/index.html?gid=1&token="+"2b8f2e3e0d0373617f262888516b22a31ee91d68"+"from=webview");
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }


    private void init(){
        webView.addJavascriptInterface(new JsOperation(), "client");
        webView.setWebViewClient(new WebViewClient());
        setWalkView();
    }

    private void setWalkView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setAllowUniversalAccessFromFileURLs(true);
    }



    class JsOperation {

        @JavascriptInterface
        public void backToApp() {
            webView.post(new Runnable() {
                @Override
                public void run() {
                    onBackPressed();
                }
            });
        }

    }


    @Override
    protected void onResume() {
        jsOnActive();
        super.onResume();
    }

    @Override
    protected void onPause() {
        jsOnDeactivate();
        super.onPause();
    }

    private void jsOnActive(){
        webView.loadUrl("javascript:onActive()");
    }


    private void jsOnDeactivate(){
        webView.loadUrl("javascript:onActive()");
    }
}
