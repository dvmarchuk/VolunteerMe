package com.example.marchuk.volunteerme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        Button category = (Button) findViewById(R.id.button);

            category.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent;
            intent = new Intent(Start.this, Category.class);
            Start.this.startActivity(intent);
        }
    });



        ImageButton information = (ImageButton) findViewById(R.id.imageButton);

        information.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Start.this, Information.class);
                Start.this.startActivity(intent);
            }
        });




}










}