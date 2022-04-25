package com.alishirmohammadi.AirlineTicketBookingSystem.service;

import com.alishirmohammadi.AirlineTicketBookingSystem.entity.Customer;
import com.alishirmohammadi.AirlineTicketBookingSystem.entity.FlightSchedule;

import java.util.List;

public interface FlightScheduleService {
    public List<FlightSchedule> findAllFlightSchedule();

    public List<FlightSchedule> searchFlightSchedule(String keyword);

    public FlightSchedule findFlightScheduleById(Long id);

    public void saveFlightSchedule(FlightSchedule flightSchedule);

    public void updateFlightSchedule(FlightSchedule flightSchedule);

    public void deleteFlightSchedule(Long id);
}
