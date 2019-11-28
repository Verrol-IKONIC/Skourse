package com.example.skourse.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.skourse.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalSearchResultAdapter extends RecyclerView.Adapter<VerticalSearchResultAdapter.VerticalViewHolder> {

    private String[] items;

    public VerticalSearchResultAdapter(String[] items) {
        this.items = items;
    }


    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_search_result, parent, false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        holder.title.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView_courseTitle);

        }
    }
}
