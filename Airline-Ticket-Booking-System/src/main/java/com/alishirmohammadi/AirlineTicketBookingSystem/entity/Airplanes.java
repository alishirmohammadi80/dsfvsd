package com.alishirmohammadi.AirlineTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airplanes")
public class Airplanes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "airplane_id")
    private Long airplaneId;

    @Column(name = "airplane_code")
    private String airplaneCode;

    @Column(name = "capacity")
    private int capacity;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airlines_id", referencedColumnName = "airline_id")
    private Airlines airlines;

    @OneToOne(targetEntity = Flight.class, mappedBy = "airplanes", cascade =CascadeType.ALL)
    private Flight flight;



}
