package com.bloodspy.spring.libary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reader")
public class ReaderEntity {
    public ReaderEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "libary_card")
    private LibaryCardEntity libaryCard;
}
