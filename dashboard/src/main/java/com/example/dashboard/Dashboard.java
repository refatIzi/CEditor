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
import com.example.dashboard.folder.Explorer;
import com.example.dashboard.folder.ExplorerAdapter;
import com.example.dashboard.status.DetectFile;
import com.example.dashboard.status.DetectHost;
import com.example.dashboard.status.DetectStatus;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    private List<Detect> list = new ArrayList<>();
    private DetectAdapter detectAdapter;
    private ListView detectView;
    private List<Explorer> explorers = new ArrayList<>();
    private ExplorerAdapter explorerAdapter;
    private ListView detectDir;
    private DetectStatus detectStatus;
    private DetectHost detectHost;
    private DetectFile[] detectFile;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        detectStatus = new DetectStatus().status((byte[]) getIntent().getSerializableExtra("status"));
        detectHost = detectStatus.getHost();
        detectFile = detectStatus.getDetectFile();
        setTitle(detectHost.getHostName());
        detectView = findViewById(R.id.detectView);
        detectDir = findViewById(R.id.detectDir);

        showDetect(detectFile);
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
    private void showDetect(DetectFile[] detectFile) {
        list.clear();
        for (int i = 0; i < detectFile.length; i++) {
            {
                list.add(new Detect(
                        detectFile[i].getFile_name(),
                        detectFile[i].getTime_create(),
                        detectFile[i].getDetect_info(),
                        R.drawable.ic_file_hex));
            }
        }
        detectAdapter = new DetectAdapter(this, R.layout.iteam_detect, list);
        detectView.setAdapter(detectAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showDire(String connected) {
        explorers.clear();
        for (int i = 0; i < 20; i++) {
            {
                String about = "Metadata is defined as the data providing information about one or more aspects of the data; it is used to summarize basic";
                if (i % 2 == 0) {
                    explorers.add(new Explorer("Folder" + i, "12.12.12", about, R.drawable.ic_folder));
                } else {
                    explorers.add(new Explorer("File" + i, "12.12.12", about, R.drawable.ic_file_hex));
                }
            }
        }
        explorerAdapter = new ExplorerAdapter(this, R.layout.iteam_file, explorers);
        detectDir.setAdapter(explorerAdapter);
    }
}