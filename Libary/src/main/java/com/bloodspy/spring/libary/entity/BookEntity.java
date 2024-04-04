package com.bloodspy.spring.libary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="book")
public class BookEntity {
    public BookEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @ManyToOne()
    @JoinColumn(name = "style_id")
    private StyleEntity style;

    @Column(name = "length")
    private int length;

    @Column(name = "cost")
    private int cost;

    @ManyToMany(cascade =
            {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "books"
    )
    @JsonIgnore
    private List<LibaryCardEntity> libaryCards;

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

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public StyleEntity getStyle() {
        return style;
    }

    public void setStyle(StyleEntity style) {
        this.style = style;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<LibaryCardEntity> getLibaryCards() {
        return libaryCards;
    }

    public void setLibaryCards(List<LibaryCardEntity> libaryCards) {
        this.libaryCards = libaryCards;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", style=" + style +
                ", length=" + length +
                ", cost=" + cost +
                '}';
    }
}