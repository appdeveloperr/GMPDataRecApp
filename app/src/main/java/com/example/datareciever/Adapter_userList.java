package com.example.datareciever;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_userList extends BaseAdapter {
    Context context;
    List<String> Target = new ArrayList();
    String user;

    TextView userName ;




    public  Adapter_userList(Context m,List<String>user)
    {
        context=m;
        Target=user;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = null;
        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.user_key_list,null);

        }
        else
        {
            v=convertView;
        }
        userName = v.findViewById(R.id.userNameTV);
        user = Target.get(position);
        userName.setText(user);








        return v;
    }


    @Override
    public int getCount() {
        return Target.size();
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
