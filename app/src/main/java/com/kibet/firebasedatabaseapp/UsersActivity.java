package com.kibet.firebasedatabaseapp;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class UsersActivity extends AppCompatActivity {
    ListView list;
    CustomAdapter adapter;
    ArrayList<Item> users;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        list = findViewById(R.id.listpp);
        users = new ArrayList<>();
        adapter = new CustomAdapter(this,users);
        list.setAdapter(adapter);
        dialog = new ProgressDialog(this);
        dialog.setMessage("loading");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("watu");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users.clear();
                for (DataSnapshot snap: dataSnapshot.getChildren()){
                    Item user = snap.getValue(Item.class);
                    users.add(user);

                    //To ensure that kupata mtu ni rahisi kama kuna list kubwa
                    Collections.reverse(users);
                    dialog.dismiss();
                }
                //When a user is inserting information si lazima ha exit ndio harudi haone watu wame jiongeza ataona hapohapo

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UsersActivity.this, "Sorry system locked", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
