package com.example.terminal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.terminal.terminal.Console;
import com.example.terminal.terminal.TerminalAdapter;
import com.example.terminal.visualization.TerminalEditWatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Terminal extends AppCompatActivity implements View.OnClickListener {
    private List<Console> consoleList = new ArrayList<>();
    Console console;
    TerminalAdapter terminalAdapter;
    ListView terminalView;
    ListView lineView;
    EditText consoleEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminal);
        terminalView = findViewById(R.id.consoleList);
        consoleEdit = findViewById(R.id.console);
        consoleEdit.addTextChangedListener(new TerminalEditWatcher(this));
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        terminalView.setNestedScrollingEnabled(true);
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onClick(View v) {

    }

    public void clearEdit() {
        consoleEdit.setText("");
    }


    public void shell(String line) {
        List<String> tokens = new ArrayList<String>();
        tokens.add("line");
        tokens.add("Traceback");
        tokens.add("NameError");
        tokens.add("SyntaxError");
        String join = TextUtils.join("|", tokens);
        String patternString = "\\b(" + join + ")\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
        }
        setShellOut(line);
    }



    private void setShellOut(String line) {
        consoleList.add(new Console(line));
        terminalAdapter = new TerminalAdapter(this, this, R.layout.iteam_terminal, consoleList);
        terminalView.setAdapter(terminalAdapter);
    }
}