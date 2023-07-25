package jmcompany.erp.service;

import jmcompany.erp.domain.Stock;
import jmcompany.erp.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {

    private StockRepository stockRepository;

    @Transactional
    public Long save(Stock stock) {
        stockRepository.save(stock);
        return stock.getId();
    }

    public Stock findOne(Long stockId) {
        return stockRepository.findOne(stockId);
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }
}
