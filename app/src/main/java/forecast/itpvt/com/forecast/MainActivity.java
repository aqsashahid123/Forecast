package forecast.itpvt.com.forecast;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    TextView tvNoInternet;
    ImageView ivNoInternet;
    private ProgressBar progress;
    String url;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        //  progress=(ProgressBar)findViewById(R.id.progressBar);
        ivNoInternet = (ImageView) findViewById(R.id.ivNoNet);
        Intent intent = getIntent();
        url = intent.getStringExtra("URL");
        tvNoInternet = (TextView) findViewById(R.id.tvInternet);


//         dialog = ProgressDialog.show(MainActivity.this, "Loading", "Please wait...",
//                true);
//         dialog.setMessage("please wait");
//
//        dialog.show();
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                dialog.dismiss();
//            }
//        }, 20000);
//        dialog.dismiss();
//

        if (isNetworkAvailable()) {

            ivNoInternet.setVisibility(View.GONE);
            tvNoInternet.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
//            progress.setVisibility(View.VISIBLE);


            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);


            webView.setWebViewClient(new WebViewClient());

            webView.loadUrl(url);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // chromium, enable hardware acceleration
                webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            } else {
                // older android version, disable hardware acceleration
                webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }




//            WebSettings webSettings = webView.getSettings();
//            webSettings.setJavaScriptEnabled(true);
//            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
//            webView.loadUrl(url);
        //    webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
         //   webSettings.setPluginState(WebSettings.PluginState.ON);
//            webSettings.setAppCacheMaxSize(5 * 1048576);
//            webSettings.setAppCacheEnabled(true);
            //webView.setWebChromeClient(new WebChromeClient());// opens links inside same chrome webview
          //  webView.setWebViewClient(new WebViewClient());
//            webView.setWebViewClient(new WebViewClient() {
//                @Override
//                public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                    super.onPageStarted(view, url, favicon);
//                    // progress.setVisibility(View.VISIBLE);
//                    //    setTitle("Loading....");
//                }
//
//                @Override
//                public void onPageFinished(WebView view, String url) {
//                    super.onPageFinished(view, url);
//                    //  progress.setVisibility(View.GONE);
//                    // setTitle(view.getTitle());
//                }
//            });


           // webView.setWebViewClient(new webCont());




//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                // chromium, enable hardware acceleration
//                webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//            } else {
//                // older android version, disable hardware acceleration
//                webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//            }


        }
        if (!isNetworkAvailable()) {

            webView.setVisibility(View.GONE);
            progress.setVisibility(View.GONE);
            ivNoInternet.setVisibility(View.VISIBLE);
            tvNoInternet.setVisibility(View.VISIBLE);


        }


//        WebView webview = new WebView(this);
//        webview.loadUrl("http://forecast.com.pk");
//        setContentView(webview);


    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }


    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    ////////////////////////////////////////////////////////////////////////
//
//    class webCont extends WebViewClient {
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            // TODO Auto-generated method stub
//            view.loadUrl(url);
//
//            return true;
//        }
//            @Override
//            public void onPageFinished (WebView view, String url){
//                super.onPageFinished(view, url);
//
//                //Hide Progress bar.
//
//              //  hideProgressLayout();
//            }
//
//            @Override
//            public void onReceivedError (WebView view,int errorCode, String description, String
//            failingUrl){
//                //If any error comes this method will handle for webview.
//
//               // hideProgressLayout();
//
//                if (view.canGoBack()) {
//                    view.goBack();
//                }
//
//                //  You can write your own Dialog or Toast message if you want to show error message
//            }
//
//
//
//    }
}