package jmcompany.erp.service;

import jmcompany.erp.domain.Item;
import jmcompany.erp.domain.ItemInfo;
import jmcompany.erp.domain.Sell;
import jmcompany.erp.dto.ItemDto;
import jmcompany.erp.dto.SellDto;
import jmcompany.erp.repository.ItemRepository;
import jmcompany.erp.repository.SellRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class SellService {

    private final SellRepository sellRepository;

    @Transactional
    public Long join(Sell sell) {
        sellRepository.save(sell);
        return sell.getId();
    }

    public Sell findOne(Long sellId) {
        return sellRepository.findOne(sellId);
    }

    public List<Sell> findAll() {
        return sellRepository.findAll();
    }

    @Transactional
    public void confirmEntity(Long id, SellDto sellDto) {
        Sell sell = sellRepository.findOne(sellDto.getId());
        sell.setPrice(sellDto.getPrice());
        sell.setVat(sellDto.getVat());
        sell.setTotalPrice(sellDto.getTotalPrice());
    }

    @Transactional
    public void update(Long id, SellDto form) {
        Sell sell = sellRepository.findOne(id);
        sell.setDate(form.getDate());
        sell.setMadeBy(form.getMadeBy());
        sell.setCustomer(form.getCustomer());
        sell.setItemInfo(new ItemInfo(form.getItemNum(), form.getItemName()));
        sell.setUnit(form.getUnit());
        sell.setQuantity(form.getQuantity());
        sell.setUnitPrice(form.getUnitPrice());
        sell.setPrice(form.getUnitPrice() * form.getQuantity());
        sell.setVat((int) ((form.getUnitPrice() * form.getQuantity()) * 0.1));
        sell.setTotalPrice((int) ((form.getUnitPrice() * form.getQuantity()) * 1.1));
        sell.setRemarks(form.getRemarks());
    }
}
