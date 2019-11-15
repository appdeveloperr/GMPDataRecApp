package com.example.datareciever;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Classes.MobileStatus;

public class Array_Adapter_Last extends BaseAdapter {

    Context context;
    ArrayList<MobileStatus> mobileStatusArrayList = new ArrayList<>();
    TextView Battery , ntwrk, simID, simavail;



    public Array_Adapter_Last(Context m , ArrayList<MobileStatus> mobileStatuses)
    {
        context=m;
        mobileStatusArrayList= mobileStatuses;

    }







    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=null;

            if(convertView==null)
            {
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.list_view_layout_last,null);

            }
            else
            {
                v=convertView;
            }
            Battery = v.findViewById(R.id.batteryLevel);
            ntwrk= v.findViewById(R.id.network);
            simavail = v.findViewById(R.id.simAvail);
            simID = v.findViewById(R.id.simId);

            MobileStatus mobileStatus = new MobileStatus();
            mobileStatus= mobileStatusArrayList.get(position);
            Battery.setText(mobileStatus.getBatterylevel());
            ntwrk.setText(mobileStatus.getNetworkavaiable());
            simID.setText(mobileStatus.getSimid());
            simavail.setText(mobileStatus.getSimavailable());






        return v;
    }


    @Override
    public int getCount() {

        return mobileStatusArrayList.size();
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
