package com.abril.myapplication.ui;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abril.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private String TAG = ItemAdapter.class.getSimpleName();
    private Context context;
    public int[] colors = new int[]{
            android.R.color.holo_green_light,
            android.R.color.holo_red_light,
            android.R.color.holo_blue_light,
            android.R.color.holo_purple,
            android.R.color.holo_orange_light
    }; // Add more colors if needed
    public int colorIndex = 0;
    public List<TextView> list;

    public ItemAdapter(Context context, List<TextView> itemList) {
        this.context = context;
        this.list = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_textview, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        TextView tv = list.get(position);
        holder.bind(tv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public boolean isAllSameColor(List<TextView> view) {
        int count = 0;
        for (View v : view) {
            if (hasSpecificBackgroundColor((TextView) v, colorIndex)) {
                count++;
            }
        }
        return count == list.size()-1;
    }
    public boolean hasSpecificBackgroundColor(TextView textView, int colorIndex) {
        Drawable background = textView.getBackground();
        if (background instanceof ColorDrawable) {
            int color = ((ColorDrawable) background).getColor();
            return color == textView.getContext().getResources().getColor(colors[colorIndex], null);
        }
        return false;
    }

    public void changeColor(TextView textView, int colorIndex) {
        textView.setBackgroundColor(textView.getContext().getResources().getColor(colors[colorIndex], null));
    }
    public void changeIndividualColor(TextView textView, int colorIndex) {
        int index = list.indexOf(textView);
        changeColor(textView, (colorIndex + index) % colors.length);
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_textView);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    if (index != RecyclerView.NO_POSITION) {
                        if (isAllSameColor(list)) {
                            colorIndex = (colorIndex + 1) % colors.length;
                            for (TextView textView : list) {
                                changeColor(textView, colorIndex);
                            }
                        } else {
                            // Perform individual color change logic here
                            changeIndividualColor((TextView) view, colorIndex);
                            changeColor((TextView) view, colorIndex);
                        }
                    }
                }
            });
        }

        public void bind(TextView tv) {
            textView.setText(tv.getText());
        }
    }
}
