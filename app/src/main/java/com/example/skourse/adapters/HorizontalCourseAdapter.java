package com.example.skourse.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.skourse.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalCourseAdapter extends RecyclerView.Adapter<HorizontalCourseAdapter.HorizontalViewHolder> {

    private String [] item_courseTitle;

    public HorizontalCourseAdapter(String[] item_courseTitle) {
        this.item_courseTitle = item_courseTitle;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_course, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        holder.titleCourse.setText(item_courseTitle[position]);
    }

    @Override
    public int getItemCount() {
        return item_courseTitle.length;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        TextView titleCourse;
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            titleCourse = (TextView) itemView.findViewById(R.id.textView_courseTitle);

        }
    }
}
