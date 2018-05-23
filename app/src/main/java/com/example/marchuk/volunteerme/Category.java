package com.example.marchuk.volunteerme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        Button add = (Button) findViewById(R.id.button2);

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Category.this, AddVolunteer.class);
                Category.this.startActivity(intent);
            }
        });


        Button view = (Button) findViewById(R.id.button3);

        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Category.this, ViewVolunteer.class);
                Category.this.startActivity(intent);
            }
        });

    }
}
