package forecast.itpvt.com.forecast;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    TextView tvNoInternet;
    ImageView ivNoInternet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        ivNoInternet = (ImageView) findViewById(R.id.ivNoNet);



        tvNoInternet= (TextView) findViewById(R.id.tvInternet);


        if (isNetworkAvailable()){

            ivNoInternet.setVisibility(View.GONE);
            tvNoInternet.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);


            webView.setWebViewClient(new WebViewClient());

            webView.loadUrl("http://forecast.com.pk");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // chromium, enable hardware acceleration
                webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            } else {
                // older android version, disable hardware acceleration
                webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }



        }
        if (!isNetworkAvailable()){

            webView.setVisibility(View.GONE);
            ivNoInternet.setVisibility(View.VISIBLE);
            tvNoInternet.setVisibility(View.VISIBLE);


        }








//        WebView webview = new WebView(this);
//        webview.loadUrl("http://forecast.com.pk");
//        setContentView(webview);



    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
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


}
