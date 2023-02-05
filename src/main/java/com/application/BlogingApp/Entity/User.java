package com.application.BlogingApp.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "user_name", nullable = false, length = 100)
    private String name;
    @Column(name = "user_email", nullable = false, length = 100)
    private String email;
    @Column(name = "user_password", nullable = false, length = 100)
    private String password;
    @Column(name = "about", nullable = false, length = 500)
    private String about;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
}
