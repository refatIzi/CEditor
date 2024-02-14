package com.example.ceditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ceditors.CEditors;

import com.example.ceditors.language.Language;
import com.example.generate.Generate;
import com.example.generate.ReturnActivity;

/**
 * @Activity Реалізує інтерфейс ReturnActivity:
 * Цей інтерфейс містить методи для повернення даних з активності.
 **/
public class MainActivity extends AppCompatActivity implements ReturnActivity {

    TextView texttt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texttt = findViewById(R.id.texttt);
        /**
         * Створює масив рядків functions, який містить список функцій Python.
         * Створює об'єкт класу Language з кодом Python, мовою та списком функцій.
         * Створює об'єкт класу Generate, який використовується для виконання дії з класом CEditors який є Activity та об'єктом Language.
         **/

        String[] functions = {
                "self", "def", "as", "assert", "break", "continue", "del", "elif", "else", "except", "finally", "for", "from", "global",
                "if", "import", "in", "pass", "raise", "return", "try", "while", "with", "yield", "min()", "setattr()", "abs()", "all()",
                "dir()", "hex()", "next()", "any()", "divmod()", "id()", "sorted()", "ascii()", "enumerate()", "input()", "oct()", "max()",
                "round()", "bin()", "eval()", "exec()", "isinstance()", "ord()", "sum()", "filter()", "issubclass()", "pow()", "iter()",
                "print()", "callable()", "format()", "delattr()", "len()", "chr()", "range()", "vars()", "getattr()", "locals()", "repr()",
                "zip()", "compile()", "globals()", "map()", "reversed()", "__import__()", "hasattr()", "hash()", "memoryview()"};
        Language language = new Language("print(\"Hello World HI RIFATE\")", "Python", functions);
        new Generate(this, CEditors.class, language, "language");


    }


    @Override
    public void setText(String text) {
        texttt.setText(text);
    }

    @Override
    public void setCls(Object cls) {
        Language language = (Language) cls;
        texttt.setText(language.getCode() + " " + language.getLanguage());
    }
}