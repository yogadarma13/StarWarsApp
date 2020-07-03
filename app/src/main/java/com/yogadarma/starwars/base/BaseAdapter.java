package com.yogadarma.starwars.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    public int layoutId;
    protected ArrayList<?> list = new ArrayList<>();
    Context context;
    public View itemview;

    public BaseAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        onBindView(position, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0: list.size();
    }

    public abstract void onBindView(int position, Object itemView);

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemview = itemView;
            getView(itemView);
        }
    }

    protected abstract View getView(View itemView);

    public <T extends View> T bind(int id) {
        return itemview.findViewById(id);
    }
}
