package com.example.generate;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;


import com.example.serializationutils.SerializationUtils;

import java.io.IOException;

public class Generate {
    Context context;
    ReturnActivity returnActivity; //інтерфейс задопомогою якого ми повертаємо обʼєкт
    Class<?> cls;
    Object rCls; //обʼєкт який треба повернути
    String key;   //Цей ключ використовується для ідентифікації об'єкта.


    public Generate() {

    }

    public Generate(Context context, Class<?> cls, Object rCls, String key) {
        this.context = context;
        this.cls = cls;
        this.rCls = rCls;
        this.key = key;
        returnActivity = (ReturnActivity) context;
        sendToActivity((ComponentActivity) context);
    }

    public void sendToActivity(Activity activity, Object o, String key) {
        try {
            Intent intent = new Intent();
            intent.putExtra(key, SerializationUtils.serialize(o));
            activity.setResult(RESULT_OK, intent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private void sendToActivity(ComponentActivity componentActivity) {
        ActivityResultLauncher<Intent> launcher = componentActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {

                            try {
                                byte[] bytes = (byte[]) data.getSerializableExtra(key);
                                returnActivity.setCls(SerializationUtils.deserialize(bytes));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });

        try {
            Intent intent = new Intent(context, cls);
            intent.putExtra(key, SerializationUtils.serialize(rCls));
            launcher.launch(intent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
