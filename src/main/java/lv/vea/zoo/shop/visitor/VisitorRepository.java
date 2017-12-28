package lv.vea.zoo.shop.visitor;

import lv.vea.zoo.shop.visitor.dto.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends CrudRepository<Visitor, Long> {
}
