package com.example.datareciever;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Classes.CallLogs;

public class Call_Logs_Adapter extends BaseAdapter {
    ArrayList<CallLogs> callLogsArrayList = new ArrayList<>();
    Context mcontext;
    public Call_Logs_Adapter(Context m, ArrayList<CallLogs> callLogs){
        mcontext=m;
        callLogsArrayList=callLogs;
    }
    TextView Date,Duration,callType,dir,no;




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = null;
        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.call_logs_listview,null);
        }
        else{
            v=convertView;
        }

        Date = v.findViewById(R.id.callDateTv);
        Duration = v.findViewById(R.id.callDuration);
        callType = v.findViewById(R.id.callType);
        dir = v.findViewById(R.id.callDirection);
        no= v.findViewById(R.id.phoneNumber);

        CallLogs callLogs = callLogsArrayList.get(position);
        Date.setText(callLogs.getCalldate());
        Duration.setText(callLogs.getCallduration());
        callType.setText(callLogs.getCalltype());
        dir.setText(callLogs.getDir());
        no.setText(callLogs.getPhoneno());





        return v;
    }

    @Override
    public int getCount() {
        return callLogsArrayList.size();
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
