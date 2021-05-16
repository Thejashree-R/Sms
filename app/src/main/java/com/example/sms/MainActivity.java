package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num,msg;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num=findViewById(R.id.ed1);
        msg=findViewById(R.id.ed2);
        ok=findViewById(R.id.b1);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    SmsManager smg=SmsManager.getDefault();
                    smg.sendTextMessage(num.getText().toString(),null,msg.getText().toString(),null,null);
                    Toast.makeText(MainActivity.this,"sms sent",Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"sms fail",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}