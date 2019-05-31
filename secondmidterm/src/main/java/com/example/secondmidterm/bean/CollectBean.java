package com.example.secondmidterm.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class CollectBean {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String imagePath;
    @Property
    private String title;
    @Property
    private String desc;
    @Generated(hash = 279745925)
    public CollectBean(Long id, String imagePath, String title, String desc) {
        this.id = id;
        this.imagePath = imagePath;
        this.title = title;
        this.desc = desc;
    }
    @Generated(hash = 420494524)
    public CollectBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImagePath() {
        return this.imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
