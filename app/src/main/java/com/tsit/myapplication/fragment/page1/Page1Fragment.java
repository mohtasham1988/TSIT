package com.tsit.myapplication.fragment.page1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tsit.myapplication.R;
import com.tsit.myapplication.activity.main.MainActivity;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class Page1Fragment extends Fragment implements Page1Contractor.iView {

    public static final String BITMAP_IMAGE = "BitmapImage";
    private WebView webViewOne;
    private ImageView imageView;
    private Page1Presenter iPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1, container, false);
        webViewOne = view.findViewById(R.id.webViewOne);
        imageView = view.findViewById(R.id.imageView);
        setRetainInstance(true);
        iPresenter = new Page1Presenter(this);
        iPresenter.onCreateView(savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initWebView(Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            webViewOne.restoreState(savedInstanceState);
        } else {
            webViewOne.loadUrl("http://www.google.com");
        }
        webViewOne.getSettings().setJavaScriptEnabled(true);

        webViewOne.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                isInternetOn();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!Uri.parse(url).getHost().equals("www.yahoo.com")) {
                    // This is my website, so do not override; let my WebView load the page
                    return false;
                }
                iPresenter.startPage2();
                return true;
            }
        });


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        webViewOne.saveState(outState);
        super.onSaveInstanceState(outState);

        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        if (drawable != null) {
            Bitmap bitmap = drawable.getBitmap();
            outState.putParcelable(BITMAP_IMAGE, bitmap);
        }
    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Bitmap image;
        if (savedInstanceState != null) {
            webViewOne.restoreState(savedInstanceState);
            image = savedInstanceState.getParcelable(BITMAP_IMAGE);
            imageView.setImageBitmap(image);

        }
    }

    /**
     * ******************************
     * check internet is on or off
     */
    public void isInternetOn() {
        if (getContext() != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            Observable.just(activeNetworkInfo != null && activeNetworkInfo.isConnected()).observeOn(AndroidSchedulers.mainThread()).subscribe(aBoolean -> {
                if (!aBoolean)
                    Toast.makeText(Page1Fragment.this.getContext(), "اینترنت قطع میباشد", Toast.LENGTH_SHORT).show();
            });
        }
    }

    @Override
    public void startPage2() {
        if (getActivity() != null)
            ((MainActivity) getActivity()).showPage(2, null);
    }

    @Override
    public void initImageView(final String[] array) {
        imageView.setOnClickListener(v -> {
            Random random = new Random();
            if (getActivity() != null)
                Glide.with(getActivity()).load(array[random.nextInt(array.length)]).into(imageView);
            isInternetOn();
        });
    }
}
