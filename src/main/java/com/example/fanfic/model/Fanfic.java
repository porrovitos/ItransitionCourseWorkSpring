package com.example.fanfic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@ToString(of = {"id", "title"})
@EqualsAndHashCode(of = {"id"})
public class Fanfic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime creation_date;

    private String link_photo, fanfic, fanfic_name, user_username, description;
    private int count_likes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fandom_id")
    private Fandom fandom;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Fandom getFandom() {
        return fandom;
    }

    public void setFandom(Fandom fandom) {
        this.fandom = fandom;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getFanfic_name() {
        return fanfic_name;
    }

    public void setFanfic_name(String fanfic_name) {
        this.fanfic_name = fanfic_name;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public String getFanfic() {
        return fanfic;
    }

    public void setFanfic(String fanfic) {
        this.fanfic = fanfic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink_photo() {
        return link_photo;
    }

    public void setLink_photo(String link_photo) {
        this.link_photo = link_photo;
    }

    public int getCount_likes() {
        return count_likes;
    }

    public void setCount_likes(int count_likes) {
        this.count_likes = count_likes;
    }
}
