package com.pruebaTecnica.ticketsApp.services;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pruebaTecnica.ticketsApp.models.Ticket;
import com.pruebaTecnica.ticketsApp.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Optional;

@Component
public class TicketGraphQLService implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final TicketRepository repository;

    @Autowired
    public TicketGraphQLService(TicketRepository repository) {
        this.repository = repository;
    }

    public Iterable<Ticket> findAllTickets(){
        return repository.findAll();
    }

    public Page<Ticket> findAllTicketsPaged(Integer page, Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest);
    }

    public Ticket findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Iterable<Ticket> findAllByStatus(Boolean status){
        return repository.findAllByStatus(status);
    }

    public Page<Ticket> findAllByStatusPaged(Boolean status, Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllByStatus(status, pageable);
    }

    public Iterable<Ticket> findAllByUser(String user){
        return repository.findAllByUser(user);
    }

    public Page<Ticket> findAllByUserPaged(String user, Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllByUser(user, pageable);
    }

    public Ticket createTicket(String user, Boolean status) {
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setStatus(status);
        ticket.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return repository.save(ticket);
    }

    public boolean deleteTicket(Long id) {
        try{
            repository.deleteById(id);
            return true;
        } catch (Exception e){
            System.out.println("*** CATCH deleteTicket ***");
            e.printStackTrace();
            return false;
        }
    }

    public Ticket updateTicket(Long id, String user, Boolean status) throws Exception {
        Optional<Ticket> optionalTicket = repository.findById(id);
        Ticket ticket;
        if (optionalTicket.isPresent()) {
            ticket = optionalTicket.get();
            ticket.setUser(user);
            ticket.setStatus(status);
            ticket.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return repository.save(ticket);
        }
        throw new Exception("Not found Tutorial to update!");
    }
}
