package com.alishirmohammadi.AirlineTicketBookingSystem.service.impl;

import com.alishirmohammadi.AirlineTicketBookingSystem.entity.FlightSchedule;
import com.alishirmohammadi.AirlineTicketBookingSystem.repository.FlightScheduleRepository;
import com.alishirmohammadi.AirlineTicketBookingSystem.service.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {
    @Autowired
    FlightScheduleRepository flightScheduleRepository;
    @Override
    public List<FlightSchedule> findAllFlightSchedule() {
        return flightScheduleRepository.findAll();
    }

    @Override
    public List<FlightSchedule> searchFlightSchedule(String keyword) {
        if (keyword != null) {
            return flightScheduleRepository.search(keyword);
        }
        return flightScheduleRepository.findAll();
    }

    @Override
    public FlightSchedule findFlightScheduleById(Long id) {
        return flightScheduleRepository.getById(id);
    }

    @Override
    public void saveFlightSchedule(FlightSchedule flightSchedule) {
flightScheduleRepository.save(flightSchedule);
    }

    @Override
    public void updateFlightSchedule(FlightSchedule flightSchedule) {
flightScheduleRepository.save(flightSchedule);
    }

    @Override
    public void deleteFlightSchedule(Long id) {
flightScheduleRepository.deleteById(id);
    }
}
