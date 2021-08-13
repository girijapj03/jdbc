package com.girija.webseries.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.girija.webseries.dto.WebSeriesDTO;

public interface WebSeriesDAO {
int save(WebSeriesDTO dto);
boolean saveAll(Collection<WebSeriesDTO> collection);
 Collection<WebSeriesDTO> findAll();
 Collection<WebSeriesDTO> findAll(Predicate<WebSeriesDTO> predicate);
 int total();
 int findMaxSeason();
 int findMinSeason();
 Collection<WebSeriesDTO> findAllSortByNameDesc();
 Optional<WebSeriesDTO> findOne(Predicate<WebSeriesDTO> predicate);
 

}
