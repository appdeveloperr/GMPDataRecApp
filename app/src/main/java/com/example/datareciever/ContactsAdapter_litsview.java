package com.example.datareciever;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Classes.PersonContact;

public class ContactsAdapter_litsview extends BaseAdapter {

    Context mcontext;
    ArrayList<PersonContact> personContactArrayList = new ArrayList<>();

    public ContactsAdapter_litsview(Context m, ArrayList<PersonContact> personContacts){
        mcontext=m;
        personContactArrayList=personContacts;

    }

    TextView CName,CNumber;





    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=null;
        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.contacts_listview,null);

        }
        else{
            v=convertView;
        }
        CName = (TextView) v.findViewById(R.id.contactNameTv);
        CNumber = (TextView) v.findViewById(R.id.contactNumberTv);

        PersonContact personContact = personContactArrayList.get(position);
        CName.setText(personContact.getContactname());
        CNumber.setText(personContact.getContactnnumber());







        return v;
    }



    @Override
    public int getCount() {

        return personContactArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
