package com.uptc.cleanXpress.models;

import com.uptc.cleanXpress.utilities.State;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empleados")
@PrimaryKeyJoinColumn(referencedColumnName = "documento")
public class Employee extends Person{

    @Getter @Setter @Column(name = "estado")
    private State state;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Rating> ratingsList;
}