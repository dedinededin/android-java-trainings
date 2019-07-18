package com.example.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.myapplication.R;

import static android.R.layout.select_dialog_item;


public class FirstFragment extends Fragment {
    AutoCompleteTextView actv;
    String[] countries = {
            "Turkey",
            "Tunisa",
            "Turkmenistan",
            "Turtle",
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AutoComplete(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    private void AutoComplete(View view) {
        actv = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), select_dialog_item,countries);
        actv.setThreshold(2);
        actv.setAdapter(adapter);
    }


}
