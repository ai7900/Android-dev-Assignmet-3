package com.example.dnd_char_creator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class start extends Fragment {

    CountDownTimer timer;

    public start() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startInputFragment();
            }
        }.start();

        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    public void startInputFragment(){
        Input input = new Input();
        MainActivity.fragmentManager.beginTransaction().add((R.id.container),input, null).commit();
        MainActivity.input = input;
    }
}