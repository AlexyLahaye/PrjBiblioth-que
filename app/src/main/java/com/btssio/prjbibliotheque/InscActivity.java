package com.btssio.prjbibliotheque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InscActivity extends AppCompatActivity {
    private TextView TVEmail;
    private TextView TVPrenom;
    private TextView TVNom;
    private TextView TVMdp1;
    private TextView TVMdp2;
    private Button BTVINSC;
    private Button BTReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insc);

        TVEmail = (TextView) findViewById(R.id.TVEmail);
        TVPrenom = (TextView) findViewById(R.id.TVPrenom);
        TVNom = (TextView) findViewById(R.id.TVNom);
        TVMdp1 = (TextView) findViewById(R.id.TVMdp1);
        TVMdp2 = (TextView) findViewById(R.id.TVMdp2);

        BTVINSC = (Button) findViewById(R.id.BTVINSC);
        BTReturn = (Button) findViewById(R.id.BTReturn);

        BTReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toReturn();
            }
        });

        BTVINSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    public void onResponse() {

    }
    public void toReturn(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

}