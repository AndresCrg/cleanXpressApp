package com.uptc.cleanXpress.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "personas")
@Inheritance (strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @Getter @Setter @Column(name = "documento")
    private String id;

    @Getter @Setter @Column(name = "nombre_completo")
    private String name;

    @Getter @Setter @Column(name = "direccion")
    private String address;

    @Getter @Setter @Column(name = "telefono")
    private String phoneNumber;

    @Getter @Setter @Column(name = "correo_electronico")
    private String email;
}