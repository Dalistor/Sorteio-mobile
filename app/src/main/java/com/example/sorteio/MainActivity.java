package com.example.sorteio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void roolButton(View v) {
        String id = getResources().getResourceEntryName(v.getId());
        TextView field = findViewById(R.id.result);

        String result = String.valueOf(roolDice(getIntInString(id)));
        field.setText(result);
    }

    public int roolDice(int number) {
        int randomNumber = new Random().nextInt(number) + 1;

        return randomNumber;
    }

    public int getIntInString(String string) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);

        int number = 0;
        while (matcher.find()) {
            String digits = matcher.group();
            number = Integer.parseInt(digits);
        }

        return number;
    }
}