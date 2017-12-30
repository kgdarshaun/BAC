package com.example.darshaun.bac;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class first extends AppCompatActivity implements View.OnClickListener {

    Button result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        result = (Button) findViewById(R.id.button);

        result.setOnClickListener(this);
    }

    public void onClick(View view) {

        Spinner pressure = (Spinner)findViewById(R.id.spinner1);
        EditText cfm = (EditText)findViewById(R.id.editText);
        Spinner capacity = (Spinner)findViewById(R.id.spinner2);
        Spinner model = (Spinner)findViewById(R.id.spinner3);
        EditText discount = (EditText)findViewById(R.id.editText2);

        //Toast.makeText(first.this,"hi"),Toast.LENGTH_SHORT).show();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("pressure" , Integer.parseInt((String) pressure.getSelectedItem()));
        editor.putInt("cfm" , Integer.parseInt(cfm.getText().toString()));
        editor.putInt("capacity", Integer.parseInt(capacity.getSelectedItem().toString()));
        editor.putString("model", model.getSelectedItem().toString());
        editor.putInt("discount",Integer.parseInt(discount.getText().toString()));
        editor.commit();

        Intent intent = new Intent(this, result.class);
        startActivity(intent);
    }
}
