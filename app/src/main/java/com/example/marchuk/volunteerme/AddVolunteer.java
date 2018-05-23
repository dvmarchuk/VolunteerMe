package com.example.marchuk.volunteerme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddVolunteer extends AppCompatActivity {

    String getWhere;
    String getWhat;
    String getDate;
    int num = 0;



    private static final String TAG = "blank";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference what = database.getReference("what");
    DatabaseReference where = database.getReference("where");
    DatabaseReference date = database.getReference("date");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_volunteer);

        ViewVolunteer viewVolunteer = new ViewVolunteer();
//TODO


        // Write a message to the database


        Button submit = (Button) findViewById(R.id.button4);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextInputLayout pullWhere = findViewById(R.id.Where);  //time
                EditText etWhere = pullWhere.getEditText();
                String whereStr = etWhere.getText().toString();

                TextInputLayout pullWhat = findViewById(R.id.What);  //time
                EditText etWhat = pullWhat.getEditText();
                String whatStr = etWhat.getText().toString();

                TextInputLayout pullDate = findViewById(R.id.Date);  //time
                EditText etDate = pullDate.getEditText();
                String dateStr = etDate.getText().toString();


                getWhere = ("Where: " + whereStr);
                getWhat = ("What: " + whatStr);
                getDate = ("Date: "  + dateStr);

                what.setValue(getWhat);
                where.setValue(getWhere);
                date.setValue(getDate);


                //change to view
                Intent intent;
                intent = new Intent(AddVolunteer.this, Confirm.class);
                AddVolunteer.this.startActivity(intent);
            }
        });


    }
}
