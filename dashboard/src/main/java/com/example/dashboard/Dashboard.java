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

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    private List<Detect> list = new ArrayList<>();
    private DetectAdapter detectAdapter;
    private ListView detectView;
    private List<FileDetect> fileDetects = new ArrayList<>();
    private FileDetectAdapter fileDetectAdapter;
    private ListView detectDir;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        detectView = findViewById(R.id.detectView);
        detectDir = findViewById(R.id.detectDir);

        showDetect(null);
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
    String metadate = "Metadata has various purposes. It can help users find relevant information and discover resources. It can also help organize electronic resources, provide digital identification, and archive and preserve resources. Metadata allows users to access resources by \"allowing resources to be found by relevant criteria, identifying resources, bringing similar resources together, distinguishing dissimilar resources, and giving location information\".[8] Metadata of telecommunication activities including Internet traffic is very widely collected by various national governmental organizations. This data is used for the purposes of traffic analysis and can be used for mass surveillance.[9]\n" +
            "\n" +
            "Metadata was traditionally used in the card catalogs of libraries until the 1980s when libraries converted their catalog data to digital databases.[10] In the 2000s, as data and information were increasingly stored digitally, this digital data was described using metadata standards.[11]";
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showDetect(Detect[] connected) {
        list.clear();
        for (int i = 0; i < 20; i++) {
            {
                String about ="Some loans were made to borrowers who merely stated their income, without any independent verification.\n" +
                        "The government has become stricter about income verification for those receiving benefits.\n" +
                        "verification of address/ID/income\n";
                if (i%2==0) {
                    list.add(new Detect("My word document"+i, "12.12.12", metadate, R.drawable.ic_file_hex));
                } else {
                    list.add(new Detect("My exel document"+i, "12.12.12", metadate, R.drawable.ic_file_hex));
                }
            }
        }
        detectAdapter = new DetectAdapter(this, R.layout.iteam_detect, list);
        detectView.setAdapter(detectAdapter);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showDire(Detect[] connected) {
        fileDetects.clear();
        for (int i = 0; i < 20; i++) {
            {
                String about ="Metadata is defined as the data providing information about one or more aspects of the data; it is used to summarize basic";
                if (i%2==0) {
                    fileDetects.add(new FileDetect("Folder"+i, "12.12.12", about, R.drawable.ic_folder));
                } else {
                    fileDetects.add(new FileDetect("File"+i, "12.12.12", about, R.drawable.ic_file_hex));
                }
            }
        }
        fileDetectAdapter = new FileDetectAdapter(this, R.layout.iteam_file, fileDetects);
        detectDir.setAdapter(fileDetectAdapter);
    }
}