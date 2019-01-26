package com.example.deguzman.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScanActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        FloatingActionButton sum = (FloatingActionButton) findViewById(R.id.summary);
        sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_scan);

//                TextView title = (TextView) dialog.findViewById(R.id.title);
//                title.setText("A1");
//
//                // set the custom dialog components - text, image and button
//                TextView text = (TextView) dialog.findViewById(R.id.input_name);
//                text.setText("Lettuce");

                dialog.show();
            }
        });

        Button a1 = (Button) findViewById(R.id.a1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScanActivity.this, DisplayActivity.class);
                startActivity(i);
            }
        });
    }
}
