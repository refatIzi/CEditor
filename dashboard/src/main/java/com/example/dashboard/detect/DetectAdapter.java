package com.example.dashboard.detect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.dashboard.Dashboard;
import com.example.dashboard.R;
import com.example.dashboard.visualization.ActivityEditWatcher;

import java.util.List;

public class DetectAdapter extends ArrayAdapter<Detect> {
    private final List<Detect> list;
    private final Context context;
    private Detect detect;
    private int resourceLayout;

    public DetectAdapter(@NonNull Context context, int resource, List<Detect> list) {
        super(context, resource, list);
        this.list = list;
        this.context = context;
        this.resourceLayout = resource;

    }

    @SuppressLint("SuspiciousIndentation")
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resourceLayout, null);
        detect = list.get(position);
        ImageView image = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.name);
        TextView status = view.findViewById(R.id.time_create);
        TextView info = view.findViewById(R.id.info);
        info.addTextChangedListener(new ActivityEditWatcher((Dashboard) context));

        image.setImageResource(detect.getImage());
        name.setText(detect.getFile_name());
        status.setText(detect.getTime_create());
        info.setText(detect.getDetect_info());

        return view;
    }
}
