package com.uptc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "LOCATIONS")
@Data
public class Location implements Serializable {

  
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_location")
    private Long id;
    private String address;
    private String country;

    @OneToOne(mappedBy = "location",  fetch = FetchType.LAZY)
    private Employe employe;


    public Location(Long id, String address, String country) {
        this.id = id;
        this.address = address;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location [address=" + address +", id=" + id + ", country=" + country + ", employe=" + employe.getId() +  "]";
    }
    
}
