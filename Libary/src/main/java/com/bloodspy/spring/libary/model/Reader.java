package com.bloodspy.spring.libary.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reader")
public class Reader {
    public Reader() {
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

    @OneToOne()
    @JoinColumn(name = "libary_card_id")
    private LibaryCard libaryCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public LibaryCard getLibaryCard() {
        return libaryCard;
    }

    public void setLibaryCard(LibaryCard libaryCard) {
        this.libaryCard = libaryCard;
    }

    @Override
    public String toString() {
        return "ReaderEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", libaryCard=" + libaryCard +
                '}';
    }
}
