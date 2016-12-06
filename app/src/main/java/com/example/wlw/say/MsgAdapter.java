package com.example.wlw.say;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wlw on 2016/12/5.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {
    public MsgAdapter(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg=getItem(position);
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item_msg,parent,false);
        }
        TextView left_TextView= (TextView) convertView.findViewById(R.id.list_item_left);
        TextView right_TextView= (TextView) convertView.findViewById(R.id.list_item_right);
        if (msg.getmType()==Msg.TYPE_RECEIVEO){
            right_TextView.setVisibility(View.GONE);
            left_TextView.setVisibility(View.VISIBLE);
            left_TextView.setText(msg.getmContent());
        }else {
            left_TextView.setVisibility(View.GONE);
            right_TextView.setVisibility(View.VISIBLE);
            right_TextView.setText(msg.getmContent());
        }
        return convertView;
    }
}
