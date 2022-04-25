package com.alishirmohammadi.AirlineTicketBookingSystem.repository;

import com.alishirmohammadi.AirlineTicketBookingSystem.entity.Airlines;
import com.alishirmohammadi.AirlineTicketBookingSystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
