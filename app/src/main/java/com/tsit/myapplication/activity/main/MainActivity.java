package com.tsit.myapplication.activity.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.tsit.myapplication.R;
import com.tsit.myapplication.fragment.page1.Page1Fragment;
import com.tsit.myapplication.fragment.page2.Page2Fragment;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity implements MainContractor.iView {
    public static final String KEY_NAME = "fragment";
    MainContractor.iPresenter iPresenter;
    private boolean mExit;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter = new MainPresenter(this);
        setContentView(R.layout.activity_main);
        iPresenter.onCreateView(savedInstanceState);
    }

    /**
     * ******************************
     *
     * @param i                  page number
     * @param savedInstanceState savedInstanceState from activity
     */
    @Override
    public void showPage(int i, Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            if (i == 1) {
                fragment = new Page1Fragment();
            } else {
                fragment = new Page2Fragment();
            }
        } else {
            fragment = getSupportFragmentManager()
                    .getFragment(savedInstanceState, KEY_NAME);
        }
        showFragment(fragment);
    }

    /**
     * **********************************
     *
     * @param fragment fragment
     */
    private void showFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction bt = getSupportFragmentManager().beginTransaction();
            bt.replace(R.id.container, fragment);
            bt.addToBackStack(null);
            bt.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, KEY_NAME, fragment);
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
