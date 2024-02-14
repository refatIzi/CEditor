package com.example.ceditors.control;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ceditors.help.Help;
import com.example.ceditors.R;

@SuppressLint("ValidFragment")
public class Controls extends Fragment implements View.OnClickListener {


    Control control;
    Context context;
    EditText parameters;
    TextView notice;
    Button tab;


    public Controls(Context context) {
        control = (Control) context;
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
        parameters = v.findViewById(R.id.parameters);
        notice = v.findViewById(R.id.notice);
        tab=v.findViewById(R.id.table);
        notice.setText("no connection to server. Please check your internet connection");
        tab.setOnClickListener(this);
        return v;
    }

    @Override
    public String toString() {
        if(parameters!=null)
        return parameters.getText().toString();
        else return  "";
    }

    @Override
    public void onClick(View v) {
        control.tab();
    }
}