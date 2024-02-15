package com.example.communication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.communication.connect.Connect;
import com.example.communication.connect.ConnectAdapter;
import com.example.communication.connect.Сonnected;

import java.util.ArrayList;
import java.util.List;

public class Communication extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<Connect> list = new ArrayList<>();
    private ConnectAdapter connectAdapter;
    private ListView listView;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);
        listView = findViewById(R.id.OpenListView);
        listView.setOnItemClickListener(this);
        showDirectory(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showDirectory(Сonnected[] connected) {
        list.clear();
        for (int i = 0; i < 20; i++) {
         {
                String about ="Some loans were made to borrowers who merely stated their income, without any independent verification.\n" +
                        "The government has become stricter about income verification for those receiving benefits.\n" +
                        "verification of address/ID/income\n";
                if (i%2==0) {
                    list.add(new Connect("sDirList[i]", "online", about, R.drawable.xenomorphonline));
                } else {
                    list.add(new Connect("DESKTOP-HO124TE \nIP 192.168.100.200", "offline", about, R.drawable.xenomorphoffline));
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