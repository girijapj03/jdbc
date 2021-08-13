package com.girija.webseries;

import java.util.Collection;
import java.util.Optional;

import com.girija.webseries.constant.GenreType;
import com.girija.webseries.constant.StreamedIN;
import com.girija.webseries.dao.WebSeriesDAO;
import com.girija.webseries.dao.WebSeriesDAOImpl;
import com.girija.webseries.dto.WebSeriesDTO;

public class WebTester {

	public static void main(String[] args) {
		WebSeriesDTO dto=new WebSeriesDTO("Who killed SARA", 9,3 ,18, StreamedIN.NETFLIX, GenreType.THRILLER);
		WebSeriesDTO dto1=new WebSeriesDTO("Hello  me",10,5,18, StreamedIN.NETFLIX, GenreType.RPMANCE);
		
		WebSeriesDAO dao = new WebSeriesDAOImpl();
		dao.save(dto1);
		dao.save(dto);
		
		System.out.println("Total webseries saved :" +dao.total());
		System.out.println("Maxseason :"+dao.findMaxSeason());
		System.out.println("MIn season :"+dao.findMinSeason());
		Collection<WebSeriesDTO> collection=dao.findAll();
		collection.forEach(f->System.out.println("FindAll :"+f));
		Optional<WebSeriesDTO> findOne = dao.findOne((g) -> g.getWebName().equals("Watchmen"));
		if (findOne.isPresent()) {
			WebSeriesDTO temp = findOne.get();
			System.out.println(" optional findOne():" + temp);
		}
		Collection<WebSeriesDTO> collection1 = dao.findAllSortByNameDesc();
		collection1.forEach((desc) -> System.out.println("sorting name in descending order:" + desc));

		Collection<WebSeriesDTO> findAll = dao.findAll((g) -> g.getTotalSeasons() >= 2);
		findAll.forEach((pre) -> System.out.println(" predicate:" + pre));

		
	}

}
