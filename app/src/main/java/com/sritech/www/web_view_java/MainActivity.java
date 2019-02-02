package com.sritech.www.web_view_java;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public WebView webView;
    private EditText edturl;
    private Button search,facebook,youtube,google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       search=findViewById(R.id.search);
       facebook=findViewById(R.id.facebook);
       youtube=findViewById(R.id.youtube);
       webView=findViewById(R.id.webview);

       google=findViewById(R.id.google);
       edturl=findViewById(R.id.weburl);

        final ProgressDialog pdialog=new ProgressDialog(this);
        pdialog.setTitle("message");
        pdialog.setMessage("Please wait ...");

       webView.setWebViewClient(new WebViewClient(){
           @Override
           public void onPageStarted(WebView view, String url, Bitmap favicon) {
               super.onPageStarted(view, url, favicon);
               pdialog.show();
           }

           @Override
           public void onPageFinished(WebView view, String url) {
               super.onPageFinished(view, url);
               pdialog.dismiss();
           }
       });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDisplayZoomControls(true);

       search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               webView.loadUrl(edturl.getText().toString());
           }
       });

       facebook.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               webView.loadUrl("http://www.facebook.com");
           }
       });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://www.youtube.com");
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://www.google.com");
            }
        });


    }

}
