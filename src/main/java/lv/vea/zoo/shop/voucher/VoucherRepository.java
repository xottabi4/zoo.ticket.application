package lv.vea.zoo.shop.voucher;

import lv.vea.zoo.shop.voucher.dto.Voucher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends CrudRepository<Voucher, Long> {
}
