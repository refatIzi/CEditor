package com.example.terminal.visualization;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

import com.example.terminal.Terminal;

import java.util.regex.Matcher;

public class TerminalEditWatcher implements TextWatcher {
    Terminal terminal;

    public TerminalEditWatcher(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (!s.toString().contains("\n")) {
            //terminal.shell(s.toString());

            // Log.e("TAG", "Первая строка: Печатается");
        } else {
            Log.e("TAG", "Первая строка: " + s.toString().startsWith("\n"));
            if (s.toString().startsWith("\n")) {
               terminal.shell("\n");
                terminal.clearEdit();

            } else {
                String[] str = s.toString().split("\n");
                terminal.shell(str[0]+"\n");
                terminal.clearEdit();
            }


        }
    }

    // после изменении текста
    @Override
    public void afterTextChanged(Editable s) {
        removeSpans(s, ForegroundColorSpan.class);
        for (Visualization.TextColor tetxtColor : Visualization.getColors()) {
            for (Matcher m = tetxtColor.pattern.matcher(s); m.find(); ) {
                s.setSpan(new ForegroundColorSpan(tetxtColor.color),
                        m.start(),
                        m.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    void removeSpans(Editable e, Class<? extends CharacterStyle> type) {
        CharacterStyle[] spans = e.getSpans(0, e.length(), type);
        for (CharacterStyle span : spans) {
            e.removeSpan(span);
        }
    }
}
