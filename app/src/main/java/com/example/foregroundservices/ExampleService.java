package com.example.foregroundservices;

import static com.example.foregroundservices.App.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ExampleService extends Service {


    //private static final String CHANNEL_ID = "exampleServiceChannel" ;

    @Override
    public  void onCreate(){
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent,int flags, int startId){
        String input = intent.getStringExtra("inputExtra");
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID )
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
