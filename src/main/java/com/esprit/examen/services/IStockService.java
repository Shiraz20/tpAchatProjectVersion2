package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.dto.StockDTO;
import com.esprit.examen.entities.Stock;

public interface IStockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(StockDTO s);

	void deleteStock(Long id);

	Stock updateStock(StockDTO u);

	Stock retrieveStock(Long id);

	String retrieveStatusStock();
}
