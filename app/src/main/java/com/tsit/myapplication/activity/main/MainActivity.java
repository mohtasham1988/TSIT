package com.tsit.myapplication.activity.main;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tsit.myapplication.R;
import com.tsit.myapplication.fragment.page1.Page1Fragment;
import com.tsit.myapplication.fragment.page2.Page2Fragment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity implements MainContractor.iView {
    MainContractor.iPresenter iPresenter;
    private WebView webViewOne;
    private ImageView imageView;
    private boolean mExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter = new MainPresenter(this);
        setContentView(R.layout.activity_main);

        iPresenter.onCreateView();

    }

    @Override
    public void showPage(int i) {
        if (i == 1) {
            showFragment(new Page1Fragment());
        } else {
            showFragment(new Page2Fragment());
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction bt = getSupportFragmentManager().beginTransaction();
        bt.replace(R.id.container, fragment);
        bt.addToBackStack(null);
        bt.commit();
    }

    @Override
    public void onBackPressed() {
        if (mExit)
            finish();
        Toast.makeText(this, "برای خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
        mExit = true;

        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong ->
                        mExit = false);
    }
}
