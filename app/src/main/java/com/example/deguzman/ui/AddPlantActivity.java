package com.example.deguzman.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.nineoldandroids.view.ViewHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AddPlantActivity extends AppCompatActivity {

    final Context context = this;

    private SwipeLayout sample1, sample2, sample3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.fab) ;
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddPlantActivity.this, AddPlantInforActivity.class);
                startActivity(i);
            }
        });

//        SwipeLayout swipeLayout = (SwipeLayout)findViewById(R.id.godfather);
//        swipeLayout.setDragEdge(SwipeLayout.DragEdge.Bottom); // Set in XML

        //sample1


        //sample2

        sample2 = (SwipeLayout) findViewById(R.id.sample2);
        sample2.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample2.addDrag(SwipeLayout.DragEdge.Right, sample2.findViewWithTag("Bottom2"));
//        sample2.setShowMode(SwipeLayout.ShowMode.PullOut);
        sample2.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPlantActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddPlantActivity.this, AddPlantInforActivity.class);
                startActivity(i);
            }
        });

        sample2.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPlantActivity.this, "Trash Bin", Toast.LENGTH_SHORT).show();
            }
        });

        sample2.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPlantActivity.this, "Magnifier", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddPlantActivity.this, ScanActivity.class);
                startActivity(i);
            }
        });

        sample2.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPlantActivity.this, "Click on surface", Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog1);

                TextView title = (TextView) dialog.findViewById(R.id.title);
                title.setText("A1");

                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.input_name);
                text.setText("Lettuce");

                dialog.show();
            }
        });


    }


    /*
    Color transition method.
     */
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int startInt = (Integer) startValue;
        int startA = (startInt >> 24) & 0xff;
        int startR = (startInt >> 16) & 0xff;
        int startG = (startInt >> 8) & 0xff;
        int startB = startInt & 0xff;

        int endInt = (Integer) endValue;
        int endA = (endInt >> 24) & 0xff;
        int endR = (endInt >> 16) & 0xff;
        int endG = (endInt >> 8) & 0xff;
        int endB = endInt & 0xff;

        return (int) ((startA + (int) (fraction * (endA - startA))) << 24) |
                (int) ((startR + (int) (fraction * (endR - startR))) << 16) |
                (int) ((startG + (int) (fraction * (endG - startG))) << 8) |
                (int) ((startB + (int) (fraction * (endB - startB))));
    }
}