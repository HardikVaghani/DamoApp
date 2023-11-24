package com.abril.myapplication.ui;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abril.myapplication.R;

import java.util.List;

public class ButtonsAdapter{// extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private static final int VIEW_TYPE_LIST = 1;
//    private static final int VIEW_TYPE_GRID = 2;
//
//    private List<Button> items;
//    private Context context;
//
//    public ButtonsAdapter(Context context, List<Button> items) {
//        this.context = context;
//        this.items = items;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        // Alternate between list and grid view types
//        return position % 2 == 0 ? VIEW_TYPE_LIST : VIEW_TYPE_GRID;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        RecyclerView.ViewHolder viewHolder;
//        View view;
//
//        switch (viewType) {
//            case VIEW_TYPE_LIST:
//                view = inflater.inflate(R.layout.item_button_list, parent, false);
//                viewHolder = new ListViewHolder(view);
//                break;
//            case VIEW_TYPE_GRID:
//                view = inflater.inflate(R.layout.item_button_grid, parent, false);
//                viewHolder = new GridViewHolder(view);
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid view type");
//        }
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        Button item = items.get(position);
//
//        switch (holder.getItemViewType()) {
//            case VIEW_TYPE_LIST:
//                ((ListViewHolder) holder).bind(item);
//                break;
//            case VIEW_TYPE_GRID:
//                ((GridViewHolder) holder).bind(item);
//                break;
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
//    // ViewHolder for list item
//    private class ListViewHolder extends RecyclerView.ViewHolder {
//        private Button button;
//
//        ListViewHolder(View itemView) {
//            super(itemView);
//            button = itemView.findViewById(R.id.button_list);
//        }
//
//        void bind(Button item) {
//            button.setText(item.getButtonText());
//            // Set click listener or any other functionality for list items
//        }
//    }
//
//    // ViewHolder for grid item
//    private class GridViewHolder extends RecyclerView.ViewHolder {
//        private Button button;
//
//        GridViewHolder(View itemView) {
//            super(itemView);
//            button = itemView.findViewById(R.id.button_grid);
//        }
//
//        void bind(Button item) {
//            button.setText(item.g);
//            // Set click listener or any other functionality for grid items
//        }
//    }
}
