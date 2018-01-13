package lv.vea.zoo.shop.voucher;

import lv.vea.zoo.shop.voucher.dto.Voucher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends CrudRepository<Voucher, Long> {

    @Query("SELECT v FROM Voucher v WHERE v.expired = false AND v.id=?1")
    Voucher findAvailableVouchers(Long voucherId);
}
