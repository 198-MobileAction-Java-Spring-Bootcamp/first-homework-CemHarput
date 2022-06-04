package com.bootcamp.homework1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name ="COMMENT")
public class Comment {

    @Id
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    @GeneratedValue(generator = "Comment")
    private Long id;

    @Column(name = "Yorum", length = 500, nullable = false)
    private String comment;

    @Column(name = "yorumTarihi", nullable = false)
    private Date commentDate;


    @Column(name = "urunId", nullable = false)
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KullanıcıId")
    private User user;




}
