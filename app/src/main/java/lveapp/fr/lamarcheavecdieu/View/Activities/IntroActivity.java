package lveapp.fr.lamarcheavecdieu.View.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;

import lveapp.fr.lamarcheavecdieu.Presenter.IntroPresenter;
import lveapp.fr.lamarcheavecdieu.R;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.IntroInterface.IIntroActivity;

public class IntroActivity extends Activity implements IIntroActivity{

    private CountDownTimer downTimer;
    private WebView webView;
    private IntroPresenter introPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);
        // Loading presenter data
        introPresenter = new IntroPresenter(this);
        introPresenter.loadIntroData(IntroActivity.this);
    }

    @Override
    public void findWidgetsAndSetEvents() {
        webView = findViewById(R.id.webView);
    }

    @Override
    public void displayImageToWebView() {
        String html = "<html><head><title>Image</title></head>";
        html += "<body style=\"margin: 0; padding: 0;\"><img style=\"width: 100%;\" src=\"background_intro.jpg\"></body></html>";
        webView.loadDataWithBaseURL("file:///android_res/mipmap/", html, "text/html", "UTF-8", null);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setInitialScale(1);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportZoom(true);
        webView.setBackgroundColor(0x00000000);
        if (Build.VERSION.SDK_INT >= 11){
            webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        }
    }

    @Override
    public void showHomeActivity() {
        downTimer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {}

            @Override
            public void onFinish() {
                Intent intent = new Intent(IntroActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        introPresenter.cancelDownTimer(downTimer);
        super.onBackPressed();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            if (hasFocus) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
    }
}
