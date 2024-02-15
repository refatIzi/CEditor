package com.example.ceditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ceditors.language.Language;


import com.example.communication.Communication;
import com.example.communication.connect.Сonnected;
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
        String code="#Python program to find the factorial of a number provided by the user.\n" +
                "#import time\n" +
                "import time\n" +
                "print('FACTORIAL')\n" +
                "def main():\n" +
                "    # create parrot1 object\n" +
                "    # change the value for a different result\n" +
                "    num = 15\n" +
                "    # To take input from the user\n" +
                "    #num = int(input(\"Enter a number: \"))\n" +
                "    factorial = 1\n" +
                "    # check if the number is negative, positive or zero\n" +
                "    if num < 0:\n" +
                "        print(\"Sorry, factorial does not exist for negative numbers\")\n" +
                "    elif num == 0:\n" +
                "        print(\"The factorial of 0 is 1\")\n" +
                "    else:\n" +
                "        for i in range(1,num + 1):\n" +
                "            factorial = factorial*i\n" +
                "            #time.sleep(0.3)\n" +
                "                #time.sleep(6)\n" +
                "            print(factorial)\n" +
                "\n" +
                "        print(\"The factorial of\",num,\"is\",factorial)\n" +
                "    #num = int(input(\"Enter a number: \"))\n" +
                "if name == 'main':\n" +
                "    main()";
        Language language = new Language(code, "Python", functions);

        //new Generate(this, CEditors.class, language, "language");
       Сonnected сonnected = new Сonnected();
       new Generate(this, Communication.class, сonnected, "language");
    }


    @Override
    public void setText(String text) {
        texttt.setText(text);
    }

    @Override
    public void setCls(Object cls) {
        Language language = (Language) cls;
        texttt.setText(language.getCode() + " " + language.getLanguage()+ " " + language.getParameters()+ " " + language.getAction());
    }
}