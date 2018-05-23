package com.example.marchuk.volunteerme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoreInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        String what = getIntent().getStringExtra("what");
        TextView viewWhat = (TextView) findViewById(R.id.textWhat);
        viewWhat.setText(what);

        String where = getIntent().getStringExtra("where");
        TextView viewWhere = (TextView) findViewById(R.id.textWhere);
        viewWhere.setText(where);

        String date = getIntent().getStringExtra("date");
        TextView viewDate = (TextView) findViewById(R.id.textDate);
        viewDate.setText(date);

        Button submit = (Button) findViewById(R.id.button8);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                //change to view
                Intent intent;
                intent = new Intent(MoreInfo.this, ViewVolunteer.class);
                MoreInfo.this.startActivity(intent);
            }
        });



    }
}
