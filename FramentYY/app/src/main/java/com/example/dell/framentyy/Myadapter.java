package com.example.dell.framentyy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/7/3.
 */
public class Myadapter extends BaseAdapter{
    Context context;
    ArrayList<Student> arrayList;

    public Myadapter(Context context, ArrayList<Student> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder der;
        if(convertView==null){
           der=new viewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.ben, null);
            der.te= (TextView) convertView.findViewById(R.id.name);
            der.te1= (TextView) convertView.findViewById(R.id.sex);
            der.te2= (TextView) convertView.findViewById(R.id.pp);
            convertView.setTag(der);
        }else{
            der= (viewHolder) convertView.getTag();

        }
        Student student = arrayList.get(position);

        der.te.setText(student.getName());
        der.te1.setText(student.getGender());
        der.te2.setText(student.getJi());
        return convertView;
    }
    class viewHolder{
        TextView te;
        TextView te1;
        TextView te2;
    }
}
