package com.example.fanfic.model;

import javax.persistence.*;

@Entity
public class FanficTag {

    @Id
    @JoinColumn(name = "idfanfictag")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idfanfic")
    private Fanfic fanfic;

    @ManyToOne
    @JoinColumn(name = "idtag")
    private Tag tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fanfic getFanfic() {
        return fanfic;
    }

    public void setFanfic(Fanfic fanfic) {
        this.fanfic = fanfic;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
