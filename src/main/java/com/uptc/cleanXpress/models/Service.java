package com.uptc.cleanXpress.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "servicios")
public class Service {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_servicio")
    private int id;

    @Getter @Setter @Column(name = "tipo_jornada")
    private String workingDay;

    @Getter @Setter @Column(name = "tipo_frecuencia")
    private String frequency;

    @Getter @Setter @Column(name = "fecha_servicio")
    private String date;

    @Getter @Setter @Column(name = "prioridad")
    private int priority;

    @Getter @Setter @Column(name = "estado_servicio")
    private String stateService;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento_cliente", nullable = false)
    @Getter @Setter
    private Client clientId;

    @OneToOne(mappedBy = "service", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Bill bill;

    //TODO Falta relacionarlo con una lista de empleados

}
