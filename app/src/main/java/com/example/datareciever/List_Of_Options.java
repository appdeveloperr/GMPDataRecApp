package com.example.datareciever;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Classes.CallLogs;
import Classes.MobileStatus;
import Classes.PersonContact;
import Classes.smsData;

public class List_Of_Options extends AppCompatActivity {

    Button statusBtn, contactsBtn,calllogsBtn,smsBtn;

    DatabaseReference smsREf ;

    ArrayList<smsData> smsDataArrayList= new ArrayList<>();
    ArrayList<String> SmsIDList= new ArrayList<>();

    final static  int StatusCode=1;
    final static  int ConactsCode=2;
    final static  int LogsCode=3;
    final static int smsCode=4;
    static int i=0;


    String UserName_From_Previous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__of__options);

        statusBtn = findViewById(R.id.statusBTn);
        contactsBtn = findViewById(R.id.contactBtn);
        calllogsBtn= findViewById(R.id.callogBtn);
        smsBtn= findViewById(R.id.getSms);


        smsREf = FirebaseDatabase.getInstance().getReference().child("SmsData").child("Boss");


        UserName_From_Previous= getIntent().getStringExtra("User_NAME");


        //Sms functions

        getSmsKey();


        calllogsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    sendCallData();

            }
        });

        contactsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    sendConactsIntent();

            }
        });






        statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    sendStatusIntent();






            }
        });

        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

              sendSmsIntent();
            }
        });








        //End of on Create
    }


   private void getSmsKey(){

       smsREf.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if(dataSnapshot==null)
                   return;
               else
                   for(DataSnapshot dataSnapshot2: dataSnapshot.getChildren())
                   {
                       SmsIDList.add(dataSnapshot2.getKey());
                   }
               Toast.makeText(List_Of_Options.this, "got smskey"+SmsIDList.size(), Toast.LENGTH_SHORT).show();


           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

   }










     private void sendStatusIntent()
     {

         Intent intent = new Intent(this, Display_Data.class);
         intent.putExtra("Key",StatusCode);
         intent.putExtra("User_NAME",UserName_From_Previous);
         startActivity(intent);



     }

    private void sendConactsIntent(){


        Intent intent = new Intent(this, Display_Data.class);


        intent.putExtra("Key",ConactsCode);
        intent.putExtra("User_NAME",UserName_From_Previous);


        startActivity(intent);



    }

    private void sendCallData(){
        Intent intent = new Intent(this,Display_Data.class);
        intent.putExtra("Key", LogsCode);
        intent.putExtra("User_NAME",UserName_From_Previous);
        startActivity(intent);

    }

    private void sendSmsIntent(){

        Bundle bundle = new Bundle();
        bundle.putSerializable("SmsID",SmsIDList);
        Intent intent = new Intent(this, Display_Data.class);
        intent.putExtra("Key",smsCode);
        intent.putExtra("User_NAME",UserName_From_Previous);
        intent.putExtras(bundle);

        startActivity(intent);


    }


}
