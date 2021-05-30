package one.digital.web.stdercorretora.service;

import one.digital.web.stdercorretora.exceptions.BusinessException;
import one.digital.web.stdercorretora.exceptions.NotFoundException;
import one.digital.web.stdercorretora.mapper.StockMapper;
import one.digital.web.stdercorretora.model.Stock;
import one.digital.web.stdercorretora.model.dto.StockDto;
import one.digital.web.stdercorretora.repository.StockRepository;
import one.digital.web.stdercorretora.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

        @Transactional()
        public StockDto save(StockDto dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }
        @Transactional
        public StockDto update(StockDto dto) {
            Optional<Stock> optionalStock = repository.findByNameAndDateAndId(dto.getName(), dto.getDate(), dto.getId());
            if(optionalStock.isPresent()){
                throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
            }
            Stock stock = mapper.toEntity(dto);
            repository.save(stock);
            return mapper.toDto(stock);
        }

        @Transactional(readOnly = true)
        public List<StockDto> findAll() {
            return mapper.toDto(repository.findAll());
        }

        @Transactional(readOnly = true)
        public StockDto findByID(Long id) {
            return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

        @Transactional
        public StockDto delete(Long id) {
            StockDto dto = this.findByID(id);
            repository.deleteById(id);
            return dto;
    }
        @Transactional(readOnly = true)
        public List<StockDto> findByToday() {
            return  repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }
}
