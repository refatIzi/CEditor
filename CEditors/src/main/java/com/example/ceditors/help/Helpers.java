package com.example.ceditors.help;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.ceditors.R;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class Helpers extends Fragment implements  AdapterView.OnItemClickListener {


    String[] functions;

    ListView listView;
    private List<Helper> helper = new ArrayList<>();
    HelperAdapter adapter;
    Help mainInterface;
    Context context;
    String help;

    public Helpers(Context context) {
        mainInterface = (Help) context;
        this.context = context;

    }

    public void helpAdd(String help, @NonNull String[] functions) {
        this.help=help;
        this.functions=functions;
        for (int i = 0; i < functions.length; i++) {
            if (functions[i].startsWith(help))
                helper.add(new Helper(functions[i], "no info"));
        }
    }

    public void clear() {
        adapter.clear();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_help, container, false);
        listView = v.findViewById(R.id.search);
        adapter = new HelperAdapter(context, R.layout.iteam_help, helper);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mainInterface.Information(adapter.getItem(position).getHelp());
                return true;
            }
        });
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mainInterface.setEdit(adapter.getItem(position).getHelp().replaceAll(help,""));
    }
}