package com.bootcamp.homework1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name ="Kullanıcı")
public class User {

    @Id
    @SequenceGenerator(name = "User", sequenceName = "User_ID_SEQ")
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(name = "Adı", length = 50, nullable = false)
    private String name;

    @Column(name="Soyad",length = 50,nullable = false)
    private String surname;

    @Column(name="Email",length = 50,nullable = false)
    private String email;


    @Column(name = "telefon",length = 15,nullable = false)
    private String number;

    @Column(name = "DogumTarihi", nullable = false)
    private Date bod;



    private Boolean isActive;




}