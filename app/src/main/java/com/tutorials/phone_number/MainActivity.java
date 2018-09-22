package com.tutorials.phone_number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText phoneTextField = findViewById(R.id.phoneTextField);
        //Create text watcher
        MaskedEditTextWatcher simpleListener = new MaskedEditTextWatcher(phoneTextField, new MaskedEditTextWatcherDelegate() {
            @Override
            public String maskForCountryCode(String text) {
                //Here you receive just entered text
                //and you should return the mask or null
                switch (text) {
                    case "1":
                        return "+1 ###-###-####";
                    case "7":
                        return "+7 (###) ###-##-##";
                    case "44":
                        return "+44 (##) ###-####";
                    case "64":
                        return "+64 ## # (###) ##-##";
                }
                return null;
            }
        });
        //Add the textWatcher to your text field
        phoneTextField.addTextChangedListener(simpleListener);
    }
}
