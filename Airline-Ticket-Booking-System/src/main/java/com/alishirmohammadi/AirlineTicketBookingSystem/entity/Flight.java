package com.alishirmohammadi.AirlineTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fare")
    private int fare;

    @Column(name = "journey_time")
    private int journeyTime;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "airplanes_id", referencedColumnName = "airplane_id")
    private Airplanes airplanes;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "american_airlines_id", referencedColumnName = "airline_id")
    private Airlines airlines;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "source_stop_id", referencedColumnName = "id")
    private Stop sourceStop;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dest_stop_id", referencedColumnName = "id")
    private Stop destStop;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "flight_schedule_id", referencedColumnName = "id")
    private FlightSchedule flightShcedule;

}
