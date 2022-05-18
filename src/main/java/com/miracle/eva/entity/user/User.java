package com.miracle.eva.entity.user;

import com.miracle.eva.entity.post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity(name = "User")
@Table(name = "users")
public class User implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String first_name;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String last_name;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "login", nullable = false, updatable = false)
    private String login;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;


}
