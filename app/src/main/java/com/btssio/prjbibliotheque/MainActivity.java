package com.btssio.prjbibliotheque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button BTCNX;
    private Button BTINSC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTCNX = (Button) findViewById(R.id.BTCNX);
        BTINSC = (Button) findViewById(R.id.BTINSC);

        BTCNX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toConnexion();
            }
        });
        BTINSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toInscription();
            }
        });
    }
    public void toConnexion(){
        Intent intent = new Intent(getApplicationContext(),CnxActivity.class);
        startActivity(intent);
        finish();
    }
    public void toInscription(){
        Intent intent2 = new Intent(getApplicationContext(),InscActivity.class);
        startActivity((intent2));
        finish();
    }
}