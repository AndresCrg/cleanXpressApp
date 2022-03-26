package com.uptc.cleanXpress.models;

import com.uptc.cleanXpress.utilities.ClientType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(referencedColumnName = "documento")
public class Client extends Person{

    @Getter @Setter @Column(name = "tipo_cliente")
    private ClientType clientType;

    @Getter @Setter @Column(name = "contrasena")
    private String password;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Service> services;
}