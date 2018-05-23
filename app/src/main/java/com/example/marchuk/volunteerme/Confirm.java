package com.example.marchuk.volunteerme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);




        Button next = (Button) findViewById(R.id.button8);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                //change to view
                Intent intent;
                intent = new Intent(Confirm.this, ViewVolunteer.class);
                Confirm.this.startActivity(intent);
            }
        });
    }
}
