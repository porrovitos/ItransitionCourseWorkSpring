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
public class Fandom {

    @Id
    @JoinColumn(name = "idfandom")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "fandom_name")
    private String fandom_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFandom_name() {
        return fandom_name;
    }

    public void setFandom_name(String fandom_name) {
        this.fandom_name = fandom_name;
    }
}
