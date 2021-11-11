package com.example.fanfic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @JoinColumn(name = "idcomment")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime creation_date;

    @JoinColumn(name = "commenttext")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "idfanfic")
    private Fanfic fanfic;

    public Fanfic getFanfic() {
        return fanfic;
    }

    public void setFanfic(Fanfic fanfic) {
        this.fanfic = fanfic;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

