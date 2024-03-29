package com.example.ceditor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ceditors.language.Language;


import com.example.communication.Communication;
import com.example.communication.connect.AConnect;
import com.example.communication.connect.Сonnected;
import com.example.dashboard.status.DetectFile;
import com.example.dashboard.status.DetectHost;
import com.example.dashboard.status.DetectStatus;
import com.example.generate.Generate;
import com.example.generate.ReturnActivity;
import com.example.terminal.terminal.Contact;

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
        String code = "#Python program to find the factorial of a number provided by the user.\n" +
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

        Contact contact = new Contact();

        String metadate = "Metadata has various purposes. It can help users find relevant information and discover resources. It can also help organize electronic resources, provide digital identification, and archive and preserve resources. Metadata allows users to access resources by \"allowing resources to be found by relevant criteria, identifying resources, bringing similar resources together, distinguishing dissimilar resources, and giving location information\".[8] Metadata of telecommunication activities including Internet traffic is very widely collected by various national governmental organizations. This data is used for the purposes of traffic analysis and can be used for mass surveillance.[9]\n" +
                "\n" +
                "Metadata was traditionally used in the card catalogs of libraries until the 1980s when libraries converted their catalog data to digital databases.[10] In the 2000s, as data and information were increasingly stored digitally, this digital data was described using metadata standards.[11]";


        /**HOST імʼя пристрою з кого було отримано даннні*/
        DetectHost detectHost = new DetectHost("Desktop-HS20PTRK", "192.168.200.100", "20:H0:20:10:0:H0:20:10");
        /**Файли по яким було знайдені*/
        DetectFile[] detectFiles = {
                new DetectFile("My word document", "12.12.12", metadate),
                new DetectFile("My word document", "12.12.12", metadate),
                new DetectFile("My word document", "12.12.12", metadate),
                new DetectFile("My word document", "12.12.12", metadate),
                new DetectFile("My word document", "12.12.12", metadate),
                new DetectFile("My word document", "12.12.12", metadate),
                new DetectFile("My word document", "12.12.12", metadate),
                new DetectFile("My word document", "12.12.12", metadate)};
        DetectStatus detectStatus = new DetectStatus(detectHost, detectFiles);
        DetectStatus[] detectStatuses = {detectStatus, detectStatus, detectStatus, detectStatus, detectStatus, detectStatus};
        //new Generate(this, CEditors.class, language, "language");

        String[] metadates = {"My word document", "My word document", "My word document", "My word document", "My word document", "My word document",};
        AConnect aConnect1 = new AConnect("Desktop-HS20PTRK", metadates, "online");
        AConnect aConnect2 = new AConnect("Desktop-HS20PTRK", metadates, "offline");
        AConnect aConnect3 = new AConnect("Desktop-HS20PTRK", metadates, "online");
        AConnect aConnect4 = new AConnect("Desktop-HS20PTRK", metadates, "offline");
        AConnect aConnect5 = new AConnect("Desktop-HS20PTRK", metadates, "online");

        AConnect[] connects = {aConnect1, aConnect2, aConnect3, aConnect4, aConnect5};
        Сonnected сonnected = new Сonnected(connects);
        new Generate(this, Communication.class, сonnected, "сonnected");
        //new Generate(this, Terminal.class, contact, "contact");
        //new Generate(this, Dashboard.class, status, "status");
    }


    @Override
    public void setText(String text) {
        texttt.setText(text);
    }

    @Override
    public void setCls(@NonNull Object cls) {
        Toast.makeText(this, " action " + cls.toString(), Toast.LENGTH_LONG).show();
        if (cls.toString().equals("loading")) {
            Language language = (Language) cls;
            texttt.setText(language.getCode() + " " + language.getLanguage() + " " + language.getParameters() + " " + language.getAction());
        }
    }
}