package com.esprit.examen.services.mapper;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.entities.dto.StockDTO;
import org.springframework.stereotype.Component;

@Component
public class Stock_MapperImpl implements StockMapper {
    @Override
    public Stock toEntity(StockDTO stockDTO) {
        return null;
    }
}
