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

public class ExplorerAdapter extends ArrayAdapter<Explorer> {
    private final List<Explorer> list;
    private final Context context;
    private Explorer explorer;
    private int resourceLayout;

    public ExplorerAdapter(@NonNull Context context, int resource, List<Explorer> list) {
        super(context, resource, list);
        this.list = list;
        this.context = context;
        this.resourceLayout = resource;
    }

    @SuppressLint("SuspiciousIndentation")
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resourceLayout, null);
        explorer = list.get(position);
        ImageView image = view.findViewById(R.id.imageFile);
        TextView name = view.findViewById(R.id.name);
        TextView status = view.findViewById(R.id.time_create);
        TextView info = view.findViewById(R.id.metadate);
        info.addTextChangedListener(new ActivityEditWatcher((Dashboard) context));

        image.setImageResource(explorer.getImage());
        name.setText(explorer.getName());
        status.setText(explorer.getTime_create());
        info.setText(explorer.getMetadate());

        return view;
    }
}
