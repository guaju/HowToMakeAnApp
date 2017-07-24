package com.guaju.androidh5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private WebView wv;
    String url1 = "https://www.baidu.com";
    String url2 = "https://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        wv = (WebView) findViewById(R.id.wv);
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
        wv.loadUrl(url1);
        wv.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//                DialogUtils.showUpdateDialog(MainActivity.this, "加载中", "请稍后。。。");
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                DialogUtils.hideDialog();
//            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(MainActivity.this, "网页加载错误，请稍后重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }

            //            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return true;
//            }


            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                WebResourceResponse response = null;
                if (url.contains("logo")) {
                    try {
                        InputStream open = getAssets().open("ic_launcher.png");
                        response = new WebResourceResponse("image/png", "UTF-8", open);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                return response;
            }


        });
        wv.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);  //此句话没有什么界面效果
                setTitle("页面加载中，当前进度"+newProgress+"%");
//                setProgress(newProgress*100);

                if (newProgress==100){
                    setTitle("baidu");
                }
            }
        });

    }
}
