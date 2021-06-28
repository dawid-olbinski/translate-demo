package com.example.demo.translation.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TranslationsText {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne
    private Translation translation;

    private String isoCode;

}
