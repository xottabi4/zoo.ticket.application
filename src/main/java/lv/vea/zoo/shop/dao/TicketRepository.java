package lv.vea.zoo.shop.dao;

import lv.vea.zoo.shop.ticket.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
