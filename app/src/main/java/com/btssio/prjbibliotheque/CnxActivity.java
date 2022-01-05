package com.btssio.prjbibliotheque;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class CnxActivity extends AppCompatActivity {
    private TextView TVEmailCnx;
    private TextView TVMdpCnx;
    private Button BTForgotPassword;
    private Button BTCNX;
    private Button BTINSC;
    StringRequest stringRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnx);

        TVEmailCnx = (TextView) findViewById(R.id.TVEmailCnx);
        TVMdpCnx = (TextView) findViewById(R.id.TVMdpCnx);

        BTForgotPassword = (Button) findViewById(R.id.BTForgotPassword);
        BTCNX = (Button) findViewById(R.id.BTCNX);
        BTINSC = (Button) findViewById(R.id.BTINSC);

        BTINSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { toInscription();}
        });
        BTForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toForgotPassword();
            }
        });
        BTCNX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRecap();
            }
        });
    }
    public void toRecap(){
        String login = TVEmailCnx.getText().toString().trim();
        String mdp = TVMdpCnx.getText().toString().trim();
        if (!login.equalsIgnoreCase("")&& !mdp.equalsIgnoreCase("")){
            stringRequest = new StringRequest(Request.Method.POST, DBPages.login_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("ResDBE", response);
                    if (StringUtils.contains(response,"Connecté")){
                        Intent intent3 = new Intent(getApplicationContext(), ActivityRecap.class);
                        intent3.putExtra("reponse",response);
                        startActivity(intent3);
                    }else{
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.toString().trim(),Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("login",login);
                    params.put("mdp",mdp);
                    return params;
                }
            };
            requestQueue = Volley.newRequestQueue(CnxActivity.this);
            requestQueue.add(stringRequest);
        }else{
            Toast.makeText(getApplicationContext(),"Les champs sont incomplets",Toast.LENGTH_SHORT).show();
        }
    }
    public void toInscription(){
        Intent intent2 = new Intent(getApplicationContext(),InscActivity.class);
        startActivity(intent2);
        finish();
    }
    public void toForgotPassword(){
        Intent intent = new Intent(getApplicationContext(),FPActivity.class);
        startActivity(intent);
        finish();
    }
}