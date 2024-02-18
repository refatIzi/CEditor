package com.example.communication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.communication.connect.AConnect;
import com.example.communication.connect.Connect;
import com.example.communication.connect.ConnectAdapter;
import com.example.communication.connect.Сonnected;

import java.util.ArrayList;
import java.util.List;

public class Communication extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<Connect> list = new ArrayList<>();
    private ConnectAdapter connectAdapter;
    private ListView listView;
    private Сonnected connected;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);
        connected = new Сonnected().сonnected((byte[]) getIntent().getSerializableExtra("сonnected"));

        listView = findViewById(R.id.OpenListView);
        listView.setOnItemClickListener(this);
       showDirectory(connected.getConnect());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showDirectory(AConnect[] connects) {
        list.clear();
        for (int i = 0; i < connects.length; i++) {
         {
                if (i%2==0) {
                    list.add(new Connect(connects[i].getHostName()+" "+i, connects[i].getStatus(), connects[i].getFiles(), R.drawable.xenomorphonline));
                } else {
                    list.add(new Connect(connects[i].getHostName()+" "+i, connects[i].getStatus(), connects[i].getFiles(), R.drawable.xenomorphoffline));
                }
            }
        }
        connectAdapter = new ConnectAdapter(this, R.layout.iteam_row, list);
        listView.setAdapter(connectAdapter);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
}