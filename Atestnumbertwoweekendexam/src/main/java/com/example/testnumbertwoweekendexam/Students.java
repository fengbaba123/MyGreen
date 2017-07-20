package com.example.testnumbertwoweekendexam;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by admin on 2017/6/21.
 */


@Entity
public class Students {
    @Id
    Long id;
    @Property(nameInDb = "name")
    String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 782286533)
    public Students(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 174834727)
    public Students() {
    }
}
