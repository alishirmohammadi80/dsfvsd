package com.alishirmohammadi.AirlineTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flight_schedule")
public class FlightSchedule {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = Flight.class, mappedBy = "flightShcedule", cascade =CascadeType.ALL)
    private Flight flight;

    @Column(name = "trip_date")
    private LocalDate tripDate;

    @Column(name = "available_seats")
    private int availableSeats;

    @OneToMany(targetEntity = Ticket.class, mappedBy = "flightSchedule", cascade = CascadeType.ALL)
    private List<Ticket> ticketsSold = new ArrayList<>();


}
