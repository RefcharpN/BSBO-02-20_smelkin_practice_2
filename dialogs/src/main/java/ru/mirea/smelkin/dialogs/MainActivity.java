package ru.mirea.smelkin.dialogs;

import static android.Manifest.permission.POST_NOTIFICATIONS;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int PermissionCode = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //проверка разрешения

        if(ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED)
        {
            Log.d(MainActivity.class.getSimpleName().toString(), "разрешение получено");
        }
        else
        {
            Log.d(MainActivity.class.getSimpleName(),"не получено разршение");
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, PermissionCode);
        }
    }

    public void Toast_click(View view)
    {
        EditText text_ed = (EditText) findViewById(R.id.editTextTextPersonName);

        Toast.makeText(getApplicationContext() , String.format("Студент %s. кол-во символов %s", text_ed.getText().toString(), text_ed.getText().toString().length()), Toast.LENGTH_SHORT).show();
    }

    private static final String CHANNEL_ID = "com.smelkin.asd.notification.ANDROID";//почему именно это?
    public void send_notification(View view)
    {

        if (ActivityCompat.checkSelfPermission(this, POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setContentText("test").setSmallIcon(R.drawable.ic_launcher_background).setPriority(NotificationCompat.PRIORITY_HIGH).setStyle(new NotificationCompat.BigTextStyle().bigText("loooooooooooo ...  ooooooooooooooooooooooooooooooooooooooooooooo ... oooooong text")).setContentTitle("mirea");

        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Smelkin", importance);
        channel.setDescription("MIREA");
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.createNotificationChannel(channel);
        notificationManager.notify(1, builder.build());

    }

    public void popup(View view)
    {
        MyDialogFragment fragment = new MyDialogFragment();

        fragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(this, "кнопка нажата", Toast.LENGTH_SHORT).show();
    }
}