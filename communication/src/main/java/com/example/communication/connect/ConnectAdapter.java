package com.example.communication.connect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.communication.Communication;
import com.example.communication.R;
import com.example.communication.visualization.ActivityEditWatcher;

import java.util.List;

public class ConnectAdapter extends ArrayAdapter<Connect> {
    private final List<Connect> list;
    private final Context context;
    private Connect connect;
    private int resourceLayout;

    public ConnectAdapter(@NonNull Context context, int resource, List<Connect> list) {
        super(context, resource, list);
        this.list = list;
        this.context = context;
        this.resourceLayout = resource;

    }

    @SuppressLint("SuspiciousIndentation")
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resourceLayout, null);
        connect = list.get(position);
        ImageView image = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.name);
        TextView status = view.findViewById(R.id.status);
        TextView info = view.findViewById(R.id.info);
        info.addTextChangedListener(new ActivityEditWatcher((Communication) context));

        image.setImageResource(connect.getImage());
        name.setText(connect.getNumber());
        status.setText(connect.getTime());
        info.setText(connect.getInformation());

        return view;
    }
}
