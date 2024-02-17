package com.example.dashboard.folder;

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

public class FileDetectAdapter extends ArrayAdapter<FileDetect> {
    private final List<FileDetect> list;
    private final Context context;
    private FileDetect fileDetect;
    private int resourceLayout;

    public FileDetectAdapter(@NonNull Context context, int resource, List<FileDetect> list) {
        super(context, resource, list);
        this.list = list;
        this.context = context;
        this.resourceLayout = resource;

    }

    @SuppressLint("SuspiciousIndentation")
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resourceLayout, null);
        fileDetect = list.get(position);
        ImageView image = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.name);
        TextView status = view.findViewById(R.id.status);
        TextView info = view.findViewById(R.id.info);
        info.addTextChangedListener(new ActivityEditWatcher((Dashboard) context));

        image.setImageResource(fileDetect.getImage());
        name.setText(fileDetect.getName());
        status.setText(fileDetect.getTime());
        info.setText(fileDetect.getInformation());

        return view;
    }
}
