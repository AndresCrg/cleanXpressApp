package com.uptc.cleanXpress.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(referencedColumnName = "documento")
public class Client extends Person{

    @Column(name = "tipo_cliente")
    private String clientType;

    @Getter @Setter @Column(name = "contrasena")
    private String password;

    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @Getter @Setter
    private List<Service> services;

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
}