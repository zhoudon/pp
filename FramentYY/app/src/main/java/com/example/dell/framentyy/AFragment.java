package com.example.dell.framentyy;


import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dell.Main2Activity;
import com.example.dell.MyHilder;
import com.example.dell.greendao.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {

    private ListView list1;
    private StudentDao daow;
    ArrayList<Student> arrayList = new ArrayList<>();
    private Myadapter myadapter;

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String p = intent.getStringExtra("p");
            String o = intent.getStringExtra("pp");
            String l = intent.getStringExtra("pp1");
            Student student = new Student();
            student.setName(p);
            student.setGender(o);
            student.setJi(l);
            daow.insert(student);
            myadapter = new Myadapter(getContext(), arrayList);
            list1.setAdapter(myadapter);
            arrayList.clear();

            List<Student> list = daow.queryBuilder().list();
            arrayList.addAll(list);
            myadapter.notifyDataSetChanged();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initData();
        myadapter = new Myadapter(getContext(), arrayList);
        list1.setAdapter(myadapter);
        return inflate;
    }

    private void initView(View inflate) {
        list1 = (ListView) inflate.findViewById(R.id.list1);
        daow = MyHilder.getIntence(getContext()).getDaow();
        List<Student> list1 = daow.queryBuilder().list();
        if (list1.size() == 0) {
            for (int i = 0; i < 10; i++) {
                Student student = new Student();
                student.setName("hh" + i);
                student.setGender("hh" + i);
                student.setJi("11" + i);
                daow.insert(student);
            }
        }
        StudentDao daor = MyHilder.getIntence(getContext()).getDaor();
        List<Student> list = daor.queryBuilder().list();
        arrayList.addAll(list);

        IntentFilter filter = new IntentFilter();
        filter.addAction("dd");
        getActivity().registerReceiver(receiver, filter);
    }

    private void initData() {
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder bu = new AlertDialog.Builder(getContext());
                bu.setTitle("呵呵呵");
                bu.setIcon(R.mipmap.ic_launcher);
                bu.setMessage("是否删除");
                bu.setPositiveButton("删除", new DatePickerDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        daow.delete(arrayList.get(position));
                        arrayList.remove(position);
                        myadapter.notifyDataSetChanged();
                    }
                });
                bu.setNegativeButton("修改", new DatePickerDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getContext(), Main2Activity.class);
                        intent.putExtra("dui", arrayList.get(position));
                        startActivityForResult(intent, 100);
                    }
                });
                bu.show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            StudentDao daor = MyHilder.getIntence(getContext()).getDaor();
            List<Student> list = daor.queryBuilder().list();
            arrayList.clear();
            arrayList.addAll(list);
            myadapter.notifyDataSetChanged();
        }
    }
}
