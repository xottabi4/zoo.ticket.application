package lv.vea.zoo.shop.dao;

import lv.vea.zoo.shop.visitor.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends CrudRepository<Visitor, Long> {
}
