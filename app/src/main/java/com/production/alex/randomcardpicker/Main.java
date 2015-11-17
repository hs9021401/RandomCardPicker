package com.production.alex.randomcardpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity implements View.OnClickListener{
    Button btnOnePick, btnThreePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    void initComponent()
    {
        btnOnePick = (Button)findViewById(R.id.onePick);
        btnThreePicker = (Button)findViewById(R.id.oneThree);
        btnOnePick.setOnClickListener(this);
        btnThreePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.onePick:
            case R.id.oneThree:
                Intent it = new Intent(Main.this, ResultActivity.class);
                startActivity(it);
                break;
        }

    }
}
