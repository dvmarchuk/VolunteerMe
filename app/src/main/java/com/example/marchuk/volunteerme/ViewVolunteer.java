package com.example.marchuk.volunteerme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewVolunteer extends AppCompatActivity {

    private static final String TAG = "blank";
    String value;
    String strWhere;
    String strWhat;
    String strDate;

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_volunteer);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();


//        Movie bm = new Movie("What: Feed the homeless", "Where: Homeless shelter", "5/24 at 7pm");
//        movieList.add(bm);


        final DatabaseReference what = database.getReference("what");
        what.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                strWhat = dataSnapshot.getValue(String.class);

//                Log.d(TAG, "Value is: " + strWhat);
//                Toast.makeText(ViewVolunteer.this, strWhat,
//                        Toast.LENGTH_LONG).show();
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        final DatabaseReference where = database.getReference("where");
        where.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                strWhere = dataSnapshot.getValue(String.class);

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        final DatabaseReference date = database.getReference("date");
        date.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                strDate = dataSnapshot.getValue(String.class);

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });




        Button submit = (Button) findViewById(R.id.button8);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                TextInputLayout what = findViewById(R.id.What);
//                myRef.setValue(what.getEditText().toString());


                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

                    mAdapter = new MoviesAdapter(movieList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(mAdapter);
                    prepareMovieData();

                recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Movie movie = movieList.get(position);
//                        Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();

                        Intent intent;
                        intent = new Intent(ViewVolunteer.this, MoreInfo.class);
                        intent.putExtra("what", movie.getGenre());
                        intent.putExtra("where", movie.getTitle());
                        intent.putExtra("date", movie.getYear());
                        ViewVolunteer.this.startActivity(intent);

                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));


                //change to view

            }
        });

    }

    private void prepareMovieData() {
        int counter = mAdapter.getItemCount();
        for(int i=-1; i<counter; i++){
            Movie movie = new Movie(strWhat, strWhere, strDate);
            movieList.add(movie);
        }



        mAdapter.notifyDataSetChanged();
    }



    public int getNum(){
        int num = mAdapter.getItemCount();
        return num;
    }


}
