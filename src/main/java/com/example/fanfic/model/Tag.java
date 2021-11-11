package com.example.fanfic.model;

import javax.persistence.*;

@Entity
public class Tag {

    @Id
    @JoinColumn(name = "idtag")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "tagname")
    private String tag_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFandom_name() {
        return tag_name;
    }

    public void setFandom_name(String tag_name) {
        this.tag_name = tag_name;
    }
}
