package com.tsit.myapplication.fragment.page2;

import android.os.Bundle;
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

import java.util.List;

public class Page2Fragment   extends Fragment implements Page2Contractor.iView {
    private RecyclerView recyclerView;
    private Page2Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter=new Page2Presenter(this);
        mPresenter.onCreateView();
    }

    @Override
    public void initList(List<String> list) {
//        if (recyclerView.getAdapter()!=null){
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
            recyclerView.setAdapter(new SampleAdapter(list, v -> {
                int i = (int) v.getTag();
                if (i==0 && getActivity()!=null)
                    ((MainActivity )getActivity()).showPage(1);
            }));
//        }else{
//
//        }
    }
}
