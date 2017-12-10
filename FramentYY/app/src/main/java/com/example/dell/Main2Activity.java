package com.example.dell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.framentyy.R;
import com.example.dell.framentyy.Student;
import com.example.dell.greendao.dao.StudentDao;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edu;
    private EditText ed1u;
    private EditText ed2u;
    private Button yybuu;
    private Student dui;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        intent = getIntent();
        dui = intent.getParcelableExtra("dui");
        edu.setText(dui.getName());
        ed1u.setText(dui.getGender());
        ed2u.setText(dui.getJi());
    }

    private void initView() {
        edu = (EditText) findViewById(R.id.edu);
        ed1u = (EditText) findViewById(R.id.ed1u);
        ed2u = (EditText) findViewById(R.id.ed2u);
        yybuu = (Button) findViewById(R.id.yybuu);

        yybuu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yybuu:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String eduString = edu.getText().toString().trim();
        if (TextUtils.isEmpty(eduString)) {
            Toast.makeText(this, "请输入名字", Toast.LENGTH_SHORT).show();
            return;
        }

        String ed1uString = ed1u.getText().toString().trim();
        if (TextUtils.isEmpty(ed1uString)) {
            Toast.makeText(this, "请输入性别", Toast.LENGTH_SHORT).show();
            return;
        }

        String ed2uString = ed2u.getText().toString().trim();
        if (TextUtils.isEmpty(ed2uString)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        StudentDao daow = MyHilder.getIntence(this).getDaow();
        dui.setName(eduString);
        dui.setGender(ed1uString);
        dui.setJi(ed2uString);
        daow.update(dui);
        setResult(200,intent);
        finish();
    }
}
