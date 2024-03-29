package com.greensuper.GreenSuper.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    private String title;

    public Category(){
        super();
    }
    public Category(int categoryId,String titile) {
        super();
        this.categoryId = categoryId;
        this.title = title;
    }
    public int getCategoryId() {
        return  categoryId;
    }
    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;

    }




}
