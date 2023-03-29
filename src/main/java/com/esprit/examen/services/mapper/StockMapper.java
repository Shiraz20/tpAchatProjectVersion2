package com.esprit.examen.services.mapper;

import com.esprit.examen.entities.dto.StockDTO;
import com.esprit.examen.entities.Stock;
import org.mapstruct.Mapper;

@Mapper
public interface StockMapper extends EntityMapper<StockDTO, Stock> {
    Stock toEntity(StockDTO stockDTO);
}
