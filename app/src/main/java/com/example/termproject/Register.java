package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.ActionBar;
import android.view.MenuItem;
import androidx.annotation.NonNull;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    TextView username;
    TextView password;
    TextView security;

    public static final String mypreference = "mypref";
    public static final String UserName = "nameKey";
    public static final String Password = "passKey";
    public static final String Security = "secKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        username = (TextView) findViewById(R.id.txtUsername);
        password = (TextView) findViewById(R.id.txtPassword);
        security = (TextView) findViewById(R.id.txtSecurity);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(UserName)) {
            username.setText(sharedpreferences.getString(UserName, ""));
        }
        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));
        }
        if (sharedpreferences.contains(Security)) {
            security.setText(sharedpreferences.getString(Security, ""));
        }
    }
    public void Register(View view) {
        String un = username.getText().toString();
        String p = password.getText().toString();
        String s = security.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(UserName, un);
        editor.putString(Password, p);
        editor.putString(Security, s);

        editor.commit();

        Toast.makeText(this, "User/pass/sec has been saved Successfully!" + un + "," + p + "," + s, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}