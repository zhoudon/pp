package com.example.dell;

import android.content.Context;

import com.example.dell.greendao.dao.DaoMaster;
import com.example.dell.greendao.dao.DaoSession;
import com.example.dell.greendao.dao.StudentDao;

/**
 * Created by lenovo on 2017/6/22.
 */
public class MyHilder {
    private static MyHilder myHilder;
    private final DaoMaster.DevOpenHelper devOpenHelper;

    private MyHilder(Context context){
        devOpenHelper = new DaoMaster.DevOpenHelper(context, "qwe.db");
    }
    public static MyHilder getIntence(Context context){
        if(myHilder==null){
            synchronized (MyHilder.class){
                if (myHilder==null){
                    myHilder= new MyHilder(context);
                }
            }
        }
        return myHilder;
    }
    public StudentDao getDaor(){
                DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDatabase());
                DaoSession daoSession = daoMaster.newSession();
        StudentDao studentDao = daoSession.getStudentDao();
        return studentDao;
            }
            public StudentDao getDaow(){
                DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
                DaoSession daoSession = daoMaster.newSession();
                StudentDao leiDao = daoSession.getStudentDao();
                return leiDao;
            }
}
