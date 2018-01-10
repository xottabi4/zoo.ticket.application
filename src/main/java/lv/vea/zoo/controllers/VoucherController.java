package lv.vea.zoo.controllers;

import java.math.BigDecimal;
import java.util.List;
import lv.vea.zoo.shop.Shop;
import lv.vea.zoo.shop.voucher.dto.Voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/voucher")
public class VoucherController {

    private Shop shop;

    @Autowired
    public VoucherController(final Shop shop) {
        this.shop = shop;
    }

    @RequestMapping(value = "/create/{percentage}", method = RequestMethod.GET)
    public ResponseEntity giveVouchers(
            @PathVariable("percentage") final BigDecimal percentage){
        shop.createVoucher(percentage);
        return new ResponseEntity("Voucher successfully created",HttpStatus.OK);
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public List<Voucher> getAllVouchers(){
        return (List<Voucher>) shop.getAllVouchers();
    }
}
