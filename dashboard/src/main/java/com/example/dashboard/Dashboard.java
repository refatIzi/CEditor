package com.example.dashboard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.dashboard.detect.Detect;
import com.example.dashboard.detect.DetectAdapter;
import com.example.dashboard.folder.FileDetect;
import com.example.dashboard.folder.FileDetectAdapter;
import com.example.dashboard.status.CheckFile;
import com.example.dashboard.status.CheckHost;
import com.example.dashboard.status.Status;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    private List<Detect> list = new ArrayList<>();
    private DetectAdapter detectAdapter;
    private ListView detectView;
    private List<FileDetect> fileDetects = new ArrayList<>();
    private FileDetectAdapter fileDetectAdapter;
    private ListView detectDir;
    private Status status;
    private CheckHost checkHost;
    private CheckFile[] checkFile;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        status = new Status().status((byte[]) getIntent().getSerializableExtra("status"));
        checkHost = status.getHost();
        checkFile = status.getCheckFiles();
        setTitle(checkHost.getHostName());
        detectView = findViewById(R.id.detectView);
        detectDir = findViewById(R.id.detectDir);

        showDetect(checkFile);
        showDire(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.terminal) {
        } else if (id == R.id.action_settings) {
        }
        return super.onOptionsItemSelected(item);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showDetect(CheckFile[] checkFile) {
        list.clear();
        for (int i = 0; i < checkFile.length; i++) {
            {
                list.add(new Detect(
                        checkFile[i].getFile_name(),
                        checkFile[i].getTime_create(),
                        checkFile[i].getDetect_info(),
                        R.drawable.ic_file_hex));
            }
        }
        detectAdapter = new DetectAdapter(this, R.layout.iteam_detect, list);
        detectView.setAdapter(detectAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showDire(String connected) {
        fileDetects.clear();
        for (int i = 0; i < 20; i++) {
            {
                String about = "Metadata is defined as the data providing information about one or more aspects of the data; it is used to summarize basic";
                if (i % 2 == 0) {
                    fileDetects.add(new FileDetect("Folder" + i, "12.12.12", about, R.drawable.ic_folder));
                } else {
                    fileDetects.add(new FileDetect("File" + i, "12.12.12", about, R.drawable.ic_file_hex));
                }
            }
        }
        fileDetectAdapter = new FileDetectAdapter(this, R.layout.iteam_file, fileDetects);
        detectDir.setAdapter(fileDetectAdapter);
    }
}