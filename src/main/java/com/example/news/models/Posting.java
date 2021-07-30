package com.example.news.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posting {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, tag, full_text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public Posting() {
    }

    public Posting(String title, String tag, String full_text) {
        this.title = title;
        this.tag = tag;
        this.full_text = full_text;
    }
}
