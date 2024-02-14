package com.example.ceditors.help;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.ceditors.R;

import java.util.List;

public class HelperAdapter extends ArrayAdapter<Helper> {
    private List<Helper> objects;
    private Context context;
    Helper helper;
    private int resourse;

    public HelperAdapter(@NonNull Context context, int resourse, List<Helper> objects) {

        super(context, resourse, objects);
        this.objects = objects;
        this.context = context;
        this.resourse = resourse;

    }

    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(context).inflate(resourse, null);
        helper = objects.get(position);
        TextView help = view.findViewById(R.id.help);
        help.setText(helper.getHelp());
        TextView infirmation = view.findViewById(R.id.info);
        infirmation.setText(helper.getInformation());

        return view;
    }


}
