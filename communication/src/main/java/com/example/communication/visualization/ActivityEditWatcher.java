package com.example.communication.visualization;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

import com.example.communication.Communication;

import java.util.regex.Matcher;

public class ActivityEditWatcher implements TextWatcher {
    Communication mainActivity;
    public ActivityEditWatcher(Communication mainActivity) {
        this.mainActivity=mainActivity;
    }

    //до изменении текста
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    /**при изменении текста и добавлениии текста и переходе на новую строку*/
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
