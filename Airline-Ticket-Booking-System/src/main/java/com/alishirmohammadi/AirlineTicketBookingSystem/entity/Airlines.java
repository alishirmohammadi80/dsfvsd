package com.alishirmohammadi.AirlineTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airlines")
public class Airlines {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "airline_id", updatable = false, nullable = false)
    private Long airlineId;

    @Column(name = "airline_Code")
    private String airlineCode;

    @Column(name = "name")
    private String airlineName;

    @Column(name = "details")
    private String details;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(targetEntity = Airplanes.class, mappedBy = "Airlines", cascade =CascadeType.ALL)
    private List<Airplanes> listOfAirplanes = new ArrayList<>();

    @OneToOne(targetEntity = Flight.class, mappedBy = "Airlines", cascade =CascadeType.ALL)
    private Flight flight;



}
