package lv.vea.zoo.shop.dao;

import java.time.LocalDate;
import java.util.List;

import lv.vea.zoo.shop.ticket.dto.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.dateUsed = ?1")
    List<Ticket> findAllActiveTickets(LocalDate date);
}
