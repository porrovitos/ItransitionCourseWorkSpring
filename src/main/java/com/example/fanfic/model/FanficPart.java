package com.example.fanfic.model;

import javax.persistence.*;

@Entity
public class FanficPart {

    @Id
    @JoinColumn(name = "idfanficpart")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "parttext")
    private String part_test;

    @JoinColumn(name = "partname")
    private String part_name;

    @JoinColumn(name = "partnumber")
    private Integer part_number;

    @ManyToOne
    @JoinColumn(name = "idfanfic")
    private Fanfic fanfic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPart_test() {
        return part_test;
    }

    public void setPart_test(String part_test) {
        this.part_test = part_test;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public Integer getPart_number() {
        return part_number;
    }

    public void setPart_number(Integer part_number) {
        this.part_number = part_number;
    }

    public Fanfic getFanfic() {
        return fanfic;
    }

    public void setFanfic(Fanfic fanfic) {
        this.fanfic = fanfic;
    }
}
