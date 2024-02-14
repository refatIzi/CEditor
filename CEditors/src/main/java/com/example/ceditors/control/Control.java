package com.example.ceditors.control;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ceditors.help.Help;
import com.example.ceditors.R;

@SuppressLint("ValidFragment")
public class Control extends Fragment {




    Help mainInterface;
    Context context;


    public Control(Context context) {
        mainInterface = (Help) context;
        this.context = context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_control, container, false);



        return v;
    }

}