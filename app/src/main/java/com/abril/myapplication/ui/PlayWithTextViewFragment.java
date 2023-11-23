package com.abril.myapplication.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abril.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PlayWithTextViewFragment extends Fragment {
    private String TAG = PlayWithTextViewFragment.class.getCanonicalName();
    private View root;
    private LinearLayout containerLayout;
    private int[] colors = new int[]{
            android.R.color.holo_green_light,
            android.R.color.holo_red_light,
            android.R.color.holo_blue_light,
            android.R.color.holo_purple,
            android.R.color.holo_orange_light
    }; // Add more colors if needed
    private int colorIndex = 0;
    private int numOfItems = 5;
    private List<TextView> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_play_with_text_view, container, false);
        containerLayout = root.findViewById(R.id.container_layout);
        return root;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();

        for (int i = 0; i < numOfItems; i++) {
            TextView textView = (TextView) getLayoutInflater().inflate(R.layout.item_textview, containerLayout, false);
            textView.setText("Text" + i);
            list.add(textView);
            containerLayout.addView(textView); // Add the TextView to the layout
        }

        for (TextView textView : list) {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isAllSameColor()) {
                        Log.d(TAG, "onClick: true");
                        colorIndex = (colorIndex + 1) % colors.length; // Move to the next color
                        changeColor((TextView) view, colorIndex);
                    } else {
                        Log.d(TAG, "onClick: false");
                        changeIndividualColor((TextView) view, colorIndex);
                        int index = list.indexOf(view);
                        changeColor((TextView) view, colorIndex);
                    }
                }
            });
        }
    }

    private void changeIndividualColor(TextView textView, int colorIndex) {
        int index = list.indexOf(textView);
        changeColor(textView, (colorIndex + index) % colors.length);
    }

    private boolean isAllSameColor() {
        int count = 0;
        for (TextView t : list) {
            if (hasSpecificBackgroundColor(t, colorIndex)) {
                count++;
            }
        }
        return count == list.size()-1;
    }

    private boolean hasSpecificBackgroundColor(TextView textView, int colorIndex) {
        Drawable background = textView.getBackground();
        if (background instanceof ColorDrawable) {
            int color = ((ColorDrawable) background).getColor();
            return color == getResources().getColor(colors[colorIndex], null);
        }
        return false;
    }

    private void changeColor(TextView textView, int colorIndex) {
        textView.setBackgroundColor(getResources().getColor(colors[colorIndex], null));
    }
}








