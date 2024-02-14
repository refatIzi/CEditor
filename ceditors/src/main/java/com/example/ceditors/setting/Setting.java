package com.example.ceditors.setting;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ceditors.R;


public class Setting {
    Context context;

    public Setting(Activity context) {
        this.context = context;
        //mainInterface = (MainInterface) context;
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        final View linearlayout = context.getLayoutInflater().inflate(R.layout.dialog_setting, null);
        dialog.setView(linearlayout);
        final AlertDialog alertDialog = dialog.show();
        /**установка прозрачного фона вашего диалога*/
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button saveButton = linearlayout.findViewById(R.id.save);

        final SeekBar textSizeBar = linearlayout.findViewById(R.id.text_size_bar);
        final TextView textSize = linearlayout.findViewById(R.id.text_size);

        textSizeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSize.setText("Text size = " + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                       alertDialog.cancel();
            }
        });
        dialog.create();
    }
}
