package com.example.dnd_char_creator;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Input extends Fragment {

    ImageButton randomizeButton;
    EditText firstNmbrs;

    public Input() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        randomizeButton = view.findViewById(R.id.imageButton);
        firstNmbrs =  (EditText) view.findViewById(R.id.editTextNumberStrength3);

        randomizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Dice(getActivity(), new DL()).roll();
            }
        });

        return view;
    }

    private class DL implements Dice.rollListener {
        public void rollLoaded(int results) {
            firstNmbrs.setText(Integer.toString(results));
        }
    }

}