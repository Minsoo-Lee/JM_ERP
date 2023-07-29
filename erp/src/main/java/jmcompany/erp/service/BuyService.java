package jmcompany.erp.service;

import jmcompany.erp.domain.ItemInfo;
import jmcompany.erp.domain.Buy;
import jmcompany.erp.dto.BuyDto;
import jmcompany.erp.repository.BuyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class BuyService {

    private final BuyRepository buyRepository;

    @Transactional
    public Long join(Buy buy) {
        buyRepository.save(buy);
        return buy.getId();
    }

    public Buy findOne(Long buyId) {
        return buyRepository.findOne(buyId);
    }

    public List<Buy> findAll() {
        return buyRepository.findAll();
    }

    @Transactional
    public void confirmEntity(Long id, BuyDto buyDto) {
        Buy buy = buyRepository.findOne(buyDto.getId());
        buy.setPrice(buyDto.getPrice());
        buy.setVat(buyDto.getVat());
        buy.setTotalPrice(buyDto.getTotalPrice());
    }

    @Transactional
    public void update(Long id, BuyDto form) {
        Buy buy = buyRepository.findOne(id);
        buy.setDate(form.getDate());
        buy.setCustomer(form.getCustomer());
        buy.setItemInfo(new ItemInfo(form.getItemNum(), form.getItemName()));
        buy.setUnit(form.getUnit());
        buy.setQuantity(form.getQuantity());
        buy.setCurrency(form.getCurrency());
        buy.setUnitPrice(form.getUnitPrice());
        buy.setPrice(form.getUnitPrice() * form.getQuantity());
        buy.setVat((int) ((form.getUnitPrice() * form.getQuantity()) * 0.1));
        buy.setTotalPrice((int) ((form.getUnitPrice() * form.getQuantity()) * 1.1));
        buy.setRemarks(form.getRemarks());
    }
}
