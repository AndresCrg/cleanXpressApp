package com.uptc.cleanXpress.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "calificaciones")
public class Rating {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_calificacion")
    private int id;

    @Getter @Setter @Column(name = "calificacion")
    private int rate;

    @Getter @Setter @Column(name = "comentario")
    private String comment;

    @Getter @Setter @Column(name = "fecha")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento", nullable = false)
    @Getter @Setter
    private Employee employee;
}