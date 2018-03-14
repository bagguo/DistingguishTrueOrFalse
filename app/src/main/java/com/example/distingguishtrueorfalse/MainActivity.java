package com.example.distingguishtrueorfalse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton;
    private RecyclerView mRecyclerView;
    private WebView webView1,webView2,webView3;
    private String searchUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.edit_text);
        mButton = (Button) findViewById(R.id.button);
//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(layoutManager);
//        FruitAdapter adapter = new FruitAdapter(fruitList);
//        mRecyclerView.setAdapter(adapter);
        webView1=  (WebView) findViewById(R.id.webView1);
        webView2= (WebView) findViewById(R.id.webView2);
        webView3= (WebView) findViewById(R.id.webView3);

        Editable word = mEditText.getText();
        /**
         * 分词搜索
         */
        String searchKey=null;
        for (int i = 0; i < word.length(); i++) {

            searchKey= word.subSequence(i, i+2).toString();
        }
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
//        searchUrl = "http://baidu.mobi/s?from=1429b&word=" + "大风";
        String searchUrl2 = "http://baidu.mobi/s?from=1429b&word=" + "天空";
        String searchUrl3 = "http://baidu.mobi/s?from=1429b&word=" + "白云";
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {//文字
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (sharedText != null) {
                    searchUrl = "http://baidu.mobi/s?from=1429b&word=" + sharedText;

                }
                }
            }

        WebSettings webSettings= webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView1.loadUrl(searchUrl);
       webView1.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });

         WebSettings webSettings2= webView2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView2.loadUrl(searchUrl2);
        webView2.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });

         WebSettings webSettings3= webView3.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView3.loadUrl(searchUrl3);
        webView3.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });


    }
}
