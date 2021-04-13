package com.nguyenngoctrunghieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.DBHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edName;
    private EditText edQuantity;
    private Button btAdd;
    private Button btView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        db = new DBHelper(this);
        db.GetReadableDatabase;
    }

    private void initView(){
        edName = (EditText) findViewById(R.id.edName);
        edQuantity = (EditText) findViewById(R.id.edQuantity);
        btAdd = (Button) findViewById(R.id.btAdd);
        btView = (Button) findViewById(R.id.btView);
        btAdd.setOnClickListener(this);

        @Override
                public void onClick(){
            if (edName.getText().toString().isEmpty()){
                Toast.makeText(this, "Please enter your name",Toast.LENGTH_LONG).show();
                return;
            }
            String iAdd = db.addActivity(edName.getText().toString());
            Toast.makeText(this,iAdd,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, ListAct.class);
            startActivity(intent);

        }
    }
}