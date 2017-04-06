package com.django1.yogesh.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder notification;
    int no=1;
    public static final int uniqueid=12367;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification= new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
   public void buttonclicked(View view){
       //build the notification

       notification.setSmallIcon(R.mipmap.ic_launcher);
       notification.setTicker("This is the ticker");
       notification.setWhen(System.currentTimeMillis());
       notification.setContentTitle("Here is the title");
       notification.setContentText("This is the body");
       notification.setNumber(no);
       Intent intent=new Intent(this,MainActivity.class);
       PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
       notification.setContentIntent(pendingIntent);
       //build notification nd issue it

       NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
       notificationManager.notify(uniqueid,notification.build());
       no++;
   }

}
