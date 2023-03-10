package ru.mirea.smelkin.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicked(View view)
    {
        Uri url = Uri.parse("https://www.mirea.ru/");
        Intent openLink = new Intent(Intent.ACTION_VIEW, url);
        startActivity(openLink);
    }

    public void clicked_2(View view)
    {
        Intent shInt = new Intent(Intent.ACTION_SEND);
        shInt.setType("text/plain");
        shInt.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
        shInt.putExtra(Intent.EXTRA_TEXT, "Смелкин Н.Д.");
        startActivity(Intent.createChooser(shInt, " Моё ФИО"));
    }
}