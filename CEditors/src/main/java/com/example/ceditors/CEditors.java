package com.example.ceditors;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ceditors.control.Control;
import com.example.ceditors.help.Help;
import com.example.ceditors.help.Helpers;
import com.example.ceditors.language.Language;
import com.example.ceditors.line.Line;
import com.example.ceditors.visualization.ActivityEditWatcher;
import com.example.generate.Generate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CEditors extends AppCompatActivity implements Help {
    EditText editText;
    TextView numberCode;
    Helpers helpers;
    Control control;
    Language language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceditors);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        /**
         * Отримує серіалізований об'єкт з Intent за ключем "language" за допомогою @getIntent().getSerializableExtra("language").
         * Цей ключ використовується для ідентифікації об'єкта @Language.
         **/

        language = new Language().language((byte[]) getIntent().getSerializableExtra("language"));

        numberCode = findViewById(R.id.numberCode);
        editText = findViewById(R.id.txtCode);
        editText.setTextSize(12);
        numberCode.setTextSize(12);
        helpers = new Helpers(this);
        control = new Control(this);

        setFragment(control);


        editText.addTextChangedListener(new ActivityEditWatcher(CEditors.this));

        /**
         * Cлідкуємо за вводом текста
         * Метод для філтрації тексту для підсказок
         **/
        InputFilter filter = (source, start, end, dest, dstart, dend) -> {

            try {
                setFragment(helpers);
                helpers.clear();
                StringBuilder sb = new StringBuilder(dest);
                Line line = new Line();
                String filter_text = "";

                if (source.length() > 0) {
                    sb.append(source);
                    filter_text = line.returnFilterStr(sb.toString());

                }
                /**
                 * Якщо видалений символ, і декілька символів видалено
                 * Видаляємо символ
                 **/
                else if (start == end && dstart < dend) {
                    sb.deleteCharAt(dstart);
                    filter_text = line.returnFilterStr(sb.toString());
                    checkEndsWith(sb.toString());
                }
                /**
                 * Якщо видалений текст, видаляємо його з рядка
                 **/
                else if (start < end) {
                    sb.delete(dstart, dend);
                    filter_text = line.returnFilterStr(sb.toString());
                    checkEndsWith(sb.toString());
                }

                helpers.helpAdd(filter_text, language.getFunctions());
                checkEndsWith(source.toString());

            } catch (Exception e) {
            }


            return null;
        };
        editText.setFilters(new InputFilter[]{filter});
        editText.setText(language.getCode());
    }


    private void checkEndsWith(@NonNull String str) {
        if (str.endsWith(" ")) {
            setFragment(control);
        }
        if (str.endsWith("\n")) {
            setFragment(control);
        }
        if (str.length() <= 0) {
        }
    }

    private void setFragment(Object o) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.bottom_panel, (Fragment) o);
        fragmentTransaction.commit();
    }


    /**
     * Метод котрый выводит номурецию строки
     */
    public void numberOfConstruction(int errLine) {
        int line = editText.getLineCount();
        String number = "";
        try {
            for (int i = 1; i <= line; i++) {
                number = number + i + "\n";
            }
            numberCode.clearFocus();
            int error;
            if (errLine == 0) {
                numberCode.setText(number);
            } else if (errLine < 10) {
                error = 2 * (errLine - 1);
                final SpannableStringBuilder text = new SpannableStringBuilder(number);
                final ForegroundColorSpan style = new ForegroundColorSpan(Color.rgb(255, 0, 0));
                text.setSpan(style, error, error + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                numberCode.setText(text);
            } else if (errLine >= 10) {
                error = 3 * (errLine - 9) + 15;
                final SpannableStringBuilder text = new SpannableStringBuilder(number);
                final ForegroundColorSpan style = new ForegroundColorSpan(Color.rgb(255, 0, 0));
                text.setSpan(style, error, error + 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                numberCode.setText(text);
            } else {
            }
        } catch (Exception e) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.loading) {
            new Generate().sendToActivity(this,language,"language");
            finish();
        } else if (id == R.id.new_file) {
            editText.getText().clear();
        } else if (id == R.id.action_settings) {

        } else if (id == R.id.open) {

        } else if (id == R.id.new_project) {

        }
        return super.onOptionsItemSelected(item);
    }

    public void setEdit(String text) {
        editText.getText().insert(editText.getSelectionStart(), text);
    }

    @Override
    public void Information(String txt) {

    }


    public void setResult(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();

        if (message.equals("Excellent")) {

        } else {
            message = message.replaceAll("SyntaxError\\(\"expected", "");
            Pattern pattern = Pattern.compile("line(([^\\n+',']+))");
            Matcher matcher = pattern.matcher(message);
            while (matcher.find()) {
                String[] line = message.substring(matcher.start(), matcher.end()).split(" ");
                Toast.makeText(this, "" + line, Toast.LENGTH_SHORT).show();

                try {
                    int l = Integer.parseInt(String.valueOf(new Scanner(line[1]).useDelimiter("[^\\d]+").nextInt()));
                    if (l > 0) {
                        numberOfConstruction(l);

                    } else {
                        numberOfConstruction(0);
                    }
                } catch (NumberFormatException e) {
                }

            }
        }
    }
}
