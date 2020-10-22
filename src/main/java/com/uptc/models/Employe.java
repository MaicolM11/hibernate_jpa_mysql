package com.uptc.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "EMPLOYEES")
@Data
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_employee")
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;

    @OneToOne(cascade =  CascadeType.ALL ) // para que inserte la ubicacion.
    @JoinColumn(name = "id_location")
    private Location location;

    public Employe(Long id, String firstname, String lastname, LocalDate birthDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }

    public void setLocation(Location location){
        this.location = location;
        location.setEmploye(this);
    }
}
