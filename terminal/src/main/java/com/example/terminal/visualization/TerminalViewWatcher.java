package com.example.terminal.visualization;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

import com.example.terminal.Terminal;

import java.util.regex.Matcher;

public class TerminalViewWatcher implements TextWatcher {
    Context terminal;

    public TerminalViewWatcher(Context terminal) {
        this.terminal = terminal;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

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
