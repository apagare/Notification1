package abhijeet.com.notification1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder nsb;
    private  final int uniqueid=1232022;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       nsb=new NotificationCompat.Builder(MainActivity.this);

        nsb.setAutoCancel(true);
        Button btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                diplay();
            }
        });

    }
    public void diplay(){
    nsb.setSmallIcon(R.mipmap.ic_launcher_round);
        nsb.setTicker("The Rock is Cooking ");
        nsb.setWhen(System.currentTimeMillis());
        nsb.setContentTitle("The Rock is Cooking ");
        nsb.setContentText("Body of the notification");


         Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pd= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        nsb.setContentIntent(pd);

        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueid,nsb.build());

    }
}
