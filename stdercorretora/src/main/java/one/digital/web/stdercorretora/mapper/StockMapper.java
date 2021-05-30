package one.digital.web.stdercorretora.mapper;
import one.digital.web.stdercorretora.model.Stock;
import one.digital.web.stdercorretora.model.dto.StockDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {
    public Stock toEntity(StockDto dto) {
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setDate(dto.getDate());
        stock.setName(dto.getName());
        stock.setVariation(dto.getVariation());
        stock.setPrice(dto.getPrice());
        return stock;
    }


    public StockDto toDto(Stock stock) {
        StockDto dto = new StockDto();
        dto.setId(stock.getId());
        dto.setDate(stock.getDate());
        dto.setName(stock.getName());
        dto.setVariation(stock.getVariation());
        dto.setPrice(stock.getPrice());
        return dto;
    }

    public List<StockDto> toDto(List<Stock> ListStock){
        return ListStock.stream().map(this::toDto).collect(Collectors.toList());
    }
}
