package com.example.skourse.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.skourse.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalCategoryAdapter extends RecyclerView.Adapter<HorizontalCategoryAdapter.HorizontalViewHolder> {

    private String [] item_category;

    public HorizontalCategoryAdapter(String[] item_category) {
        this.item_category = item_category;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_category, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        holder.textView_category.setText(item_category[position]);
    }

    @Override
    public int getItemCount() {
        return item_category.length;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        TextView textView_category;
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_category = (TextView) itemView.findViewById(R.id.textView_category);

        }
    }
}
