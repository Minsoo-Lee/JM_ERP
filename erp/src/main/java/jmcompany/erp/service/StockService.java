package jmcompany.erp.service;

import jmcompany.erp.domain.Item;
import jmcompany.erp.domain.ItemInfo;
import jmcompany.erp.domain.Stock;
import jmcompany.erp.dto.ItemDto;
import jmcompany.erp.dto.StockDto;
import jmcompany.erp.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional
    public Long join(Stock stock) {
        stockRepository.save(stock);
        return stock.getId();
    }

    public Stock findOne(Long stockId) {
        return stockRepository.findOne(stockId);
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Transactional
    public void update(StockDto dto) {
        stockRepository.update(dto);
    }
}
