
package com.example.marchuk.volunteerme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);





        Button back = (Button) findViewById(R.id.button7);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Confirmation.this, ViewVolunteer.class);
                Confirmation.this.startActivity(intent);
            }
        });
    }
}
