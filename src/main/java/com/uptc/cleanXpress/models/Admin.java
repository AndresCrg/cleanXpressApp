package com.uptc.cleanXpress.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "administradores")
@PrimaryKeyJoinColumn(referencedColumnName = "documento")
public class Admin extends Person{

    @Getter @Setter @Column(name = "contrasena")
    private String password;
}
