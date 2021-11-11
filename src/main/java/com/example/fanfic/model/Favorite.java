package com.example.fanfic.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;


import javax.persistence.*;

@Entity
public class Favorite {

    @Id
    @JoinColumn(name = "idfavorite")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idfanfic")
    private Fanfic fanfic;

    public Fanfic getFanfic() {
        return fanfic;
    }

    public void setFanfic(Fanfic fanfic) {
        this.fanfic = fanfic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

