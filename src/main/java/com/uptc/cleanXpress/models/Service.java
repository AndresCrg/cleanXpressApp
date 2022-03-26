package com.uptc.cleanXpress.models;

import com.uptc.cleanXpress.utilities.Frecuency;
import com.uptc.cleanXpress.utilities.StateService;
import com.uptc.cleanXpress.utilities.WorkingDay;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "servicios")
public class Service {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_servicio")
    private int id;

    @Getter @Setter @Column(name = "tipo_jornada")
    private WorkingDay workingDay;

    @Getter @Setter @Column(name = "tipo_frecuencia")
    private Frecuency frequency;

    @Getter @Setter @Column(name = "fecha_servicio")
    private LocalDate date;

    @Getter @Setter @Column(name = "prioridad")
    private boolean priority;

    @Getter @Setter @Column(name = "estado_servicio")
    private StateService stateService;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento_cliente", nullable = false)
    @Getter @Setter
    private Client client;

    @OneToOne(mappedBy = "service", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Bill bill;

    //TODO Falta relacionarlo con una lista de empleados

}
