package com.application.BlogingApp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id;
    @NotEmpty
    @Size(max = 100)
    private String title;
    @NotEmpty
    @Size(max = 1000)
    private String content;
    private String imageName;
    private Date addedDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
}
