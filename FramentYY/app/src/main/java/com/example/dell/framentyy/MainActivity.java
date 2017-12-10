package com.example.dell.framentyy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.dell.MyHilder;
import com.example.dell.greendao.dao.StudentDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fra;
    private FragmentManager supp;
    private AFragment aFragment;
    private BFragment bFragment;
    private RadioGroup grop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        grop = (RadioGroup) findViewById(R.id.grop);
        fra = (FrameLayout) findViewById(R.id.fra);
        supp = getSupportFragmentManager();
        FragmentTransaction transaction = supp.beginTransaction();
        aFragment = new AFragment();
        transaction.add(R.id.fra, aFragment);
        transaction.commit();

        grop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                setHiderw(transaction1);
                switch (checkedId) {
                    case R.id.bu:
                        if (aFragment == null) {
                            transaction1.add(R.id.fra, aFragment);
                        } else {
                            transaction1.show(aFragment);
                        }
                        break;
                    case R.id.bu1:
                        if (bFragment == null) {
                            bFragment = new BFragment();
                            transaction1.add(R.id.fra, bFragment);
                        } else {
                            transaction1.show(bFragment);
                        }
                        break;
                }
                transaction1.commit();
            }

            private void setHiderw(FragmentTransaction transaction1) {
                if (aFragment != null) {
                    transaction1.hide(aFragment);
                }
                if (bFragment != null) {
                    transaction1.hide(bFragment);
                }
            }


        });
    }

}
