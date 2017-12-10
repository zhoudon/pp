package com.example.dell.framentyy;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by lenovo on 2017/8/9.
 */
@Entity
public class Student implements Parcelable{
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "sname")
    private String name;
    @Property(nameInDb = "sgender")
    private String gender;
    @Property(nameInDb = "ji")
    private String ji;
    @Generated(hash = 43591925)
    public Student(Long id, String name, String gender, String ji) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.ji = ji;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getJi() {
        return this.ji;
    }
    public void setJi(String ji) {
        this.ji = ji;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.gender);
        dest.writeString(this.ji);
    }

    protected Student(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.gender = in.readString();
        this.ji = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
