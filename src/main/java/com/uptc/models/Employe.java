package com.uptc.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_employee")
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthDate")
    private LocalDate birthDate;

}
