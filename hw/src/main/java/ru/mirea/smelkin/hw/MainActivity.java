package ru.mirea.smelkin.hw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show_snack(View view)
    {
        Snackbar.make(view, "smelkin bsbo-02-20", Snackbar.LENGTH_SHORT).show();
    }

    public void show_time(View view)
    {
        MyTimeDialog dialog = new MyTimeDialog(MainActivity.this);
    }



    public void show_date(View view)
    {
        MydateDialog dialog = new MydateDialog(MainActivity.this);
    }
}