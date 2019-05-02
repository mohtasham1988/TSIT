package com.tsit.myapplication.fragment.page2;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tsit.myapplication.R;
import com.tsit.myapplication.activity.main.MainActivity;
import com.tsit.myapplication.adapter.SampleAdapter;

import java.util.ArrayList;
import java.util.List;

public class Page2Fragment extends Fragment implements Page2Contractor.iView {
    public static final String Key_Layout = "layout";
    private RecyclerView recyclerView;
    private Page2Contractor.iPresenter mPresenter;
    private LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        this.setRetainInstance(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new Page2Presenter(this);
        mPresenter.onCreateView(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(Key_Layout, layoutManager.onSaveInstanceState());
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null && recyclerView != null && recyclerView.getLayoutManager() != null) {
            Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(Key_Layout);
            recyclerView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
        }
    }

    @Override
    public void initList(List<String> list) {
        if (recyclerView.getAdapter() == null) {
            layoutManager = new LinearLayoutManager(this.getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new SampleAdapter(list, v -> {
                int i = (int) v.getTag();
                if (i == 0 && getActivity() != null)
                    ((MainActivity) getActivity()).showPage(1, null);
            }));
        } else {
            ((SampleAdapter) recyclerView.getAdapter()).setList(list);
        }
    }

    @Override
    public ArrayList<String> getList() {
        if (recyclerView != null && recyclerView.getAdapter() != null)
            return ((SampleAdapter) recyclerView.getAdapter()).getList();
        return new ArrayList<>();
    }
}
