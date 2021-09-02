package com.blog.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profile")
@Getter
@Setter
@JsonIgnoreProperties({"HibernateLazyInitializer","Handler","user"})
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "position")
    private String position;

    @Column(name = "age")
    private int age;

    @Column(name = "company")
    private String company;

    @Column(name = "phone")
    private Long phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
