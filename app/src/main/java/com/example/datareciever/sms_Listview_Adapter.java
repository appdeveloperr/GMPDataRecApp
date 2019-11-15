package com.example.datareciever;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Classes.smsData;

public class sms_Listview_Adapter extends BaseAdapter {

    Context mcontext;
    ArrayList<smsData> smsDataArrayList2= new ArrayList<>();
    TextView smsbody,smsNum;

    public sms_Listview_Adapter(Context m,ArrayList<smsData> p){
        mcontext=m;
        smsDataArrayList2=p;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=null;
            if(convertView==null)
            {
                LayoutInflater inflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.sms_listview,null);

            }
            else
            {
                v=convertView;
            }

        smsbody= v.findViewById(R.id.smsBodyTv);
        smsNum=v.findViewById(R.id.smsNumberTv);
        smsData sms = smsDataArrayList2.get(position);
        smsbody.setText(sms.getBody());
        smsNum.setText(sms.getNumber());







        return v;
    }


    @Override
    public int getCount() {
        return smsDataArrayList2.size();
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
