package com.tsit.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tsit.myapplication.R;

import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {

    private final List<String> list;
    private View.OnClickListener mListener;

    public SampleAdapter(List<String> list,View.OnClickListener listener) {
        this.list = list;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_listview, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(list.get(i));
        viewHolder.itemView.setOnClickListener(v -> {
            viewHolder.itemView.setTag(i);
            mListener.onClick( viewHolder.itemView);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
