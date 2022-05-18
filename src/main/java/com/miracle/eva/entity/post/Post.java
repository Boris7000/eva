package com.miracle.eva.entity.post;

import com.miracle.eva.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "owner_id",nullable = false)
    private User user = new User();

    @Lob
    @Column(name = "text")
    private String text;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "likes_count", nullable = false)
    private Integer likesCount;

    @Column(name = "comments_count", nullable = false)
    private Integer commentsCount;



}