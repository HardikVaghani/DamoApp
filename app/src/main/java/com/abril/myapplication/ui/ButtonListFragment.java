package com.abril.myapplication.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abril.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ButtonListFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View root;
    private LinearLayout containerLayout;
    int numOfItems = 5;
    List<TextView> list = new ArrayList<>();

    private String mParam1;
    private String mParam2;

    public ButtonListFragment() {
        // Required empty public constructor
    }


    public static ButtonListFragment newInstance(String param1, String param2) {
        ButtonListFragment fragment = new ButtonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_button_list, container, false);
        containerLayout = root.findViewById(R.id.container);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Here, create a list of TextViews
        for (int i = 0; i < numOfItems; i++) {
            TextView textView = (TextView) getLayoutInflater().inflate(R.layout.item_textview, containerLayout, false);
            textView.setText("Text" + i);
            list.add(textView);
        }

        ItemAdapter adapter = new ItemAdapter(requireContext(), list);
        recyclerView.setAdapter(adapter);
    }
}