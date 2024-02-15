package com.example.communication.connect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.communication.R;

import java.util.List;

public class ConnectAdapter extends ArrayAdapter<Connect> {
    private List<Connect> mList;
    private Context mContext;
    Connect connect;
    private int resourceLayout;
    public ConnectAdapter(@NonNull Context context, int resource, List<Connect> objects){

        super(context,resource,objects);
        this.mList=objects;
        this.mContext=context;
        this.resourceLayout =resource;

    }
    public View getView(final int position, View convertView, final ViewGroup parent)
    {
        View view=convertView;
        if(view==null)
            view= LayoutInflater.from(mContext).inflate(resourceLayout,null);
           connect =mList.get(position);
        ImageView image=view.findViewById(R.id.imageView);
        TextView name=view.findViewById(R.id.name);
        TextView status=view.findViewById(R.id.status);
        TextView info=view.findViewById(R.id.info);
        image.setImageResource(connect.getImage());
        name.setText(connect.getNumber());
        status.setText(connect.getTime());
        info.setText(connect.getInformation());

        return view;
    }
}
