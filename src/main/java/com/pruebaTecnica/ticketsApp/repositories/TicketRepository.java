package com.pruebaTecnica.ticketsApp.repositories;

import com.pruebaTecnica.ticketsApp.models.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByStatus(Boolean status);

    Page<Ticket> findAllByStatus(Boolean status, Pageable pageable);

    List<Ticket> findAllByUser(String user);

    Page<Ticket> findAllByUser(String user, Pageable pageable);

    Page<Ticket> findByCreatedAtBetween(OffsetDateTime fechaInicio, OffsetDateTime fechafin, Pageable pageable);

}
