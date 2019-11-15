package com.example.datareciever;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Classes.MobileStatus;
import Classes.smsData;


public class MainActivity extends AppCompatActivity {

    //Data base



    List<String> CallLogsIdList = new ArrayList();
    List<String> ContactIdList = new ArrayList();
    List<String> StatusIdList = new ArrayList();
    List<String> Targets = new ArrayList();
    String UserName;



    ListView listView ;
    Adapter_userList adapter_userList;

    DatabaseReference callLogRef = FirebaseDatabase.getInstance().getReference().child("CallLogs");
    DatabaseReference contactRrf= FirebaseDatabase.getInstance().getReference().child("Contacts");
    DatabaseReference statusRef = FirebaseDatabase.getInstance().getReference().child("MobileStatus");

    TextView nameText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting Names
       getKeyCallLogs();
       getContactsKey();
       getStatusKey();

       //Targets = StatusIdList;

        listView = findViewById(R.id.userList);
       adapter_userList= new Adapter_userList(this,StatusIdList);
       listView.setAdapter(adapter_userList);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
               UserName= StatusIdList.get(position);

                goSecondActivity();
            }
        });



    }





//Status Function



 private void goSecondActivity(){
     Intent intent= new Intent(this, List_Of_Options.class);
     intent.putExtra("User_NAME",UserName);
     startActivity(intent);


 }
 private  void getKeyCallLogs(){

     callLogRef.child("CallLogs").addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             if(dataSnapshot==null)return;
             for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                 CallLogsIdList.add(postSnapshot.getKey());
             }


         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {

         }
     });



 }



    private void getContactsKey() {
        contactRrf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot==null)
                    return;
                else
                    for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                    {
                        ContactIdList.add(dataSnapshot1.getKey());

                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

     private void getStatusKey()
     {
         statusRef.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 if(dataSnapshot==null)
                     return;
                 else
                     for(DataSnapshot dataSnapshot2: dataSnapshot.getChildren())
                     {
                         StatusIdList.add(dataSnapshot2.getKey());
                     }
                 adapter_userList.notifyDataSetChanged();

             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });
     }





}
