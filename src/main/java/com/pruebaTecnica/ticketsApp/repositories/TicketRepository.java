package com.pruebaTecnica.ticketsApp.repositories;

import com.pruebaTecnica.ticketsApp.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByStatus(Boolean status);
    List<Ticket> findAllByUser(String user);
}
